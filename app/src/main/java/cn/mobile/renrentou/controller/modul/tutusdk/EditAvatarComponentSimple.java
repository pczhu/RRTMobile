/** 
 * TuSdkDemo
 * EditAvatarComponentSimple.java
 *
 * @author 		Clear
 * @Date 		2015-4-21 下午1:36:55 
 * @Copyright 	(c) 2015 tusdk.com. All rights reserved.
 * 
 */
package cn.mobile.renrentou.controller.modul.tutusdk;

import android.app.Activity;

import org.lasque.tusdk.TuSdkGeeV1;
import org.lasque.tusdk.core.TuSdkResult;
import org.lasque.tusdk.core.utils.hardware.CameraHelper;
import org.lasque.tusdk.impl.activity.TuFragment;
import org.lasque.tusdk.impl.components.TuAvatarComponent;
import org.lasque.tusdk.impl.components.camera.TuCameraOption;
import org.lasque.tusdk.modules.components.TuSdkComponent.TuSdkComponentDelegate;

import java.util.Arrays;

import cn.mobile.renrentou.R;

/**
 * 名称：EditAvatarComponentSimple
 * 作用：头像设置
 * 描述：
 * 作者：pczhu
 * 创建时间： 15/12/31 下午12:17
 * 版本：V1.0
 * 修改历史：
 */
public class EditAvatarComponentSimple extends SimpleBase {

	/** 头像设置组件(编辑)范例 */
	public EditAvatarComponentSimple()
	{
		super(2, R.string.simple_EditAvatarComponent);
	}

	/** 显示范例 */
	@Override
	public void showSimple(Activity activity)
	{
		if (activity == null)
			return;
		if (CameraHelper.showAlertIfNotSupportCamera(activity))
			return;
		// 组件选项配置
		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/TuAvatarComponent.html
		TuAvatarComponent component = TuSdkGeeV1.avatarCommponent(activity, new TuSdkComponentDelegate() {
			@Override
			public void onComponentFinished(TuSdkResult tuSdkResult, Error error, TuFragment tuFragment) {
				if (resultAvatar != null) {
					resultAvatar.getAvatar(tuSdkResult, error, tuFragment);
				}
			}
		});



		// 组件选项配置
		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/TuAvatarComponentOption.html
		// component.componentOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/album/TuAlbumListOption.html
		// component.componentOption().albumListOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/album/TuPhotoListOption.html
		// component.componentOption().photoListOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/camera/TuCameraOption.html
		TuCameraOption cameraOption = component.componentOption().cameraOption();

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/edit/TuEditTurnAndCutOption.html
		// component.componentOption().editTurnAndCutOption()

		// 需要显示的滤镜名称列表 (如果为空将显示所有自定义滤镜, 可选)
		String[] filters = {
				"SkinNature", "SkinPink", "SkinJelly", "SkinNoir", "SkinRuddy", "SkinPowder", "SkinSugar"};
		cameraOption.setFilterGroup(Arrays.asList(filters));
		component
		// 在组件执行完成后自动关闭组件
				.setAutoDismissWhenCompleted(true)
				// 显示组件
				.showComponent();
		cameraOption.setAutoReleaseAfterCaptured(true);


	}
	ResultAvatar resultAvatar;
	public void setResult(ResultAvatar resultAvatar){
		this.resultAvatar = resultAvatar;
	}


}