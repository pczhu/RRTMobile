package cn.mobile.renrentou.utils;

/**
 * 名称：StringUtils
 * 作用：字符串处理工具类
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/28 下午4:42
 * 版本：V1.0
 * 修改历史：
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if(str == null ||"".equals(str))
            return true;
        else
            return false;
    }



}
