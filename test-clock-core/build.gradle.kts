plugins {
  id("test-clock.java-conventions")
}

dependencies {
  implementation("com.google.code.findbugs:jsr305:3.0.2")
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
    }
  }
}
