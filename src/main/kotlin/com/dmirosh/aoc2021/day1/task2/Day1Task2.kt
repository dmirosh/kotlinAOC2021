package com.dmirosh.aoc2021.day1.task2

import com.dmirosh.aoc2021.util.Task

class Day1Task2(
    name: String = "Day 1 task 2",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 5
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        return input
            .map { it.toInt() }
            .windowed(size = 3, step = 1) { it.sum() }
            .zipWithNext()
            .count { (prev, next) -> next > prev }
    }
}
