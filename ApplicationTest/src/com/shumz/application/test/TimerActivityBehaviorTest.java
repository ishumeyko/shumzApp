package com.shumz.application.test;

import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.application.R;
import com.shumz.application.TimerActivity;

//@SuppressWarnings("deprecation")
public class TimerActivityBehaviorTest extends
		ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerActivityBehaviorTest() {
		super(TimerActivity.class);
	}

	private static final String LOGGER = "TimerActivityBehaviorTest:";
	private static final int SLEEP_TIME = 500;

	private static Solo solo;

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

	}

	protected void tearDown() throws Exception {

		super.tearDown();

		Log.v(LOGGER, "Tearing down...");

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

	/*
	 * public void testInitialStateOfTimerActivityInPortraitMode() {
	 * Log.i(LOGGER, "Running testInitialStateOfTimerActivityInPortraitMode()");
	 * 
	 * TimerActivityToTest
	 * .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	 * 
	 * assertNotNull("Cannot find TimerActivityToTest!", TimerActivityToTest);
	 * 
	 * assertNotNull("Cannot find rLayoutTimerTopView!", rLayoutTimerTopView);
	 * 
	 * assertNotNull("Cannot find tPicker!", tPicker);
	 * 
	 * assertNotNull("Cannot find lLayoutCountdown!", lLayoutCountdown);
	 * 
	 * assertNotNull("Cannot find tvHHs!", tvHHs);
	 * assertNotNull("Cannot find tvDelimeterHM!", tvDelimeterHM);
	 * assertNotNull("Cannot find tvMMs!", tvMMs);
	 * assertNotNull("Cannot find tvDelimeterMS!", tvDelimeterMS);
	 * assertNotNull("Cannot find tvSSs!", tvSSs);
	 * 
	 * assertNotNull("Cannot find dClock!", dClock);
	 * 
	 * assertNotNull("Cannot find startStopButton!", startStopButton);
	 * assertNotNull("Cannot find pauseResumeButton!", pauseResumeButton);
	 * 
	 * }
	 * 
	 * public void testInitialStateOfTimerActivityInLandscapeMode() {
	 * Log.i(LOGGER,
	 * "Running testInitialStateOfTimerActivityInLandscapeMode()");
	 * 
	 * TimerActivityToTest
	 * .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	 * 
	 * assertNotNull("Cannot find TimerActivityToTest!", TimerActivityToTest);
	 * 
	 * assertNotNull("Cannot find lLayoutTimerLandTopView!",
	 * lLayoutTimerLandTopView);
	 * 
	 * assertNotNull("Cannot find rLayoutTimerLandCounter!",
	 * rLayoutTimerLandCounter);
	 * 
	 * assertNotNull("Cannot find tPicker!", tPicker);
	 * 
	 * assertNotNull("Cannot find lLayoutCountdown!", lLayoutCountdown);
	 * 
	 * assertNotNull("Cannot find tvHHs!", tvHHs);
	 * assertNotNull("Cannot find tvDelimeterHM!", tvDelimeterHM);
	 * assertNotNull("Cannot find tvMMs!", tvMMs);
	 * assertNotNull("Cannot find tvDelimeterMS!", tvDelimeterMS);
	 * assertNotNull("Cannot find tvSSs!", tvSSs);
	 * 
	 * assertNotNull("Cannot find dClock!", dClock);
	 * 
	 * assertNotNull("Cannot find rLayoutTimerLandButtons!",
	 * rLayoutTimerLandButtons);
	 * 
	 * assertNotNull("Cannot find startStopButton!", startStopButton);
	 * assertNotNull("Cannot find pauseResumeButton!", pauseResumeButton);
	 * 
	 * }
	 */

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

		Log.i(LOGGER, "Running testStartStopButtonBehaviorIfChangeOrientationOfTimerActivity()");

		
		fail("Not fully implemented yet...");
		
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
	
}
