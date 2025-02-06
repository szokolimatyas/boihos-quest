package boihos.quest

import boihos.quest.config.installModules
import boihos.quest.properties.loadConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlin.io.path.Path

fun main(args: Array<String>) {
    val applicationProperties = loadConfig(Path(args[0]))

    val server = embeddedServer(
        Netty,
        host = applicationProperties.core.server.host,
        port = applicationProperties.core.server.port,
        module = {
            installModules(applicationProperties)
        }
    )

    server.start(true)
}
