package com.padcmyanmar.thiha.assigmentforcustomview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ListAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ProfileAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.listWithDateAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.components.OverlapRecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.dummy.dummyGenreList
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.MainView
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters.MainPresenter
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_details.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mListAdapter : ListAdapter
    private lateinit var mProfileAdapter : ProfileAdapter
    private lateinit var mListWithDateAdapter : listWithDateAdapter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpRecyclerView()
        setUpTabLayout()
        setUpListener()

    }



    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.iniView(this)
    }

    private fun setUpListener(){
        btnAdd.setOnClickListener {
            mPresenter.onTapAdd()
        }
    }
    private fun setUpRecyclerView(){
  mListWithDateAdapter = listWithDateAdapter(mPresenter)
    rvListItems.adapter = mListWithDateAdapter
    rvListItems.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    mProfileAdapter = ProfileAdapter(mPresenter)
    rvProfile.adapter = mProfileAdapter
    rvProfile.layoutManager =LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    rvProfile.addItemDecoration(OverlapRecyclerView())

    mListAdapter = ListAdapter(true,mPresenter)
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

    override fun navigateToCreateNewTask() {
     startActivity(NewTaskActivity.newIntent(this))
    }


    override fun navigateToProfile() {
        val sheet = BottomSheetBehavior.from(bottomSheet)

//        tvInProgress.setOnClickListener {
        when {

            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> {
                sheet.state = BottomSheetBehavior.STATE_COLLAPSED
            }

        }
//        }

        btnClose.setOnClickListener {

            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}


