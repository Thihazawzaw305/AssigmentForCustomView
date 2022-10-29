package com.padcmyanmar.thiha.assigmentforcustomview.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.listdelegate
import kotlinx.android.synthetic.main.list_view_holder.view.*

class listAndProgressStateViewHolder(itemView: View,private val mDelegate: listdelegate): RecyclerView.ViewHolder(itemView) {

init {
    itemView.ivProfileFromList.setOnClickListener {
        mDelegate.onTapProfile()
    }
}
}