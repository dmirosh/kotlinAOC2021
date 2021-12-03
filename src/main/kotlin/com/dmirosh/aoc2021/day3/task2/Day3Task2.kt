package com.dmirosh.aoc2021.day3.task2

import com.dmirosh.aoc2021.day3.DiagnosticReport
import com.dmirosh.aoc2021.day3.DiagnosticReport.Companion.toDiagnosticReport
import com.dmirosh.aoc2021.util.BinaryUtils.copy
import com.dmirosh.aoc2021.util.Task

class Day3Task2(
    name: String = "Day 3 task 1",
    testsConfig: Map<String, Int> = mapOf(
        "test1.txt" to 230
    )
) : Task<Int>(name = name, testsConfig = testsConfig) {

    override fun solve(input: Sequence<String>): Int {
        val report = input.toDiagnosticReport()

        val oxygenRating = calculateOxygenRating(report)
        val co2Rating = calculateC02Rating(report)

        return oxygenRating * co2Rating
    }

    private fun calculateOxygenRating(report: DiagnosticReport): Int {
        val measurementIndex = report.columns.reduce { filtered, nextColumn ->
            if (report.hasSingleSetBit(filtered)) {
                return@reduce filtered
            }
            filtered.copy().also {
                if (report.mostBitsAreSet(filtered, nextColumn)) {
                    it.and(nextColumn)
                } else {
                    it.and(report.invertColumn(nextColumn))
                }
            }
        }.nextSetBit(0)
        return report.getMeasurement {
            it.get(measurementIndex)
        }
    }

    private fun calculateC02Rating(report: DiagnosticReport): Int {
        val measurementIndex = report.columns.reduce { filtered, next ->
            if (report.hasSingleClearBit(filtered)) {
                return@reduce filtered
            }
            filtered.copy().also {
                if (report.mostBitsAreClear(it, next)) {
                    it.or(report.invertColumn(next))
                } else {
                    it.or(next)
                }
            }
        }.nextClearBit(0)
        return report.getMeasurement {
            it.get(measurementIndex)
        }
    }
}
