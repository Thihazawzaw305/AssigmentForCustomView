package com.padcmyanmar.thiha.assigmentforcustomview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.viewHolders.ProfileViewHolder

class ProfileAdapter(private val mDelegate: ProfileDelegate): RecyclerView.Adapter<ProfileViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_view_holder, parent, false)
        return ProfileViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }
}