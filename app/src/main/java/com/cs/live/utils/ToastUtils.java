package com.cs.live.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/13.
 * Toast工具类
 */

public class ToastUtils {
    public static void toastText(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
