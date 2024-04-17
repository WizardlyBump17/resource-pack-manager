plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")

    group = "com.wizardlybump17.resource-pack-manager"
    version = "0.0.1"

    repositories {
        mavenCentral()
        mavenLocal()
    }

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(18)
        }
    }
}
