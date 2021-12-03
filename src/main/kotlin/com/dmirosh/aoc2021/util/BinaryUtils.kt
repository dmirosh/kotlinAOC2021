package com.dmirosh.aoc2021.util

import java.util.*

object BinaryUtils {

    fun BitSet.toInt(): Int {
        return toLongArray()[0].toInt()
    }

    fun BitSet.copy(): BitSet {
        return BitSet.valueOf(this.toLongArray())
    }

    fun BitSet.invert(size: Int): BitSet {
        val inverted = BitSet.valueOf(this.toLongArray())
        inverted.flip(0, size)
        return inverted
    }
}