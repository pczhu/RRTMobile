package cn.mobile.renrentou.controller.ui.fragment.projectdetail;

import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.fragment.basefragment.BaseFragment;
import cn.mobile.renrentou.controller.widget.dragview.CustWebView;

/**
 * 名称：ProFragmentBottom
 * 作用：项目详情说明
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/18 下午5:48
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.fragment_probottom)
public class ProFragmentBottom extends BaseFragment {
	@ViewInject(R.id.progressbar)
	private View progressBar;
	@ViewInject(R.id.fragment3_webview)
	private CustWebView webview;
	private boolean hasInited = false;


	public void initView() {
		if (null != webview && !hasInited) {
			hasInited = true;
			progressBar.setVisibility(View.GONE);
			webview.loadUrl("http://m.zol.com/tuan/");
		}
	}
}
