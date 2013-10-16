package com.tutor.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.wanzhuan.R;
import com.example.wanzhuan.R.id;
import com.example.wanzhuan.R.layout;
import com.example.wanzhuan.R.menu;
import com.example.wanzhuan.R.style;
import com.tutor.dialogs.ConfirmDialog;

public class TodoExchangeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_exchange);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo_exchange, menu);
		return true;
	}

	public void confirmExchange(View view)
	{
		ConfirmDialog cDialog =new ConfirmDialog(this,R.layout.dialog_confirm_layout,R.style.Theme_dialog);
		cDialog.show();
		TextView tvMessage = (TextView)cDialog.findViewById(R.id.tvMessage);
		tvMessage.setText("¹§Ï²Äú¶Ò»»³É¹¦£¡¼ÌÐø¶Ò»»£¡");				
	}
	
	public void cancelExchange(View view)
	{
		super.onBackPressed();
	}
}
