package com.dmirosh.aoc2021.util

class TestFailedException(
    val fileName: String,
    val errorMessage: String
) : RuntimeException("$fileName: $errorMessage")
