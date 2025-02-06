package boihos.quest

import boihos.quest.config.installModules
import boihos.quest.db.cleanDatabase
import boihos.quest.properties.loadConfig
import io.kotest.core.test.TestScope
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import org.koin.java.KoinJavaComponent.inject
import org.komapper.r2dbc.R2dbcDatabase
import kotlin.io.path.Path

val testProperties = loadConfig(Path("build/resources/test/application.conf"))

fun TestScope.ktorTest(block: suspend (HttpClient) -> Unit) = testApplication {
    application {
        installModules(testProperties)
    }

    val httpClient = createClient {
        install(ContentNegotiation) {
            json()
        }
    }

    block(httpClient)

    val db by inject<R2dbcDatabase>(R2dbcDatabase::class.java)
    cleanDatabase(db)

    val cp = db.config.connectionFactory as io.r2dbc.pool.ConnectionPool
    cp.close()
}