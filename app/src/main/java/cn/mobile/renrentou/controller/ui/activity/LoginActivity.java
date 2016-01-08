package cn.mobile.renrentou.controller.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.flyco.roundview.RoundTextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.AppManager;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.controller.ui.fragment.login.LoginFragment;
import cn.mobile.renrentou.controller.ui.fragment.login.RegisterFragment;

/**
 * 名称：LoginActivity
 * 作用：注册登录页面
 * 描述：主要控制两个Fragment切换，尤其注意切换时容易引发的no host问题
 * 作者：pczhu
 * 创建时间： 15/12/31 下午3:24
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @ViewInject(R.id.login_panel)
    private FrameLayout frameLayout;
    @ViewInject(R.id.login)
    private RoundTextView roundTextView_login;
    @ViewInject(R.id.register)
    private RoundTextView roundTextView_register;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private boolean isInAnimation = false;
    private int currentid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(false);
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_panel, loginFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
        roundTextView_login.setOnClickListener(this);
        roundTextView_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                if(currentid == 0){
                    return;
                }
                currentid = 0;
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.login_slide_left_in, R.anim.login_slide_right_out);
                transaction.replace(R.id.login_panel, loginFragment).commit();
                isInAnimation = true;
                changedAnimationState();
                break;
            case R.id.register:
                if(currentid == 1){
                    return;
                }
                currentid = 1;
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.setCustomAnimations(R.anim.login_slide_right_in,R.anim.login_slide_left_out);
                transaction2.replace(R.id.login_panel, registerFragment).commit();
                isInAnimation = true;
                changedAnimationState();
                break;
            default:
                break;
        }

    }

    /**
     * 定时切换动画标志位
     */
    private void changedAnimationState(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isInAnimation = false;
            }
        }, 1000);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(isInAnimation){//控制动画时的操作
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(isInAnimation){//控制动画时的操作
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
    public void onSaveInstanceState(Bundle outState) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppManager.getAppManager().removeActivity(this);
    }
}
