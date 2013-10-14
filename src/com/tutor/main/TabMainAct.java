package com.tutor.main;

import com.example.wanzhuan.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class TabMainAct extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.tabmain);
		initTab();
	}

	private void initTab() {

		View sgTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabwidebg, null);
		LinearLayout sgLinLay = (LinearLayout) sgTab
				.findViewById(R.id.mainTabLl);
		TextView sgtv = (TextView) sgTab.findViewById(R.id.mainTabTv);
		sgtv.setText("3G辅导");

		View yxTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabwidebg, null);
		LinearLayout yxLinLay = (LinearLayout) yxTab
				.findViewById(R.id.mainTabLl);
		TextView yxtv = (TextView) yxTab.findViewById(R.id.mainTabTv);
		yxtv.setText("营销积分");
		TabHost yxTabHost = (TabHost) findViewById(R.id.yxTabHost);
		yxTabHost.setup();
		yxTabHost.addTab(yxTabHost.newTabSpec("3GTab").setIndicator(sgTab)
				.setContent(R.id.tab_3gfudao));
		yxTabHost.addTab(yxTabHost.newTabSpec("YXJifen").setIndicator(yxTab)
				.setContent(R.id.tab_yxjifen));
		yxTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				if (tabId.equals("3GTab")) {
					ListView myTabLst = (ListView) findViewById(R.id.myTabLst);
					
				} else {

				}
			}

		});
	}
}
