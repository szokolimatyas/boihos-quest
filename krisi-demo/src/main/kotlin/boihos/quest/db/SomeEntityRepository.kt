package boihos.quest.db

import org.koin.core.annotation.Single
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.r2dbc.R2dbcDatabase


val SomeEntityTable = Meta.someEntity

@Single
class SomeEntityRepository(private val database: R2dbcDatabase) {

    suspend fun insert(entity: SomeEntity) = database.runQuery {
        QueryDsl.insert(SomeEntityTable).single(entity)
    }

    suspend fun find(id: Long) = database.runQuery {
        QueryDsl.from(SomeEntityTable).where { SomeEntityTable.id eq id }
    }.firstOrNull()

    suspend fun findAll() = database.runQuery {
        QueryDsl.from(SomeEntityTable)
    }
}
