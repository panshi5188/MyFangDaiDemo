package com.wuwo.fangdaidemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.utils
 * 文件名：ShareUtils
 * 创建者：SGY
 * Created by 2018/5/20 20:47
 * 描述：TODO
 */

public class ShareUtils {

    public static final String NAME = "config";
    public static void putString(Context context,String key,String value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    public static String getString(Context context,String key,String defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }
    public static void putInt(Context context,String key,int value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    public static int getInt(Context context,String key,int defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }
    public static void putBoolean(Context context,String key,Boolean value){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    public static boolean getBoolean(Context context,String key,Boolean defValue){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    public static void deleShare(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }
    public static void deleAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
