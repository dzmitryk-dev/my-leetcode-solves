import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "me.dzmitry"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(platform("org.junit:junit-bom:5.9.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
    testImplementation("org.hamcrest:hamcrest-library:2.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(13))
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "13"
    kotlinOptions.apiVersion = "1.3"
    kotlinOptions.languageVersion = "1.4"
}