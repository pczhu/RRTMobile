package cn.mobile.renrentou.utils;

import java.util.Date;

import cn.mobile.renrentou.domain.BlackBean;

/**
 * 名称：TimeUtils
 * 作用：时间工具类
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午12:26
 * 版本：V1.0
 * 修改历史：
 */
public class TimeUtils {
    public static long getTime(){
        return new Date().getTime();
    }
}
