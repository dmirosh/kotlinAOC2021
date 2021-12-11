package com.dmirosh.aoc2021.day7.task2

import com.dmirosh.aoc2021.util.StringUtils.toInts
import com.dmirosh.aoc2021.util.Task
import kotlin.math.abs

class Day7Task2(
    name: String = "Day 7 task 2",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 168
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val crabPositions = input.toInts().toList()
        return (crabPositions.minOrNull()!!..crabPositions.maxOrNull()!!)
            .minOf { testedPosition ->
                crabPositions.sumOf { calculateDistance(it, testedPosition) }
            }
    }

    private fun calculateDistance(start: Int, end: Int): Int {
        val n = abs(end - start)
        return n * (n + 1) / 2
    }
}
