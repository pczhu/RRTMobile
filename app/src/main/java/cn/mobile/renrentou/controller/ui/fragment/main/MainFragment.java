package cn.mobile.renrentou.controller.ui.fragment.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.flyco.roundview.RoundLinearLayout;
import com.google.gson.Gson;
import com.litesuits.android.async.SimpleCachedTask;
import com.litesuits.android.async.SimpleTask;
import com.litesuits.android.async.TaskExecutor;

import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.controller.ui.adapter.MainFragmentAdapter;
import cn.mobile.renrentou.controller.ui.adapter.MainStatisticAdapter;
import cn.mobile.renrentou.controller.ui.adapter.PanelGridAdapter;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.gridview.CustomGridView;
import cn.mobile.renrentou.controller.widget.listview.CustomListView;
import cn.mobile.renrentou.controller.widget.viewpagerscroll.MyImgScroll;
import cn.mobile.renrentou.domain.AdData;
import cn.mobile.renrentou.domain.HomeCount;
import cn.mobile.renrentou.domain.HomePro;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.MyInteger;
import cn.mobile.renrentou.utils.MyLong;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:01
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_main)
public class MainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private static final String TAG = "MainFragment";

//    @InjectView(R.id.title_back)
//    private TextView leftBack;
//    @InjectView(R.id.title_name)
//    private TextView title;
//    @InjectView(R.id.title_right)
//    private TextView rightBtn;

