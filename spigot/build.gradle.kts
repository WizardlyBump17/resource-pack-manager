plugins {
    id("io.papermc.paperweight.userdev") version "1.5.11"
}

val lombok = "1.18.30"
val jetbrainsAnnotations = "24.1.0"
val paper = "1.20.4-R0.1-20240329.175742-144"

dependencies {
    compileOnly("org.projectlombok:lombok:${lombok}")
    compileOnly("org.jetbrains:annotations:${jetbrainsAnnotations}")
    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:${paper}")
    implementation(project(":resource-pack"))
    annotationProcessor("org.projectlombok:lombok:${lombok}")
}

tasks {
    reobfJar {
        outputJar.set(layout.buildDirectory.file("libs/${rootProject.name}-${project.version}.jar"))
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(
                mapOf(
                    "name" to rootProject.name,
                    "version" to project.version
                )
            )
        }
    }

    assemble {
        dependsOn(getTasksByName("reobfJar", true))
    }
}
