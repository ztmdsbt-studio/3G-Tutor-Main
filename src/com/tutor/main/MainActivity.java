package com.tutor.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.example.wanzhuan.R;

public class MainActivity extends Activity {

	private TabHost tabHost = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.tabmain);
		initialTabHost();

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			final Dialog dialog = new Dialog(this, R.style.Theme_dialog);
			dialog.setCanceledOnTouchOutside(true);
			View view = LayoutInflater.from(this).inflate(
					R.layout.dialog_yesno_layout, null);
			dialog.setContentView(view);
			TextView tvMessage = (TextView) dialog.findViewById(R.id.tvMessage);
			tvMessage.setText("是否确定退出？");

			Button confirmButton = (Button) dialog
					.findViewById(R.id.btnConfirm);
			confirmButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					finish();
					// android.os.Process.killProcess(android.os.Process.myPid());
				}
			});

			Button cancelButton = (Button) dialog.findViewById(R.id.btnCancel);
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

	private void initialTabHost() {
		tabHost = (TabHost) findViewById(R.id.myTabHost);

		// 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
		tabHost.setup();

		// 这里content的设置采用了布局文件中的view
		TabSpec spec3gTutor = tabHost.newTabSpec("tab1").setIndicator("3G辅导")
				.setContent(R.id.view1);
		tabHost.addTab(spec3gTutor);

		TabSpec specYxjf = tabHost.newTabSpec("tab2").setIndicator("营销积分")
				.setContent(R.id.view2);
		tabHost.addTab(specYxjf);

		updateTab(tabHost);// 初始化Tab的颜色，和字体的颜色

		tabHost.setOnTabChangedListener(new OnTabChangedListener()); // 选择监听器
	}

	class OnTabChangedListener implements OnTabChangeListener {

		@Override
		public void onTabChanged(String tabId) {
			tabHost.setCurrentTabByTag(tabId);
			System.out.println("tabid " + tabId);
			System.out.println("curreny after: " + tabHost.getCurrentTabTag());
			updateTab(tabHost);
		}
	}

	private void updateTab(final TabHost tabHost) {

		View view1 = tabHost.getTabWidget().getChildAt(0);
		LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) view1
				.getLayoutParams();
		params1.height = 55;
		view1.setLayoutParams(params1);
		if (tabHost.getCurrentTab() == 0) {
			view1.setBackgroundResource(R.drawable.tabselectedcolor);
		} else {
			view1.setBackgroundResource(R.drawable.tabunselcolor);
		}

		View view2 = tabHost.getTabWidget().getChildAt(1);
		LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) view2
				.getLayoutParams();
		params2.height = 55;
		view2.setLayoutParams(params2);
		if (tabHost.getCurrentTab() == 1) {
			view2.setBackgroundResource(R.drawable.tabselectedcolor);
		} else {
			view2.setBackgroundResource(R.drawable.tabunselcolor);
		}
	}
	
	private float getDesity(Context context)
	{
		Resources resource = context.getResources();
		DisplayMetrics dm = resource.getDisplayMetrics();
		return dm.density;
	}
}
