package com.padcmyanmar.thiha.assigmentforcustomview.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.thiha.assigmentforcustomview.R
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ListAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.ProfileAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.adapters.listAndProgressStateAdapter
import com.padcmyanmar.thiha.assigmentforcustomview.components.OverlapRecyclerView
import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.acitivity_new_task.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_details.*
import java.util.*

class NewTaskActivity : AppCompatActivity() ,ProfileDelegate{

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,NewTaskActivity::class.java)
        }
    }

    private lateinit var mProfileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_new_task)


        setUpDatePicker()
        setUpRecyclerView()

    }

    private fun setUpDatePicker() {
        tvStartDate.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day: Int = calendar[Calendar.DAY_OF_MONTH]
            val month: Int = calendar[Calendar.MONTH]
            val year: Int = calendar[Calendar.YEAR]

            //date picker dialog

            val picker = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    tvStartDate.text =
                        ("$dayOfMonth/ ${monthOfYear + 1}/ $year")
                },
                2022,
                9,
                28
            )
            picker.show()
        }
        tvEndDate.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day: Int = calendar[Calendar.DAY_OF_MONTH]
            val month: Int = calendar[Calendar.MONTH]
            val year: Int = calendar[Calendar.YEAR]

            //date picker dialog

            val picker = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    tvEndDate.text =
                        ("$dayOfMonth/ ${monthOfYear + 1}/ $year")
                },
                2022,
                9,
                28
            )
            picker.show()
        }
    }

    private fun setUpRecyclerView() {

        mProfileAdapter = ProfileAdapter(this)
        rvProfileFromNewTask.adapter = mProfileAdapter
        rvProfileFromNewTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProfileFromNewTask.addItemDecoration(OverlapRecyclerView())


    }

    override fun onTapProfile() {

    }
}