plugins {
    kotlin("jvm") version "2.1.0"
}

group = "boihos.quest"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    allprojects {
        repositories {
            maven (url = "https://jitpack.io" )
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.quillraven.fleks:Fleks:2.11")
    implementation("com.github.trystan:AsciiPanel:master-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}