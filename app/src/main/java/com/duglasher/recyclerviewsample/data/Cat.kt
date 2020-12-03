package com.duglasher.recyclerviewsample.data

import androidx.annotation.IntRange


class Cat(
    val name: String,
    val age: Int
)

class Dog(
    val name: String,
    val age: Int,
    @IntRange(from = 0L, to = 100L)
    val rawrVolume: Int
)