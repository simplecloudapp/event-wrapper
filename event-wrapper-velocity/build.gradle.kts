dependencies {
    implementation(project(":event-wrapper-shared"))
    implementation(libs.velocity)
}

tasks.register("generateBuildConfig") {
    val outputDir = project.layout.buildDirectory.dir("generated/source/buildConfig").get().asFile
    outputs.dir(outputDir)

    doLast {
        outputDir.mkdirs()
        val buildConfigFile = outputDir.resolve("BuildConstants.kt")
        buildConfigFile.writeText("""
            object BuildConstants {
                const val MODULE_NAME = "${project.name}"
                const val VERSION = "${rootProject.version}"
            }
        """.trimIndent())
    }
}

sourceSets["main"].java.srcDir("build/generated/source/buildConfig")
