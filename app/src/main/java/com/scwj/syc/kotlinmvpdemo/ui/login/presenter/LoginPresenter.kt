package com.scwj.syc.kotlinmvpdemo.ui.login.presenter

import com.scwj.syc.kotlinmvpdemo.ui.login.activity.LoginActivity
import com.scwj.syc.kotlinmvpdemo.ui.login.contract.LoginContract
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-13
 */
class LoginPresenter @Inject
constructor():LoginContract.Presenter {

    lateinit var mView:LoginContract.View
    override fun attachView(view: LoginContract.View) {
        this.mView=view
    }

    override fun detachView(){

    }

}