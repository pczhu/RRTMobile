package cn.mobile.renrentou.controller.widget.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 名称：CustomGridView
 * 作用：自定义布局用于个人中心的九宫格
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/30 下午4:25
 * 版本：V1.0
 * 修改历史：
 */
public class CustomGridView extends GridView{
    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGridView(Context context) {
        super(context);
    }

    public CustomGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}