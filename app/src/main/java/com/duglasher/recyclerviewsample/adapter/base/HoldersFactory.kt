package com.duglasher.recyclerviewsample.adapter.base

import android.view.View
import com.duglasher.recyclerviewsample.R
import com.duglasher.recyclerviewsample.adapter.holder.CatHolder
import com.duglasher.recyclerviewsample.adapter.holder.DogHolder


object HoldersFactory {

    fun <T : RecyclerEntry> holder(
        type: Int,
        view: View
    ): BaseViewHolder<*> {
        return when (type) {

            // region Animals
            R.layout.item_cat -> CatHolder(view)
            R.layout.item_dog -> DogHolder(view)
            // endregion

            else              -> error("Unknown type")
        }
    }

}