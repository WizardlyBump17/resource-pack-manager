val lombok = "1.18.30"
val jetbrainsAnnotations = "24.1.0"

dependencies {
    compileOnly("org.projectlombok:lombok:${lombok}")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotations}")
    annotationProcessor("org.projectlombok:lombok:${lombok}")
}