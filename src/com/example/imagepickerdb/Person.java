package com.example.imagepickerdb;

import android.net.Uri;

public class Person {
	
	private Uri image;
	private String name;
	
	public Person(Uri image, String name) {
		super();
		this.image = image;
		this.name = name;
	}
	
	public Uri getImage() {
		return image;
	}

	public void setImage(Uri image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
