package cn.mobile.renrentou.controller.ui.activity.baseactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.xutils.x;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.utils.SystemUtils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/28 下午2:55
 * 版本：V1.0
 * 修改历史：
 */
public class BaseActivity extends SwipeBackActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //设置渲染通知栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.red);

        /***********/
    }

    /**
     * 设置渲染
     * @param on
     */
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 处理toolbar
     * @param view
     * @param back 是否退出
     */
    public void setToolBar(Toolbar view,boolean back){
        this.toolbar = view;
        toolbar.setPadding(0, SystemUtils.getStatusBarHeight(this), 0, 0);
        TextView title_back = (TextView) toolbar.findViewById(R.id.title_back);
        if(!back){
            title_back.setVisibility(View.GONE);
        }else{//退出图标颜色变为白色
            title_back.setVisibility(View.VISIBLE);
            finished(title_back);
        }
    }

    private void finished(TextView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置页面标题
     * @param titleName 标题内容
     */
    public void setTitle(String titleName){
        if(toolbar!= null)
            ((TextView)toolbar.findViewById(R.id.title_name)).setText(titleName);
    }
    public void setRightButtonText(String titleName){
        ((TextView) findViewById(R.id.title_right)).setText(titleName);
    }
    public void setRightButtonDrawable(int id){
        ((TextView) findViewById(R.id.title_right)).setCompoundDrawables(null,
                null,getResources().getDrawable(R.mipmap.last),null);
    }
}
