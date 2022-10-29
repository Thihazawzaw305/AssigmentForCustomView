package com.padcmyanmar.thiha.assigmentforcustomview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ListAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ProfileAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.listAndProgressStateAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.components.OverlapRecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.listdelegate
import com.padcmyanmar.thiha.assigmentforcustomview.dummy.dummyGenreList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_details.*

class MainActivity : AppCompatActivity(), ProfileDelegate , listdelegate{

    private lateinit var mListAdapter : ListAdapter
    private lateinit var mProfileAdapter : ProfileAdapter
    private lateinit var mListAndProgressStateAdapter : listAndProgressStateAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpTabLayout()
        setUpListener()

    }


private fun setUpRecyclerView(){
  mListAndProgressStateAdapter = listAndProgressStateAdapter(this)
    rvListItems.adapter = mListAndProgressStateAdapter
    rvListItems.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    mProfileAdapter = ProfileAdapter(this)
    rvProfile.adapter = mProfileAdapter
    rvProfile.layoutManager =LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    rvProfile.addItemDecoration(OverlapRecyclerView())

    mListAdapter = ListAdapter()
    rvListItemsFromProfile.adapter = mListAdapter
    rvListItemsFromProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

}




private fun setUpTabLayout() {
    dummyGenreList.forEach {
        tabLayOut.newTab().apply {
            text = it
            tabLayOut.addTab(this)
        }

    }

}
private fun setUpListener(){
    tabLayOut.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {
          Snackbar.make(window.decorView, tab?.text?:"",Snackbar.LENGTH_LONG).show()
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {

        }

        override fun onTabReselected(tab: TabLayout.Tab?) {

        }
    })

    btnAdd.setOnClickListener {
        startActivity(NewTaskActivity.newIntent(this))
    }
}

    override fun onTapProfile() {
        val sheet  = BottomSheetBehavior.from(bottomSheet)

//        tvInProgress.setOnClickListener {
            when {

                sheet.state != BottomSheetBehavior.STATE_EXPANDED ->{
                    sheet.state = BottomSheetBehavior.STATE_EXPANDED
                }
                else ->{
                    sheet.state = BottomSheetBehavior.STATE_COLLAPSED
                }

            }
//        }

        btnClose.setOnClickListener {

            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}


