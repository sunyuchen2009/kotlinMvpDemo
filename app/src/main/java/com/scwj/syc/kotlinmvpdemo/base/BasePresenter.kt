package com.scwj.syc.kotlinmvpdemo.base

/**
 * Created by sunYuChen on 2018-07-09
 */
interface BasePresenter<in T:BaseView>{

    fun attachView(view:T)

    fun detachView()
}