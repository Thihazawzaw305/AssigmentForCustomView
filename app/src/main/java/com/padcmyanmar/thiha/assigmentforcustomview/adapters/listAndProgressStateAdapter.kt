package com.padcmyanmar.thiha.assigmentforcustomview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.listdelegate
import com.padcmyanmar.thiha.assigmentforcustomview.viewHolders.listAndProgressStateViewHolder

class listAndProgressStateAdapter(private val mDelegate:listdelegate): RecyclerView.Adapter<listAndProgressStateViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listAndProgressStateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_and_state_progress, parent, false)
        return listAndProgressStateViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: listAndProgressStateViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 6
    }
}