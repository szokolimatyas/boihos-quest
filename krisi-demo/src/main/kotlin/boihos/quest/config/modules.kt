package boihos.quest.config

import boihos.quest.properties.ApplicationProperties
import boihos.quest.routes.helloWorldRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.ksp.generated.defaultModule
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.installModules(applicationProperties: ApplicationProperties) {
    install(Koin) {
        slf4jLogger()
        modules(
            defaultModule,
            propertiesModule(applicationProperties),
            databaseModule(applicationProperties.core.database)
        )
    }
    install(ContentNegotiation) {
        json()
    }
    helloWorldRoutes()
}