package com.example.sampleviewpager;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CardPagerAdapter extends PagerAdapter {

	LayoutInflater _inflater = null;
	List<PersonData> list;
	private WebViewClientSample webviewclientsample;
	private ImageView charView;
	private ImageView barImage;
	private WebView webview;
	// listener
	private ClickPagerImgListerner listener;

	public CardPagerAdapter(Context context, List<PersonData> list) {
		super();
		_inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list = list;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LinearLayout layout = (LinearLayout) _inflater.inflate(R.layout.card,
				null);

		barImage = (ImageView) layout.findViewById(R.id.imageView1);
		barImage.setBackgroundColor(listener.getColorResource(position));

		charView = (ImageView) layout.findViewById(R.id.img);
		charView.setImageResource(list.get(position).getRes());
		charView.setClickable(true);

		webview = (WebView) layout.findViewById(R.id.webView);
		webview.loadUrl(list.get(position).getUrl());

		// ズームを有効
		webview.getSettings().setBuiltInZoomControls(true);
		// JavaScriptを有効
		webview.getSettings().setJavaScriptEnabled(true);
		// カスタムしたイベントを拾う
		webviewclientsample = new WebViewClientSample();
		// リスナで紐づける
		webviewclientsample.setListener(listener);
		webview.setWebViewClient(webviewclientsample);

		// ボタンの位置までスクロールしてボタンをセンター表示
		// listener.setButtonScrollPosition(position);
		container.addView(layout);
		return layout;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		return view.equals(obj);
	}

	public void setListener(ClickPagerImgListerner listener) {
		this.listener = listener;
	}
}
