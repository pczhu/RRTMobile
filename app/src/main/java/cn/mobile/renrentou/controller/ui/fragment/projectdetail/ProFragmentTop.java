package cn.mobile.renrentou.controller.ui.fragment.projectdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.john.waveview.WaveView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import cn.com.video.venvy.param.JjVideoRelativeLayout;
import cn.com.video.venvy.param.JjVideoView;
import cn.com.video.venvy.param.OnJjBufferingUpdateListener;
import cn.com.video.venvy.param.OnJjOpenStartListener;
import cn.com.video.venvy.param.OnJjOpenSuccessListener;
import cn.com.video.venvy.param.VideoJjMediaContoller;
import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.activity.MProjectDetailsActivity;
import cn.mobile.renrentou.controller.ui.adapter.PanelGridAdapter;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.dashboard.DashboardView;
import cn.mobile.renrentou.controller.widget.gridview.CustomGridView;
import cn.mobile.renrentou.domain.ProjectDetail;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.SolidToast;
import de.greenrobot.event.EventBus;

/**
 * 名称：ProFragmentTop
 * 作用：项目详情上布局
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/18 下午5:48
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_protop)
public class ProFragmentTop extends BaseFragment implements AdapterView.OnItemClickListener {
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
    @ViewInject(R.id.custom_gridview)
    private CustomGridView customGridView;
    @ViewInject(R.id.videobtn)
    private ImageView imageView;
    @ViewInject(R.id.root)
    private RelativeLayout mLayout;
    @ViewInject(R.id.jjlayout)
    private JjVideoRelativeLayout mJjVideoRelativeLayout;
    @ViewInject(R.id.wave_view)
    private WaveView waveView;
    @ViewInject(R.id.pbcount)
    private TextView textView;

    private ArrayList<PanelGridAdapter.Panel> panellist;
    private ProjectDetail projectDetail;
    private EventBus eventBus;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //开始逻辑
        initBus();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                initVideo();
            }
        });
        fillview();
    }
    private void initBus() {
        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    public void onEventMainThread(ProjectDetail projectDetail) {
        SolidToast.showToast(mContext,projectDetail.getMsg()+"项目名称："+projectDetail.getData().getName());
        // 拿到了数据 做处理
    }
    /**
     * 填充面板
     */
    private void fillview() {
        if (panellist == null || panellist.isEmpty()) {
            panellist = new ArrayList<PanelGridAdapter.Panel>();
            panellist.add(new PanelGridAdapter().new Panel("图文介绍", R.mipmap.i_account));
            panellist.add(new PanelGridAdapter().new Panel("资质审核", R.mipmap.project_invest));
            panellist.add(new PanelGridAdapter().new Panel("店铺概况", R.mipmap.project_publish));
            panellist.add(new PanelGridAdapter().new Panel("预算概况", R.mipmap.i_attention));
            panellist.add(new PanelGridAdapter().new Panel("份额计算", R.mipmap.chushou_personal));
            panellist.add(new PanelGridAdapter().new Panel("风控点评", R.mipmap.gmxm_));
            panellist.add(new PanelGridAdapter().new Panel("电子协议", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("相关融资", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("项目评论", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("项目历程", R.mipmap.sys_));
        }

        customGridView.setAdapter(new PanelGridAdapter(mContext, panellist));
        customGridView.setOnItemClickListener(this);
    }

    /**
     * 视频配置
     */
    private void initVideo(){
        mVideoView.setMediaController(new VideoJjMediaContoller(mContext, true));
        mLoadBufferTextView.setTextColor(getResources().getColor(R.color.red));
        //设置缓冲
        mVideoView.setMediaBufferingView(mLoadBufferView);
        //视频开始加载数据
        mVideoView.setOnJjOpenStart(new OnJjOpenStartListener() {
            @Override
            public void onJjOpenStart(String arg0) {
                mLoadText.setText(arg0);
            }
        });
        //视频开始播放
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
                        if (mLoadBufferView.getVisibility() == View.VISIBLE) {
                            mLoadBufferTextView.setText(String
                                    .valueOf(mVideoView.getBufferPercentage())
                                    + "%");
                            LogUtils.i("Video++====================缓冲值2====="
                                    + arg1);
                        }
                    }
                });
        //注意VideoView 要调用下面方法 配置你用户信息
        mVideoView.setVideoJjAppKey("NJQ-jdZde");
        mVideoView.setVideoJjPageName("cn.mobile.renrentou");
        // mVideoView.setMediaCodecEnabled(true);// 是否开启 硬解 硬解对一些手机有限制
        // 判断是否源 0 代表 8大视频网站url 3代表自己服务器的视频源 2代表直播地址 1代表本地视频(手机上的视频源),4特殊需求
        mVideoView.setVideoJjType(0);
        mVideoView.setVideoJjTitle("");
        mVideoView.setResourceVideo("http://www.tudou.com/albumplay/Lqfme5hSolM/AhJ924T8ZW8.html");
        //RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.root);
        //JjVideoRelativeLayout mJjVideoRelativeLayout = (JjVideoRelativeLayout) findViewById(R.id.jjlayout);
        mJjVideoRelativeLayout.setJjToFront(mLayout);// 设置此方法重新排序视图层级JjVideoRelativeLayout，避免横屏其它遮挡
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
        eventBus.unregister(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //各个面板点击
    }


}
