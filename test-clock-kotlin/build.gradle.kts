plugins {
    id("test-clock.java-conventions")
    kotlin("jvm") version "1.7.21"
}
repositories {
    mavenCentral()
}

val kotestVersion: String by project

dependencies {
    implementation(project(":test-clock-core"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
