package cn.mobile.renrentou.utils;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * 名称：AShapeUtils
 * 作用：代码生成Shape资源
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/18 下午12:05
 * 版本：V1.0
 * 修改历史：
 */
public class AShapeUtils {


    public AShapeUtils() {
    }

    public static ShapeDrawable generateCornerShapeDrawable(int color, int corner) {
        return generateCornerShapeDrawable(color, corner, corner, corner, corner);
    }

    public static ShapeDrawable generateCornerShapeDrawable(int color, int topLeftCorner, int topRightCorner, int bottomRightCorner, int bottomLeftCorner) {
        RoundRectShape shape = new RoundRectShape(new float[]{(float) topLeftCorner, (float) topLeftCorner, (float) topRightCorner, (float) topRightCorner, (float) bottomRightCorner, (float) bottomRightCorner, (float) bottomLeftCorner, (float) bottomLeftCorner}, (RectF) null, (float[]) null);
        ShapeDrawable sd = new ShapeDrawable(shape);
        sd.getPaint().setColor(color);
        sd.getPaint().setStyle(Paint.Style.FILL);
        return sd;
    }

    public static ShapeDrawable generateCornerStrokeDrawable(int color, float width, int corner) {
        return generateCornerStrokeDrawable(color, width, corner, corner, corner, corner);
    }

    public static ShapeDrawable generateCornerStrokeDrawable(int color, float width, int topLeftCorner, int topRightCorner, int bottomRightCorner, int bottomLeftCorner) {
        RoundRectShape shape = new RoundRectShape(new float[]{(float) topLeftCorner, (float) topLeftCorner, (float) topRightCorner, (float) topRightCorner, (float) bottomRightCorner, (float) bottomRightCorner, (float) bottomLeftCorner, (float) bottomLeftCorner}, (RectF) null, (float[]) null);
        ShapeDrawable sd = new ShapeDrawable(shape);
        sd.getPaint().setColor(color);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        sd.getPaint().setAntiAlias(true);
        sd.getPaint().setStrokeWidth(width);
        return sd;
    }

    public static StateListDrawable selectorClickSimple(Drawable normal, Drawable pressed) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{16842919, 16842910}, pressed);
        drawable.addState(new int[0], normal);
        return drawable;
    }

    public static StateListDrawable selectorClickColorCornerSimple(int normalColor, int pressedColor, int corner) {
        return selectorClickSimple(generateCornerShapeDrawable(normalColor, corner), generateCornerShapeDrawable(pressedColor, corner));
    }

    public static ShapeDrawable generateBackgroundDrawable(int color) {
        OvalShape shape = new OvalShape();
        ShapeDrawable sd = new ShapeDrawable(shape);
        Paint paint = sd.getPaint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        return sd;
    }
}