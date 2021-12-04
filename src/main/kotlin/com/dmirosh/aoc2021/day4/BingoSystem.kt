package com.dmirosh.aoc2021.day4

import com.dmirosh.aoc2021.util.StringUtils.toInts

data class BingoSystem(
    private val boards: List<Board>
) {
    private var winnerBoards: LinkedHashSet<Board> = LinkedHashSet()

    val totalBoards: Int = boards.size

    fun draw(number: Int) {
        boards.forEach { it.draw(number) }
    }

    fun checkFinish(): LinkedHashSet<Board> {
        if (winnerBoards.size != totalBoards) {
            winnerBoards.addAll(boards.filter { it.isFinished() })
        }
        return winnerBoards
    }

    companion object {
        fun Sequence<String>.readBingoSystem(): BingoSystem {
            val boards: MutableList<Board> = mutableListOf()
            val boardBuilder: MutableList<List<Int>> = mutableListOf()

            for (line in this.drop(1)) {
                if (line.isEmpty()) {
                    if (boardBuilder.isNotEmpty()) { // if not first delimiter
                        boards.add(boardBuilder.toBoard())
                        boardBuilder.clear()
                    }
                } else {
                    boardBuilder.add(line.toInts())
                }
            }
            if (boardBuilder.isNotEmpty()) {
                boards.add(boardBuilder.toBoard())
            }
            return BingoSystem(boards)
        }

        private fun List<List<Int>>.toBoard(): Board {
            return Board(
                board = this
                    .map { row -> row.map { number -> number.toPosition() }.toTypedArray() }
                    .toTypedArray()
            )
        }

        private fun Int.toPosition() = Position(this, false)

        fun Sequence<String>.readInputNumbers(): List<Int> {
            return this.first().split(",").map { it.toInt() }
        }
    }
}
