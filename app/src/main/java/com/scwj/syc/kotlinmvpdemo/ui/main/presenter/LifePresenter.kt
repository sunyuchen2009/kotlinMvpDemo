package com.scwj.syc.kotlinmvpdemo.ui.main.presenter

import com.scwj.syc.kotlinmvpdemo.ui.main.contract.LifeContract
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-24
 */
class LifePresenter @Inject
constructor():LifeContract.Presenter {

    private lateinit var mView:LifeContract.View

    override fun attachView(view: LifeContract.View) {
        this.mView=view
    }

    override fun detachView() {
    }
}