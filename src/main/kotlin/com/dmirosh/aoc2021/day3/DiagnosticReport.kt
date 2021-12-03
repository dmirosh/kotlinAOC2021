package com.dmirosh.aoc2021.day3

import com.dmirosh.aoc2021.util.BinaryUtils.copy
import com.dmirosh.aoc2021.util.BinaryUtils.invert
import com.dmirosh.aoc2021.util.BinaryUtils.toInt
import java.util.*

class DiagnosticReport(
    private val totalRows: Int,
    val columns: List<BitSet>
) {

    private val bitsInMeasurement: Int = columns.size

    fun getMostCommonBit(column: BitSet): Boolean {
        return column.cardinality() >= totalRows / 2
    }

    fun getMeasurement(bitExtractor: (BitSet) -> Boolean): Int {
        return columns
            .foldIndexed(BitSet()) { columnIndex, acc, nextColumn ->
                acc.set(invertIndex(columnIndex), bitExtractor(nextColumn))
                acc
            }.toInt()
    }

    fun getComplement(number: Int): Int {
        return (1 shl bitsInMeasurement) - 1 - number
    }

    private fun invertIndex(index: Int): Int {
        return bitsInMeasurement - 1 - index
    }

    fun invertColumn(column: BitSet): BitSet {
        return column.invert(totalRows)
    }

    fun hasSingleClearBit(set: BitSet): Boolean {
        return totalRows - set.cardinality() == 1
    }

    fun hasSingleSetBit(set: BitSet): Boolean {
        return set.cardinality() == 1
    }

    fun mostBitsAreSet(base: BitSet, next: BitSet): Boolean {
        val tester = base.copy().also { it.and(next) }
        return tester.cardinality() >= base.cardinality() - tester.cardinality()
    }

    fun mostBitsAreClear(base: BitSet, next: BitSet): Boolean {
        val tester = base.copy().also { it.or(next) }
        return totalRows - tester.cardinality() > tester.cardinality() - base.cardinality()
    }

    companion object {
        fun Sequence<String>.toDiagnosticReport(): DiagnosticReport {
            var total = 0
            val columns = mutableListOf<BitSet>()
            this
                .forEachIndexed { measurementIndex, measurement ->
                    total++
                    measurement.forEachIndexed { bitIndex, bit ->
                        if (columns.size <= bitIndex) {
                            columns.add(BitSet())
                        }
                        columns[bitIndex].set(measurementIndex, bit == '1')
                    }
                }
            return DiagnosticReport(total, columns)
        }
    }
}