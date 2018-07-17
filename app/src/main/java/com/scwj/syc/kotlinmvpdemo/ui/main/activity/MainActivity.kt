package com.scwj.syc.kotlinmvpdemo.ui.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.model.bean.ThingsBean
import com.scwj.syc.kotlinmvpdemo.ui.main.adapter.MainListAdapter
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MainContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(),MainContract.Veiw {

    private lateinit var mDataList : ArrayList<ThingsBean>

    private lateinit var mainListAdapter:MainListAdapter

    override fun getLayout(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        val manager=GridLayoutManager(this,1)

        mDataList= ArrayList()
        for (i in 1..10){
            mDataList.add(ThingsBean("1"))
        }

        mainListAdapter=MainListAdapter(R.layout.main_list_item,mDataList)
        mainListAdapter.setOnItemChildClickListener({ _, _, position ->
            Toast.makeText(this,"onItemChildClick" + position,Toast.LENGTH_SHORT).show()
        })
        rv_list.adapter=mainListAdapter
        rv_list.layoutManager=manager
        mainListAdapter.expandAll()
    }

    override fun initInject() {
        activityComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun showMsg(msg: String) {
        Toast.makeText(this,"Great",Toast.LENGTH_SHORT).show()
    }

}
