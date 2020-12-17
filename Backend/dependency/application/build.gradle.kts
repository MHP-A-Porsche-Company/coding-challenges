plugins {
    id("org.springframework.boot")
}

@Suppress("PropertyName")
val spring_mockk_version: String by project

dependencies {
    implementation(project(":notifications"))
    testImplementation("com.ninja-squad:springmockk:$spring_mockk_version")
}
