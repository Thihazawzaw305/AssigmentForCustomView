package com.padcmyanmar.thiha.assigmentforcustomview.components

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class OverlapRecyclerView:RecyclerView.ItemDecoration() {

    private val  vertOverLap = -25

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        var position = parent.getChildAdapterPosition(view)
      if(position !=0){
          outRect.left = -40
      }
    }
}