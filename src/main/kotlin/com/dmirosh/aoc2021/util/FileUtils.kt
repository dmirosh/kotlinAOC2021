package com.dmirosh.aoc2021.util

import com.dmirosh.aoc2021.Main
import java.nio.file.Files
import java.nio.file.Path
import kotlin.reflect.KClass

object FileUtils {
    fun String.readLines(fileName: String): Sequence<String> {
        val path = "$this/$fileName"
        val input = FileUtils::class.java.classLoader.getResource(path) ?: error("Can't find resource '$path'")
        return Files.readAllLines(Path.of(input.toURI())).asSequence()
    }

    fun defaultResourcesDirForClass(clazz: KClass<*>): String {
        val classPackagePath = Path.of(clazz.java.packageName.replace(".", "/"))
        val rootPackagePath = Path.of(Main::class.java.packageName.replace(".", "/"))
        return rootPackagePath.relativize(classPackagePath).toString()
    }
}