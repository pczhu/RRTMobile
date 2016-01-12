package cn.mobile.renrentou.controller.widget.baserefresh.view;

/**
 * 名称：CustomTestxUtils
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/11/20 上午11:03
 * 版本：V1.0
 * 修改历史：
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.Toast;


import com.etsy.android.grid.StaggeredGridView;
import com.nostra13.universalimageloader.utils.L;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.SolidToast;


/**
 * 自定义不规则GridView
 * Created by storm on 14-5-6.
 */
public class PageStaggeredGridView extends StaggeredGridView implements AbsListView.OnScrollListener {
    private LoadingFooter mLoadingFooter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private OnLoadNextListener mLoadNextListener;
    private int stateScroll = SCROLL_STATE_IDLE;
    public PageStaggeredGridView(Context context) {
        super(context);
        init();
    }

    public PageStaggeredGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageStaggeredGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mLoadingFooter = new LoadingFooter(getContext());
        addFooterView(mLoadingFooter.getView());
        setOnScrollListener(this);

    }

    public void setLoadNextListener(OnLoadNextListener listener) {
        mLoadNextListener = listener;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.stateScroll = scrollState;
    }
    /**
     * firstVisibleItem 表示在当前屏幕显示的第一个listItem在整个listView里面的位置（下标从0开始）
     * visibleItemCount表示在现时屏幕可以见到的ListItem(部分显示的ListItem也算)总数
     * totalItemCount表示ListView的ListItem总数
     * listView.getLastVisiblePosition()表示在现时屏幕最后一个ListItem
     * (最后ListItem要完全显示出来才算)在整个ListView的位置（下标从0开始）
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 0 && swipeRefreshLayout!= null)
            swipeRefreshLayout.setEnabled(true);
        else if(firstVisibleItem != 0 && swipeRefreshLayout != null)
            swipeRefreshLayout.setEnabled(false);

        if (mLoadingFooter.getState() == LoadingFooter.State.Loading) {
            //SolidToast.make((Activity)getContext(), "正在刷新中，请稍后", Gravity.BOTTOM).setBackgroundColorId(R.color.colorPrimaryDark).show();
            return;
        }
        if(mLoadingFooter.getState() == LoadingFooter.State.TheEnd){
            //SolidToast.make((Activity)getContext(), "没有更多数据", Gravity.BOTTOM).setBackgroundColorId(R.color.colorPrimaryDark).show();
            return;
        }
        if(stateScroll == SCROLL_STATE_IDLE){
            return;
        }
        if (firstVisibleItem + visibleItemCount >= totalItemCount
                && totalItemCount != 0
                && totalItemCount != getHeaderViewsCount() + getFooterViewsCount()
                && mLoadNextListener != null
                ) {
            mLoadingFooter.setState(LoadingFooter.State.Loading);
            mLoadNextListener.onLoadNext();
        }

    }

    float x1;
    float y1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件

        float x2;
        float y2;
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            if(y1 - y2 > 50) {
                int i = getLastVisiblePosition()+1;
                LogUtils.i("当前显示数据：" + i + ";总共的数据：" + getCount());
                if(mLoadingFooter.getState() == LoadingFooter.State.TheEnd && i == getCount()){
                    SolidToast.make((Activity) getContext(), "没有更多数据",Gravity.BOTTOM).setBackgroundColorId(R.color.blue).show();
                    return super.onTouchEvent(event);
                }
                if(stateScroll== SCROLL_STATE_IDLE) {

                    mLoadingFooter.setState(LoadingFooter.State.Loading);
                    mLoadNextListener.onLoadNext();
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public void setState(LoadingFooter.State status) {
        mLoadingFooter.setState(status);
    }

    public void setState(LoadingFooter.State status, long delay) {
        mLoadingFooter.setState(status, delay);
    }
    public LoadingFooter.State getState(){
        return mLoadingFooter.getState();
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }
}