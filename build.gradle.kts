
 plugins {

	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"


 }

 group = "com.latteIceCream"
 version = "0.0.1-SNAPSHOT"

 java { toolchain { languageVersion = JavaLanguageVersion.of(24) } }

 repositories { mavenCentral() }

 dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
     
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.mockito:mockito-core:4.8.1")
    testImplementation("org.mockito:mockito-junit-jupiter:4.8.1")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

 }

 tasks.withType<Test> { useJUnitPlatform() }
