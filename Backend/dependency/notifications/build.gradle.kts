@Suppress("PropertyName")
val spring_boot_version: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(project(":inquiry"))
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-dependencies:${spring_boot_version}") }
}
