package com.padcmyanmar.thiha.assigmentforcustomview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.viewHolders.ListWithDateViewHolder

class listWithDateAdapter(private val mDelegate: ProfileDelegate): RecyclerView.Adapter<ListWithDateViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListWithDateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_with_date, parent, false)
        return ListWithDateViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: ListWithDateViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }
}