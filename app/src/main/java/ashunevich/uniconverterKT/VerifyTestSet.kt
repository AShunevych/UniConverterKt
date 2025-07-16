package com.example

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

// Data class representing each entry in the JSON array
data class TestModuleEntry(
    val module: String,
    val tests: List<String>
)

abstract class VerifyTestSet : DefaultTask() {

    @get:InputFile
    abstract val inputFile: RegularFileProperty

    @get:InputFile
    abstract val settingsFile: RegularFileProperty

    @get:Input
    abstract val srcDirs: ListProperty<String>

    @get:Input
    abstract val className: Property<String> // used when test entry is just "methodName"

    init {
        group = "verification"
        description = "Verify test methods and module definitions from a JSON configuration"
    }

    @TaskAction
    fun verify() {
        val jsonFile: File = inputFile.get().asFile
        val settings: File = settingsFile.get().asFile

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, TestModuleEntry::class.java)
        val adapter = moshi.adapter<List<TestModuleEntry>>(type)

        val modules: List<TestModuleEntry> = adapter.fromJson(jsonFile.readText())
            ?: throw GradleException("Failed to parse JSON input file: ${jsonFile.path}")

        val definedModules = settings.readLines()
            .mapNotNull { line ->
                Regex("""include\(\s*":(\w+)"\s*\)""").find(line)?.groupValues?.get(1)
            }.toSet()

        val missingModules = mutableSetOf<String>()
        val missingTests = mutableListOf<String>()

        for (entry in modules) {
            val module = entry.module
            if (module != "app" && !definedModules.contains(module)) {
                missingModules.add(module)
            }

            for (testEntry in entry.tests) {
                 val parts = testEntry.split("#", limit = 2).map(String::trim)
                 val classNameRaw = "${className.get()}${parts[0]}"
                 val methodName = parts[1] e


                val relativePath = classNameRaw.replace('.', '/') + ".kt"

                var found = false
                for (srcDir in srcDirs.get()) {
                    val sourceFile = project.file("$srcDir/$relativePath")
                    if (sourceFile.exists() &&
                        sourceFile.readText().contains(Regex("""fun\s+$methodName\s*\("""))
                    ) {
                        logger.lifecycle("Found test $methodName in $classNameRaw")
                        found = true
                        break
                    }
                }

                if (!found) {
                    missingTests.add("$classNameRaw#$methodName")
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
