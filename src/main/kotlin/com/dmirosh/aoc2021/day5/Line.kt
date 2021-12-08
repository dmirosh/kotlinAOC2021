package com.dmirosh.aoc2021.day5

import com.dmirosh.aoc2021.day5.Point.Companion.toPoint

data class Line(val start: Point, val end: Point) {

    val horizontal = start.y == end.y
    val vertical = start.x == end.x

    fun points() = sequence {
        yield(start)
        var current = start
        while (current != end) {
            current = current.stepTo(end)
            yield(current)
        }
    }

    companion object {
        fun String.toLine(): Line {
            val split = this.split("->")
            return Line(
                start = split.first().toPoint(),
                end = split.last().toPoint()
            )
        }
    }
}
