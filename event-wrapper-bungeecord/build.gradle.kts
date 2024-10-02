dependencies {
    api(project(":event-wrapper-shared"))
    implementation(libs.bungeecord)
}

tasks.processResources {
    expand("version" to project.version,
        "name" to project.name)
}