//    @ViewInject(R.id.listview_main)
//    private ListView listview;
    //
    @ViewInject(R.id.swipe_main)
    private SwipeRefreshLayout swipeRefreshLayout;
    //快捷面板
    @ViewInject(R.id.custom_gridview)
    private CustomGridView customGridView;
    private PanelGridAdapter panelGridAdapter;
    private ArrayList<PanelGridAdapter.Panel> panellist;
    //首页项目
    @ViewInject(R.id.custom_listview)
    private CustomListView customListView;
    private MainFragmentAdapter mainFragmentAdapter;

    //统计数据
    @ViewInject(R.id.custom_gridview_statistics)
    private CustomGridView customGridView_statistics;
    private MainStatisticAdapter mainStatisticAdapter;

    //轮播图
    @ViewInject(R.id.myvp)
    private MyImgScroll myImgScroll;
    @ViewInject(R.id.vb)
    private LinearLayout ovalLayout;
    //服务电话
    @ViewInject(R.id.servicephone)
    private RoundLinearLayout roundLinearLayout;




    //数据
    private List<View> imageviews;
    private SimpleCachedTask simplePagerCachedTask;
    private SimpleTask simpleProTask;
    private SimpleCachedTask simpleStatisCachedTask;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

    }

    /**
     * 初始化各种布局控件
     */
    private void initView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        roundLinearLayout.setOnClickListener(this);
        fillPanel();//第一面板
    }


    //填充面板
    private void fillPanel(){
        if (panellist == null || panellist.isEmpty()) {
            panellist = new ArrayList<PanelGridAdapter.Panel>();
            panellist.add(new PanelGridAdapter().new Panel("新手指引", R.mipmap.xinshouzhiyin));
            panellist.add(new PanelGridAdapter().new Panel("明星榜", R.mipmap.mingxingbang));
            panellist.add(new PanelGridAdapter().new Panel("积分商城", R.mipmap.jifenshangcheng));
            panellist.add(new PanelGridAdapter().new Panel("平台公示", R.mipmap.pingtaigongshi));
        }
        if(panelGridAdapter == null) {
            panelGridAdapter = new PanelGridAdapter(mContext,panellist);
            customGridView.setAdapter(panelGridAdapter);
        }else {
            panelGridAdapter.notifyDataSetChanged(panellist);
        }
        customGridView.setOnItemClickListener(this);
    }
    /**
     * 刷新进行数据处理
     */
    @Override
    public void onRefresh() {
        homePagerTask();//初始化轮播图请求
        homeStatisticTask();//初始化统计数据请求
        homeProCount();
        TaskExecutor.newCyclicBarrierExecutor().put(simpleStatisCachedTask).put(simplePagerCachedTask).put(simpleProTask).start(new SimpleTask<String>() {

            @Override
            protected String doInBackground() {
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                swipeRefreshLayout.setRefreshing(false);//结束了网络访问
            }
        });
    }


    /**
     * 轮播图
     */
    private void homePagerTask(){
        simplePagerCachedTask = new SimpleCachedTask<AdData>(mContext,
                "get_adlist_url",10*1000,
                TimeUnit.MILLISECONDS){
            @Override
            protected AdData doConnectNetwork() throws Exception {
                String json = null;
                AdData data = null;
                try {
                    json = x.http().postSync(
                            new RequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_ADLIST_URL),
                            String.class);
                    data = new Gson().fromJson(json,AdData.class);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                LogUtils.i("执行请求一次");
                return data;
            }

            @Override
            protected void onPostExecuteSafely(AdData adData, Exception e) throws Exception {
                swipeRefreshLayout.setRefreshing(false);
                LogUtils.i("执行外部一次");
                if(adData != null && adData.getData() != null){
                    adData.toString();

                    if(myImgScroll.isScrolling()){
                        myImgScroll.stopTimer();
                    }
                    myImgScroll.start(activity, 4000, ovalLayout,
                            R.layout.view_pagerscroll_point, R.id.ad_item_v,
                            R.drawable.dot_focused, R.drawable.dot_normal, adData.getData());
                }
            }
        };
    }

    /**
     * 首页项目
     */
    private void homeProCount(){
        simpleProTask = new SimpleTask<HomePro>() {
            @Override
            protected HomePro doInBackground() {
                String json = null;
                HomePro homePro = null;
                try {
                    json = x.http().postSync(
                            new RequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_HOME_PROJECT_URL),
                            String.class);
                    homePro = new Gson().fromJson(json,HomePro.class);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                LogUtils.i("执行请求一次");
                return homePro;
            }

            @Override
            protected void onPostExecute(HomePro homePro) {
                super.onPostExecute(homePro);
                if(mainFragmentAdapter == null){
                    mainFragmentAdapter = new MainFragmentAdapter(mContext,homePro);
                    customListView.setAdapter(mainFragmentAdapter);
                }else{
                    mainFragmentAdapter.notifyDataSetChanged(homePro);
                }
                customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
            }
        };
    }

    /**
     * 首页统计信息
     */
    private void homeStatisticTask(){
        simpleStatisCachedTask = new SimpleCachedTask<HomeCount>(mContext,
                "get_home_count",1,
                TimeUnit.DAYS){
            @Override
            protected HomeCount doConnectNetwork() throws Exception {
                String json = null;
                HomeCount homeCount = null;
                try {
                    json = x.http().postSync(
                            new RequestParams(Constants.BASE_SERVER_URL2 + Constants.GET_HOME_COUNT_URL),
                            String.class);
                    homeCount = new Gson().fromJson(json,HomeCount.class);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                LogUtils.i("执行请求一次");
                return homeCount;
            }

            @Override
            protected void onPostExecuteSafely(HomeCount homeCount, Exception e) throws Exception {
                swipeRefreshLayout.setRefreshing(false);
                LogUtils.i("执行外部一次");
                if(homeCount != null && homeCount.getData() != null){
                    homeCount.toString();
                    HomeCount.DataEntity dataEntity = homeCount.getData();
                    ArrayList<MainStatisticAdapter.Panel> panels = new ArrayList<MainStatisticAdapter.Panel>();
                    panels.add(new MainStatisticAdapter().new Panel("成功融资总额",""+ MyLong.parseString(dataEntity.getInvest_amount())));
                    panels.add(new MainStatisticAdapter().new Panel("预约认购总额",""+ MyLong.parseString(dataEntity.getInvestment_count())));
                    panels.add(new MainStatisticAdapter().new Panel("项目总数", "" + dataEntity.getProject_count()));
                    panels.add(new MainStatisticAdapter().new Panel("会员总数", "" + dataEntity.getUser_count()));
                    if(mainStatisticAdapter == null){
                        mainStatisticAdapter = new MainStatisticAdapter(mContext,panels);
                        customGridView_statistics.setAdapter(mainStatisticAdapter);
                    }else{
                        mainStatisticAdapter.notifyDataSetChanged(panels);
                    }
                    customGridView_statistics.setClickable(false);
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.servicephone:
                break;
        }
    }

    /**
     * 功能性标签
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
