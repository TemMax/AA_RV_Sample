package com.duglasher.recyclerviewsample.adapter

import com.duglasher.recyclerviewsample.R
import com.duglasher.recyclerviewsample.adapter.base.RecyclerEntry
import com.duglasher.recyclerviewsample.data.Cat
import com.duglasher.recyclerviewsample.data.Dog


sealed class AnimalEntry : RecyclerEntry {

    class CatEntry(val cat: Cat) : AnimalEntry() {
        override val layoutId: Int = R.layout.item_cat
    }

    class DogEntry(val dog: Dog) : AnimalEntry() {
        override val layoutId: Int = R.layout.item_dog
    }

}