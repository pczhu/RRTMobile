package cn.mobile.renrentou.domain;

import android.graphics.drawable.Drawable;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/18 下午2:55
 * 版本：V1.0
 * 修改历史：
 */
public class PanelItem{
    private int id;
    private String title;
    private int resId;
    private int normalColor;
    private int pressColor;
    private int labelColor;
    private int lableSize;
    private Drawable labelBackgroundDrawable;

    public PanelItem(int id,String title, int resId, int normalColor, int pressColor, int labelColor, int lableSize, Drawable labelBackgroundDrawable) {
        this.id = id;
        this.title = title;
        this.resId = resId;
        this.normalColor = normalColor;
        this.pressColor = pressColor;
        this.labelColor = labelColor;
        this.lableSize = lableSize;
        this.labelBackgroundDrawable = labelBackgroundDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getNormalColor() {
        return normalColor;
    }

    public void setNormalColor(int normalColor) {
        this.normalColor = normalColor;
    }

    public int getPressColor() {
        return pressColor;
    }

    public void setPressColor(int pressColor) {
        this.pressColor = pressColor;
    }

    public int getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(int labelColor) {
        this.labelColor = labelColor;
    }

    public int getLableSize() {
        return lableSize;
    }

    public void setLableSize(int lableSize) {
        this.lableSize = lableSize;
    }

    public Drawable getLabelBackgroundDrawable() {
        return labelBackgroundDrawable;
    }

    public void setLabelBackgroundDrawable(Drawable labelBackgroundDrawable) {
        this.labelBackgroundDrawable = labelBackgroundDrawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}