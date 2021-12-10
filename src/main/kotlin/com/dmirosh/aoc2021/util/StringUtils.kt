package com.dmirosh.aoc2021.util

object StringUtils {
    fun String.toInts(): List<Int> {
        return this.trim().split("\\s+".toRegex())
            .map { it.toInt() }
    }

    fun Sequence<String>.toInts(): Sequence<Int> {
        return this
            .flatMap { it.split(",") }
            .map { it.toInt() }
    }
}