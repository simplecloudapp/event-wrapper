import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
    implementation(project(":event-wrapper-shared"))
    implementation(libs.paper)
}

tasks.processResources {
    expand("version" to project.version,
        "name" to project.name)
}

tasks.named("shadowJar", ShadowJar::class) {
    dependsOn("processResources")
    dependencies {
        include(project(":event-wrapper-shared"))
        include(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
    }
    val externalRelocatePath = "app.simplecloud.external"
    relocate("kotlin", "$externalRelocatePath.kotlin")
    archiveFileName.set("${project.name}.jar")
}