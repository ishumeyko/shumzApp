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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TimePicker;

import com.shumz.application.R;
import com.shumz.application.TimerActivity;

@SuppressWarnings("deprecation")
public class TimerActivityLayoutParametersOfPortraitOrientationTest extends
		ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerActivityLayoutParametersOfPortraitOrientationTest() {
		super(TimerActivity.class);
	}

	private static final String LOGGER = "TimerActivityPortraitLayoutTest:";

	// private static Solo solo;

	private static TimerActivity TimerActivityToTest;

	private static RelativeLayout rLayoutTimerTopView;

	private static TimePicker tPicker;

	private static LinearLayout lLayoutCountdown;

	private static TextView tvHHs;
	private static TextView tvDelimeterHM;
	private static TextView tvMMs;
	private static TextView tvDelimeterMS;
	private static TextView tvSSs;

	private static DigitalClock dClock;

	private static Button startStopButton;
	private static Button pauseResumeButton;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		TimerActivityToTest = getActivity();

		rLayoutTimerTopView = (RelativeLayout) TimerActivityToTest
				.findViewById(R.id.rlayout_timer_top_view);

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

		startStopButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_start_stop);
		pauseResumeButton = (Button) TimerActivityToTest
				.findViewById(R.id.timer_button_pause_resume);

		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// TODO
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");

	}

	public void testAAAAAAAPortrait() {
		TimerActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	public void testAllViewsArePresentOnTimerActivity() {

		
		Log.i(LOGGER, "Running testAllViewsArePresentOnTimerActivity()");

		assertNotNull("Cannot find TimerActivityToTest!", TimerActivityToTest);

		assertNotNull("Cannot find rLayoutTimerTopView!", rLayoutTimerTopView);

		assertNotNull("Cannot find tPicker!", tPicker);

		assertNotNull("Cannot find lLayoutCountdown!", lLayoutCountdown);

		assertNotNull("Cannot find tvHHs!", tvHHs);
		assertNotNull("Cannot find tvDelimeterHM!", tvDelimeterHM);
		assertNotNull("Cannot find tvMMs!", tvMMs);
		assertNotNull("Cannot find tvDelimeterMS!", tvDelimeterMS);
		assertNotNull("Cannot find tvSSs!", tvSSs);

		assertNotNull("Cannot find dClock!", dClock);

		assertNotNull("Cannot find startStopButton!", startStopButton);
		assertNotNull("Cannot find pauseResumeButton!", pauseResumeButton);

	}

	public final void testRelativeLayoutTopViewOfTimerActivityParametersPortrait() {
		Log.i(LOGGER,
				"Running testRelativeLayoutTopViewOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerTopView.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerTopView.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutTimerTopView, tPicker);
		ViewAsserts.assertGroupContains(rLayoutTimerTopView, lLayoutCountdown);
		ViewAsserts.assertGroupContains(rLayoutTimerTopView, dClock);
		ViewAsserts.assertGroupContains(rLayoutTimerTopView, startStopButton);
		ViewAsserts.assertGroupContains(rLayoutTimerTopView, pauseResumeButton);

	}

	public final void testTimePickerOfTimerActivityParametersPortrait() {
		Log.i(LOGGER,
				"Running testTimePickerOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tPicker.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tPicker.getLayoutParams().width);

		ViewAsserts.assertVerticalCenterAligned(rLayoutTimerTopView, tPicker);
		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerTopView, tPicker);

		assertEquals(View.VISIBLE, tPicker.getVisibility());

	}

	public final void testLinearLayoutCountdownOfTimerActivityParametersPortrait() {
		Log.i(LOGGER,
				"Running testLinearLayoutCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutCountdown.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutCountdown.getLayoutParams().width);

		// ViewAsserts.assertVerticalCenterAligned(rLayoutTimerTopView,
		// lLayoutCountdown);
		// ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerTopView,
		// lLayoutCountdown);

		ViewAsserts.assertGroupContains(lLayoutCountdown, tvHHs);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvDelimeterHM);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvMMs);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvDelimeterMS);
		ViewAsserts.assertGroupContains(lLayoutCountdown, tvSSs);

		assertEquals(View.GONE, lLayoutCountdown.getVisibility());

	}

	public final void testTextViewHoursOfCountdownOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testTextViewHoursOfCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	public final void testTextViewDelimiterHMOfCountdownOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testTextViewDelimiterHMOfCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterHM.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterHM.getLayoutParams().width);

		assertEquals(":", tvDelimeterHM.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvDelimeterHM.getTypeface());
	}

	public final void testTextViewMinutesOfCountdownOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testTextViewMinutesOfCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	public final void testTextViewDelimiterMSOfCountdownOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testTextViewDelimiterMSOfCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterMS.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvDelimeterMS.getLayoutParams().width);

		assertEquals(":", tvDelimeterMS.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvDelimeterMS.getTypeface());
	}

	public final void testTextViewSecondsOfCountdownOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testTextViewSecondsOfCountdownOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().width);

		assertEquals("00", tvSSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvSSs.getTypeface());
	}

	public final void testDigitalClockOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testDigitalClockOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutTimerTopView, dClock);

		assertEquals(rLayoutTimerTopView.getBottom(), dClock.getBottom());

	}

	public final void testStartStopButtonOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testStartStopButtonOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				startStopButton.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				startStopButton.getLayoutParams().width);

		assertEquals("Start", startStopButton.getText().toString());

		assertEquals(Typeface.MONOSPACE, startStopButton.getTypeface());

		assertEquals(dClock.getTop(), startStopButton.getBottom());
		assertEquals(rLayoutTimerTopView.getLeft(), startStopButton.getLeft());

	}

	public final void testPauseResumeButtonOfTimerActivityParametersPortrait() {

		Log.i(LOGGER,
				"Running testPauseResumeButtonOfTimerActivityParametersPortrait()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				pauseResumeButton.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				pauseResumeButton.getLayoutParams().width);

		assertEquals("Pause", pauseResumeButton.getText().toString());

		assertEquals(Typeface.MONOSPACE, pauseResumeButton.getTypeface());

		assertEquals(dClock.getTop(), pauseResumeButton.getBottom());
		assertEquals(rLayoutTimerTopView.getRight(),
				pauseResumeButton.getRight());

		assertFalse(pauseResumeButton.isEnabled());

	}

	// TODO
}
