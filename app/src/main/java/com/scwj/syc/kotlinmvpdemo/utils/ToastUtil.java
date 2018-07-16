package com.scwj.syc.kotlinmvpdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sunYuChen on 2018-07-16
 */
public class ToastUtil {
    public void toastLong(Context mContext,String str){
        Toast.makeText(mContext,str,Toast.LENGTH_LONG).show();
    }
    public void toastShort(Context mContext,String str){
        Toast.makeText(mContext,str,Toast.LENGTH_SHORT).show();
    }
}
