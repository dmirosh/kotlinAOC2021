package com.dmirosh.aoc2021.day6

import java.util.*

class FishFarm {
    private val adultFishes = MutableList(7) { 0L }
    private val growingFishes = MutableList(2) { 0L }

    fun addFish(daysTillChildBearing: Int) {
        adultFishes[daysTillChildBearing] += 1L
    }

    fun countFishes(): Long {
        return growingFishes.sum() + adultFishes.sum()
    }

    fun simulateDay() {
        val newAdults = growingFishes.first()
        growingFishes[0] = adultFishes.first() // happy birthday little fishes

        Collections.rotate(growingFishes, -1)
        Collections.rotate(adultFishes, -1)

        adultFishes[6] += newAdults // welcome to adult life
    }
}
