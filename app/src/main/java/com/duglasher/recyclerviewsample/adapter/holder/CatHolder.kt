package com.duglasher.recyclerviewsample.adapter.holder

import android.view.View
import android.widget.TextView
import com.duglasher.recyclerviewsample.R
import com.duglasher.recyclerviewsample.adapter.AnimalEntry
import com.duglasher.recyclerviewsample.adapter.base.BaseViewHolder


class CatHolder(itemView: View) : BaseViewHolder<AnimalEntry.CatEntry>(itemView) {

    private val tvName = itemView.findViewById<TextView>(R.id.tvName)

    override fun bind() {
        tvName.text = "%s, %d".format(item.cat.name, item.cat.age)
    }

}