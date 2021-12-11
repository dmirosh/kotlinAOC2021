package com.dmirosh.aoc2021

import com.dmirosh.aoc2021.day1.task1.Day1Task1
import com.dmirosh.aoc2021.day1.task2.Day1Task2
import com.dmirosh.aoc2021.day2.task1.Day2Task1
import com.dmirosh.aoc2021.day2.task2.Day2Task2
import com.dmirosh.aoc2021.day3.task1.Day3Task1
import com.dmirosh.aoc2021.day3.task2.Day3Task2
import com.dmirosh.aoc2021.day4.task1.Day4Task1
import com.dmirosh.aoc2021.day4.task2.Day4Task2
import com.dmirosh.aoc2021.day5.task1.Day5Task1
import com.dmirosh.aoc2021.day5.task2.Day5Task2
import com.dmirosh.aoc2021.day6.task1.Day6Task1
import com.dmirosh.aoc2021.day6.task2.Day6Task2
import com.dmirosh.aoc2021.day7.task1.Day7Task1
import com.dmirosh.aoc2021.day7.task2.Day7Task2
import com.dmirosh.aoc2021.util.Task
import com.dmirosh.aoc2021.util.TestFailedException
import kotlin.system.exitProcess

object Main {
    private val tasks: List<Task<*>> = listOf(
        Day1Task1(),
        Day1Task2(),
        Day2Task1(),
        Day2Task2(),
        Day3Task1(),
        Day3Task2(),
        Day4Task1(),
        Day4Task2(),
        Day5Task1(),
        Day5Task2(),
        Day6Task1(),
        Day6Task2(),
        Day7Task1(),
        Day7Task2()
    )

    @JvmStatic
    fun main(args: Array<String>) {
        tasks.forEach { printTaskSolution(it) }
    }

    private fun printTaskSolution(task: Task<*>) {
        println(task.name)
        try {
            val taskResult = task.solve()
            println("$taskResult\n")
        } catch (ex: TestFailedException) {
            System.err.println("Test '${ex.fileName}' failed: ${ex.errorMessage}")
            exitProcess(1)
        }
    }
}
