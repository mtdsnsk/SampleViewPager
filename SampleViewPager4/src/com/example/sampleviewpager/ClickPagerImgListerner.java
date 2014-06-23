package com.example.sampleviewpager;

import android.widget.Button;

public interface ClickPagerImgListerner {
	public void change(int position);
	public void addButton(Button btn, int position);
	public void startAnotherActivity(String url);
	public void setPageTitle(String title);
	int getColorResource(int position);
	void setButtonScrollPosition(int position);
}
