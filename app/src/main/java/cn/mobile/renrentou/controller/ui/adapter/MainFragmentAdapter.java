package cn.mobile.renrentou.controller.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.domain.HomePro;

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
    public MainFragmentAdapter(Context context,HomePro homePro){
        this.context = context;
        this.homePro = homePro;
        if(homePro != null && homePro.getData()!=null){
            investEntitys = homePro.getData().getInvest();
            waitingEntitys = homePro.getData().getWaiting();
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
                View view = View.inflate(context, R.layout.item_home_project, null);
                TextView textView = (TextView) view.findViewById(R.id.textView);
                textView.setText("待秒杀项目");
                linearLayout.addView(view);
                for (HomePro.DataEntity.WaitingEntity wiWaitingEntity:waitingEntitys){
                    View child = View.inflate(context, R.layout.item_home_project, null);
                    TextView textViewchild = (TextView) child.findViewById(R.id.textView);
                    textViewchild.setText("待秒杀项目"+wiWaitingEntity.getName());
                    linearLayout.addView(child);
                }
            }else{
                View view = View.inflate(context, R.layout.item_home_project, null);
                TextView textView = (TextView) view.findViewById(R.id.textView);
                textView.setText("待抢购项目");
                linearLayout.addView(view);
                for (HomePro.DataEntity.InvestEntity investEntity:investEntitys){
                    View child = View.inflate(context, R.layout.item_home_project, null);
                    TextView textViewchild = (TextView) child.findViewById(R.id.textView);
                    textViewchild.setText("待抢购项目"+investEntity.getName());
                    linearLayout.addView(child);
                }
            }
        }else{
            View view = View.inflate(context, R.layout.item_home_project, null);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText("待抢购项目");
            linearLayout.addView(view);
            for (HomePro.DataEntity.InvestEntity investEntity:investEntitys){
                View child = View.inflate(context, R.layout.item_home_project, null);
                TextView textViewchild = (TextView) child.findViewById(R.id.textView);
                textViewchild.setText("待抢购项目"+investEntity.getName());
                linearLayout.addView(child);
            }
        }

        return linearLayout;
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
            investEntitys = homePro.getData().getInvest();
            waitingEntitys = homePro.getData().getWaiting();
        }
        super.notifyDataSetChanged();
    }
}
