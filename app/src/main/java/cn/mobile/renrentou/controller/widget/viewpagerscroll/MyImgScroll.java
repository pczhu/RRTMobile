package cn.mobile.renrentou.controller.widget.viewpagerscroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.domain.AdData;
import cn.mobile.renrentou.domain.AdvertiseResponse;
import cn.mobile.renrentou.utils.ImageUtils;

/**
 * 
 * 创建日期 ：2015年7月7日上午11:04:32
 * 
 * 描述：
 * 		轮播图自定义控件
 * @author 朱道研
 * @version 1.0
 * 
 *          修改历史：
 */
public class MyImgScroll extends ViewPager{
	private Activity mActivity; // 上下文
	private List<ImageView> mListViews; // 图片组
	/**
	 * 滚动间隔
	 */
	private int mScrollTime = 0;
	/**
	 * 事件控制器
	 */
	private Timer timer;
	private int oldIndex = 0;
	private int curIndex = 0;
	private boolean isScrolling = true;
	/**
	 * 轮播数据集合
	 */
	private List<AdData.DataEntity> advertisementInfos = null;

	/**
	 * 内容适配器
	 */
	private MyPagerAdapter myPagerAdapter;
	/**
	 * 构造器
	 * @param context
	 * 			上下文
	 * @param attrs
	 * 			属性
	 */
	public MyImgScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setId(R.id.myvp);
		this.setOffscreenPageLimit(1);
	}

	/**
	 * 开始广告滚动
	 * 
	 * @param mainActivity
	 *            显示广告的主界面
	 * @param scrollTime
	 *            滚动间隔 ,0为不滚动
	 * @param ovalLayout
	 *            圆点容器,可为空,LinearLayout类型
	 * @param ovalLayoutId
	 *            ovalLayout为空时 写0, 圆点layout XMl
	 * @param ovalLayoutItemId
	 *            ovalLayout为空时 写0,圆点layout XMl 圆点XMl下View ID
	 * @param focusedId
	 *            ovalLayout为空时 写0, 圆点layout XMl 选中时的动画
	 * @param normalId
	 *            ovalLayout为空时 写0, 圆点layout XMl 正常时背景
	 * @param addata
	 */
	@SuppressLint("ClickableViewAccessibility")
	public void start(Activity mainActivity,
			int scrollTime, LinearLayout ovalLayout, int ovalLayoutId,
			int ovalLayoutItemId, int focusedId, int normalId, List<AdData.DataEntity> addata) {
		mActivity = mainActivity;
		mScrollTime = scrollTime;
		this.advertisementInfos = addata;


		if(mListViews == null) {
			mListViews = new ArrayList<ImageView>();
		}else {
			mListViews.clear();
		}
		for (int i = 0; i < addata.size(); i++) {
			ImageView imageView = new ImageView(getContext());
			imageView.setId(i);
			AdData.DataEntity advertisementInfo = addata.get(i);
			String url = advertisementInfo.getLink();
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			mListViews.add(imageView);
		}



		// 设置圆点
		setOvalLayout(ovalLayout, ovalLayoutId, ovalLayoutItemId, focusedId,
				normalId);
		myPagerAdapter = new MyPagerAdapter(addata);
		this.setAdapter(myPagerAdapter);// 设置适配器

		if (scrollTime != 0 && mListViews.size() > 1) {
			// 设置滑动动画时间  ,如果用默认动画时间可不用 ,反射技术实现
			new FixedSpeedScroller(mActivity).setDuration(this, 700);
			startTimer();
			
		}
	
			// 触摸时停止滚动
//			this.setOnTouchListener(new OnTouchListener() {
//				public boolean onTouch(View v, MotionEvent event) {
////					if (event.getAction() == MotionEvent.ACTION_UP) {
////						startTimer();
////					} else {
////						stopTimer();
////					}
//					return false;
//				}
//			});

//		if (mListViews.size() > 1) {
//			this.setCurrentItem((Integer.MAX_VALUE / 2)
//					- (Integer.MAX_VALUE / 2) % mListViews.size());// 设置选中为中间/图片为和第0张一样
//		}

	}
	/**
	 * 刷新轮播图数据
	 * @param advertisementInfo
	 * 					轮播图数据集合
	 */
	public void notifyByMySelf(List<AdData.DataEntity> advertisementInfo){
		this.advertisementInfos = advertisementInfo;
		if(myPagerAdapter != null){
			myPagerAdapter.notifyDataSetChanged();
		}
	}
	/**
	 * 初始化轮播圆点
	 * 
	 * @param ovalLayout
	 *            圆点容器,可为空,LinearLayout类型
	 * @param ovalLayoutId
	 *            ovalLayout为空时 写0, 圆点layout XMl
	 * @param ovalLayoutItemId
	 *            ovalLayout为空时 写0,圆点layout XMl 圆点XMl下View ID
	 * @param focusedId
	 *            ovalLayout为空时 写0, 圆点layout XMl 选中时的动画
	 * @param normalId
	 *            ovalLayout为空时 写0, 圆点layout XMl 正常时背景
	 */
	private void setOvalLayout(final LinearLayout ovalLayout, int ovalLayoutId,
			final int ovalLayoutItemId, final int focusedId, final int normalId) {
		if (ovalLayout != null) {
			ovalLayout.removeAllViews();
			LayoutInflater inflater=LayoutInflater.from(mActivity);
			for (int i = 0; i < mListViews.size(); i++) {
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);  
				lp.setMargins(10, 0, 10, 0);
				ovalLayout.addView(inflater.inflate(ovalLayoutId, null),lp);
			}
			//选中第一个
			ovalLayout.getChildAt(0).findViewById(ovalLayoutItemId)
			.setBackgroundResource(focusedId);
			this.setOnPageChangeListener(new OnPageChangeListener() {
				public void onPageSelected(int i) {
					curIndex = i % mListViews.size();
					if(curIndex != 0){
						ovalLayout.getChildAt(0).findViewById(ovalLayoutItemId)
						.setBackgroundResource(normalId);
					}
                    //取消圆点选中
					ovalLayout.getChildAt(oldIndex).findViewById(ovalLayoutItemId)
							.setBackgroundResource(normalId);
					 //圆点选中
					ovalLayout.getChildAt(curIndex).findViewById(ovalLayoutItemId)
					.setBackgroundResource(focusedId);
					oldIndex = curIndex;
				}

				public void onPageScrolled(int arg0, float arg1, int arg2) {
				}

				public void onPageScrollStateChanged(int arg0) {
				}
			});
		}
	}
	/**
	 * 取得当明选中下标
	 * @return
	 * 		下标值curIndex
	 */
    public int getCurIndex() {
		return curIndex;
	}
	/**
	 * 停止滚动
	 */
	public void stopTimer() {
		if (timer == null) {
			return;
		}
		timer.cancel();
		timer.purge();
		timer = null;
		this.setScrolling(false);
	}

	/**
	 * 开始滚动
	 */
	public void startTimer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				mActivity.runOnUiThread(new Runnable() {
					public void run() {
						MyImgScroll.this.setCurrentItem(MyImgScroll.this
								.getCurrentItem() + 1);
					}
				});
			}
		}, mScrollTime, mScrollTime);
		this.setScrolling(true);
	}
	/**
	 * 获取轮播状态
	 * @return
	 * 		isScrolling true:正在轮播 false:轮播停止
	 */
	public boolean isScrolling() {
		return isScrolling;
	}
	/**
	 * 设置轮播状态
	 * @param isScrolling
	 */
	public void setScrolling(boolean isScrolling) {
		this.isScrolling = isScrolling;
	}

	/**
	 * 
	 * 描述：
	 * 		轮播图适配器
	 * @author 朱道研
	 * @version 1.0
	 * 
	 *          修改历史：
	 */
	private class MyPagerAdapter extends PagerAdapter {
		/**
		 * 轮播数据集合
		 */
		private List<AdData.DataEntity> advertisementInfos;
		public MyPagerAdapter(List<AdData.DataEntity> advertisementInfos) {
			this.advertisementInfos = advertisementInfos;
		}

		public void finishUpdate(View arg0) {
		}

		public void notifyDataSetChanged() {
			super.notifyDataSetChanged();
		}

		public int getCount() {
			if (mListViews.size() == 1) {// 一张图片时不用流动
				return mListViews.size();
			}
			return Integer.MAX_VALUE;
		}

		public Object instantiateItem(View v, int i) {
			
			if (((ViewPager) v).getChildCount() == mListViews.size()) {
				((ViewPager) v).removeView(mListViews.get(i % mListViews.size()));
			}
			ViewParent view = mListViews.get(i % mListViews.size()).getParent();
			if(view != null){
				((ViewGroup)view).removeView(mListViews.get(i % mListViews.size()));
			}
			((ViewPager) v).addView(mListViews.get(i % mListViews.size()), 0);
			x.image().bind(mListViews.get(i % mListViews.size()), advertisementInfos.get(i % mListViews.size()).getImg(),
					ImageUtils.getImageOptions(R.mipmap.banner_image_default));
			return mListViews.get(i % mListViews.size());
		}

		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		public Parcelable saveState() {
			return null;
		}

		public void startUpdate(View arg0) {
		}

		public void destroyItem(View container, int position, Object object) {
		}
	}

}
