package cn.mobile.renrentou.controller.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import cn.mobile.renrentou.R;

/**
 * 名称：CenterPanelGridAdapter
 * 作用：个人中心功能面板
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/30 下午5:01
 * 版本：V1.0
 * 修改历史：
 */
public class CenterPanelGridAdapter extends BaseAdapter{
    private ArrayList<Panel> panellist;
    private Context context;

    public CenterPanelGridAdapter() {
    }

    public CenterPanelGridAdapter(Context context,ArrayList<Panel> panellist) {
        this.panellist = panellist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return (panellist!=null)?panellist.size():0;
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
        Holder holder = null;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_customgridview_fragment_center,null);
            holder = new Holder();
            holder.iv_item= (ImageView)convertView.findViewById(R.id.iv_item);
            holder.tv_item= (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.tv_item.setText(panellist.get(position).getPanelname());
        holder.iv_item.setBackground(context.getResources().getDrawable(panellist.get(position).getPanelDrawable()));
        return convertView;
    }
    public class Holder{
        ImageView iv_item;
        TextView tv_item;
    }
    public class Panel{
        public Panel(String panelname,int panelDrawable){
            this.panelDrawable = panelDrawable;
            this.panelname = panelname;
        }
        private String panelname;
        private int panelDrawable;

        public String getPanelname() {
            return panelname;
        }

        public void setPanelname(String panelname) {
            this.panelname = panelname;
        }

        public int getPanelDrawable() {
            return panelDrawable;
        }

        public void setPanelDrawable(int panelDrawable) {
            this.panelDrawable = panelDrawable;
        }
    }
}
