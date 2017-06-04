package com.ptteng.small.admin.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by hujin on 2017/5/20.
 */
public class DateUtil {

    public static String timeCycle(Long time) throws ParseException {
        Long t = System.currentTimeMillis();
        Long z = t / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        Long result = t-time;
        Long result2 = z - time;
        if (result < 60000 && result > 0 ) {
            String date = result / 1000 + "秒前";
            return date;
        }
        if (result < 3600000 && result >= 60000) {
            String date = result / 60000 + "分钟前";
            return date;
        }
        if (result < 86400000 && result >= 3600000) {
            String date = result / 3600000 + "小时前";
            return date;
        }
        if (result < 86400000 * 5 && result >= 86400000) {
            String date = result / 86400000 + "天前";
            return date;
        }
        SimpleDateFormat format =  new SimpleDateFormat("MM月dd日");
        Date datetime = new Date(time);
        String date = format.format(datetime);
        return date;
    }
    public static void main(String[] args) throws ParseException {
       Long n = System.currentTimeMillis();
       Long a = 1495281149412l-454000001;
        String d = DateUtil.timeCycle(1495282702000l);
        System.out.print(d);
    }
}
