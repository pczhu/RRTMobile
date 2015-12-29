package cn.mobile.renrentou.utils;

/**
 * 名称：MyLong
 * 作用：便于转换Long类型
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/24 下午5:16
 * 版本：V1.0
 * 修改历史：
 */
public class MyLong {
    public static Long parseString(String str){
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }
    public static Long parseString(String str,long defaultlong){
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultlong;
        }
    }
}
