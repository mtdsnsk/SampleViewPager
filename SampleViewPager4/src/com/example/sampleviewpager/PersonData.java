package com.example.sampleviewpager;


public class PersonData {
	private String name;
	private int res;
	private String url;

	public PersonData(String name, int res, String url) {
		this.name = name;
		this.res = res;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

}