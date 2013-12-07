package com.shumz.application.test;

import android.annotation.SuppressLint;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.application.R;
import com.shumz.application.TimerActivity;
import com.shumz.application.TimerEndOfTimeDialogActivity;

@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class TimerActivityBehaviorTest extends
		ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerActivityBehaviorTest() {
		super(TimerActivity.class);
	}

	private static final String LOGGER = "TimerActivityBehaviorTest:";
	private static final int SLEEP_TIME = 500;

	private static Solo solo;

	// private static TimerEndOfTimeDialogActivity
	// TimerEndOfTimeDialogActivityToTest;

	//
	// Views that are visible in all orientations
	private static TimerActivity TimerActivityToTest;

	private static TimePicker tPicker;

	private static LinearLayout lLayoutCountdown;

	private static TextView tvHHs;
	private static TextView tvDelimeterHM;
	private static TextView tvMMs;
	private static TextView tvDelimeterMS;
	private static TextView tvSSs;

	// private static DigitalClock dClock;

	private static Button startStopButton;
	private static Button pauseResumeButton;

	//
	// Views that are visible only in PORTRAIT orientation
	// private static RelativeLayout rLayoutTimerTopView;

	//
	// Views that are visible only in LANDSCAPE orientation
	// private static LinearLayout lLayoutTimerLandTopView;

	// private static RelativeLayout rLayoutTimerLandCounter;

	// private static RelativeLayout rLayoutTimerLandButtons;

	KeyguardManager keyguardManager;

	KeyguardLock lock;

	ActivityMonitor TimerActivityMonytor;
	ActivityMonitor TimerEndOfTimeDialogActivityMonytor;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		TimerActivityToTest = getActivity();

		solo = new Solo(getInstrumentation(), TimerActivityToTest);

		tPicker = (TimePicker) TimerActivityToTest
				.findViewById(R.id.timer_picker);

		lLayoutCountdown = (LinearLayout) TimerActivityToTest
				.findViewById(R.id.ll_timer_countdown);

		tvHHs = (TextView) TimerActivityToTest
				.findViewById(R.id.tv_timer_current_hours);
		tvDelimeterHM = (TextView) TimerActivityToTest
				.findViewById(R.id.tv_timer_delimiter_hm);
		tvMMs = (TextView) TimerActivityToTest
				.findViewById(R.id.tv_timer_current_minutes);
		tvDelimeterMS = (TextView) TimerActivityToTest
				.findViewById(R.id.tv_timer_delimiter_ms);
		tvSSs = (TextView) TimerActivityToTest
				.findViewById(R.id.tv_timer_current_seconds);

		startStopButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_start_stop);
		pauseResumeButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_pause_resume);

		// dClock = (DigitalClock) TimerActivityToTest
		// .findViewById(R.id.timer_digital_clock);

		//
		// Views that are visible only in PORTRAIT orientation
		// rLayoutTimerTopView = (RelativeLayout) TimerActivityToTest
		// .findViewById(R.id.rlayout_timer_top_view);

		//
		// Views that are visible only in LANDSCAPE orientation
		// lLayoutTimerLandTopView = (LinearLayout) TimerActivityToTest
		// .findViewById(R.id.llayout_timer_land_top_view);

		// rLayoutTimerLandCounter = (RelativeLayout) TimerActivityToTest
		// .findViewById(R.id.rlayout_timer_land_time_counter);

		// rLayoutTimerLandButtons = (RelativeLayout) TimerActivityToTest
		// .findViewById(R.id.rlayout_timer_land_buttons);

		keyguardManager = (KeyguardManager) TimerActivityToTest
				.getSystemService(Context.KEYGUARD_SERVICE);
		lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
		lock.disableKeyguard();

		TimerActivityMonytor = new ActivityMonitor(
				TimerActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(TimerActivityMonytor);

		TimerEndOfTimeDialogActivityMonytor = new ActivityMonitor(
				TimerEndOfTimeDialogActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(TimerEndOfTimeDialogActivityMonytor);

	}

	protected void tearDown() throws Exception {

		// TimerActivityToTest = null;

		// TimerActivityToTest.finish();
		// try {
		// solo.finalize();
		// } catch (Throwable e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		super.tearDown();

		Log.v(LOGGER, "Tearing down...");
		// lock.reenableKeyguard();
	}

	public void testAllViewsArePresentOnTimerActivity() {
		Log.i(LOGGER, "Running testAllViewsArePresentOnTimerActivity()");

		assertNotNull("Cannot find TimerActivityToTest!", TimerActivityToTest);

		assertNotNull("Cannot find tPicker!", tPicker);

		assertNotNull("Cannot find lLayoutCountdown!", lLayoutCountdown);

		assertNotNull("Cannot find tvHHs!", tvHHs);
		assertNotNull("Cannot find tvDelimeterHM!", tvDelimeterHM);
		assertNotNull("Cannot find tvMMs!", tvMMs);
		assertNotNull("Cannot find tvDelimeterMS!", tvDelimeterMS);
		assertNotNull("Cannot find tvSSs!", tvSSs);

		assertNotNull("Cannot find startStopButton!", startStopButton);
		assertNotNull("Cannot find pauseResumeButton!", pauseResumeButton);

	}

	public void testInitialStateOfTimerActivity() {
		Log.i(LOGGER,
				"Running testInitialStateOfTimerActivityInLandscapeMode()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

	}

	public void testInitialStateIfChangeOrientationOfTimerActivity() {
		Log.i(LOGGER,
				"Running testInitialStateOfTimerActivityInLandscapeMode()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());
		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		solo.sleep(SLEEP_TIME);

	}

	public void testStartStopButtonBehaviorOfTimerActivity() {

		Log.i(LOGGER, "Running testStartStopButtonBehaviorOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());

		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

	}

	public void testStartStopButtonBehaviorIfChangeOrientationOfTimerActivity() {

		Log.i(LOGGER,
				"Running testStartStopButtonBehaviorIfChangeOrientationOfTimerActivity()");

		// fail("Not fully implemented yet...");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

	}

	public void testPauseResumeButtonBehaviorOfTimerActivity() {

		Log.i(LOGGER, "Running testPauseResumeButtonBehaviorOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());
		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		solo.clickOnButton(pauseResumeButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		solo.clickOnButton(pauseResumeButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());
		assertTrue(pauseResumeButton.isEnabled());

		solo.clickOnButton(pauseResumeButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());
		assertTrue(pauseResumeButton.isEnabled());

	}

	public void testPauseResumeButtonBehaviorIfChangeOrientationOfTimerActivity() {

		Log.i(LOGGER,
				"Running testPauseResumeButtonBehaviorIfChangeOrientationOfTimerActivity()");

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		//
		//
		solo.clickOnButton(pauseResumeButton.getText().toString());
		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		solo.sleep(1000);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		solo.sleep(1000);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		//
		//

		solo.clickOnButton(pauseResumeButton.getText().toString());

		solo.sleep(1000);

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		solo.sleep(1000);

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Resume", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

	}

	public void testCoundownPausingOfTimerActivity() {

		Log.i(LOGGER, "Running testCoundownPausingOfTimerActivity()");

		String current_hh;
		String current_mm;
		String current_ss;
		String current_time_str;

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		solo.clickOnButton(pauseResumeButton.getText().toString());

		current_hh = tvHHs.getText().toString();
		current_mm = tvMMs.getText().toString();
		current_ss = tvSSs.getText().toString();

		solo.sleep(2000);

		assertEquals(current_hh, tvHHs.getText().toString());
		assertEquals(current_mm, tvMMs.getText().toString());
		assertEquals(current_ss, tvSSs.getText().toString());

		solo.clickOnButton(pauseResumeButton.getText().toString());

		solo.sleep(2000);

		current_time_str = current_hh + ":" + current_mm + ":" + current_ss;

		assertFalse(current_time_str
				.equals(tvHHs.getText().toString() + ":"
						+ tvMMs.getText().toString() + ":"
						+ tvSSs.getText().toString()));

	}

	public void testCoundownPausingIfChangeOrientationOfTimerActivity() {

		Log.i(LOGGER,
				"Running testCoundownPausingIfChangeOrientationOfTimerActivity()");

		String current_hh;
		String current_mm;
		String current_ss;
		String current_time_str;

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		solo.sleep(3000);

		solo.clickOnButton(pauseResumeButton.getText().toString());

		current_hh = tvHHs.getText().toString();
		current_mm = tvMMs.getText().toString();
		current_ss = tvSSs.getText().toString();

		solo.sleep(2000);

		assertEquals(current_hh, tvHHs.getText().toString());
		assertEquals(current_mm, tvMMs.getText().toString());
		assertEquals(current_ss, tvSSs.getText().toString());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		solo.sleep(2000);

		assertEquals(current_hh, tvHHs.getText().toString());
		assertEquals(current_mm, tvMMs.getText().toString());
		assertEquals(current_ss, tvSSs.getText().toString());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		solo.sleep(2000);

		assertEquals(current_hh, tvHHs.getText().toString());
		assertEquals(current_mm, tvMMs.getText().toString());
		assertEquals(current_ss, tvSSs.getText().toString());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		current_hh = tvHHs.getText().toString();
		current_mm = tvMMs.getText().toString();
		current_ss = tvSSs.getText().toString();

		current_time_str = current_hh + ":" + current_mm + ":" + current_ss;

		solo.clickOnButton(pauseResumeButton.getText().toString());

		solo.sleep(3000);

		solo.clickOnButton("Pause"); // pauseResumeButton.getText().toString());
										// => Does not work as expected!!!

		solo.sleep(3000);

		tvHHs = (TextView) solo.getView(R.id.tv_timer_current_hours);
		tvMMs = (TextView) solo.getView(R.id.tv_timer_current_minutes);
		tvSSs = (TextView) solo.getView(R.id.tv_timer_current_seconds);

		Log.i(LOGGER, current_time_str + " <==> " + tvHHs.getText().toString()
				+ ":" + tvMMs.getText().toString() + ":"
				+ tvSSs.getText().toString());

		assertFalse(current_time_str
				.equals(tvHHs.getText().toString() + ":"
						+ tvMMs.getText().toString() + ":"
						+ tvSSs.getText().toString()));

	}

	public void testTimePickerSettingZeroTimeOfTimerActivity() {

		Log.i(LOGGER, "Running testTimePickerSettingZeroTimeOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.sleep(1000);

		solo.setTimePicker(tPicker, 0, 0);

		solo.clickOnButton(startStopButton.getText().toString());

		solo.sleep(1000);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 0);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

	}

	public void testTimePickerSettingZeroTimeIfChangeDeviceOrientationOfTimerActivity() {

		Log.i(LOGGER,
				"Running testTimePickerSettingZeroTimeIfChangeDeviceOrientationOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.setTimePicker(tPicker, 0, 0);

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 0);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		solo.sleep(1000);

		solo.setTimePicker(tPicker, 0, 0);

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 0);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		solo.sleep(1000);

		solo.setTimePicker(tPicker, 0, 0);

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 0);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		solo.sleep(1000);

		solo.setTimePicker(tPicker, 0, 0);

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 0);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

	}

	public void testTimePickerTimeSettingOfTimerActivity() {

		Log.i(LOGGER, "Running testTimePickerTimeSettingOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("15", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		//
		//
		//
		solo.sleep(1000);
		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		//
		//
		solo.setTimePicker(tPicker, 15, 45);

		solo.sleep(1000);

		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("15", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("45", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

		//
		//
		//
		solo.sleep(1000);
		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 15);
		assertTrue(tPicker.getCurrentMinute() == 45);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		//
		//
		//
		solo.setTimePicker(tPicker, 23, 59);

		solo.sleep(1000);
		solo.clickOnButton(startStopButton.getText().toString());

		assertEquals(View.GONE, tPicker.getVisibility());
		assertEquals(View.VISIBLE, lLayoutCountdown.getVisibility());

		assertEquals("23", tvHHs.getText().toString());
		assertEquals(":", tvDelimeterHM.getText().toString());
		assertEquals("59", tvMMs.getText().toString());
		assertEquals(":", tvDelimeterMS.getText().toString());
		assertEquals("00", tvSSs.getText().toString());

		assertEquals("Stop", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertTrue(pauseResumeButton.isEnabled());

	}

	public void testTimePickerTimeSettingIfChangeDeviceOrientationOfTimerActivity() {
		Log.i(LOGGER,
				"Running testTimePickerTimeSettingIfChangeDeviceOrientationOfTimerActivity()");

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		solo.setTimePicker(tPicker, 7, 40);

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 7);
		assertTrue(tPicker.getCurrentMinute() == 40);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		assertEquals("Start", startStopButton.getText().toString());
		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertFalse(pauseResumeButton.isEnabled());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		solo.sleep(SLEEP_TIME);

		solo.setTimePicker(tPicker, 20, 10);
		solo.sleep(SLEEP_TIME);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 20);
		assertTrue(tPicker.getCurrentMinute() == 10);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		solo.sleep(SLEEP_TIME);

		//

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 20);
		assertTrue(tPicker.getCurrentMinute() == 10);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

	}

	public void testTimerEndOfTimeDialogActivityAppearanceAfterTimeOut() {

		Log.i(LOGGER,
				"Running testTimerEndOfTimeDialogActivityAppearanceAfterTimeOut()");

		TimerActivityToTest.setDEBUG(true);

		TouchUtils.clickView(this, startStopButton);

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Activity TEndOfTimeDialogActivity = TimerEndOfTimeDialogActivityMonytor
				.getLastActivity();
		assertNotNull("TimerEndOfTimeDialogActivityMonytor was not Started!!!",
				TEndOfTimeDialogActivity);

		TEndOfTimeDialogActivity.finish();

		TimerActivityToTest.setDEBUG(false);

	}

	public void testTimerEndOfTimeDialogActivityAppearanceAfterTimeOutIfChangeDeviceOrientation() {

		Log.i(LOGGER,
				"Running testTimerEndOfTimeDialogActivityAppearanceAfterTimeOutIfChangeDeviceOrientation()");

		TimerActivityToTest.setDEBUG(true);

		TouchUtils.clickView(this, startStopButton);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		if ((TimerActivityToTest.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
				|| (TimerActivityToTest.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT)) {
			TimerActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		} else {
			TimerActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Activity TEndOfTimeDialogActivity = TimerEndOfTimeDialogActivityMonytor
				.getLastActivity();
		assertNotNull("TimerEndOfTimeDialogActivityMonytor was not Started!!!",
				TEndOfTimeDialogActivity);

		TEndOfTimeDialogActivity.finish();

		TimerActivityToTest.setDEBUG(false);

	}

}
