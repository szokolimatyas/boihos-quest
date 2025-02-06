package boihos.quest.properties

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationProperties(
    val core: BoihosQuest
)

@Serializable
data class BoihosQuest(
    val server: ServerProperties = ServerProperties(),
    val database: DatabaseProperties,
    val appender: AppenderProperties
)

@Serializable
data class ServerProperties(
    val host: String = "127.0.0.1",
    val port: Int = 8080
)

@Serializable
data class DatabaseProperties(
    val url: String,
    val username: String? = null,
    val password: String? = null
)

@Serializable
data class AppenderProperties(
    val appendSuffix: String,
    val appendPrefix: String
)
