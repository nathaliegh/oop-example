plugins {
	java
	id("org.springframework.boot") version "3.0.3-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.oop"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val logbackVersion = "1.4.5"
var mongockSpringVersion = "4.3.8"
var mapstructVersion = "1.5.3.Final"
var mongockBomVersion = "5.0.2.BETA"
var logstashVersion = "7.3"
var springFoxVersion = "3.0.0"
var graphqlTestVersion = "15.0.0"

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.github.cloudyrock.mongock:mongock-spring-v5:$mongockSpringVersion")
	implementation("com.github.cloudyrock.mongock:mongodb-springdata-v3-driver:$mongockSpringVersion")
	implementation("com.github.cloudyrock.mongock:mongock-bom:$mongockBomVersion")
	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	implementation ("ch.qos.logback:logback-core:$logbackVersion")
	implementation ("ch.qos.logback:logback-classic:$logbackVersion")
	implementation("net.logstash.logback:logstash-logback-encoder:$logstashVersion")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")
	testImplementation ("ch.qos.logback:logback-core:$logbackVersion")
	testImplementation ("ch.qos.logback:logback-classic:$logbackVersion")
	testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:$graphqlTestVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-webflux")
	testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
