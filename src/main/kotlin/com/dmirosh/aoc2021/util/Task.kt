package com.dmirosh.aoc2021.util

import com.dmirosh.aoc2021.util.FileUtils.defaultResourcesDirForClass
import com.dmirosh.aoc2021.util.FileUtils.readLines

abstract class Task<T>(
    val name: String,
    relativeResourcesDir: String? = null,
    private val inputFile: String = "input.txt",
    private val testsConfig: Map<String, T> // file name -> expected result
) {
    private val relativeResourcesDir: String

    init {
        this.relativeResourcesDir = relativeResourcesDir ?: defaultResourcesDirForClass(this::class)
    }

    fun solve(): T {
        runTests()

        val input = relativeResourcesDir.readLines(inputFile)
        return solve(input)
    }

    private fun runTests() {
        testsConfig.forEach { (testFileName, expectedResult) ->
            val result = solve(relativeResourcesDir.readLines(testFileName))
            if (result != expectedResult) {
                throw TestFailedException(testFileName, "expected '$expectedResult' but has '$result'")
            }
        }
    }

    abstract fun solve(input: Sequence<String>): T

}
