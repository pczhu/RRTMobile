package cn.mobile.renrentou.controller.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.flyco.roundview.RoundTextView;
import com.xw.repo.xedittext.XEditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.Timer;
import java.util.TimerTask;

import cn.mobile.renrentou.R;
import cn.mobile.renrentou.controller.ui.activity.baseactivity.BaseActivity;
import cn.mobile.renrentou.utils.SystemUtils;

/**
 * 名称：${FILE_NAME}
 * 作用：
 * 描述：
 * 作者：pczhu
 * 创建时间： 16/1/14 下午1:50
 * 版本：V1.0
 * 修改历史：
 */
@ContentView(R.layout.activity_search)
public class SearchActivity extends BaseActivity {
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.xedittext)
    private XEditText xEditText;
    @ViewInject(R.id.search_view)
    private LinearLayout linearLayout;
    @ViewInject(R.id.rtv)
    private RoundTextView roundTextView_serarch;
    @ViewInject(R.id.rtv2)
    private RoundTextView roundTextView_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toolbar,true);
        xEditText.setFocusable(true);
        xEditText.setFocusableInTouchMode(true);
        xEditText.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
              public void run() {
                  InputMethodManager inputManager =
                  (InputMethodManager) xEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                   inputManager.showSoftInput(xEditText, 0);
               }
         },998);
        roundTextView_serarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = xEditText.getNonSeparatorText();
                Intent intent = new Intent();
                intent.putExtra("searchTagWord", result);
                SearchActivity.this.setResult(1, intent);
                SearchActivity.this.finish();
            }
        });
        roundTextView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });
    }


}
