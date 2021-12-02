package com.dmirosh.aoc2021.day2.task1

import com.dmirosh.aoc2021.day2.Command
import com.dmirosh.aoc2021.day2.Command.Companion.toCommand
import com.dmirosh.aoc2021.util.Task

class Day2Task1(
    name: String = "Day 2 task 1",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 150
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val yellowSubmarine = Submarine()

        input
            .map { it.toCommand() }
            .forEach { applyCommand(yellowSubmarine, it) }

        return yellowSubmarine.xPos * yellowSubmarine.yPos
    }

    private fun applyCommand(submarine: Submarine, command: Command) = when (command) {
        is Command.MoveForward -> submarine.xPos += command.units
        is Command.MoveDown -> submarine.yPos += command.units
        is Command.MoveUp -> submarine.yPos -= command.units
    }
}
