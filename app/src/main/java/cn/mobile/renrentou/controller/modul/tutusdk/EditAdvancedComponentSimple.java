/** 
 * TuSdkDemo
 * AdvancedComponentSimple.java
 *
 * @author 		Clear
 * @Date 		2015-4-21 下午12:49:54 
 * @Copyright 	(c) 2015 tusdk.com. All rights reserved.
 * 
 */
package cn.mobile.renrentou.controller.modul.tutusdk;

import android.app.Activity;

import org.lasque.tusdk.TuSdkGeeV1;
import org.lasque.tusdk.core.TuSdkResult;
import org.lasque.tusdk.core.utils.TLog;
import org.lasque.tusdk.impl.activity.TuFragment;
import org.lasque.tusdk.impl.components.TuEditComponent;
import org.lasque.tusdk.modules.components.TuSdkComponent.TuSdkComponentDelegate;
import org.lasque.tusdk.modules.components.TuSdkHelperComponent;

import cn.mobile.renrentou.R;

/**
 * 高级图片编辑组件范例
 * 
 * @author Clear
 */
public class EditAdvancedComponentSimple extends SimpleBase
{
	/** 高级图片编辑组件范例 */
	public EditAdvancedComponentSimple()
	{
		super(2, R.string.simple_EditAdvancedComponent);
	}

	/** 显示范例 */
	@Override
	public void showSimple(Activity activity)
	{
		if (activity == null) return;
		// see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/base/TuSdkHelperComponent.html
		this.componentHelper = new TuSdkHelperComponent(activity);

		TuSdkGeeV1.albumMultipleCommponent(activity, new TuSdkComponentDelegate() {
			@Override
			public void onComponentFinished(TuSdkResult result, Error error, TuFragment lastFragment) {
				openEditAdvanced(result, error, lastFragment);
			}
		}).showComponent();
	}

	/** 开启图片高级编辑 */
	private void openEditAdvanced(TuSdkResult result, Error error, TuFragment lastFragment)
	{
		if (result == null || error != null) return;

		// 组件委托
		TuSdkComponentDelegate delegate = new TuSdkComponentDelegate()
		{
			@Override
			public void onComponentFinished(TuSdkResult result, Error error, TuFragment lastFragment)
			{
				TLog.d("onEditAdvancedComponentReaded: %s | %s", result, error);
				if(resultAvatar != null){
					resultAvatar.getAvatar(result,error,lastFragment);
				}
			}
		};

		// 组件选项配置
		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/TuEditComponent.html
		TuEditComponent component = null;

		if (lastFragment == null)
		{
			component = TuSdkGeeV1.editCommponent(this.componentHelper.activity(), delegate);
		}
		else
		{
			component = TuSdkGeeV1.editCommponent(lastFragment, delegate);
		}

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/TuEditComponentOption.html
		// component.componentOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/edit/TuEditEntryOption.html
		// component.componentOption().editEntryOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/edit/TuEditCuterOption.html
		// component.componentOption().editCuterOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/filter/TuEditFilterOption.html
		// component.componentOption().editFilterOption()

		// @see-http://tusdk.com/docs/android/api/org/lasque/tusdk/impl/components/sticker/TuStickerChooseOption.html
		// component.componentOption().editStickerOption()

		// 设置图片
		component.setImage(result.image)
		// 设置系统照片
				.setImageSqlInfo(result.imageSqlInfo)
				// 设置临时文件
				.setTempFilePath(result.imageFile)
				// 在组件执行完成后自动关闭组件
				.setAutoDismissWhenCompleted(true)
				// 开启组件
				.showComponent();
	}
	ResultAvatar resultAvatar;
	public void setResult(ResultAvatar resultAvatar){
		this.resultAvatar = resultAvatar;
	}
}