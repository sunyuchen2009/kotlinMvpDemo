package com.scwj.syc.kotlinmvpdemo.ui.main.presenter

import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MainContract
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-17
 */
class MainPresenter @Inject
constructor():MainContract.Presenter{

    private lateinit var mMainView:MainContract.View

    override fun attachView(view: MainContract.View) {
        this.mMainView=view
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}