val lombok = "1.18.30"
val jetbrainsAnnotations = "24.1.0"
val paper = "1.20.4-R0.1-20240329.175742-144"

dependencies {
    compileOnly("org.projectlombok:lombok:${lombok}")
    compileOnly("org.jetbrains:annotations:${jetbrainsAnnotations}")
    annotationProcessor("org.projectlombok:lombok:${lombok}")
}