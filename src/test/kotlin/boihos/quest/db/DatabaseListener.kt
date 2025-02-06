package boihos.quest.db

import io.kotest.core.listeners.TestListener
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import org.komapper.core.dsl.QueryDsl
import org.komapper.r2dbc.R2dbcDatabase
import org.komapper.tx.core.CoroutineTransactionOperator

val ALL_TABLES = listOf(
    SomeEntityTable
)

class DatabaseListener(
    val beforeTestBlock: (testCase: TestCase, db: R2dbcDatabase) -> Unit
) : TestListener {
    lateinit var database: R2dbcDatabase

    override suspend fun beforeTest(testCase: TestCase) {
        database = R2dbcDatabase("r2dbc:pool:h2:mem:///example")
        withTransaction {
            ALL_TABLES.forEach {
                database.runQuery {
                    QueryDsl.Companion.create(it)
                }
            }
        }

        beforeTestBlock(testCase, database)
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        cleanDatabase(database)
        val cp = database.config.connectionFactory as io.r2dbc.pool.ConnectionPool

        cp.close()
        super.afterTest(testCase, result)
    }

    suspend fun <T> withTransaction(block: suspend CoroutineTransactionOperator.() -> T) = database.withTransaction {
        block(it)
    }
}

suspend fun cleanDatabase(db: R2dbcDatabase) {
    db.withTransaction {
        ALL_TABLES.forEach { table ->
            db.runQuery<Long> {
                QueryDsl.delete(SomeEntityTable).all()
            }
        }
    }
}

