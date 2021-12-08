package com.dmirosh.aoc2021.day5.task1

import com.dmirosh.aoc2021.day5.Line.Companion.toLine
import com.dmirosh.aoc2021.day5.Point
import com.dmirosh.aoc2021.util.Task

fun main() {
    Day5Task1().solve()
}

class Day5Task1(
    name: String = "Day 5 task 1",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 5
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val ventPositions = mutableMapOf<Point, Int>()
        input
            .map { it.toLine() }
            .filter { it.horizontal || it.vertical }
            .flatMap { it.points() }
            .forEach {
                ventPositions.compute(it) { _, current ->
                    if (current == null) 1 else current + 1
                }
            }

        return ventPositions.count { it.value >= 2 }
    }
}
