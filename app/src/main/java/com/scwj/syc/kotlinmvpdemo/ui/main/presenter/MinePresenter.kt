package com.scwj.syc.kotlinmvpdemo.ui.main.presenter

import com.scwj.syc.kotlinmvpdemo.ui.main.contract.LifeContract
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MineContract
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-24
 */
class MinePresenter @Inject
constructor(): MineContract.Presenter {

    lateinit var mView:MineContract.View

    override fun attachView(view: MineContract.View) {
        this.mView=view
    }

    override fun detachView() {
    }
}