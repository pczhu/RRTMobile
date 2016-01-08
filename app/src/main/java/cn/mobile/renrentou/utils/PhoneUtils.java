package cn.mobile.renrentou.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 名称：PhoneUtils
 * 作用：打电话的工具类
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/7 下午4:36
 * 版本：V1.0
 * 修改历史：
 */
public class PhoneUtils {
    public static void callTo(Context context,String number){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }
}
