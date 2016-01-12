package cn.mobile.renrentou.controller.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;
import cn.mobile.renrentou.R;
import cn.mobile.renrentou.domain.HomePro;
import cn.mobile.renrentou.utils.ImageUtils;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.MyLong;
import cn.mobile.renrentou.utils.SolidToast;
import cn.mobile.renrentou.utils.TimeUtils;

/**
 * 名称：MainFragmentAdapter
 * 作用：主页项目部分
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/6 下午6:08
 * 版本：V1.0
 * 修改历史：
 */
public class MainFragmentAdapter extends BaseAdapter{
    private Context context;
    private View view;
    private HomePro homePro;
    private List<HomePro.DataEntity.InvestEntity> investEntitys;//认购
    private List<HomePro.DataEntity.WaitingEntity> waitingEntitys;//带秒杀
    private long servertime = 0L;
    public MainFragmentAdapter(Context context,HomePro homePro){
        this.context = context;
        this.homePro = homePro;
        if(homePro != null && homePro.getData()!=null){
            investEntitys = homePro.getData().getInvest();
            waitingEntitys = homePro.getData().getWaiting();
            servertime = MyLong.parseString(homePro.getData().getTime());
            if(servertime == 0L){
                servertime = TimeUtils.getTime();
            }else{
                servertime = servertime * 1000L;
            }
        }
    }

    @Override
    public int getCount() {
        int i = 0;
        if(investEntitys!=null && investEntitys.size()!=0){
            i = i+1;
        }
        if(waitingEntitys!=null && waitingEntitys.size()!=0){
            i = i+1;
        }
        return i;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        if(position == 0){
            if(waitingEntitys != null && waitingEntitys.size() != 0) {
                 waitting(linearLayout);
            }else{
                investing(linearLayout);
            }
        }else{
            investing(linearLayout);
        }

        return linearLayout;
    }
    //待秒杀项目
    private void waitting(LinearLayout linearLayout) {
        linearLayout.addView(setTitle("待秒杀项目"));
        for (HomePro.DataEntity.WaitingEntity wiWaitingEntity:waitingEntitys){
            View child = View.inflate(context, R.layout.item_home_project, null);
            TextView textViewchild = (TextView) child.findViewById(R.id.textView);
            textViewchild.setText("待秒杀项目" + wiWaitingEntity.getName());
            ImageView imageView = (ImageView) child.findViewById(R.id.pro_img);
            x.image().bind(imageView, wiWaitingEntity.getImg_app(),
                    ImageUtils.getImageOptions(R.mipmap.banner_image_default,ImageView.ScaleType.FIT_XY));

            //计时器部分
            CountdownView mCvCountdownView = (CountdownView)child.findViewById(R.id.cv_countdownView);
            long beginTime = MyLong.parseString(wiWaitingEntity.getAmount_begin_time());
            if(beginTime == 0L){
                mCvCountdownView.setVisibility(View.GONE);
            }else{
                mCvCountdownView.setVisibility(View.VISIBLE);
                LogUtils.i("服务器时间:"+servertime);
                long time = beginTime*1000-servertime ;
                mCvCountdownView.start(time);
            }


            mCvCountdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
                @Override
                public void onEnd(CountdownView countdownView) {
                    SolidToast.showToast(context, "完事了");
                }
            });
            linearLayout.addView(child);
        }
    }
    //待抢购
    private void investing(LinearLayout linearLayout) {

        linearLayout.addView(setTitle("待抢购项目"));
        for (HomePro.DataEntity.InvestEntity investEntity:investEntitys){
            View child = View.inflate(context, R.layout.item_home_project_invest, null);
            TextView textViewchild = (TextView) child.findViewById(R.id.textView);
            textViewchild.setText("待抢购项目" + investEntity.getName());
            ImageView imageView = (ImageView) child.findViewById(R.id.pro_img);
            x.image().bind(imageView, investEntity.getImg_app(),
                    ImageUtils.getImageOptions(R.mipmap.banner_image_default, ImageView.ScaleType.FIT_XY));

            TextView surplus_time = (TextView)child.findViewById(R.id.pro_su_time);
            surplus_time.setText(investEntity.getSurplus_time()+"天");
            linearLayout.addView(child);
        }
    }
    private View setTitle(String title){
        View view = View.inflate(context, R.layout.item_home_pro_title, null);
        TextView textView = (TextView) view.findViewById(R.id.home_pro_type);
        textView.setText(title);
        return  view;
    }
//    @Override
//    public int getItemViewType(int position) {
//        if(position == 0)
//            return 0;
//        if(waitingEntitys!=null && waitingEntitys.size() != 0 && position == waitingEntitys.size()){
//            return  0;
//        }
//        return 1;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }

    public void notifyDataSetChanged(HomePro homePro) {
        this.homePro = homePro;
        if(homePro != null && homePro.getData()!=null){
            this.investEntitys = homePro.getData().getInvest();
            this.waitingEntitys = homePro.getData().getWaiting();
            this.servertime = MyLong.parseString(homePro.getData().getTime());
            if(servertime == 0L){
                this.servertime = TimeUtils.getTime();
            }else{
                this.servertime = servertime * 1000L;
            }
        }
        super.notifyDataSetChanged();
    }
}
