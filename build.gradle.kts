plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
    id("io.freefair.lombok") version "8.6"
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "io.freefair.lombok")

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

        javadoc {
            dependsOn(delombok)
            options {
                this as StandardJavadocDocletOptions
                addBooleanOption("Xdoclint:none", true)
                addStringOption("Xmaxwarns", "1")
            }
        }
    }
}
