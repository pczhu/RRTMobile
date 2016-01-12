package cn.mobile.renrentou.controller.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.widget.baserefresh.MyBaseAdapter;
import cn.mobile.renrentou.domain.SearchProject;
import cn.mobile.renrentou.utils.ImageUtils;


/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/8 下午4:25
 * 版本：V1.0
 * 修改历史：
 */
public class ProjectAdapter extends MyBaseAdapter<SearchProject.DataEntity> {
    ImageOptions imageOptions;
    public ProjectAdapter(Context context, ArrayList<SearchProject.DataEntity> userList) {
        super(context, userList);
        imageOptions = ImageUtils.getImageOptions(
                R.mipmap.project_loading_image, ImageView.ScaleType.FIT_XY);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null){
            holder = new Holder();
            convertView = View.inflate(mContext, R.layout.item_project,null);
            holder.tv = (TextView) convertView.findViewById(R.id.textView2);
            holder.iv = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        SearchProject.DataEntity bean =  userList.get(position);
        holder.tv.setText(bean.getName()+":"+bean.getId());
        x.image().bind(holder.iv, bean.getImg_app(), imageOptions);


        return convertView;
    }

    public class Holder {
        TextView tv;
        ImageView iv;
    }
}
