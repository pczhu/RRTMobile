package cn.mobile.renrentou.controller.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.xutils.x;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.MainActivity;
import cn.mobile.renrentou.controller.store.db.WelcomeInfoData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.utils.ImageUtils;
import cn.mobile.renrentou.utils.MyLong;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/24 上午9:24
 * 版本：V1.0
 * 修改历史：
 */
public class WelcomeActivity extends BaseActivity {
    private static long DURATION = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //数据库拿出数据 注意 数据是之前打开时候
        WelcomeInfoData welcomeInfoData = DbAction.getInstance(this);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        if(welcomeInfoData.getWelcomeInfo()!= null) {
            x.image().bind(imageView, welcomeInfoData.getWelcomeInfo().getPath(), ImageUtils.getImageOptions(R.mipmap.launch));
            DURATION = MyLong.parseString(welcomeInfoData.getWelcomeInfo().getMilltime(), 2000L);//拿到后台给的时间
        }else{
            imageView.setImageBitmap(ImageUtils.readBitMap(this, R.mipmap.launch));//没有存储的数据
        }
        // 闪屏
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class); //从启动动画ui跳转到主ui
                startActivity(intent);
                WelcomeActivity.this.finish(); // 结束启动动画界面
            }
        }, DURATION); //默认启动动画持续3秒钟 可以后台调节
    }

    @Override
    public void finish() {
        super.finish();
        //淡入淡出
        this.overridePendingTransition(R.anim.welcome_alpha_in, R.anim.welcome_alpha_out);
    }
}