package com.dmirosh.aoc2021.day3.task1

import com.dmirosh.aoc2021.day3.DiagnosticReport
import com.dmirosh.aoc2021.day3.DiagnosticReport.Companion.toDiagnosticReport
import com.dmirosh.aoc2021.util.Task

class Day3Task1(
    name: String = "Day 3 task 1",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 198,
        "input.txt" to 1092896
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val report = input.toDiagnosticReport()

        val gammaRate = calculateGammaRate(report)
        val epsilonRate = calculateEpsilonRate(report, gammaRate)

        return gammaRate * epsilonRate
    }

    private fun calculateGammaRate(report: DiagnosticReport): Int {
        return report.getMeasurement {
            report.getMostCommonBit(it)
        }
    }

    private fun calculateEpsilonRate(report: DiagnosticReport, gammaRate: Int): Int {
        return report.getComplement(gammaRate)
    }
}
