package cn.mobile.renrentou.controller.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.com.video.venvy.param.JjVideoRelativeLayout;
import cn.com.video.venvy.param.JjVideoView;
import cn.com.video.venvy.param.OnJjBufferCompleteListener;
import cn.com.video.venvy.param.OnJjBufferStartListener;
import cn.com.video.venvy.param.OnJjBufferingUpdateListener;
import cn.com.video.venvy.param.OnJjOpenStartListener;
import cn.com.video.venvy.param.OnJjOpenSuccessListener;
import cn.com.video.venvy.param.OnJjOutsideLinkClickListener;
import cn.com.video.venvy.param.VideoJjMediaContoller;
import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.utils.LogUtils;

/**
 * 名称：ProjectDetailActivity
 * 作用：项目详情页
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/15 上午11:21
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.activity_projectdetail)
public class ProjectDetailActivity extends BaseActivity{
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    private String pid;
    @ViewInject(R.id.video)
    private JjVideoView mVideoView;//
    @ViewInject(R.id.sdk_load_layout)
    private View mLoadBufferView;// //
    @ViewInject(R.id.sdk_sdk_ijk_load_buffer_text)
    private TextView mLoadBufferTextView;// //
    @ViewInject(R.id.sdk_ijk_progress_bar_layout)
    private View mLoadView;// /
    @ViewInject(R.id.sdk_ijk_progress_bar_text)
    private TextView mLoadText;// /

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toolbar, true);
        setTitle("项目详情");
        pid = getIntent().getStringExtra("pid");

        //开始逻辑
        initVideo();
    }
    private void initVideo(){
        mVideoView.setMediaController(new VideoJjMediaContoller(this, true));
        mLoadBufferTextView.setTextColor(getResources().getColor(R.color.red));
        /***
         * 设置缓冲
         */
        mVideoView.setMediaBufferingView(mLoadBufferView);
        /***
         * 视频开始加载数据
         */
        mVideoView.setOnJjOpenStart(new OnJjOpenStartListener() {
            @Override
            public void onJjOpenStart(String arg0) {
                mLoadText.setText(arg0);
            }
        });
        /***
         * 视频开始播放
         */
        mVideoView.setOnJjOpenSuccess(new OnJjOpenSuccessListener() {
            @Override
            public void onJjOpenSuccess() {
                mLoadView.setVisibility(View.GONE);
            }
        });

        mVideoView
                .setOnJjBufferingUpdateListener(new OnJjBufferingUpdateListener() {

                    @Override
                    public void onJjBufferingUpdate(int arg1) {
                        // TODO Auto-generated method stub
                        if (mLoadBufferView.getVisibility() == View.VISIBLE) {
                            mLoadBufferTextView.setText(String
                                    .valueOf(mVideoView.getBufferPercentage())
                                    + "%");
                            LogUtils.i("Video++====================缓冲值2====="
                                    + arg1);
                        }
                    }
                });
        /***
         * 注意VideoView 要调用下面方法 配置你用户信息
         */
        mVideoView.setVideoJjAppKey("NJQ-jdZde");
        mVideoView.setVideoJjPageName("cn.mobile.renrentou");
        // mVideoView.setMediaCodecEnabled(true);// 是否开启 硬解 硬解对一些手机有限制
        // 判断是否源 0 代表 8大视频网站url 3代表自己服务器的视频源 2代表直播地址 1代表本地视频(手机上的视频源),4特殊需求
        mVideoView.setVideoJjType(0);
        mVideoView.setVideoJjTitle("");
        mVideoView.setResourceVideo("http://www.tudou.com/albumplay/Lqfme5hSolM/AhJ924T8ZW8.html");
        RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.root);
        JjVideoRelativeLayout mJjVideoRelativeLayout = (JjVideoRelativeLayout) findViewById(R.id.jjlayout);
        mJjVideoRelativeLayout.setJjToFront(mLayout);// 设置此方法
        // 重新排序视图层级JjVideoRelativeLayout，避免横屏其它遮挡

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}
//        /***
//         * 用户自定义的外链 可 获取外链点击时间
//         */
//        mVideoView.setOnJjOutsideLinkClick(new OnJjOutsideLinkClickListener() {
//
//            @Override
//            public void onJjOutsideLinkClick(String arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//// 缓冲完成
//mVideoView.setOnJjBufferComplete(new OnJjBufferCompleteListener() {
//
//@Override
//public void onJjBufferCompleteListener(int arg0) {
//        // TODO Auto-generated method stub
//
//        }
//        });
// 缓冲开始
//mVideoView.setOnJjBufferStart(new OnJjBufferStartListener() {
//
//@Override
//public void onJjBufferStartListener(int arg0) {
//        LogUtils.i("Video++====================缓冲值=====" + arg0);
//        }
//        });