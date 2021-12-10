package com.dmirosh.aoc2021.day6.task2

import com.dmirosh.aoc2021.day6.FishFarm
import com.dmirosh.aoc2021.util.StringUtils.toInts
import com.dmirosh.aoc2021.util.Task

class Day6Task2(
    name: String = "Day 6 task 2",
    testsConfig: Map<String, Long> = mapOf(
        "test1.txt" to 26984457539L
    )
) : Task<Long>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Long {
        val fishes = FishFarm()
        input.toInts()
            .forEach { fishes.addFish(it) }

        repeat(256) {
            fishes.simulateDay()
        }
        return fishes.countFishes()
    }
}
