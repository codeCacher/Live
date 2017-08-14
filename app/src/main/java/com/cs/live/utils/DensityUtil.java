package com.cs.live.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by wenmingvs on 15/12/27.
 * 常用单位转换的辅助类
 */
public class DensityUtil {

    private DensityUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @param context 上下文
     * @param dpVal dp
     * @return px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param context 上下文
     * @param spVal sp
     * @return px
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }
    /**
     * sp转dp
     *
     * @param context 上下文
     * @param spVal sp
     * @return dp
     */
    public static int sp2dp(Context context, float spVal) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics())/
                context.getResources().getDisplayMetrics().density);
    }
    /**
     * px转dp
     *
     * @param context 上下文
     * @param pxVal px
     * @return dp
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param context 上下文
     * @param pxVal px
     * @return sp
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }


}
