package com.example.sampleviewpager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewClientFull extends WebViewClient {

	private Context context;
	private Dialog dialog;
	private ClickPagerImgListerner listener;

	public WebViewClientFull(Context context) {
		super();
		dialog = null;
		this.context = context;
	}

	/*
	 * private void disimissDialog() { dialog.dismiss(); dialog = null; }
	 */

	// ページの読み込み開始
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		//dialog = new Dialog(view.getContext());
		//dialog.setTitle("Now Loading");
		//dialog.show();
	}

	// ページの読み込み完了
	@Override
	public void onPageFinished(WebView view, String url) {
		//String title = view.getTitle();
		//dialog = new Dialog(view.getContext());
		//dialog.setTitle(title);
		//dialog.show();
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