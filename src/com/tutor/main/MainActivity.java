package com.tutor.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.wanzhuan.R;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.tabmain);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			final Dialog dialog = new Dialog(this,R.style.Theme_dialog);
			dialog.setCanceledOnTouchOutside(true);
			View view = LayoutInflater.from(this).inflate(R.layout.dialog_yesno_layout,null);
			dialog.setContentView(view);
			TextView tvMessage = (TextView) dialog
					.findViewById(R.id.tvMessage);
			tvMessage.setText("是否确定退出？");

			Button confirmButton = (Button) dialog
					.findViewById(R.id.btnConfirm);
			confirmButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					finish();
					//android.os.Process.killProcess(android.os.Process.myPid());
				}
			});
			
			Button cancelButton =(Button)dialog.findViewById(R.id.btnCancel);
			cancelButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			dialog.show();
		}

		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
