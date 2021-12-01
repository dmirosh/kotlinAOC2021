package com.dmirosh.aoc2021.day1.task1

import com.dmirosh.aoc2021.util.Task

class Day1Task1(
    name: String = "Day 1 task 1",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 7
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        return input
            .map { it.toInt() }
            .zipWithNext()
            .count { (prev, next) -> next > prev }
    }
}
