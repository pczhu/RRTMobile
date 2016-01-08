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
    /**
     * 时间戳数据等进行转换
     * @param str  目标
     * @return
     */
    public static long parseString(String str){
        if(StringUtils.isEmpty(str)){
            return 0L;
        }
        if(str.contains(".")){
            str = str.substring(0,str.indexOf("."));
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }
    /**
     * 时间戳数据等进行转换
     * @param str  目标
     * @param defaultlong  转换失败默认值
     * @return
     */
    public static long parseString(String str,long defaultlong){
        if(StringUtils.isEmpty(str)){
            return 0L;
        }
        if(str.contains(".")){
            str = str.substring(0,str.indexOf("."));
        }


        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultlong;
        }
    }
}
