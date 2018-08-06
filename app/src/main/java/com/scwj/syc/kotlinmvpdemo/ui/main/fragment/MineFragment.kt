package com.scwj.syc.kotlinmvpdemo.ui.main.fragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.scwj.syc.kotlinmvpdemo.R
import com.scwj.syc.kotlinmvpdemo.base.BaseActivity
import com.scwj.syc.kotlinmvpdemo.base.BaseFragment
import com.scwj.syc.kotlinmvpdemo.di.component.FragmentComponent
import com.scwj.syc.kotlinmvpdemo.ui.main.contract.MineContract
import com.scwj.syc.kotlinmvpdemo.ui.main.presenter.MinePresenter
import kotlinx.android.synthetic.main.fragment_life.*
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * Created by sunYuChen on 2018-07-25
 */
class MineFragment:BaseFragment<MinePresenter>(),MineContract.View {
    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun getLayout(): Int = R.layout.fragment_mine

    override fun showMsg(msg: String) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Glide.with(this)
//                .load("https://www.easyicon.net/api/resizeApi.php?id=1082114&size=128")
//                .into(mine_iv_gif)
    }

    companion object {

        val TAG=MineFragment::class.java.simpleName

        fun newInstance():MineFragment{
            val args= Bundle()
            val fragment=MineFragment()
            fragment.arguments=args
            return fragment
        }
    }
}