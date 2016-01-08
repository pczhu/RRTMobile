package cn.mobile.renrentou.controller.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.mobile.renrentou.controller.ui.fragment.main.CenterFragment;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/6 上午8:49
 * 版本：V1.0
 * 修改历史：
 */
public class AppReceiver extends BroadcastReceiver {
    public static final String REFRESH_USERINFO = "refresh_userinfo";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(REFRESH_USERINFO)){
            if(CenterFragment.intance!=null){
                CenterFragment.intance.onRefresh();
            }
        }
    }
}
