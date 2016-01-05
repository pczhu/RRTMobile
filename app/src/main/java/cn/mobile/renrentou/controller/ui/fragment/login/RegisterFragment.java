package cn.mobile.renrentou.controller.ui.fragment.login;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.xw.repo.xedittext.XEditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.button.CircularProgressButton;

/**
 * 名称：RegisterFragment
 * 作用：登录页面
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/31 下午4:24
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_register)
public class RegisterFragment extends BaseFragment {
    @ViewInject(R.id.circularButton_register)
    CircularProgressButton circularButton1;
    @ViewInject(R.id.xedit_register_username)
    private XEditText xEditText_Username;
    @ViewInject(R.id.xedit_register_password)
    private XEditText xEditText_Password;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        circularButton1.setIndeterminateProgressMode(true);
        circularButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (circularButton1.getProgress() == 0) {
                    circularButton1.setProgress(50);
                } else if (circularButton1.getProgress() == 100) {
                    circularButton1.setProgress(0);
                } else {
                    circularButton1.setProgress(-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            circularButton1.setProgress(0);
                        }
                    }, 200);
                }
            }
        });
    }
}
