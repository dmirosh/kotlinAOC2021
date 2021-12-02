package com.dmirosh.aoc2021.day2

sealed class Command(val units: Int) {
    class MoveForward(units: Int) : Command(units)
    class MoveUp(units: Int) : Command(units)
    class MoveDown(units: Int) : Command(units)

    companion object {
        private val DELIMITER = "\\s+".toRegex()
        fun String.toCommand(): Command {
            val split = this.split(DELIMITER)
            if (split.size != 2) {
                error("Unexpected command '$this'")
            }
            return when (split.first().lowercase()) {
                "forward" -> MoveForward(split.last().toInt())
                "down" -> MoveDown(split.last().toInt())
                "up" -> MoveUp(split.last().toInt())
                else -> error("Unexpected command '$this'")
            }
        }
    }
}
