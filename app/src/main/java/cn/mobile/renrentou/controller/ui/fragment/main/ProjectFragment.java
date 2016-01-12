package cn.mobile.renrentou.controller.ui.fragment.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.ui.adapter.ProjectAdapter;
import cn.mobile.renrentou.controller.widget.baserefresh.MyBaseFragment;
import cn.mobile.renrentou.controller.widget.baserefresh.view.PageStaggeredGridView;
import cn.mobile.renrentou.domain.SearchProject;
import cn.mobile.renrentou.domain.SearchType;
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
public class ProjectFragment extends MyBaseFragment {
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


    private ProjectAdapter projectAdapter;
    private SearchProject searchProject;
    private List<SearchType.DataEntity.OrderEntity> orderEntities;
    private List<SearchType.DataEntity.SearchEntity> searchEntities;
    private List<SearchType.DataEntity.TradeEntity> tradeEntities;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initCreatePop();
        initData();
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
        createPop(popupButton2,getStringArray(2));
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
}
