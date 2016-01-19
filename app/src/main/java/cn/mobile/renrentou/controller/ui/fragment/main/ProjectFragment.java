package cn.mobile.renrentou.controller.ui.fragment.main;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.xw.repo.xedittext.XEditText;

import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.app.RRTApplication;
import cn.mobile.renrentou.app.config.InitEveryDependence;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.ui.activity.MProjectDetailsActivity;
import cn.mobile.renrentou.controller.ui.activity.ProjectDetailActivity;
import cn.mobile.renrentou.controller.ui.activity.SearchActivity;
import cn.mobile.renrentou.controller.ui.adapter.ProjectAdapter;
import cn.mobile.renrentou.controller.widget.baserefresh.MyBaseFragment;
import cn.mobile.renrentou.controller.widget.baserefresh.view.PageStaggeredGridView;
import cn.mobile.renrentou.domain.SearchProject;
import cn.mobile.renrentou.domain.SearchType;
import cn.mobile.renrentou.utils.DisplayUtil;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.SystemUtils;
import pw.h57.popupbuttonlibrary.PopupButton;
import pw.h57.popupbuttonlibrary.adapter.PopupAdapter;

/**
 * 名称：ProjectFragment
 * 作用：找项目页面
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:11
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_project)
public class ProjectFragment extends MyBaseFragment<SearchProject.DataEntity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String TAG = "ProjectFragment";
    @ViewInject(R.id.swipe_container)
    private SwipeRefreshLayout swipeRefreshLayout;
    @ViewInject(R.id.grid_view)
    private PageStaggeredGridView pageStaggeredGridView;
    @ViewInject(R.id.root)
    private FrameLayout frameLayout;
    @ViewInject(R.id.search_pop1)
    private PopupButton popupButton1;
    @ViewInject(R.id.search_pop2)
    private PopupButton popupButton2;
    @ViewInject(R.id.search_pop3)
    private PopupButton popupButton3;
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.ib_search)
    private ImageButton ibsearch;
    @ViewInject(R.id.search_view)
    private LinearLayout searchView;
    @ViewInject(R.id.fragment_project)
    private LinearLayout linearLayout;
    @ViewInject(R.id.xedittext)
    private XEditText xEditText;
    private ProjectAdapter projectAdapter;
    private SearchProject searchProject;
    private List<SearchType.DataEntity.OrderEntity> orderEntities;
    private List<SearchType.DataEntity.SearchEntity> searchEntities;
    private List<SearchType.DataEntity.TradeEntity> tradeEntities;
    private int height;
    private float y;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolBar(toolbar, false);
        initButton();
        initCreatePop();
        initData();
    }

    private void initButton() {
        ibsearch.setOnClickListener(this);
        xEditText.setOnClickListener(this);
        pageStaggeredGridView.setOnItemClickListener(this);
    }

    /**
     * 头部分请求数据并初始化
     */
    private void initCreatePop(){
        if(orderEntities == null || searchEntities == null || tradeEntities == null){
            popupButton1.setOnClickListener(onClickListener);
            popupButton2.setOnClickListener(onClickListener);
            popupButton3.setOnClickListener(onClickListener);
        }
        RequestParams requestParams = new RequestParams(Constants.BASE_SERVER_URL2+Constants.GETSEARCHPROJECTTYPE);
        HttpAction.getInstance(mContext).post(requestParams, SearchType.class, new HttpResponseListener<SearchType>() {
            @Override
            public void onSuccessForData(SearchType searchType) {
                orderEntities = searchType.getData().getOrder();
                searchEntities = searchType.getData().getSearch();
                tradeEntities = searchType.getData().getTrade();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initCreatePopOne();
                        initCreatePopTwo();
                        initCreatePopThree();
                    }
                });
            }
        });
    }
    private void initCreatePopOne(){
        createPop(popupButton1, getStringArray(1));
    }
    private void initCreatePopTwo(){
        createPop(popupButton2, getStringArray(2));
    }
    private void initCreatePopThree(){
        createPop(popupButton3, getStringArray(3));
    }

    /**
     * 初始化pop
     * @param popupButton
     * @param arrayList
     */
    private void createPop(final PopupButton popupButton,final ArrayList<String> arrayList){
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_popup, null);
        ListView lv = (ListView) view.findViewById(R.id.lv);

        final PopupAdapter adapter = new PopupAdapter(mContext,
                pw.h57.popupbuttonlibrary.R.layout.popup_item,
                arrayList,
                R.drawable.search_pop_normal,
                R.drawable.search_pop_press);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setPressPostion(position);
                adapter.notifyDataSetChanged();
                if (popupButton.getId() == R.id.search_pop1) {
                    popupButton.setText(orderEntities.get(position).getName());
                    requestParams.removeParameter("order");
                    requestParams.addBodyParameter("order", orderEntities.get(position).getId());
                } else if (popupButton.getId() == R.id.search_pop2) {
                    popupButton.setText(searchEntities.get(position).getName());
                    requestParams.removeParameter("status");
                    requestParams.addBodyParameter("status", searchEntities.get(position).getId());
                } else if (popupButton.getId() == R.id.search_pop3) {
                    popupButton.setText(tradeEntities.get(position).getName());
                    requestParams.removeParameter("trade_one");
                    requestParams.addBodyParameter("trade_one", tradeEntities.get(position).getId());
                }
                popupButton.hidePopup();
                resetFragment(requestParams).start();
            }
        });
        popupButton.setPopupView(view);

    }
    //内容刷新部分
    private void initData(){
        pageStaggeredGridView.setSwipeRefreshLayout(swipeRefreshLayout);
        projectAdapter = new ProjectAdapter(mContext,null);
        RequestParams requestParams = new RequestParams(Constants.BASE_SERVER_URL2+Constants.GET_PROJECT_LIST_URL);
        requestParams.addBodyParameter("page_num", "10");
        requestParams.setMultipart(false);
        //requestParams.
        openListener(swipeRefreshLayout,
                pageStaggeredGridView,
                projectAdapter,
                SearchProject.class,
                requestParams,
                new OnActionListener() {

                }
        ).start();
        addErrorView(this);
    }
    @Override
    protected ViewGroup getRootView() {
        return  frameLayout;
    }

    /**
     * 请求的类型转化为字符串集合
     * @param i
     * @return
     */
    public ArrayList<String> getStringArray(int i){
        ArrayList<String> arrayList = new ArrayList<String>();
        if(i == 1) {
            for (SearchType.DataEntity.OrderEntity orderEntity : orderEntities)
                arrayList.add(orderEntity.getName());
        }else if(i == 2){
            for (SearchType.DataEntity.SearchEntity searchEntity : searchEntities)
                arrayList.add(searchEntity.getName());
        }if(i == 3){
            for (SearchType.DataEntity.TradeEntity tradeEntity : tradeEntities)
                arrayList.add(tradeEntity.getName());
        }
        return  arrayList;
    }
    @Override
    public ArrayList getObjectList(Object obj) {
        return ((SearchProject)obj).getData();
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            initCreatePop();
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == 1){
                String result = ((data!=null)?data.getStringExtra("searchTagWord"):"");
                xEditText.setText(""+result);
                requestParams.removeParameter("name");
                requestParams.addBodyParameter("name", result);
                resetFragment(requestParams).start();
            }
            super.onActivityResult(requestCode, resultCode, data);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_search :
                LogUtils.i("" + InitEveryDependence.getInstance(mContext).getDataEntitys().size());
                android.view.ViewGroup.LayoutParams lp = searchView.getLayoutParams();
                if (50 == (DisplayUtil.px2dip(mContext, (float) lp.height))) {
                    lp.height = DisplayUtil.dip2px(mContext, 0.0f);
                    if(requestParams.getParams("name").size() != 0) {
                        requestParams.removeParameter("name");
                        resetFragment(requestParams).start();
                    }
                } else {
                    lp.height = DisplayUtil.dip2px(mContext, 50.0f);
                }
                xEditText.setText("");
                searchView.setLayoutParams(lp);
                break;
            case R.id.xedittext:
                height = searchView.getHeight();
                Intent intent = new Intent();
                intent.setClass(mContext, SearchActivity.class);
                startActivityForResult(intent, 1);
                activity.overridePendingTransition(R.anim.search_alpha_in, R.anim.search_alpha_out);
                LogUtils.i("获取到得高度："+y +"启动动画");
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent starter = new Intent(mContext, MProjectDetailsActivity.class);
        starter.putExtra("pid",userlist.get(position).getId());
        starter.putExtra("pname",userlist.get(position).getName());

        mContext.startActivity(starter);
    }


}
