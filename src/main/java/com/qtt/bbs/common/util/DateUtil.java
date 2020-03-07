package com.qtt.bbs.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project name：NzCloudRobin
 * Class name：DataUtil
 * description：TODO
 * date：2020/2/15 15:07
 *
 * @author ：XC
 */
public class DateUtil {
    //获取今天的日期
    public static String getDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    //查询今日剩下的秒数
    public static int getSeconds(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=sdf.parse(getDate()+" 23:59:59");
            return (int)(date.getTime()-System.currentTimeMillis())/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
