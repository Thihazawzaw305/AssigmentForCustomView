package com.padcmyanmar.thiha.assigmentforcustomview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.viewHolders.ListViewHolder

class ListAdapter(private val status:Boolean,private val mDelegate: ProfileDelegate):RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view_holder, parent, false)
        return ListViewHolder(view, status,mDelegate)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }
}