package com.duglasher.recyclerviewsample.adapter.holder

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.duglasher.recyclerviewsample.R
import com.duglasher.recyclerviewsample.adapter.AnimalEntry
import com.duglasher.recyclerviewsample.adapter.base.BaseViewHolder


class DogHolder(itemView: View) : BaseViewHolder<AnimalEntry.DogEntry>(itemView) {

    private val tvName = itemView.findViewById<TextView>(R.id.tvName)
    private val tvRawrVolume = itemView.findViewById<TextView>(R.id.tvRawrVolume)

    init {
        itemView.clickable()
    }

    override fun bind() {
        tvName.text = "%s, %d".format(item.dog.name, item.dog.age)
        tvRawrVolume.text = item.dog.rawrVolume.toString()
    }

    override fun payload(payload: Bundle) {
        if (payload.containsKey(KEY_PAYLOAD_AGE)) {
            tvName.text = "%s, %d".format(item.dog.name, payload.getInt(KEY_PAYLOAD_AGE))
        }
    }

    companion object {
        const val KEY_PAYLOAD_AGE = ".age"
    }

}