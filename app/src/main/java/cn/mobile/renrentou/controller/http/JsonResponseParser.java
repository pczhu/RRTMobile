package cn.mobile.renrentou.controller.http;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

import cn.mobile.renrentou.domain.Failed;
import cn.mobile.renrentou.domain.LoginInfo;
import cn.mobile.renrentou.utils.LogUtils;
import cn.mobile.renrentou.utils.StringUtils;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/4 下午5:08
 * 版本：V1.0
 * 修改历史：
 */
public class JsonResponseParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest uriRequest) throws Throwable {

    }

    @Override
    public Object parse(Type type, Class<?> aClass, String s) throws Throwable {
        if(StringUtils.isEmpty(s)){
            return null;
        }
        if(aClass == LoginInfo.class){
            Gson gson = new Gson();
            try {
                LoginInfo loginInfo = gson.fromJson(s, type);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                Failed failed = gson.fromJson(s, Failed.class);
            }
        }
        return null;
    }
}
