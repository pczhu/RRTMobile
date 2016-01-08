package cn.mobile.renrentou.controller.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScrollingTextView extends TextView {  
	   
    public ScrollingTextView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
   
    public ScrollingTextView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
   
    public ScrollingTextView(Context context) {  
        super(context);  
    }  
    @Override  
    protected void onDraw(Canvas canvas) {  
    	
        Drawable[] drawables = getCompoundDrawables();  
        if (drawables != null) {  
            Drawable drawableLeft = drawables[0];  
            if (drawableLeft != null) {  
                float textWidth = getPaint().measureText(getText().toString());  
                int drawablePadding = getCompoundDrawablePadding();  
                int drawableWidth = 0;  
                drawableWidth = drawableLeft.getIntrinsicWidth();  
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                if(bodyWidth > getWidth()){//如果已经大于最大宽度
                	canvas.translate(getPaddingLeft()/2, 0);
                }else{
                	canvas.translate((getWidth() - bodyWidth) / 2, 0);  
                }
            } 
            
			Drawable drawableright = drawables[2];
			if (drawableright != null) {

				float textWidth = getPaint().measureText(getText().toString());
				int drawablePadding = getCompoundDrawablePadding();
				int drawableWidth = 0;
				drawableWidth = drawableright.getIntrinsicWidth();
				float bodyWidth = textWidth + drawableWidth + drawablePadding;
				setPadding(0, 0, (int) (getWidth() - bodyWidth), 0);
				canvas.translate((getWidth() - bodyWidth) / 2, 0);
			}
        }  
        super.onDraw(canvas);  
    }  
    @Override  
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {  
        if(focused)  
            super.onFocusChanged(focused, direction, previouslyFocusedRect);  
    }  
   
    @Override  
    public void onWindowFocusChanged(boolean focused) {  
        if(focused)  
            super.onWindowFocusChanged(focused);  
    }  
   
   
    @Override  
    public boolean isFocused() {  
        return true;  
    }  
   
}  