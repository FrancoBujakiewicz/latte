
 plugins {

	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
    // id("io.freefair.lombok") version "8.4" Waiting for a release for Java 24

 }

 group = "com.latteIceCream"
 version = "0.0.1-SNAPSHOT"

 java { toolchain { languageVersion = JavaLanguageVersion.of(24) } }

 repositories { mavenCentral() }

 dependencies {

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")

	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

 }

 tasks.withType<Test> { useJUnitPlatform() }
