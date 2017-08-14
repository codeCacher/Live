package com.cs.live.utils;

import android.content.Context;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by SEELE on 2017/7/15.
 * 有关获取显示状态的工具类
 */

public class DisplayUtils {

    /**
     * 获取顶部状态栏的高度
     * @param context 上下文
     * @return 顶部状态栏的高度（像素）
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c;

        Object obj;

        Field field;

        int x = 0, sbar = 0;

        try {

            c = Class.forName("com.android.internal.R$dimen");

            obj = c.newInstance();

            field = c.getField("status_bar_height");

            x = Integer.parseInt(field.get(obj).toString());

            sbar = context.getResources().getDimensionPixelSize(x);

        } catch (Exception e1) {

            e1.printStackTrace();

        }

        return sbar;
    }

    /**
     * 获取屏幕的高度
     * @param context 上下文
     * @return 屏幕的高度（像素）
     */
    public int getDisplayHeight(Context context){
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }

    /**
     * 获取屏幕的宽度
     * @param context 上下文
     * @return 屏幕的宽度（像素）
     */
    public int getDisplayWidth(Context context){
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }
}
