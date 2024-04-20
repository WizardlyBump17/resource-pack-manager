val lombok = "1.18.30"
val jetbrainsAnnotations = "24.1.0"
val jackson = "2.17.0"

dependencies {
    compileOnly("org.projectlombok:lombok:${lombok}")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotations}")
    annotationProcessor("org.projectlombok:lombok:${lombok}")
    implementation(project(":resource-pack"))
    implementation("com.fasterxml.jackson.core:jackson-databind:${jackson}")

    testCompileOnly("org.projectlombok:lombok:${lombok}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombok}")
}