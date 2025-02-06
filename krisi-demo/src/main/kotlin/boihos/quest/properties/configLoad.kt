package boihos.quest.properties

import com.typesafe.config.ConfigFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import kotlinx.serialization.hocon.decodeFromConfig
import java.nio.file.Path

@OptIn(ExperimentalSerializationApi::class)
fun loadConfig(configLocation: Path): ApplicationProperties {
    val hocon = Hocon {
        useConfigNamingConvention = true
    }

    val config = ConfigFactory.parseFileAnySyntax(
        configLocation.toFile()
    )

    return hocon.decodeFromConfig<ApplicationProperties>(config)
}