plugins {
    `java-library`
}

group = "is.kow.time"
version = "1.0"

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
