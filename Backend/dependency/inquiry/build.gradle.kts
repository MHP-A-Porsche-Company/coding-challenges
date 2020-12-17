@Suppress("PropertyName")
val spring_boot_version: String by project

dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-dependencies:${spring_boot_version}") }
}
