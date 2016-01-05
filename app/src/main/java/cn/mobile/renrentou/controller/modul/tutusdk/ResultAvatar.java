package cn.mobile.renrentou.controller.modul.tutusdk;

import org.lasque.tusdk.core.TuSdkResult;
import org.lasque.tusdk.impl.activity.TuFragment;

/**
 * 名称：ResultAvatar
 * 作用：照片摄取结果回调
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/22 下午5:45
 * 版本：V1.0
 * 修改历史：
 */
public interface ResultAvatar {
    public void getAvatar(TuSdkResult tuSdkResult, Error error, TuFragment tuFragment);
}