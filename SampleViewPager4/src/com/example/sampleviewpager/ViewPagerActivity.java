package com.example.sampleviewpager;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class ViewPagerActivity extends Activity implements
		ClickPagerImgListerner {

	List<PersonData> list;
	int currentIndex;
	CardPagerAdapter pagerAdapter;
	private int device_width;
	private int device_height;
	private TypedArray button_designs;
	private TypedArray topbar_colors;
	private ViewPager viewPager;
	private HorizontalScrollView hsv;
	private String TAG = "SampleViewPager";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 端末サイズを取得
		getDeviceSize();
		// ViewPagerのデータ作成
		this.list = PersonDataGenerator.createPersonData();
		// リソースの取得
		button_designs = getResources().obtainTypedArray(R.array.buttons);
		topbar_colors = getResources().obtainTypedArray(R.array.colors);
		// レイアウト紐付け
		hsv = (HorizontalScrollView) findViewById(R.id.hsv);
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		pagerAdapter = new CardPagerAdapter(this, list);
		pagerAdapter.setListener(this);

		viewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						Log.d(TAG, "onPageSelected position=" + position);
						setButtonScrollPosition(position);
					}
				});
		// viewPager.setOnPageChangeListener(new PageChangeListener());
		viewPager.setAdapter(pagerAdapter);

		for (int i = 0; i < 10; i++) {
			Button btn = new Button(this);
			addCategoryButton(btn, i);
		}

		currentIndex = 0;
	}

	@SuppressLint("NewApi")
	private void getDeviceSize() {
		// 画面サイズを取得する
		Display display = getWindowManager().getDefaultDisplay();
		Point p = new Point();
		display.getRealSize(p);
		device_width = p.x;
		device_height = p.y;
		Log.d(TAG, "端末 幅:" + device_width + " 高さ:" + device_height);
	}

	class PageChangeListener extends SimpleOnPageChangeListener {
		@Override
		public void onPageSelected(int position) {
			// Page change Operation!
			super.onPageSelected(position);
			currentIndex = position;
		}
	}

	@Override
	public void change(int position) {
		addExtraData();
	}

	private void addExtraData() {
		list.add(new PersonData("Sara-chan", R.drawable.images2,
				"http://www.dogactually.net/blog/photo//2009/01/28/090128_akita.jpg"));
		pagerAdapter.notifyDataSetChanged();
	}

	@Override
	public void addButton(Button btn, int position) {
		addCategoryButton(btn, position);
	}

	private void addCategoryButton(Button btn, final int position) {
		Drawable drawableDesign = button_designs.getDrawable(position);
		LinearLayout linearlayout = (LinearLayout) findViewById(R.id.hsvLinear);
		btn.setText(list.get(position).getName());
		btn.setTextColor(Color.WHITE);
		btn.setId(position);
		btn = setBtnBackground(btn, drawableDesign);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//finish();
				viewPager.setCurrentItem(position, true);
				clickbuttonfocus(position);
			}
		});
		linearlayout.addView(btn);
	}

	@SuppressLint("NewApi")
	public static Button setBtnBackground(Button btn, Drawable d) {
		int sdk = android.os.Build.VERSION.SDK_INT;
		if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
			btn.setBackgroundDrawable(d);
		} else {
			btn.setBackground(d);
		}
		return btn;
	}

	@Override
	public void startAnotherActivity(String url) {
		// タップされたリンクのURL（変更先ロケーション）
		Intent intent = new Intent(ViewPagerActivity.this, showArchives.class);
		intent.putExtra("url", url);
		// 次画面のアクティビティ起動
		startActivity(intent);
		return;
	}

	@Override
	public void setPageTitle(String title) {
		Button btn = (Button) findViewById(R.id.full_web_button1);
		btn.setText(title);
	}

	@Override
	public int getColorResource(int position) {
		int color = topbar_colors.getColor(position, position);
		return color;
	}

	private void clickbuttonfocus(int position){
		setButtonScrollPosition(position);
	}
	
	@Override
	public void setButtonScrollPosition(int position) {
		Button btn = (Button) findViewById(position);
		hsv.scrollTo(
				(btn.getLeft() - ((device_width / 2) - (btn.getWidth() / 2))),
				btn.getTop());
		Log.d(TAG, "setButtonScrollPosition " + btn.getId());
		Log.d(TAG,
				"button left "
						+ btn.getLeft()
						+ "button width "
						+ btn.getWidth()
						+ "scroll to"
						+ (btn.getLeft() - ((device_width / 2) - (btn
								.getWidth() / 2))));
		return;
	}
}