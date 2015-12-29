package cn.mobile.renrentou.controller.widget.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.utils.StringUtils;

/**
 * 名称：自定义radiobutton
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/28 下午7:46
 * 版本：V1.0
 * 修改历史：
 */
public class CustomRadioButton extends RelativeLayout implements View.OnClickListener {

    private ImageView imageview;
    private TextView textView;
    private TextView message_number;
    private int count;
    private CheckButtonSelected checkButtonSelected;
    public CustomRadioButton(Context context) {
        super(context);
        init(context, null);

    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (isInEditMode()) {
            return;
        }
        View view = View.inflate(context, R.layout.custom_radiobutton,this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRadioButton);
        Drawable drawable = typedArray.getDrawable(R.styleable.CustomRadioButton_buttonpic);
        int message_num = typedArray.getInteger(R.styleable.CustomRadioButton_message_num, 0);
        String title = typedArray.getString(R.styleable.CustomRadioButton_buttontxt);
        boolean visibility = typedArray.getBoolean(R.styleable.CustomRadioButton_message_visibility,false);
        imageview = (ImageView) view.findViewById(R.id.title_pic);
        textView = (TextView) view.findViewById(R.id.title_txt);
        message_number = (TextView) view.findViewById(R.id.unread_msg_number);
        if(!StringUtils.isEmpty(title))
            textView.setText(title);
        if(drawable!=null)
            imageview.setBackground(drawable);
        if(visibility)
            message_number.setVisibility(View.VISIBLE);
        else
            message_number.setVisibility(View.GONE);
        message_number.setText(message_num + "");
        this.setOnClickListener(this);
    }
    public void setStatue(boolean checked){
        setSelected(checked);
        imageview.setSelected(checked);
        textView.setSelected(checked);
    }

    @Override
    public void onClick(View v) {
        if(!this.isSelected()){


            setSelected(true);
            imageview.setSelected(true);
            textView.setSelected(true);
            if(checkButtonSelected != null)
                checkButtonSelected.onCheckedChanged(count,true);
        }
    }
    public void setText(String str){
        textView.setText(str);
    }
    public void setText(int id){
        textView.setText(id);
    }
    public String getText(){
        return textView.getText().toString();
    }
    public void setMessageNum(int num){
        message_number.setText(num);
    }
    public String getMessageNum(){
        return message_number.getText().toString();
    }
    public void setMessageNumVisibility(int visibility){
        message_number.setVisibility(visibility);
    }
    public int getMessageNumVisibility(){
        return message_number.getVisibility();
    }
    public void setCheckedChanged(CheckButtonSelected checkButtonSelected,int count){
        this.checkButtonSelected = checkButtonSelected;
        this.count = count;
    }

}
