package com.tutor.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.wanzhuan.R;
import com.tutor.views.GuideHelper;

public class MainActivity extends Activity {
	private TabHost tabProduct;
	private TextView tvwgmm;
	private ImageView loginBt;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.login);
		tvwgmm = (TextView) findViewById(R.id.tvwgmm);
		tvwgmm.setText(Html.fromHtml("<u>记住密码</u>"));
		loginBt = (ImageView) findViewById(R.id.loginBt);
		loginBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new  Intent(MainActivity.this,TabMainAct.class);
				MainActivity.this.startActivity(intent);
			}
		});

        GuideHelper guideHelper = new GuideHelper(this);
        guideHelper.openGuide();
		
	}

	private void intiLlProduct() {
		tabProduct = (TabHost) findViewById(R.id.tabProduct);
		tabProduct.setup();
		intiLlProduct();
		tabProduct.addTab(tabProduct.newTabSpec("tab1").setIndicator("流量产品")
				.setContent(R.id.tab_LlProduct));
		tabProduct.addTab(tabProduct.newTabSpec("tab2").setIndicator("创新产品")
				.setContent(R.id.tab_CxProduct));
		tabProduct.addTab(tabProduct.newTabSpec("tab3").setIndicator("更多产品")
				.setContent(R.id.tab_MoreProduct));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
