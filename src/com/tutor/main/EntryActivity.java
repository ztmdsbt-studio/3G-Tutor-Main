package com.tutor.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.wanzhuan.R;

public class EntryActivity extends FragmentActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.activity_entry);

	    FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

	    tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

	    //1
	    tabHost.addTab(tabHost.newTabSpec("3G辅导")
	                          .setIndicator("3G辅导"), 
	                   Tutor3GFragment.class, 
	                   null);
	    //2
	    tabHost.addTab(tabHost.newTabSpec("营销积分")
	                          .setIndicator("营销积分"), 
	                   Tutor3GFragment.class, 
	                   null);
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
