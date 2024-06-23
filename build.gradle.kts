plugins {
    id("java")
    id("org.springframework.boot") version("3.2.5")
    id("io.spring.dependency-management") version("1.1.4")
}

allprojects {

    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    version = "0.1.11-DEV"
    group =  "net.justkilli.rpgpomodorotimer"

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation ("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly ("org.junit.platform:junit-platform-launcher")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation ("org.springframework.boot:spring-boot-starter-web")
        implementation ("org.springframework.boot:spring-boot-devtools")
        compileOnly("org.projectlombok:lombok")
        runtimeOnly ("org.postgresql:postgresql")
        annotationProcessor ("org.projectlombok:lombok")
    }

    tasks.test {
        useJUnitPlatform()
    }
}