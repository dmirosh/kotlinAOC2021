package com.dmirosh.aoc2021.day4.task1

import com.dmirosh.aoc2021.day4.BingoSystem.Companion.readBingoSystem
import com.dmirosh.aoc2021.day4.BingoSystem.Companion.readInputNumbers
import com.dmirosh.aoc2021.util.Task

class Day4Task1(
    name: String = "Day 4 task 1", testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 4512
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val inputNumbers = input.readInputNumbers()
        val bingoSystem = input.readBingoSystem()

        for (currentNumber in inputNumbers) {
            bingoSystem.draw(currentNumber)
            val winnerBoards = bingoSystem.checkFinish()
            if (winnerBoards.isNotEmpty()) {
                val unmarkedSum = winnerBoards.first().unmarked().sum()
                return unmarkedSum * currentNumber
            }
        }
        error("no winner at the end")
    }
}
