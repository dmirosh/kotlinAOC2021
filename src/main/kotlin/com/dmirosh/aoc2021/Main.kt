package com.dmirosh.aoc2021

import com.dmirosh.aoc2021.day1.task1.Day1Task1
import com.dmirosh.aoc2021.day1.task2.Day1Task2
import com.dmirosh.aoc2021.day2.task1.Day2Task1
import com.dmirosh.aoc2021.day2.task2.Day2Task2
import com.dmirosh.aoc2021.util.Task
import com.dmirosh.aoc2021.util.TestFailedException
import kotlin.system.exitProcess

object Main {
    private val tasks: List<Task<*>> = listOf(
        Day1Task1(),
        Day1Task2(),
        Day2Task1(),
        Day2Task2()
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
