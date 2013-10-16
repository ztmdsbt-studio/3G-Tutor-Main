package com.tutor.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wanzhuan.R;
import com.tutor.views.GuideHelper;

public class LoginActivity extends Activity {

	private ImageView loginBt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		loginBt = (ImageView) findViewById(R.id.loginBt);

		GuideHelper guideHelper = new GuideHelper(this);
		guideHelper.openGuide();
	}
	
	public void gotoMainPage(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		this.finish();
	}

}
