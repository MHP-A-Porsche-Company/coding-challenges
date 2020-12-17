@Suppress("PropertyName")
val spring_boot_version: String by project

dependencies {
    api(project(":inquiry"))
}

dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-dependencies:${spring_boot_version}") }
}
