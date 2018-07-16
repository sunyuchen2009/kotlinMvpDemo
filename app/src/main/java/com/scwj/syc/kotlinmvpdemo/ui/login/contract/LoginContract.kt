package com.scwj.syc.kotlinmvpdemo.ui.login.contract

import com.scwj.syc.kotlinmvpdemo.base.BasePresenter
import com.scwj.syc.kotlinmvpdemo.base.BaseView

/**
 * Created by sunYuChen on 2018-07-13
 */
interface LoginContract {

    interface View:BaseView

    interface Presenter:BasePresenter<View>
}