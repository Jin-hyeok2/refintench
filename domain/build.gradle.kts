plugins {
    kotlin("plugin.jpa") version "1.8.22"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.mysql:mysql-connector-j")
    testCompileOnly("com.h2database:h2")
}