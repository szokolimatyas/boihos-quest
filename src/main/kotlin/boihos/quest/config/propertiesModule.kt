package boihos.quest.config

import boihos.quest.properties.ApplicationProperties
import org.koin.dsl.module

fun propertiesModule(applicationProperties: ApplicationProperties) = module(createdAtStart = true) {
    single { applicationProperties.core }
    single { applicationProperties.core.server }
    single { applicationProperties.core.database }
    single { applicationProperties.core.appender }
}