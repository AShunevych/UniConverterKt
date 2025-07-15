package com.example

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class VerifyTestSet : DefaultTask() {

    @get:InputFile
    abstract val inputFile: RegularFileProperty

    @get:Input
    abstract val srcDirs: ListProperty<String>

    @get:Input
    abstract val className: Property<String>

    @get:InputFile
    abstract val settingsFile: RegularFileProperty

    init {
        group = "verification"
        description = "Verify test methods and module definitions from config files"
    }

    @TaskAction
    fun verify() {
        val testFile = inputFile.get().asFile
        val settings = settingsFile.get().asFile

        val missingTests = mutableListOf<String>()
        val missingModules = mutableSetOf<String>()

        val definedModules: Set<String> = settings.readLines()
            .mapNotNull { line ->
                val match = Regex("""include\(\s*":(\w+)"\s*\)""").find(line)
                match?.groupValues?.get(1)
            }.toSet()

        testFile.forEachLine { line ->
            val parts = line.split("=")
            if (parts.size < 2) return@forEachLine

            val module = parts[0].removePrefix(":").trim()
            if (module == "app") return@forEachLine

            if (!definedModules.contains(module)) {
                missingModules.add(module)
            }

            val entries = parts[1]
            entries.split(",").forEach { entry ->
                val (classRaw, methodRaw) = entry.split("#")
                val classNameClean = classRaw.trim()
                val methodName = methodRaw.trim()
                val relativePath = classNameClean.replace('.', '/') + ".kt"

                var found = false
                for (srcDir in srcDirs.get()) {
                    val sourceFile = project.file("$srcDir/$relativePath")
                    if (sourceFile.exists() &&
                        sourceFile.readText().contains(Regex("""fun\s+$methodName\s*\("""))
                    ) {
                        logger.lifecycle("Found test $methodName in $classNameClean")
                        found = true
                        break
                    }
                }

                if (!found) {
                    missingTests.add("$classNameClean#$methodName")
                }
            }
        }

        val errors = mutableListOf<String>()
        if (missingModules.isNotEmpty()) {
            errors.add("Missing module definitions:\n" + missingModules.joinToString("\n") { ":$it" })
        }
        if (missingTests.isNotEmpty()) {
            errors.add("Missing test definitions:\n" + missingTests.joinToString("\n"))
        }

        if (errors.isNotEmpty()) {
            throw GradleException(errors.joinToString("\n\n"))
        }
    }
}
