package com.dmirosh.aoc2021.day4.task2

import com.dmirosh.aoc2021.day4.BingoSystem.Companion.readBingoSystem
import com.dmirosh.aoc2021.day4.BingoSystem.Companion.readInputNumbers
import com.dmirosh.aoc2021.util.Task

class Day4Task2(
    name: String = "Day 4 task 2",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 1924
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val inputNumbers = input.readInputNumbers()
        val bingoSystem = input.readBingoSystem()

        for (currentNumber in inputNumbers) {
            bingoSystem.draw(currentNumber)
            val winnerBoards = bingoSystem.checkFinish()
            if (winnerBoards.size == bingoSystem.totalBoards) {
                val unmarkedSum = winnerBoards.last().unmarked().sum()
                return unmarkedSum * currentNumber
            }
        }
        error("no winner at the end")
    }
}
