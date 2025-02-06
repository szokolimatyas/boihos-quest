plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
    alias(libs.plugins.ksp)
}
group = "boihos.quest"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)
    implementation(libs.koin.annotations)

    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)

    implementation(libs.ktor.client.content.negotiation)

    implementation(libs.logback.classic)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.hocon)

    implementation(libs.r2dbc.pool)

    platform(libs.komapper.platform).let {
        ksp(it)
        implementation(it)
    }

    ksp("org.komapper:komapper-processor")
    implementation("org.komapper:komapper-starter-r2dbc")
    implementation("org.komapper:komapper-dialect-h2-r2dbc")

    runtimeOnly(libs.r2dbc.h2)

    ksp(libs.koin.ksp.compiler)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertion)

}

application {
    mainClass.set("boihos.quest.BoihosQuestKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}