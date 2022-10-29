package com.padcmyanmar.thiha.assigmentforcustomview.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate

class ProfileViewHolder(itemView: View,private val mDelegate: ProfileDelegate): RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTapProfile()
        }
    }
}