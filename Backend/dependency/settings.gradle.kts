@file:Suppress("LocalVariableName")

rootProject.name = "dependency-challenge"

pluginManagement {
    repositories { gradlePluginPortal() }

    val kotlin_version: String by settings
    val spring_boot_version: String by settings
    val spring_dependency_management_version: String by settings
    val test_logger_version: String by settings

    plugins {
        kotlin("jvm") version kotlin_version
        kotlin("plugin.spring") version kotlin_version
        id("org.springframework.boot") version spring_boot_version
        id("io.spring.dependency-management") version spring_dependency_management_version
        id("com.adarshr.test-logger") version test_logger_version
    }
}

include(
    "inquiry",
    "notifications",
    "application"
)
