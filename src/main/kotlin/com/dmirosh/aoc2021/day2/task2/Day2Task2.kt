package com.dmirosh.aoc2021.day2.task2

import com.dmirosh.aoc2021.day2.Command
import com.dmirosh.aoc2021.day2.Command.Companion.toCommand
import com.dmirosh.aoc2021.util.Task

class Day2Task2(
    name: String = "Day 2 task 2",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 900
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
        is Command.MoveForward -> {
            submarine.xPos += command.units
            submarine.yPos += command.units * submarine.aim
        }
        is Command.MoveDown -> submarine.aim += command.units
        is Command.MoveUp -> submarine.aim -= command.units
    }
}
