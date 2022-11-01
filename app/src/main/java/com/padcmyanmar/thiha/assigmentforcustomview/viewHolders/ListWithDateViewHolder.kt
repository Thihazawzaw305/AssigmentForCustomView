package com.padcmyanmar.thiha.assigmentforcustomview.viewHolders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ListAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.view_holder_list_with_date.view.*

class ListWithDateViewHolder(itemView: View, private val mDelegate: ProfileDelegate): RecyclerView.ViewHolder(itemView) {

    init {
        itemView.rvTaskWithData.adapter = ListAdapter(false, mDelegate )
        itemView.rvTaskWithData.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
    }
}