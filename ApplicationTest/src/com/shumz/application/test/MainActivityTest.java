package com.shumz.application.test;

import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

import com.shumz.application.MainActivity;
import com.shumz.application.R;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	
	public MainActivityTest() {
		super(MainActivity.class);
	}

	
	MainActivity mainActivityToTest;
	ImageView cognianceLogo;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		mainActivityToTest = getActivity();
	
		cognianceLogo = (ImageView) mainActivityToTest.findViewById(R.id.image_cogniance_logo);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testMainActivityPresence() {
		assertNotNull(cognianceLogo);
		
		assertNotNull("Gotcha!!!", cognianceLogo);
	}
}
