package cn.mobile.renrentou.controller.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import cn.com.video.venvy.param.JjVideoRelativeLayout;
import cn.com.video.venvy.param.JjVideoView;
import cn.com.video.venvy.param.OnJjBufferingUpdateListener;
import cn.com.video.venvy.param.OnJjOpenStartListener;
import cn.com.video.venvy.param.OnJjOpenSuccessListener;
import cn.com.video.venvy.param.VideoJjMediaContoller;
import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.controller.ui.adapter.PanelGridAdapter;
import cn.mobile.renrentou.controller.widget.gridview.CustomGridView;
import cn.mobile.renrentou.domain.PanelItem;
import cn.mobile.renrentou.utils.AShapeUtils;
import cn.mobile.renrentou.utils.DisplayUtil;
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
public class ProjectDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener, RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {
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
    @ViewInject(R.id.custom_gridview)
    private CustomGridView customGridView;
    @ViewInject(R.id.videobtn)
    private ImageView imageView;

    @ViewInject(R.id.label_list_sample_rfal)
    private RapidFloatingActionLayout rfaLayout;
    @ViewInject(R.id.label_list_sample_rfab)
    private RapidFloatingActionButton rfaButton;
    private RapidFloatingActionHelper rfabHelper;

    private ArrayList<PanelGridAdapter.Panel> panellist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toolbar, true);
        setTitle("项目详情");
        pid = getIntent().getStringExtra("pid");

        //开始逻辑
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                initVideo();
            }
        });

        fillview();
        initRightButton();
    }

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

        customGridView.setAdapter(new PanelGridAdapter(this, panellist));
        customGridView.setOnItemClickListener(this);
    }

    /**
     * 视频配置
     */
    private void initVideo(){
        mVideoView.setMediaController(new VideoJjMediaContoller(this, true));
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
        RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.root);
        JjVideoRelativeLayout mJjVideoRelativeLayout = (JjVideoRelativeLayout) findViewById(R.id.jjlayout);
        mJjVideoRelativeLayout.setJjToFront(mLayout);// 设置此方法重新排序视图层级JjVideoRelativeLayout，避免横屏其它遮挡
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * 浮动按钮
     */
    private void initRightButton(){
        List<PanelItem> panelItems = new ArrayList<PanelItem>();
        panelItems.add(new PanelItem(1,"购买项目",R.mipmap.ico_test_d,0xffff4364,0xff3e2723,Color.WHITE,14,AShapeUtils.generateCornerShapeDrawable(0xaa000000, DisplayUtil.dip2px(this, 4))));
        panelItems.add(new PanelItem(2,"收藏项目",R.mipmap.ico_test_c,0xfffc9d99,0xff3e2723,Color.WHITE,14,AShapeUtils.generateCornerShapeDrawable(0xaa000000, DisplayUtil.dip2px(this, 4))));
        panelItems.add(new PanelItem(3,"加入群组",R.mipmap.ico_test_b,0xfff9ccad,0xff3e2723,Color.WHITE,14,AShapeUtils.generateCornerShapeDrawable(0xaa000000, DisplayUtil.dip2px(this, 4))));
        panelItems.add(new PanelItem(4,"定时购买",R.mipmap.ico_test_a,0xffc9c8aa,0xff84af9b,Color.WHITE,14,AShapeUtils.generateCornerShapeDrawable(0xaa000000, DisplayUtil.dip2px(this, 4))));
        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(this);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        for (PanelItem panelItem:panelItems) {
            items.add(new RFACLabelItem<Integer>()
                            .setLabel(panelItem.getTitle())
                            .setResId(panelItem.getResId())
                            .setIconNormalColor(panelItem.getNormalColor())
                            .setIconPressedColor(panelItem.getPressColor())
                            .setLabelColor(panelItem.getLabelColor())
                            .setLabelSizeSp(panelItem.getLableSize())
                            .setLabelBackgroundDrawable(panelItem.getLabelBackgroundDrawable())
                            .setWrapper(panelItem.getId())
            );
        }

        rfaContent
                .setItems(items)
                .setIconShadowRadius(DisplayUtil.dip2px(this, 5))
                .setIconShadowColor(0xff888888)
                .setIconShadowDy(DisplayUtil.dip2px(this, 5))
        ;

        rfabHelper = new RapidFloatingActionHelper(
                this,
                rfaLayout,
                rfaButton,
                rfaContent
        ).build();

    }

    @Override
    public void onRFACItemLabelClick(int i, RFACLabelItem rfacLabelItem) {
        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemIconClick(int i, RFACLabelItem rfacLabelItem) {
        rfabHelper.toggleContent();
    }


}
