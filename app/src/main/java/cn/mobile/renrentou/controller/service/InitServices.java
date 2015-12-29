package cn.mobile.renrentou.controller.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.app.HttpRetryHandler;
import org.xutils.x;

import java.io.File;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.store.db.WelcomeInfoData;
import cn.mobile.renrentou.controller.store.db.impl.DbAction;
import cn.mobile.renrentou.domain.WelcomeData;
import cn.mobile.renrentou.utils.ImageUtils;
import cn.mobile.renrentou.utils.LogUtils;


/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/24 下午2:39
 * 版本：V1.0
 * 修改历史：
 */
public class InitServices extends Service {

    private WelcomeInfoData welcomeInfoData;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        welcomeInfoData = DbAction.getInstance(this);

        super.onCreate();
        x.http().get(new RequestParams("http://192.168.2.4:8080/MyServerInterface/getWelcome"), new Callback.CommonCallback<String>() {

            private WelcomeData welcomeData;

            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                welcomeData = null;
                try {
                    welcomeData = gson.fromJson(s, WelcomeData.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                if (welcomeData != null) {
                    //getImage();
                    getLoadImage();


                }
            }

            private void getLoadImage() {
                x.image().loadFile(welcomeData.getData().getImg(),
                        ImageUtils.getImageOptions(R.mipmap.launch),
                        new CommonCallback<File>(){

                    @Override
                    public void onSuccess(File file) {
                        if(file != null) {
                            welcomeData.getData().setPath(file.getAbsolutePath());
                            welcomeInfoData.setWelcomeInfo(welcomeData.getData(), false);
                            LogUtils.i("数据存入");
                        }
                    }

                    @Override
                    public void onError(Throwable throwable, boolean b) {

                    }

                    @Override
                    public void onCancelled(CancelledException e) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }

            private void getImage() {
                RequestParams requestParams = new RequestParams(welcomeData.getData().getImg());
                requestParams.setSaveFilePath(Environment.getDataDirectory()+"/download/");
                requestParams.setAutoResume(false);
                requestParams.setAutoRename(false);
                requestParams.setHttpRetryHandler(new HttpRetryHandler());
                x.http().post(requestParams, new CommonCallback<File>() {
                   @Override
                   public void onSuccess(final File file) {
                       if(file != null) {
                           welcomeData.getData().setPath(file.getAbsolutePath());
                           welcomeInfoData.setWelcomeInfo(welcomeData.getData(), false);
                           LogUtils.i("数据存入");
                       }
                   }

                   @Override
                   public void onError(Throwable throwable, boolean b) {

                   }

                   @Override
                   public void onCancelled(CancelledException e) {

                   }

                   @Override
                   public void onFinished() {

                   }
               });
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
