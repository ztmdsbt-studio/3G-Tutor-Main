package com.tutor.main;

import com.example.wanzhuan.R;
import com.example.wanzhuan.R.id;
import com.example.wanzhuan.R.layout;
import com.example.wanzhuan.R.menu;
import com.example.wanzhuan.R.style;
import com.tutor.dialogs.ConfirmDialog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ChangePassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_password, menu);
		return true;
	}
	
	public void backToPrevious(View view)
	{
		super.onBackPressed();
	}

	public void confirmExchange(View view)
	{
		ConfirmDialog cDialog =new ConfirmDialog(this,R.layout.dialog_confirm_layout,R.style.Theme_dialog);
		cDialog.show();
		TextView tvMessage = (TextView)cDialog.findViewById(R.id.tvMessage);
		tvMessage.setText("ÃÜÂëÐÞ¸Ä³É¹¦£¡");				
	}

}
