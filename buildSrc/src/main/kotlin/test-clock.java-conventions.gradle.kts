plugins {
    `java-library`
    id("maven-publish")
}

group = "is.kow.test-clock"
version = "1.0.5"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// Make sure that all compiler output is java 8 compatible.
tasks.withType<JavaCompile>().configureEach {
    javaCompiler.set(javaToolchains.compilerFor{
        languageVersion.set(JavaLanguageVersion.of(8))
    })
}


val junit5Version: String by project

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/dkowis/test-clock")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
