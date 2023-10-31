
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    implementation(project(":domain"))
    implementation(project(":kafka"))

    runtimeOnly("com.mysql:mysql-connector-j")
    testCompileOnly("com.h2database:h2")

    implementation("org.springframework.boot:spring-boot-starter-aop:3.1.5")
}