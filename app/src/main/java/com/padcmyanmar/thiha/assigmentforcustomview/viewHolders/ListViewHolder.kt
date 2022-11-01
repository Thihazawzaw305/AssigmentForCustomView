package com.padcmyanmar.thiha.assigmentforcustomview.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.list_view_holder.view.*

class ListViewHolder(itemView: View, status: Boolean,
                     private val mDelegate: ProfileDelegate):RecyclerView.ViewHolder(itemView) {

    init {

        if (status) {
            itemView.ivStatus.visibility = View.GONE
            itemView.viewStatus.visibility = View.GONE
        } else {
            itemView.ivStatus.visibility = View.VISIBLE
            itemView.viewStatus.visibility = View.VISIBLE
        }
        itemView.ivProfileTask.setOnClickListener {
            mDelegate.onTapProfile()
        }
    }
}