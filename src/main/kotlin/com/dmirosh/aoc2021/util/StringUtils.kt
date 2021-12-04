package com.dmirosh.aoc2021.util

object StringUtils {
    private val DELIMITER = "\\s+".toRegex()

    fun String.toInts(): List<Int> {
        return this.trim().split(DELIMITER)
            .map { it.toInt() }
    }
}