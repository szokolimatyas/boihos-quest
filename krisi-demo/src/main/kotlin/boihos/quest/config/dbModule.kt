package boihos.quest.config

import kotlinx.coroutines.runBlocking
import boihos.quest.db.SomeEntityTable
import boihos.quest.properties.DatabaseProperties
import org.koin.dsl.module
import org.komapper.core.dsl.QueryDsl
import org.komapper.r2dbc.R2dbcDatabase

fun databaseModule(databaseProperties: DatabaseProperties) = module(createdAtStart = true) {
    val db = R2dbcDatabase(
        databaseProperties.url
    )
    single { db }
    /*
    * here we could run Liquibase or Flyaway for setting up / migrating database
    * or anything related to database
    * for demo purposes it is initialized with komapper tho proper sql files are better
    * */
    runBlocking {
        db.withTransaction {
            db.runQuery {
                QueryDsl.Companion.create(SomeEntityTable)
            }
        }
    }
}