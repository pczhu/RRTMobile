package cn.mobile.renrentou.controller.ui.fragment.basefragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.xutils.x;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.widget.textview.ScrollingTextView;
import cn.mobile.renrentou.utils.SystemUtils;


/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:01
 * 版本：V1.0
 * 修改历史：
 */
public class BaseFragment extends Fragment {
    private boolean injected = false;
    protected Activity activity;
    protected Context mContext;
    private Toolbar toolbar;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }
    public void setToolBar(Toolbar view,boolean back){
        this.toolbar = view;
        toolbar.setPadding(0, SystemUtils.getStatusBarHeight(activity), 0, 0);
        ScrollingTextView title_back = (ScrollingTextView) toolbar.findViewById(R.id.title_back);
        Drawable last = getResources().getDrawable(R.mipmap.last);
        if(!back){
            //title_back.setVisibility(View.GONE);

            title_back.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else{//退出图标颜色变为白色
            //title_back.setVisibility(View.VISIBLE);
            title_back.setCompoundDrawablesWithIntrinsicBounds(last,null,null,null);
            finished(title_back);
        }
    }
    private void finished(TextView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity != null)
                    activity.finish();
            }
        });
    }

    /**
     * 设置页面标题
     * @param title 标题控件
     * @param titleName 标题内容
     */
    public void setTitle(TextView title,String titleName){
        title.setText(titleName);
    }

    /**
     * 回退按键
     * @param back 控件
     */
    public void setBack(TextView back){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });
    }

}
