package com.dmirosh.aoc2021.day5.task2

import com.dmirosh.aoc2021.day5.Line.Companion.toLine
import com.dmirosh.aoc2021.day5.Point
import com.dmirosh.aoc2021.util.Task

class Day5Task2(
    name: String = "Day 5 task 2",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 12
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val ventPositions = mutableMapOf<Point, Int>()
        input
            .map { it.toLine() }
            .flatMap { it.points() }
            .forEach {
                ventPositions.compute(it) { _, current ->
                    if (current == null) 1 else current + 1
                }
            }

        return ventPositions.count { it.value >= 2 }
    }
}
