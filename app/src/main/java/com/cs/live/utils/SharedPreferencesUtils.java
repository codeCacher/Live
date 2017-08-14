package com.cs.live.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/4/29.
 * SharedPreferences Utils
 */

public class SharedPreferencesUtils {
    private static SharedPreferences sp;

    /**
     * 根据键值从sp中移除一项
     * @param context 上下文
     * @param key 键值
     */
    public static void remove(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * put a string into the SharedPreferences file
     * @param context Context
     * @param key Key
     * @param value the string
     */
    public static void putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * get the string from the SharedPreferences file via the key
     * @param context Context
     * @param key Key
     * @param defaultValue if can't find the string through the key,return the defaultValue
     * @return string
     */
    public static String getString(Context context, String key, String defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defaultValue);
    }

    /**
     * put a int value into the SharedPreferences file
     * @param context Context
     * @param key Key
     * @param value the int value
     */
    public static void putInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * get the int value from the SharedPreferences file via the key
     * @param context Context
     * @param key Key
     * @param defaultValue if can't find the string through the key,return the defaultValue
     * @return int
     */
    public static int getInt(Context context, String key, int defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defaultValue);
    }


    /**
     * 将一个boolean值放入sp中
     * @param context 上下文
     * @param key 键值
     * @param value boolean值
     */
    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 根据键值从sp中获取boolean值
     * @param context 上下文
     * @param key 键值
     * @param defaultValue 若根据键值没有找到对应的boolean值，则返回默认值
     * @return boolean
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defaultValue);
    }
}
