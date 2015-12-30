package cn.mobile.renrentou.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/28 下午4:41
 * 版本：V1.0
 * 修改历史：
 */
public class SystemUtils {
    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取屏幕宽度高度
     * @param context
     * @return  宽高数组 [宽度，高度]
     */
    public static int[] getScreenMaxWidth(Context context){
        //DisplayMetrics metrics = new DisplayMetrics();
        //getW

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return new int[]{width,height};
    }
}
