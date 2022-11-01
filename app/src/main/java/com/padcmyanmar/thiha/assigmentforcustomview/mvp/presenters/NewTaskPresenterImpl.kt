package com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.NewTaskView

class NewTaskPresenterImpl : ViewModel(), NewTaskPresenter {
    lateinit var mView: NewTaskView
    override fun initView(view: NewTaskView) {
       mView = view
    }

    override fun onTapBack() {
      mView.navigateToMain()
    }

    override fun onTapSave() {
      mView.navigateToMain()
    }

    override fun onTapStartDate() {
       mView.pickDateForStartDate()
    }

    override fun onTapEndDate() {
     mView.pickDateForEndDate()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mView.navigateToProfile()

    }

    override fun onTapProfile() {
      mView.navigateToProfile()
    }
}