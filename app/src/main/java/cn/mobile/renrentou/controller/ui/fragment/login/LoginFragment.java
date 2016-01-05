package cn.mobile.renrentou.controller.ui.fragment.login;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.xw.repo.xedittext.XEditText;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.service.UserInfoRefreshService;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.button.CircularProgressButton;
import cn.mobile.renrentou.domain.Failed;
import cn.mobile.renrentou.domain.LoginInfo;
import cn.mobile.renrentou.utils.SolidToast;
import cn.mobile.renrentou.utils.StringUtils;

/**
 * 名称：LoginFragment
 * 作用：登录页面
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/31 下午4:23
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_login)
public class LoginFragment extends BaseFragment implements View.OnClickListener{
    /**
     * 登录图标
     */
    @ViewInject(R.id.circularButton_login)
    private CircularProgressButton circularButton_login;
    /**
     * 用户名
     */
    @ViewInject(R.id.xedit_login_username)
    private XEditText xEditText_Username;
    /**
     * 密码
     */
    @ViewInject(R.id.xedit_login_password)
    private XEditText xEditText_Password;
    /**
     * 外部布局，实例化为了剥夺焦点
     */
    @ViewInject(R.id.login_root)
    private LinearLayout linearLayout;
    private Callback.Cancelable cancelable;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    /**
     * 设置监听 初始化状态
     */
    private void initData() {
        linearLayout.setOnClickListener(this);
        circularButton_login.setIndeterminateProgressMode(true);//循环转
        circularButton_login.setProgress(0);//初始化状态
        circularButton_login.setOnClickListener(this);
//        xEditText_Username.setOnFocusChangeListener(this);
//        xEditText_Password.setOnFocusChangeListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_root://点击外部布局的时候剥夺输入焦点
                clearFocus();
                break;
            case R.id.circularButton_login:
                if(circularButton_login.getProgress() == 50){//如果是正在请求的状态
                    if(cancelable != null){//取消请求，提示请求失败
                        cancelable.cancel();
                        circularButton_login.setProgress(-1);
                        circularButtonStateBack();
                    }
                    return;
                }else if(circularButton_login.getProgress() == 100 || circularButton_login.getProgress() == -1){
                    //如果是成功失败状态，无需操作。
                    return;
                }
                clearFocus();
                String mUsername = xEditText_Username.getNonSeparatorText();
                String mPassword = xEditText_Password.getNonSeparatorText();
                if (StringUtils.isEmpty(mUsername)) {
                    SolidToast.showToast(activity, R.string.login_username_empty);
                    return;
                }
                if (StringUtils.isEmpty(mPassword)) {
                    SolidToast.showToast(activity, R.string.login_username_empty);
                    return;
                }
                circularButton_login.setProgress(50);//正在请求
                RequestParams requestParams = new RequestParams(Constants.BASE_SERVER_URL2 + Constants.LOGIN_URL);
                requestParams.addBodyParameter("username", mUsername);
                requestParams.addBodyParameter("password", mPassword);
                cancelable = HttpAction.getInstance(activity).post(requestParams,LoginInfo.class, new HttpResponseListener<LoginInfo>() {
                    @Override
                    public void onSuccessForData(LoginInfo loginInfo) {
                        circularButton_login.setProgress(100);
                        circularButtonStateBack();
                        Intent intent = new Intent(activity, UserInfoRefreshService.class);
                        intent.putExtra("logininfo",loginInfo);
                        activity.startService(intent);
                        activity.finish();
                    }

                    @Override
                    public void onSuccessButNoData(Failed failed) {
                        circularButton_login.setProgress(-1);
                        circularButtonStateBack();
                        SolidToast.showToast(activity, failed.getMsg());
                    }

                    @Override
                    public void onFanished() {
                        xEditText_Username.setFocusableInTouchMode(true);
                        xEditText_Password.setFocusableInTouchMode(true);
                    }
                });
                break;
            default:
                break;
        }
    }
    /**
     * 恢复按钮状态
     */
    private void circularButtonStateBack(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                circularButton_login.setProgress(0);
            }
        }, 500);
    }
    /**
     * 清除焦点并隐藏软键盘
     */
    private void clearFocus() {
       linearLayout.requestFocus();

    }

    /**
     * 软键盘的监听
     * @param v
     * @param hasFocus
     */
//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        if(!hasFocus){
//            InputMethodManager imm = (InputMethodManager) getActivity()
//                            .getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//        }
//    }
}
