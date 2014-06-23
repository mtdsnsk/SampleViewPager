package com.example.sampleviewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;

public class showArchives extends Activity {

	private BackNotify mNotify = new BackNotify();
	private Handler mNotifyHandler = null;
	private WebView webview;
	private Button backbtn;
	private WebViewClientFull fullwebviewclient;
	private ClickPagerImgListerner listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// ウィンドウ非表示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// メインレイアウトをセット
		setContentView(R.layout.fullwebview);

		Intent i = getIntent();
		String url = i.getStringExtra("url");

		webview = (WebView) findViewById(R.id.full_webView);
		webview.loadUrl(url);

		// ズームを有効
		webview.getSettings().setBuiltInZoomControls(true);
		// JavaScriptを有効
		webview.getSettings().setJavaScriptEnabled(true);
		// カスタムしたイベントを拾う
		fullwebviewclient = new WebViewClientFull(this);
		// リスナで紐づける
		fullwebviewclient.setListener(listener);

		webview.setWebViewClient(fullwebviewclient);

		// クリックリスナ登録
		backbtn = (Button) findViewById(R.id.full_web_button1);
		backbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		if (mNotifyHandler == null) {
			mNotifyHandler = new Handler();
		}
	}

	// called when Back gesture is done while no more backward history
	public class BackNotify implements Runnable { // notify from nfWebView
		@Override
		public void run() {
			finish();
		}
	}
}