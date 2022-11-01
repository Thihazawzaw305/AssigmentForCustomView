package com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.MainView

class MainPresenterImpl: MainPresenter, ViewModel() {

    var mMainView: MainView? = null
    override fun iniView(view: MainView) {
        mMainView = view
    }

    override fun onTapAdd() {
      mMainView?.navigateToCreateNewTask()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapProfile() {
        mMainView?.navigateToProfile()
    }


}