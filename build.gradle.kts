plugins {
    alias(libs.plugins.kotlin)
    application
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(libs.kotest.core)
    testImplementation(libs.kotest.property)
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
