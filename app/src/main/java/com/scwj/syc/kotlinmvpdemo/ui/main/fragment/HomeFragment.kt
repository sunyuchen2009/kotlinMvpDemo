package com.scwj.syc.kotlinmvpdemo.ui.main.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseFragment
import com.scwj.syc.kotlinmvpdemo.model.bean.ThingsBean
import com.scwj.syc.kotlinmvpdemo.ui.main.adapter.HomeListAdapter
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.HomeContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by sunYuChen on 2018-07-23
 */
class HomeFragment: BaseFragment<HomePresenter>(),HomeContract.View {


    private lateinit var mDataList : ArrayList<ThingsBean>

    private lateinit var homeListAdapter:HomeListAdapter

    override fun getLayout()=R.layout.fragment_home

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        mDataList= ArrayList()
        for (i in 1..10){
            mDataList.add(ThingsBean("1"))
        }

        val manager= GridLayoutManager(activity,1)
        homeListAdapter= HomeListAdapter(R.layout.home_list_item,mDataList)
        home_rv_list.layoutManager=manager
        home_rv_list.adapter=homeListAdapter
        homeListAdapter.expandAll()
    }

    override fun showMsg(msg: String) {
    }

    companion object {

        val TAG=HomeFragment::class.java.simpleName

        fun newInstance():HomeFragment{
            val args=Bundle()
            val fragment=HomeFragment()
            fragment.arguments=args
            return fragment
        }
    }
}