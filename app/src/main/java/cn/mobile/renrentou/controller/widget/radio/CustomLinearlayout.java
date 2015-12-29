package cn.mobile.renrentou.controller.widget.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import cn.mobile.renrentou.utils.LogUtils;


/**
 * 名称：CustomLinearlayout
 * 作用：一个继承自线性布局的RadioGroup
 * 描述：做了回调，可以监听子控件的点击事件
 * 作者：pczhu
 * 创建时间： 15/12/29 上午11:10
 * 版本：V1.0
 * 修改历史：
 */
public class CustomLinearlayout extends LinearLayout implements CheckButtonSelected {
    private RadioChangedListener radioChangedListener;
    public CustomLinearlayout(Context context) {
        super(context);
    }


    public CustomLinearlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        ((CustomRadioButton)child).setCheckedChanged(this,getChildCount()-1);
    }

    @Override
    public void onCheckedChanged(int count, boolean flag) {
        LogUtils.i("出现点击事件:" + count + ":" + flag);
        for (int j = 0; j < getChildCount(); j++) {

            if (j != count) {
                LogUtils.i("遍历其他控件:" + j + ":" + flag);
                ((CustomRadioButton) getChildAt(j)).setStatue(false);
            }else{
                ((CustomRadioButton) getChildAt(j)).setStatue(true);
            }
        }
        if (radioChangedListener != null)
            radioChangedListener.getSelectedStatue(count, flag);
    }

    /**
     * 选定某个控件被选中
     * @param count 控件编号  从0开始
     */
    public void setChildStatue(int count){
        onCheckedChanged(count,true);
    }


    public void setOnRadioChangedListener(RadioChangedListener radioChangedListener){
        this.radioChangedListener = radioChangedListener;
    }

}
