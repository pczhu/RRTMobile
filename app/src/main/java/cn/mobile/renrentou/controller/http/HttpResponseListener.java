package cn.mobile.renrentou.controller.http;

import org.xutils.common.Callback;

import cn.mobile.renrentou.domain.Failed;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/4 下午5:27
 * 版本：V1.0
 * 修改历史：
 */
public abstract class HttpResponseListener<T> {
    public void onStart(){

    }
    public abstract void onSuccessForData(T t);
    public void onSuccessButNoData(Failed failed){

    }
    public void onFailed(Throwable throwable, boolean b){

    }
    public void onSuccess(String s){

    }
    public void onCanel(Callback.CancelledException e){

    }
    public void onFanished(){

    }

}
