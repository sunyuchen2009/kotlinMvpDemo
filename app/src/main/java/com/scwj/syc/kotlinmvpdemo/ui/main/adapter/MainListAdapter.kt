package com.scwj.syc.kotlinmvpdemo.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.scwj.syc.kotlinmvpdemo.base.BaseViewHolderTSK
import com.scwj.syc.kotlinmvpdemo.model.bean.ThingsBean

/**
 * Created by sunYuChen on 2018-07-17
 * 这里RecyclerView用的是Brvah框架，官方教程简书地址：https://www.jianshu.com/p/b343fcff51b0
 */
class MainListAdapter(layoutResId:Int,data:List<ThingsBean>):BaseQuickAdapter<ThingsBean,BaseViewHolderTSK>(layoutResId,data){

    override fun convert(helper: BaseViewHolderTSK, item: ThingsBean) {
    }

}