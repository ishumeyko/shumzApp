package com.shumz.application.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.ImageView;

import com.shumz.application.MainActivity;
import com.shumz.application.SplashActivity;
import com.shumz.application.R;

public class SplashActivityTest extends
		ActivityInstrumentationTestCase2<SplashActivity> {

	public SplashActivityTest() {
		super(SplashActivity.class);
	}

	SplashActivity splashActivityToTest;
	ImageView chuckskullImage;

	private ActivityMonitor mainMenuActivityMonitor;

	protected void setUp() throws Exception {
		super.setUp();

		splashActivityToTest = getActivity();
		chuckskullImage = (ImageView) getActivity().findViewById(
				R.id.image_chuckskull);

		mainMenuActivityMonitor = new ActivityMonitor(
				MainActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(mainMenuActivityMonitor);

	}

	public final void testCleanLaunch() throws InterruptedException {

		Activity mainMenuActivity = mainMenuActivityMonitor
				.waitForActivityWithTimeout(5000);
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	public final void testSomething() {

		TouchUtils.clickView(this, chuckskullImage);
		
		Activity mainMenuActivity = mainMenuActivityMonitor.waitForActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);
	}

}
