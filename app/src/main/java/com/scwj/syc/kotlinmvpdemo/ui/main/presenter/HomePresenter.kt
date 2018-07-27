package com.scwj.syc.kotlinmvpdemo.ui.main.presenter

import com.scwj.syc.kotlinmvpdemo.base.BaseView
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.HomeContract
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-23
 */
class HomePresenter @Inject
constructor():HomeContract.Presenter {

    private lateinit var mHomeView:HomeContract.View

    override fun attachView(view: HomeContract.View) {
        this.mHomeView=view
    }

    override fun detachView() {
    }
}