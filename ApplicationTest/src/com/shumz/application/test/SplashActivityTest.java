package com.shumz.application.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
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

	SplashActivity splashActivityToTest;

	MainActivity mainActivityToTest;

	RelativeLayout rlSplashLayout;

	TextView tvSplashActivityPropertyOf;
	TextView tvSplashActivityShumzSoft;

	ImageView chuckskullImage;

	MediaPlayer logoMusic;

	private ActivityMonitor mainMenuActivityMonitor;

	ActivityMonitor splashAcitvityMonitor;

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

		new MediaPlayer();
		logoMusic = MediaPlayer.create(splashActivityToTest, R.raw.n_man);

		mainMenuActivityMonitor = new ActivityMonitor(
				MainActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(mainMenuActivityMonitor);

		splashAcitvityMonitor = new ActivityMonitor(
				SplashActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(splashAcitvityMonitor);

	}

	@Override
	protected void tearDown() throws Exception {

		Log.w(LOGGER, "tearDown()...");

		if (getActivity().getClass().getName()
				.equals("com.shumz.application.MainActivity")) {

			mainMenuActivityMonitor.getLastActivity().finish();

		} else {

			mainMenuActivityMonitor.waitForActivity().finish();

		}

		super.tearDown();
	}

	public void testAllWiewsArePresent() {
		Log.i(LOGGER, "Running testAllWiewsArePresent()");

		assertNotNull("Cannot find SplashAcitvity!", splashActivityToTest);
		assertNotNull("Cannot find llSplashLayout!", rlSplashLayout);
		assertNotNull("Cannot find tvSplashActivityPropertyOf!",
				tvSplashActivityPropertyOf);
		assertNotNull("Cannot find tvSplashActivityShumzSoft!",
				tvSplashActivityShumzSoft);
		assertNotNull("Cannot find ÑhuckskullImage!", chuckskullImage);

		assertNotNull("Cannot find ÑhuckskullImage!", logoMusic);

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

		// Testing the text size
		assertEquals(32.0F, tvSplashActivityShumzSoft.getTextSize());

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

		assertEquals(26.0F, tvSplashActivityPropertyOf.getTextSize());

	}

	public void testParametersOfChuckskullImage() {
		Log.i(LOGGER, "Running testParametersOfChuckskullImage()");

		// Testing the layout parameters of tvSplashActivityPropertyOf TextView
		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().height);

		ViewAsserts.assertGroupContains(rlSplashLayout, chuckskullImage);

		ViewAsserts.assertRightAligned(rlSplashLayout, chuckskullImage, 15);
		ViewAsserts.assertBottomAligned(rlSplashLayout, chuckskullImage, 15);

	}

	public final void testCleanLaunch() {
		Log.i(LOGGER, "Running testCleanLaunch()");

		try {
			Thread.sleep(8500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Activity mainMenuActivity = mainMenuActivityMonitor.getLastActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	public final void testOnTouchSkippingActivity() {
		Log.i(LOGGER, "Running testOnTouchSkippingActivity()");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		TouchUtils.clickView(this, chuckskullImage);

		Activity mainMenuActivity = mainMenuActivityMonitor.getLastActivity();
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

	}

	public void testChangingDeviceOrientation() {

		Log.i(LOGGER, "Running testChangingDeviceOrientation()");

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
