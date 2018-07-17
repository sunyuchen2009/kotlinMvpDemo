package com.scwj.syc.kotlinmvpdemo.ui.main.contract

import com.scwj.syc.kotlinmvpdemo.base.BasePresenter
import com.scwj.syc.kotlinmvpdemo.base.BaseView

/**
 * Created by sunYuChen on 2018-07-17
 */
interface MainContract {

    interface Veiw:BaseView

    interface Presenter:BasePresenter<Veiw>
}