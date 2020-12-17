import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
    kotlin("plugin.spring") apply false
    id("com.adarshr.test-logger")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(14))
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    apply(plugin = "com.adarshr.test-logger")

    testlogger {
        setTheme("mocha-parallel")
        isShowFullStackTraces = false
        slowThreshold = 1_000
    }
}

subprojects {
    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                apiVersion = "1.4"
                languageVersion = "1.4"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }
        withType<Test> {
            useJUnitPlatform()
            testLogging {
                events("passed", "skipped", "failed")
            }
        }
    }
}
