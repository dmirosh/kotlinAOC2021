package com.dmirosh.aoc2021.day5

data class Point(val x: Int, val y: Int) {

    fun stepTo(end: Point): Point {
        val deltaX = when {
            x == end.x -> 0
            x < end.x -> 1
            else -> -1
        }
        val deltaY = when {
            y == end.y -> 0
            y < end.y -> 1
            else -> -1
        }
        return Point(x + deltaX, y + deltaY)
    }

    companion object {

        fun String.toPoint(): Point {
            return this.split(",").let {
                Point(it.first().trim().toInt(), it.last().trim().toInt())
            }
        }
    }
}
