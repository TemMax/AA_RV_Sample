package com.duglasher.recyclerviewsample.adapter.base

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T : RecyclerEntry>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    var clickListener: AdapterClickListener<T>? = null

    protected lateinit var item: T
        private set

    fun onBind(item: T) {
        this.item = item
        bind()
    }

    abstract fun bind()
    open fun payload(payload: Bundle) = Unit

    fun View.clickable() {
        setOnClickListener {
            clickListener?.invoke(it, item, adapterPosition)
        }
    }

}