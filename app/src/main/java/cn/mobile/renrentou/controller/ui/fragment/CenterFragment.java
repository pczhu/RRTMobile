package cn.mobile.renrentou.controller.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.adapter.CenterPanelGridAdapter;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.gridview.CustomGridView;
import cn.mobile.renrentou.controller.widget.textview.RiseNumberTextView;

/**
 * 名称：CenterFragment
 * 作用：个人中心
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:12
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_center)
public class CenterFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final String TAG = "CenterFragment";

    private ArrayList<CenterPanelGridAdapter.Panel> panellist;
    @ViewInject(R.id.custom_gridview)
    private CustomGridView customGridVIew;

    @ViewInject(R.id.risenumber_textview)
    private RiseNumberTextView riseNumberTextView;

    @ViewInject(R.id.account_panel)
    private LinearLayout account_panel;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView();
        fillData();
    }

    /**
     * 初始化控件各事件
     */
    private void initView(){
        account_panel.setVisibility(View.VISIBLE);
        account_panel.setOnClickListener(this);
    }

    /**
     * 填充数据
     */
    private void fillData(){
        riseNumberTextView.withNumber("899990.98");
        riseNumberTextView.setDuration(1000);
        riseNumberTextView.start();
        if(panellist == null || panellist.isEmpty()){
            panellist = new ArrayList<CenterPanelGridAdapter.Panel>();
            panellist.add(new CenterPanelGridAdapter().new Panel("我的账户",R.mipmap.i_account));
            panellist.add(new CenterPanelGridAdapter().new Panel("我的投资",R.mipmap.project_invest));
            panellist.add(new CenterPanelGridAdapter().new Panel("我的项目",R.mipmap.project_publish));
            panellist.add(new CenterPanelGridAdapter().new Panel("我的关注",R.mipmap.i_attention));
            panellist.add(new CenterPanelGridAdapter().new Panel("我的卖出",R.mipmap.chushou_personal));
            panellist.add(new CenterPanelGridAdapter().new Panel("我的买入",R.mipmap.gmxm_));
            panellist.add(new CenterPanelGridAdapter().new Panel("扫一扫",R.mipmap.sys_));
            panellist.add(new CenterPanelGridAdapter().new Panel("人人天使",R.mipmap.sys_));
            panellist.add(new CenterPanelGridAdapter().new Panel("人人租",R.mipmap.sys_));
            panellist.add(new CenterPanelGridAdapter().new Panel("人人稳健",R.mipmap.sys_));
            panellist.add(new CenterPanelGridAdapter().new Panel("人人筹",R.mipmap.sys_));
            panellist.add(new CenterPanelGridAdapter().new Panel("人人融",R.mipmap.sys_));
        }

        customGridVIew.setAdapter(new CenterPanelGridAdapter(activity,panellist));
        customGridVIew.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.account_panel://跳转到账户详情
                break;
            default:
                break;
        }
    }

    /**
     * panel面板跳转
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:
                break;
            default:
                break;
        }
    }
}
