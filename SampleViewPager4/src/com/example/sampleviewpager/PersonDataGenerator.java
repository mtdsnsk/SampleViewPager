package com.example.sampleviewpager;

import java.util.ArrayList;
import java.util.List;

public class PersonDataGenerator {
	public static List<PersonData> createPersonData() {
		List<PersonData> res = new ArrayList<PersonData>();

		res.add(new PersonData("Sara Rukawa", R.drawable.images2, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Aoi Hinomoto", R.drawable.images3, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Himeno Katsuragi", R.drawable.images4, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Sharuru Yoshino", R.drawable.images5, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Rikka Morizono", R.drawable.images6, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Sara Rukawa", R.drawable.images7, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Aoi Hinomoto", R.drawable.images8, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Himeno Katsuragi", R.drawable.images9, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Sharuru Yoshino", R.drawable.images10, "file:///android_asset/sample1.html"));
		res.add(new PersonData("Rikka Morizono", R.drawable.images11, "file:///android_asset/sample1.html"));

		return res;
	}
}