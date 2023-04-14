plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "com.github.DavidLakeT"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("kotlin.MainKt")
}