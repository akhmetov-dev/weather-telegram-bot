plugins {
    application
}

group = "ahmetoff"
////////// Менять версию //////////
version = "1.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    implementation ("org.json", "json", "20210307")
}

application{
    mainClass.set("Starter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}