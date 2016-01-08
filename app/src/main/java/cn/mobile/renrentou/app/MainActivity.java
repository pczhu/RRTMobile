package cn.mobile.renrentou.app;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.modul.action.UserInfoAction;
import cn.mobile.renrentou.controller.store.sp.impl.ShareStoreAction;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.controller.ui.fragment.main.CenterFragment;
import cn.mobile.renrentou.controller.ui.fragment.main.ChatFragment;
import cn.mobile.renrentou.controller.ui.fragment.main.MainFragment;
import cn.mobile.renrentou.controller.ui.fragment.main.ProjectFragment;
import cn.mobile.renrentou.controller.widget.radio.CustomLinearlayout;
import cn.mobile.renrentou.controller.widget.radio.RadioChangedListener;
import cn.mobile.renrentou.domain.UserInfo;
import cn.mobile.renrentou.utils.LogUtils;

/**
 * 名称：MainActivity
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/28 下午2:44
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements RadioChangedListener{


    @ViewInject(R.id.main_custom_radio_group)
    private CustomLinearlayout customLinearlayout;
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    //四个Fragment
    private MainFragment mainFragment;
    private ProjectFragment projectFragment;
    private ChatFragment chatFragment;
    private CenterFragment centerFragment;
    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toolbar, true);//初始化toolbar
        setSwipeBackEnable(false);//MainActivity不侧滑动
        initFragmentView();//初始化Fragment布局
        customLinearlayout.setOnRadioChangedListener(this);//主菜单监听
        customLinearlayout.setChildStatue(0);//设置默认主菜单为主页面
        setTitle("人人投");
        UserInfoAction.getInstance(this).getUserInfo();//刷新用户数据
    }

    /**
     * 初始化Fragment
     */
    private void initFragmentView(){
        mainFragment = new MainFragment();
        projectFragment = new ProjectFragment();
        chatFragment = new ChatFragment();
        centerFragment = new CenterFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment, mainFragment,"MainFragment")
                .add(R.id.main_fragment, projectFragment, "ProjectFragment")
                .add(R.id.main_fragment, chatFragment, "ChatFragment")
                .add(R.id.main_fragment, centerFragment, "CenterFragment")
                .hide(centerFragment).hide(projectFragment).hide(chatFragment)
                .show(mainFragment).commit();
        currentFragment = mainFragment;
    }
    /**
     * 主bottombar切换
     * @param count
     * @param flag
     */
    @Override
    public void getSelectedStatue(int count, boolean flag) {
        LogUtils.i("发现控件状态改变：" + count + ":" + flag);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (count){
            case 0:
                if(currentFragment instanceof MainFragment){
                    return;
                }
                fragmentTransaction.hide(currentFragment).show(mainFragment);
                currentFragment = mainFragment;
                setTitle("主页");
                break;
            case 1:
                fragmentTransaction.hide(currentFragment).show(projectFragment);
                currentFragment = projectFragment;
                setTitle("找项目");
                break;
            case 2:
                fragmentTransaction.hide(currentFragment).show(chatFragment);
                currentFragment = chatFragment;
                setTitle("聊天");
                break;
            case 3:
                fragmentTransaction.hide(currentFragment).show(centerFragment);
                currentFragment = centerFragment;
                setTitle("个人中心");
                if(allowCenterFragmentRefresh()){
                    UserInfoAction.getInstance(this).getUserInfo();
                    ShareStoreAction.getInstance(this).setLong("UserInfoTime", SystemClock.currentThreadTimeMillis());
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 防止出现控件重叠现象
     * @param fragment
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        if(mainFragment == null && fragment instanceof MainFragment){
            mainFragment = (MainFragment)fragment;
        }else if(projectFragment == null && fragment instanceof ProjectFragment){
            projectFragment = (ProjectFragment)fragment;
        }else if(chatFragment == null && fragment instanceof ChatFragment){
            chatFragment = (ChatFragment)fragment;
        }else if(centerFragment == null && fragment instanceof CenterFragment){
            centerFragment = (CenterFragment)fragment;
        }
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
    public void onSaveInstanceState(Bundle outState) {
        //防止Fragment销毁之后被保存
    }
    public boolean allowCenterFragmentRefresh(){
        if(!ShareStoreAction.getInstance(this).isLogin()){
            return false;
        }
        long time = ShareStoreAction.getInstance(this).getLong("UserInfoTime");
        long now = SystemClock.currentThreadTimeMillis();
        if(time == 0L)
            return true;//一次也没点击进入 允许刷新
        if((now - time) < 10 * 1000){
            return false;
        }
        return true;
    }
}
