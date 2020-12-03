package com.duglasher.recyclerviewsample.adapter.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


typealias AdapterClickListener<T> = (view: View, item: T, adapterPosition: Int) -> Unit

abstract class BaseAdapter<T : RecyclerEntry> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    var clickListener: AdapterClickListener<T>? = null

    var data: List<T> = emptyList()
        protected set

    override fun getItemViewType(position: Int) = data[position].layoutId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return HoldersFactory.holder<T>(
            viewType,
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        ) as BaseViewHolder<T>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.clickListener = clickListener
        holder.onBind(data[position])
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<T>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
            return
        }
        holder.payload(payloads[0] as Bundle)
    }

    override fun getItemCount() = data.size

    fun setNewData(list: List<T>, notifyDataSetChanged: Boolean = true) {
        data = list
        if (notifyDataSetChanged) {
            notifyDataSetChanged()
        }
    }

}