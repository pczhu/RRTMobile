package cn.mobile.renrentou.controller.ui.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.lasque.tusdk.core.TuSdkResult;
import org.lasque.tusdk.impl.activity.TuFragment;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.app.Constants;
import cn.mobile.renrentou.app.RRTApplication;
import cn.mobile.renrentou.controller.http.HttpAction;
import cn.mobile.renrentou.controller.http.HttpResponseListener;
import cn.mobile.renrentou.controller.modul.action.UserInfoAction;
import cn.mobile.renrentou.controller.modul.tutusdk.EditAvatarComponentSimple;
import cn.mobile.renrentou.controller.modul.tutusdk.ResultAvatar;
import cn.mobile.renrentou.controller.store.db.UserData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.controller.store.sp.impl.ShareStoreAction;
import cn.mobile.renrentou.controller.ui.activity.LoginActivity;
import cn.mobile.renrentou.controller.ui.adapter.PanelGridAdapter;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.gridview.CustomGridView;
import cn.mobile.renrentou.controller.widget.textview.RiseNumberTextView;
import cn.mobile.renrentou.domain.Failed;
import cn.mobile.renrentou.domain.UploadFile;
import cn.mobile.renrentou.domain.UserInfo;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.SolidToast;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 名称：CenterFragment
 * 作用：个人中心
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/29 下午2:12
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_center)
public class CenterFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener, ResultAvatar {

    private static final String TAG = "CenterFragment";
    public static CenterFragment intance = null;
    private ArrayList<PanelGridAdapter.Panel> panellist;
    /**
     * 头像
     */
    @ViewInject(R.id.cat_avatar)
    private CircleImageView circleImageView;
    /**
     * 面板
     */
    @ViewInject(R.id.custom_gridview)
    private CustomGridView customGridView;
    /**
     * 增长账户数值
     */
    @ViewInject(R.id.risenumber_textview)
    private RiseNumberTextView riseNumberTextView;
    /**
     * 账户面板
     */
    @ViewInject(R.id.account_panel)
    private LinearLayout account_panel;
    /**
     * 用户名
     */
    @ViewInject(R.id.tv_username)
    private TextView tv_username;

    @ViewInject(R.id.tv_left)
    private TextView tv_left;

    @ViewInject(R.id.tv_right)
    private TextView tv_right;

    private UserData userData;
    private UserInfo.UserDataEntity userInfo;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intance = this;
        initView();
        fillData();
        //onRefresh();
    }

    /**
     * 初始化控件各事件
     */
    private void initView() {
        account_panel.setVisibility(View.VISIBLE);
        account_panel.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        userData = DbAction.getInstance(mContext);
    }

    /**
     * 填充数据
     */
    private void fillData() {


        riseNumberTextView.withNumber("899990.98");
        riseNumberTextView.setDuration(1000);
        riseNumberTextView.start();
        if (panellist == null || panellist.isEmpty()) {
            panellist = new ArrayList<PanelGridAdapter.Panel>();
            panellist.add(new PanelGridAdapter().new Panel("我的账户", R.mipmap.i_account));
            panellist.add(new PanelGridAdapter().new Panel("我的投资", R.mipmap.project_invest));
            panellist.add(new PanelGridAdapter().new Panel("我的项目", R.mipmap.project_publish));
            panellist.add(new PanelGridAdapter().new Panel("我的关注", R.mipmap.i_attention));
            panellist.add(new PanelGridAdapter().new Panel("我的卖出", R.mipmap.chushou_personal));
            panellist.add(new PanelGridAdapter().new Panel("我的买入", R.mipmap.gmxm_));
            panellist.add(new PanelGridAdapter().new Panel("扫一扫", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("人人天使", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("人人租", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("人人稳健", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("人人筹", R.mipmap.sys_));
            panellist.add(new PanelGridAdapter().new Panel("人人融", R.mipmap.sys_));
        }

        customGridView.setAdapter(new PanelGridAdapter(activity, panellist));
        customGridView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_panel://跳转到账户详情
                break;
            case R.id.cat_avatar:
                if(!ShareStoreAction.getInstance(mContext).isLogin()){
                    startActivity(new Intent(activity, LoginActivity.class));
                }else {
                    EditAvatarComponentSimple editAvatarComponentSimple = new EditAvatarComponentSimple();
                    editAvatarComponentSimple.setResult(this);
                    editAvatarComponentSimple.showSimple(activity);
                }

                break;
            default:
                break;
        }
    }

    /**
     * panel面板跳转
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                break;
            default:
                break;
        }
    }

    /**
     * 回调处理拍摄的照片
     * @param tuSdkResult
     * @param error
     * @param tuFragment
     */
    @Override
    public void getAvatar(TuSdkResult tuSdkResult, Error error, TuFragment tuFragment) {
        RequestParams requestParams = HttpAction.getRequestParams(Constants.BASE_SERVER_URL2 + Constants.UPLOAD_IMG_URL);
        if (tuSdkResult != null && tuSdkResult.imageSqlInfo != null) {
            requestParams.addBodyParameter("pic", new File(tuSdkResult.imageSqlInfo.path));
        } else if (tuSdkResult != null && tuSdkResult.imageFile != null) {
            requestParams.addBodyParameter("pic", new File(tuSdkResult.imageFile.getAbsolutePath()));
        } else {
            return;
        }
        requestParams.addBodyParameter("type","1");
        requestParams.setMultipart(true);
        HttpAction.getInstance(mContext).post(requestParams, UploadFile.class, new HttpResponseListener<UploadFile>() {
            @Override
            public void onSuccessForData(UploadFile uploadFile) {
                UserInfoAction.getInstance(mContext).getUserInfo();
            }

            @Override
            public void onSuccessButNoData(Failed failed) {
                super.onSuccessButNoData(failed);
                SolidToast.showToast(mContext,failed.getMsg());
            }
        });

    }
    public void onRefresh(){
        if(!RRTApplication.isLogin){//先判断是否登录
            return;
        }
        if(userData!=null){//判断是否实例化
            userInfo = userData.getUserInfo();
        }
        if(userInfo == null){//判断是否
            return;
        }
        LogUtils.i("userInfo.getFace()=" + userInfo.getFace());
        x.image().bind(circleImageView, userInfo.getFace(),
                new ImageOptions.Builder()
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                        //.setCrop(true)
                        // 加载中或错误图片的ScaleType
                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                        .setPlaceholderScaleType(ImageView.ScaleType.CENTER_CROP)
                        .setLoadingDrawableId(R.mipmap.invester_default)
                        .setFailureDrawableId(R.mipmap.invester_default)
                        .build());
        tv_username.setText(userInfo.getRealname());
        tv_left.setText(userInfo.getTzf_level()+"级");
        tv_right.setText(userInfo.getXmf_level()+"级");

    }
}
