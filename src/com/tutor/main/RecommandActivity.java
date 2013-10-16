package com.tutor.main;

import com.example.wanzhuan.R;
import com.example.wanzhuan.R.layout;
import com.example.wanzhuan.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class RecommandActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommand);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recommand, menu);
		return true;
	}
	
	public void moveOutFromFavorite(View view)
	{
		//TODO
	}
	
	public void ToTutor(View view)
	{
		//TODO
	}
}
