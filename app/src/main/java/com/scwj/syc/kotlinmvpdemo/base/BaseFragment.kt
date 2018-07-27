package com.scwj.syc.kotlinmvpdemo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwj.syc.kotlinmvpdemo.di.component.DaggerFragmentComponent
import com.scwj.syc.kotlinmvpdemo.di.component.FragmentComponent
import com.scwj.syc.kotlinmvpdemo.di.module.FragmentModule
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-23
 */
abstract class BaseFragment<T:BasePresenter<*>>: Fragment(),BaseView {

    private lateinit var mView:View

    @Inject
    lateinit var mPresenter:T

    protected val fragmentComponent:FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .build()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initInject()
        initPresenter()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView= layoutInflater.inflate(getLayout(),null)
        return mView
    }

    override fun onDestroyView() {
        if (mPresenter!=null)
            mPresenter!!.detachView()
        super.onDestroyView()
    }

    protected abstract fun initPresenter()

    protected abstract fun initInject()

    protected abstract fun getLayout():Int


}