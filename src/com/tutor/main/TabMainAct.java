package com.tutor.main;

import com.example.wanzhuan.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

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
		// View niTab = (View)
		// LayoutInflater.from(this).inflate(R.layout.tabwidebg,
		// null);
		// TextView text0 = (TextView) niTab.findViewById(R.id.tab_label);
		// text0.setText("ni");
		//
		// View woTab = (View)
		// LayoutInflater.from(this).inflate(R.layout.tabwidebg,
		// null);
		// TextView text1 = (TextView) woTab.findViewById(R.id.tab_label);
		// text1.setText("wo");

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
		yxTabHost.addTab(yxTabHost.newTabSpec("3GTab").setIndicator("3G辅导")
				.setContent(R.id.tab_3gfudao));
		yxTabHost.addTab(yxTabHost.newTabSpec("YXJifen").setIndicator("营销积分")
				.setContent(R.id.tab_yxjifen));
	}
}
