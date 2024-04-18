val lombok = "1.18.30"
val jetbrainsAnnotations = "24.1.0"
val paper = "1.20.4-R0.1-20240329.175742-144"
val jackson = "2.17.0"

dependencies {
    implementation("org.projectlombok:lombok:${lombok}")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotations}")
    annotationProcessor("org.projectlombok:lombok:${lombok}")
    implementation(project(":resource-pack"))
    implementation("com.fasterxml.jackson.core:jackson-databind:${jackson}")
}