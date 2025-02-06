package boihos.quest.service

import boihos.quest.db.SomeEntity
import boihos.quest.db.SomeEntityRepository
import boihos.quest.properties.AppenderProperties
import org.koin.core.annotation.Single
import org.komapper.r2dbc.R2dbcDatabase

@Single
class HelloWorldService(
    private val someEntityRepository: SomeEntityRepository,
    private val db: R2dbcDatabase,
    private val appenderProperties: AppenderProperties
) {

    suspend fun respondHello(receiveText: String) = db.withTransaction {
        someEntityRepository.insert(
            SomeEntity(
                appenderProperties.appendPrefix + receiveText + appenderProperties.appendSuffix
            )
        ).id!!
    }

    suspend fun getById(id: Long) = db.withTransaction {
        someEntityRepository.find(id)
    }
}