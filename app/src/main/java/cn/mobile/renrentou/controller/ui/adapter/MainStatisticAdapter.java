package cn.mobile.renrentou.controller.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.mobile.renrentou.R;


/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/6 上午11:20
 * 版本：V1.0
 * 修改历史：
 */
public class MainStatisticAdapter extends BaseAdapter {
    private ArrayList<Panel> panellist;
    private Context context;

    public MainStatisticAdapter() {
    }

    public MainStatisticAdapter(Context context, ArrayList<Panel> panellist) {
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
            convertView = View.inflate(context, R.layout.item_customgridview_sa,null);
            holder = new Holder();
            holder.tv_item_number= (TextView)convertView.findViewById(R.id.tv_item_customgridview_sa_number);
            holder.tv_item_name= (TextView) convertView.findViewById(R.id.tv_item_customgridview_sa_numbername);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.tv_item_name.setText(panellist.get(position).getPanelname());
        holder.tv_item_number.setText(panellist.get(position).getPanelnumber());
        return convertView;
    }

    public void notifyDataSetChanged(ArrayList<Panel> panellist) {
        this.panellist = panellist;
        super.notifyDataSetChanged();
    }

    public class Holder{
        TextView tv_item_number;
        TextView tv_item_name;
    }
    public class Panel{
        public Panel(String panelname,String panelnumber){
            this.panelnumber = panelnumber;
            this.panelname = panelname;
        }
        private String panelname;
        private String panelnumber;

        public String getPanelname() {
            return panelname;
        }

        public void setPanelname(String panelname) {
            this.panelname = panelname;
        }

        public String getPanelnumber() {
            return panelnumber;
        }

        public void setPanelnumber(String panelnumber) {
            this.panelnumber = panelnumber;
        }
    }
}
