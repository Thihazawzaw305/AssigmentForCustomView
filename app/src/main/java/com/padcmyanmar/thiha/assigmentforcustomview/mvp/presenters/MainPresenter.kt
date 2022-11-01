package com.padcmyanmar.thiha.assigmentforcustomview.mvp.presenters

import com.padcmyanmar.thiha.assigmentforcustomview.delegates.ProfileDelegate
import com.padcmyanmar.thiha.assigmentforcustomview.mvp.view.MainView

interface MainPresenter: IBasePresenter,ProfileDelegate{

    fun iniView(view: MainView)
    fun onTapAdd()
}