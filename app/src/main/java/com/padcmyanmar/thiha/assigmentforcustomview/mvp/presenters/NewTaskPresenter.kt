package com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters

import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.NewTaskView

interface NewTaskPresenter:IBasePresenter, ProfileDelegate {
    fun initView(view:NewTaskView)
    fun onTapBack()
    fun onTapSave()
    fun onTapStartDate()
    fun onTapEndDate()

}