package com.dmirosh.aoc2021.day6.task1

import com.dmirosh.aoc2021.day6.FishFarm
import com.dmirosh.aoc2021.util.StringUtils.toInts
import com.dmirosh.aoc2021.util.Task

class Day6Task1(
    name: String = "Day 6 task 1",
    testsConfig: Map<String, Long> = mapOf(
        "test1.txt" to 5934L
    )
) : Task<Long>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Long {
        val farm = FishFarm()
        input.toInts()
            .forEach { farm.addFish(it) }

        repeat(80) {
            farm.simulateDay()
        }
        return farm.countFishes()
    }
}
