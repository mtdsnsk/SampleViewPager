package com.example.sampleviewpager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewClientSample extends WebViewClient {

	private Dialog dialog;
	private ClickPagerImgListerner listener;

	public WebViewClientSample() {
		super();
		dialog = null;
	}

	/*
	 * private void disimissDialog() { dialog.dismiss(); dialog = null; }
	 */

	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		listener.startAnotherActivity(url);
		return (true);
	}

	// ページの読み込み開始
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		//dialog = new Dialog(view.getContext());
		//dialog.setTitle("Now Loading");
		//dialog.show();
		//listener.setPageTitle("Now Loading");
	}

	// ページの読み込み完了
	@Override
	public void onPageFinished(WebView view, String url) {

		//String page_title = view.getTitle();
		//listener.setPageTitle(page_title);
		// disimissDialog();
	}

	// ページの読み込み失敗
	@Override
	public void onReceivedError(WebView view, int errorCode,
			String description, String failingUrl) {
		if (null != dialog) {
			// disimissDialog();
		}
		Toast.makeText(view.getContext(), "エラー", Toast.LENGTH_LONG).show();
	}

	public void setListener(ClickPagerImgListerner listener) {
		this.listener = listener;
	}
}