package com.dmirosh.aoc2021.day4

class Board(
    private val board: Array<Array<Position>>
) {
    private var finished: Boolean = false

    fun draw(number: Int) {
        board.flatten().forEach {
            if (it.number == number) {
                it.marked = true
            }
        }
    }

    fun isFinished(): Boolean {
        if (!finished) {
            finished = anyRowFullyMarked() || anyColumnFullyMarked()
        }
        return finished
    }

    private fun anyRowFullyMarked(): Boolean {
        return board.any { row -> row.all { position -> position.marked } }
    }

    private fun anyColumnFullyMarked(): Boolean {
        val columnsIndices = board[0].indices
        for (columnIndex in columnsIndices) {
            if (isColumnMarked(columnIndex)) {
                return true
            }
        }
        return false
    }

    private fun isColumnMarked(columnIndex: Int): Boolean {
        return board.indices
            .all { rowIndex -> board[rowIndex][columnIndex].marked }
    }

    fun unmarked(): List<Int> {
        return board
            .flatten()
            .filterNot { it.marked }
            .map { it.number }
    }
}
