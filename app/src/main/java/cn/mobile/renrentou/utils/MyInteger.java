package cn.mobile.renrentou.utils;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/7 上午9:59
 * 版本：V1.0
 * 修改历史：
 */
public class MyInteger {

    public static int parseInteger(String str){
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        if(str.contains(".")){
            str = str.substring(0,str.indexOf("."));
        }

        int  i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i;
    }
}
