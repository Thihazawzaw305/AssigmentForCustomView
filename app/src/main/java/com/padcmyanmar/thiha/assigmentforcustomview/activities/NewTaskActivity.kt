package com.padcmyanmar.thiha.assigmentforcustomview.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ListAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ProfileAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.components.OverlapRecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.dummy.dummyGenreList
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters.NewTaskPresenter
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters.NewTaskPresenterImpl
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.NewTaskView
import kotlinx.android.synthetic.main.acitivity_new_task.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_details.*
import java.util.*

class NewTaskActivity : AppCompatActivity() ,NewTaskView{
    private lateinit var mListAdapter : ListAdapter
    val calendar: Calendar = Calendar.getInstance()
    val day: Int = calendar[Calendar.DAY_OF_MONTH]
    val month: Int = calendar[Calendar.MONTH]
    val year: Int = calendar[Calendar.YEAR]
    lateinit var mPresenter: NewTaskPresenter
    private lateinit var mProfileAdapter: ProfileAdapter
    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,NewTaskActivity::class.java)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_new_task)
        setUpPresenter()
        setUpRecyclerView()
        setUpTabLayout()
        setUpListener()


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[NewTaskPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListener(){
        tvStartDate.setOnClickListener {
            mPresenter.onTapStartDate()
        }


        tvEndDate.setOnClickListener {
            mPresenter.onTapEndDate()
        }

        btnBackFromNewTask.setOnClickListener {
            mPresenter.onTapBack()
        }

        tvSave.setOnClickListener {
            mPresenter.onTapSave()
        }


    }

    private fun setUpTabLayout() {
        dummyGenreList.forEach {
            tabLayOut.newTab().apply {
                text = it
                tabLayOut.addTab(this)
            }

        }

    }

    private fun setUpRecyclerView() {

        mProfileAdapter = ProfileAdapter(mPresenter)
        rvProfileFromNewTask.adapter = mProfileAdapter
        rvProfileFromNewTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProfileFromNewTask.addItemDecoration(OverlapRecyclerView())

        mListAdapter = ListAdapter(true,mPresenter)
        rvListItemsFromProfile.adapter = mListAdapter
        rvListItemsFromProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }


    override fun pickDateForStartDate() {
        val picker = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                tvStartDate.text =
                    ("$dayOfMonth/ ${monthOfYear + 1}/ $year")
            },
            year, month, day
        )
        picker.show()
    }

    override fun pickDateForEndDate() {
        val picker = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                tvEndDate.text =
                    ("$dayOfMonth/ ${monthOfYear + 1}/ $year")
            },
            year, month, day
        )
        picker.show()
    }

    override fun navigateToMain() {
     finish()
    }

    override fun navigateToProfile() {
        val sheet = BottomSheetBehavior.from(bottomSheetFromNewTask)

        when {

            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> {
                sheet.state = BottomSheetBehavior.STATE_COLLAPSED
            }

        }


        btnClose.setOnClickListener {

            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}