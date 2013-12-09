package com.shumz.application.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shumz.application.MainActivity;
import com.shumz.application.R;
import com.shumz.application.SplashActivity;

public class SplashActivityTest extends
		ActivityInstrumentationTestCase2<SplashActivity> {

	public SplashActivityTest() {
		super(SplashActivity.class);
	}

	private static final String LOGGER = "SplashActivityTest:";

	private static SplashActivity splashActivityToTest;

	private static RelativeLayout rlSplashLayout;

	private static TextView tvSplashActivityPropertyOf;
	private static TextView tvSplashActivityShumzSoft;

	private static ImageView chuckskullImage;

	private static ActivityMonitor mainActivityMonitor;

	private static ActivityMonitor splashAcitvityMonitor;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		splashActivityToTest = getActivity();

		rlSplashLayout = (RelativeLayout) splashActivityToTest
				.findViewById(R.id.splash_layout);

		tvSplashActivityPropertyOf = (TextView) splashActivityToTest
				.findViewById(R.id.tv_splash_activity_property_of);
		tvSplashActivityShumzSoft = (TextView) splashActivityToTest
				.findViewById(R.id.tv_splash_activity_shumz_soft_inc);

		chuckskullImage = (ImageView) splashActivityToTest
				.findViewById(R.id.image_chuckskull);

		mainActivityMonitor = new ActivityMonitor(MainActivity.class.getName(),
				null, false);
		getInstrumentation().addMonitor(mainActivityMonitor);

		splashAcitvityMonitor = new ActivityMonitor(
				SplashActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(splashAcitvityMonitor);

	}

	@Override
	protected void tearDown() throws Exception {

		if (getActivity().getClass().getName()
				.equals("com.shumz.application.MainActivity")) {

			mainActivityMonitor.getLastActivity().finish();

		} else {

			mainActivityMonitor.waitForActivity().finish();

		}

		super.tearDown();
	}

	public void testAllWiewsArePresentOnSplashActivity() {
		Log.i(LOGGER, "Running testAllWiewsArePresent()");

		assertNotNull("Cannot find SplashAcitvity!", splashActivityToTest);
		assertNotNull("Cannot find llSplashLayout!", rlSplashLayout);
		assertNotNull("Cannot find tvSplashActivityPropertyOf!",
				tvSplashActivityPropertyOf);
		assertNotNull("Cannot find tvSplashActivityShumzSoft!",
				tvSplashActivityShumzSoft);
		assertNotNull("Cannot find ÑhuckskullImage!", chuckskullImage);
	}

	public void testParametersOftvSplashActivityShumzSoft() {
		Log.i(LOGGER, "Running testParametersOftvSplashActivityShumzSoft()");

		// Testing the layout parameters of tvSplashActivityPropertyOf TextView
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityShumzSoft.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityShumzSoft.getLayoutParams().height);

		// Testing The alignment to the parent View

		assertEquals(tvSplashActivityPropertyOf.getBottom(),
				tvSplashActivityShumzSoft.getTop());

		ViewAsserts.assertHorizontalCenterAligned(rlSplashLayout,
				tvSplashActivityShumzSoft);

		// Testing the text
		assertEquals("ShumzSoft Inc.", tvSplashActivityShumzSoft.getText()
				.toString());

	}

	public void testParametersOftvSplashActivityPropertyOf() {
		Log.i(LOGGER, "Running testParametersOftvSplashActivityPropertyOf()");

		// Testing the layout parameters of tvSplashActivityPropertyOf TextView
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityPropertyOf.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityPropertyOf.getLayoutParams().height);

		// Testing The alignment to the parent View
		ViewAsserts.assertVerticalCenterAligned(rlSplashLayout,
				tvSplashActivityPropertyOf);
		ViewAsserts.assertHorizontalCenterAligned(rlSplashLayout,
				tvSplashActivityPropertyOf);

		assertEquals("Property of", tvSplashActivityPropertyOf.getText()
				.toString());

	}

	public void testParametersOfChuckskullImage() {
		Log.i(LOGGER, "Running testParametersOfChuckskullImage()");

		// Testing the layout parameters of tvSplashActivityPropertyOf TextView
		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().height);

		ViewAsserts.assertGroupContains(rlSplashLayout, chuckskullImage);

	}

	public void testCleanLaunch() {
		Log.i(LOGGER, "Running testCleanLaunch()");

		try {
			Thread.sleep(8500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Activity mainMenuActivity = mainActivityMonitor.getLastActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	public void testOnTouchSkippingActivity() {
		Log.i(LOGGER, "Running testOnTouchSkippingActivity()");

//		fail("Does not work as expected!!!");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		TouchUtils.clickView(this, chuckskullImage);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Activity mainMenuActivity = mainActivityMonitor.getLastActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	public void testOnBackPressed() {

		Log.i(LOGGER, "Running testOnTouchSkippingActivity()");

		for (int i = 0; i < 3; i++) {

			try {

				Thread.sleep(1000);

				sendKeys(KeyEvent.KEYCODE_BACK);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		assertNotNull("SplachActivity is finished!..", splashActivityToTest);
		
		mainActivityMonitor.waitForActivity().finish();

	}

	public void testChangingDeviceOrientationOfSplashActivity() {

		Log.i(LOGGER, "Running testChangingDeviceOrientationOfSplashActivity()");

		try {
			Thread.sleep(1500);
			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			Thread.sleep(500);

			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			Thread.sleep(1500);

			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			Thread.sleep(500);
			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			Thread.sleep(500);
			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
			Thread.sleep(500);
			splashActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
