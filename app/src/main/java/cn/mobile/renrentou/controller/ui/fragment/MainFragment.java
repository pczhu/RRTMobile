package cn.mobile.renrentou.controller.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;

import butterknife.InjectView;
import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:01
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_main)
public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragment";

//    @InjectView(R.id.title_back)
//    private TextView leftBack;
//    @InjectView(R.id.title_name)
//    private TextView title;
//    @InjectView(R.id.title_right)
//    private TextView rightBtn;
    @InjectView(R.id.listview_main)
    private ListView listview;

    private Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(injected){
            listview.setClipToPadding(false);
            setInsets(activity,listview);
        }
    }
}
