package com.scwj.syc.kotlinmvpdemo.model.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by sunYuChen on 2018-07-17
 */

data class ThingsBean(var name: String) : Parcelable {

    constructor(source: Parcel) : this(source.readString())

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(this.name)
    }

    override fun describeContents(): Int = 0

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<ThingsBean> = object : Parcelable.Creator<ThingsBean> {
            override fun createFromParcel(source: Parcel): ThingsBean {
                return ThingsBean(source)
            }

            override fun newArray(size: Int): Array<ThingsBean?> {
                return arrayOfNulls(size)
            }
        }
    }

}