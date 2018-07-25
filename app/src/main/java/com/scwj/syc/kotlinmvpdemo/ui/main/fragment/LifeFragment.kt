package com.scwj.syc.kotlinmvpdemo.ui.main.fragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseFragment
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.LifeContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.LifePresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_life.*
import javax.inject.Inject

/**
 * Created by sunYuChen on 2018-07-24
 */
class LifeFragment @Inject
constructor():BaseFragment<LifePresenter>(),LifeContract.View{
    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun getLayout(): Int =R.layout.fragment_life

    override fun showMsg(msg: String) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
                .load("https://www.easyicon.net/api/resizeApi.php?id=1082114&size=128")
                .centerCrop()
                .into(life_iv_gif)
    }

    companion object {

        val TAG=LifeFragment::class.java.simpleName

        fun newInstance():LifeFragment{
            val args= Bundle()
            val fragment=LifeFragment()
            fragment.arguments=args
            return fragment
        }
    }
}