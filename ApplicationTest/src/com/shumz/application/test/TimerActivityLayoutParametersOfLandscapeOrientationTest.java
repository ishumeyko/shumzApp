package com.shumz.application.test;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.RelativeLayout.LayoutParams;

import com.shumz.application.R;
import com.shumz.application.TimerActivity;

@SuppressWarnings("deprecation")
public class TimerActivityLayoutParametersOfLandscapeOrientationTest extends
		ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerActivityLayoutParametersOfLandscapeOrientationTest() {
		super(TimerActivity.class);
	}

	private static final String LOGGER = "TimerActivityLandscapeLayoutTest:";

	// private static Solo solo;

	private static TimerActivity TimerActivityToTest;

	private static LinearLayout lLayoutTimerLandTopView;

	private static RelativeLayout rLayoutTimerLandCounter;

	private static TimePicker tPicker;

	private static LinearLayout lLayoutCountdown;

	private static TextView tvHHs;
	private static TextView tvDelimeterHM;
	private static TextView tvMMs;
	private static TextView tvDelimeterMS;
	private static TextView tvSSs;

	private static DigitalClock dClock;

	private static RelativeLayout rLayoutTimerLandButtons;

	private static Button startStopButton;
	private static Button pauseResumeButton;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		TimerActivityToTest = getActivity();

		lLayoutTimerLandTopView = (LinearLayout) TimerActivityToTest
				.findViewById(R.id.llayout_timer_land_top_view);

		rLayoutTimerLandCounter = (RelativeLayout) TimerActivityToTest
				.findViewById(R.id.rlayout_timer_land_time_counter);

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

		dClock = (DigitalClock) TimerActivityToTest
				.findViewById(R.id.timer_digital_clock);

		rLayoutTimerLandButtons = (RelativeLayout) TimerActivityToTest
				.findViewById(R.id.rlayout_timer_land_buttons);

		startStopButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_start_stop);
		pauseResumeButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_pause_resume);

		// TODO
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		// TODO
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");

	}

	public void testAAAAAAALandscape() {
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	public void testAllViewsArePresentOnTimerActivity() {
		Log.i(LOGGER, "Running testAllViewsArePresentOnTimerActivity()");

		assertNotNull("Cannot find TimerActivityToTest!", TimerActivityToTest);

		assertNotNull("Cannot find lLayoutTimerLandTopView!",
				lLayoutTimerLandTopView);

		assertNotNull("Cannot find rLayoutTimerLandCounter!",
				rLayoutTimerLandCounter);

		assertNotNull("Cannot find tPicker!", tPicker);

		assertNotNull("Cannot find lLayoutCountdown!", lLayoutCountdown);

		assertNotNull("Cannot find tvHHs!", tvHHs);
		assertNotNull("Cannot find tvDelimeterHM!", tvDelimeterHM);
		assertNotNull("Cannot find tvMMs!", tvMMs);
		assertNotNull("Cannot find tvDelimeterMS!", tvDelimeterMS);
		assertNotNull("Cannot find tvSSs!", tvSSs);

		assertNotNull("Cannot find dClock!", dClock);

		assertNotNull("Cannot find rLayoutTimerLandButtons!",
				rLayoutTimerLandButtons);

		assertNotNull("Cannot find startStopButton!", startStopButton);
		assertNotNull("Cannot find pauseResumeButton!", pauseResumeButton);

	}

	public final void testLinearLayoutTopViewOfTimerActivityParametersLandscape() {
		Log.i(LOGGER,
				"Running testLinearLayoutTopViewOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutTimerLandTopView.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutTimerLandTopView.getLayoutParams().width);

		ViewAsserts.assertGroupContains(lLayoutTimerLandTopView,
				rLayoutTimerLandCounter);
		ViewAsserts.assertGroupContains(lLayoutTimerLandTopView,
				rLayoutTimerLandButtons);

		assertEquals(LinearLayout.HORIZONTAL,
				lLayoutTimerLandTopView.getOrientation());

	}

	public final void testRelativeLayoutTimeCounterOfTimerActivityParametersPortrait() {
		Log.i(LOGGER,
				"Running testRelativeLayoutTimeCounterOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerLandCounter.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerLandCounter.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutTimerLandCounter, tPicker);
		ViewAsserts.assertGroupContains(rLayoutTimerLandCounter,
				lLayoutCountdown);
		ViewAsserts.assertGroupContains(rLayoutTimerLandCounter, dClock);

	}

	public final void testTimePickerOfTimerActivityParametersLandscape() {
		Log.i(LOGGER,
				"Running testTimePickerOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tPicker.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tPicker.getLayoutParams().width);

		ViewAsserts.assertVerticalCenterAligned(rLayoutTimerLandCounter,
				tPicker);
		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerLandCounter,
				tPicker);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

		assertTrue(tPicker.getCurrentHour() == 0);
		assertTrue(tPicker.getCurrentMinute() == 15);

	}

	public final void testLinearLayoutCountdownOfTimerActivityParametersLandscape() {
		Log.i(LOGGER,
				"Running testLinearLayoutCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutCountdown.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutCountdown.getLayoutParams().width);

		// ViewAsserts.assertVerticalCenterAligned(rLayoutTimerLandCounter,
		// lLayoutCountdown);
		// ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerLandCounter,
		// lLayoutCountdown);

		ViewAsserts.assertGroupContains(lLayoutCountdown, tvHHs);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvDelimeterHM);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvMMs);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvDelimeterMS);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvSSs);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

	}

	public final void testTextViewHoursOfCountdownOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testTextViewHoursOfCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	public final void testTextViewDelimiterHMOfCountdownOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testTextViewDelimiterHMOfCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterHM.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterHM.getLayoutParams().width);

		assertEquals(":", tvDelimeterHM.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvDelimeterHM.getTypeface());
	}

	public final void testTextViewMinutesOfCountdownOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testTextViewMinutesOfCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	public final void testTextViewDelimiterMSOfCountdownOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testTextViewDelimiterMSOfCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterMS.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterMS.getLayoutParams().width);

		assertEquals(":", tvDelimeterMS.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvDelimeterMS.getTypeface());
	}

	public final void testTextViewSecondsOfCountdownOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testTextViewSecondsOfCountdownOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().width);

		assertEquals("00", tvSSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvSSs.getTypeface());
	}

	public final void testDigitalClockOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testDigitalClockOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerLandCounter,
				dClock);

		// assertEquals(rLayoutTimerLandCounter.getBottom(),
		// dClock.getBottom());

	}

	public final void testRelativeLayoutTopViewOfTimerActivityParametersPortrait() {
		Log.i(LOGGER,
				"Running testRelativeLayoutTopViewOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerLandButtons.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerLandButtons.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutTimerLandButtons,
				startStopButton);
		ViewAsserts.assertGroupContains(rLayoutTimerLandButtons,
				pauseResumeButton);

	}

	public final void testStartStopButtonOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testStartStopButtonOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				startStopButton.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				startStopButton.getLayoutParams().width);

		assertEquals("Start", startStopButton.getText().toString());

		assertEquals(Typeface.MONOSPACE, startStopButton.getTypeface());

		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerLandButtons,
				startStopButton);
		// assertEquals(rLayoutTimerLandButtons.getTop(),
		// startStopButton.getTop());

	}

	public final void testPauseResumeButtonOfTimerActivityParametersLandscape() {

		Log.i(LOGGER,
				"Running testPauseResumeButtonOfTimerActivityParametersLandscape()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				pauseResumeButton.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				pauseResumeButton.getLayoutParams().width);

		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertEquals(Typeface.MONOSPACE, pauseResumeButton.getTypeface());

		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerLandButtons,
				pauseResumeButton);
		// assertEquals(rLayoutTimerLandButtons.getBottom(),
		// pauseResumeButton.getBottom());

		assertFalse(pauseResumeButton.isEnabled());

	}

	// TODO

}
