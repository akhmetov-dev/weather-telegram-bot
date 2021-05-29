plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "ahmetoff"
////////// Менять версию //////////
version = "1.3"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    implementation ("org.json", "json", "20210307")
    implementation("org.postgresql", "postgresql", "42.2.20")
}

application{
    mainClass.set("Starter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}