package cn.mobile.renrentou.utils;

import java.security.MessageDigest;

/**
 * 名称：MD5Utils
 * 作用：加密工具类
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/5 下午12:20
 * 版本：V1.0
 * 修改历史：
 */
public class MD5Utils {
    // MD5加密
    public static String toMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 16位的加密，其实就是32位加密后的截取
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
