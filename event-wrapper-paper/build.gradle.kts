dependencies {
    api(project(":event-wrapper-shared"))
    implementation(libs.paper)
}

tasks.processResources {
    expand("version" to project.version,
        "name" to project.name)
}