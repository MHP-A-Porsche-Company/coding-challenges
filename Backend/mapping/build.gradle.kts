import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.4.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "com.mhp.coding.challenges"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

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
