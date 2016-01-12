package cn.mobile.renrentou.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;

import java.io.InputStream;

import cn.mobile.renrentou.R;


/**
 * 名称：EveryTest
 * 作用：
 * 描述：简单的本地图片加载工具类
 * 作者：pczhu
 * 创建时间： 15/12/9 上午10:07
 * 版本：V1.0
 * 修改历史：
 */
public class ImageUtils {
    public  static Bitmap readBitMap(Context context, int resId){
        BitmapFactory.Options opt = new  BitmapFactory.Options();
        opt.inPreferredConfig =  Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //  获取资源图片
        InputStream is =  context.getResources().openRawResource(resId);
        return  BitmapFactory.decodeStream(is, null, opt);
    }

    /**
     * 拿到xutils的option
     * @return
     */
    public static ImageOptions getImageOptions(int picid) {
        return new ImageOptions.Builder()
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                        //.setCrop(true)
                        // 加载中或错误图片的ScaleType
                .setPlaceholderScaleType(ImageView.ScaleType.FIT_XY)
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setLoadingDrawableId(picid)
                .setFailureDrawableId(picid)
                .build();
    }
    /**
     * 拿到xutils的option
     * @return
     */
    public static ImageOptions getImageOptions(int picid,ImageView.ScaleType scaleType) {
        return new ImageOptions.Builder()
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                //.setCrop(true)
                // 加载中或错误图片的ScaleType
                .setPlaceholderScaleType(scaleType)
                .setImageScaleType(scaleType)
                .setLoadingDrawableId(picid)
                .setFailureDrawableId(picid)
                .build();
    }
}
