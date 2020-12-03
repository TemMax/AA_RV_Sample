package com.duglasher.recyclerviewsample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duglasher.recyclerviewsample.adapter.AnimalEntry
import com.duglasher.recyclerviewsample.adapter.AnimalsAdapter
import com.duglasher.recyclerviewsample.adapter.holder.DogHolder
import com.duglasher.recyclerviewsample.data.Cat
import com.duglasher.recyclerviewsample.data.Dog


class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private val animalsAdapter = AnimalsAdapter()

    private val animals: List<AnimalEntry> = listOf(
        AnimalEntry.CatEntry(Cat("Ivan", 3)),
        AnimalEntry.DogEntry(Dog("Pupsik", 6, 30)),
        AnimalEntry.CatEntry(Cat("Vasya", 1)),
        AnimalEntry.CatEntry(Cat("Artem", 2)),
        AnimalEntry.DogEntry(Dog("Lima", 7, 0)),
        AnimalEntry.DogEntry(Dog("Dog1", 10, 70))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnClick).setOnClickListener {
//            val newList = animals.toMutableList()
//            newList[0] = AnimalEntry.CatEntry(Cat("Ivan", 1000))
//            animalsAdapter.setNewData(newList, false)
            animalsAdapter.notifyItemChanged(1, bundleOf(DogHolder.KEY_PAYLOAD_AGE to 1000))
        }

        recycler = findViewById(R.id.rvAnimals)
        recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = animalsAdapter
        }
        animalsAdapter.clickListener = { _, item, _ ->
            if (item is AnimalEntry.DogEntry) {
                Toast.makeText(this, item.dog.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        animalsAdapter.setNewData(animals)
    }

}