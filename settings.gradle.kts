pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }
}

rootProject.name = "resource-pack-manager"
include("resource-pack")
include("spigot")
include("api")
