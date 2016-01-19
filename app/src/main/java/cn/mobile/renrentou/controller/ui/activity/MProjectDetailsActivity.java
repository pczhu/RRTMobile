package cn.mobile.renrentou.controller.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.controller.ui.fragment.projectdetail.ProFragmentTop;
import cn.mobile.renrentou.controller.ui.fragment.projectdetail.ProFragmentBottom;
import cn.mobile.renrentou.controller.widget.dragview.DragLayout;
import cn.mobile.renrentou.domain.Failed;
import cn.mobile.renrentou.domain.PanelItem;
import cn.mobile.renrentou.domain.ProjectDetail;
import cn.mobile.renrentou.utils.AShapeUtils;
import cn.mobile.renrentou.utils.DisplayUtil;
import de.greenrobot.event.EventBus;

/**
 * 名称：MProjectDetailsActivity
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/18 下午4:39
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.mactivity_projectdetail)
public class MProjectDetailsActivity extends BaseActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {
    private ProFragmentTop fragment1;
    private ProFragmentBottom fragment3;
    @ViewInject(R.id.draglayout)
    private DragLayout draglayout;
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.label_list_sample_rfal)
    private RapidFloatingActionLayout rfaLayout;
    @ViewInject(R.id.label_list_sample_rfab)
    private RapidFloatingActionButton rfaButton;
    private RapidFloatingActionHelper rfabHelper;
    private String pid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toolbar, true);
        setTitle("项目详情");
        pid = getIntent().getStringExtra("pid");
        initView();
        initRightButton();
        initData();


    }




    /**
     * 初始化View
     */
    private void initView() {
        fragment1 = new ProFragmentTop();
        fragment3 = new ProFragmentBottom();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first, fragment1).add(R.id.second, fragment3)
                .commit();

        DragLayout.ShowNextPageNotifier nextIntf = new DragLayout.ShowNextPageNotifier() {
            @Override
            public void onDragNext() {
                fragment3.initView();
            }
        };
        draglayout.setNextPageListener(nextIntf);
    }

    /**
     * 浮动按钮
     */
    private void initRightButton(){
        List<PanelItem> panelItems = new ArrayList<PanelItem>();
        panelItems.add(new PanelItem(1,"购买项目",R.mipmap.ico_test_d,0xffff4364,0xff3e2723, Color.WHITE,14, AShapeUtils.generateCornerShapeDrawable(0xaa000000, DisplayUtil.dip2px(this, 4))));
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

    /**
     * 数据请求
     */
    private void initData() {
        RequestParams requestParams = HttpAction.getRequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_PROJECT_DETAIL);
        requestParams.addBodyParameter("pid",pid);
        HttpAction.getInstance(this).post(requestParams, ProjectDetail.class, new HttpResponseListener<ProjectDetail>() {
            @Override
            public void onSuccessForData(ProjectDetail projectDetail) {
                EventBus.getDefault().post(projectDetail);
            }

            @Override
            public void onSuccessButNoData(Failed failed) {
                super.onSuccessButNoData(failed);
            }

            @Override
            public void onFailed(Throwable throwable, boolean b) {
                super.onFailed(throwable, b);
            }
        });
    }

    public void setBundleListener(){

    }
}
