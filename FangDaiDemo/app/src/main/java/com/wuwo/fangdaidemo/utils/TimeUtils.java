package com.wuwo.fangdaidemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名：FangDaiDemo
 * 包名：com.wuwo.fangdaidemo.utils
 * 文件名：TimeUtils
 * 创建者：SGY
 * Created by 2018/5/28 10:35
 * 描述：TODO
 */

public class TimeUtils {

    public static String getNowTime(){
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return df.format(day);
    }
}
