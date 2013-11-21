package com.shumz.application.test;

import android.graphics.Typeface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.application.R;
import com.shumz.application.StopWatchActivity;

@SuppressWarnings("deprecation")
public class StopWatchActivityTest extends
		ActivityInstrumentationTestCase2<StopWatchActivity> {

	public StopWatchActivityTest() {
		super(StopWatchActivity.class);
	}

	private static Solo solo;

	private static final String LOGGER = "StopWatchActivityTest:";

	private static StopWatchActivity StopWatchActivityToTest;

	// Top layout of view
	private static RelativeLayout rLayoutOfStopWatchActivity;

	// LinearLayout of StopWatch
	private static LinearLayout lLayoutOfStopWatch;

	// LinearLayout of ChronoView
	private static LinearLayout lLayoutChronoView;

	private static TextView tvStopWatchHeader;

	// TableRow of counter
	private static TableRow tRowCronometer;

	private static TextView tvHHs;
	private static TextView tvTDelimiter1;
	private static TextView tvMMs;
	private static TextView tvTDelimiter2;
	private static TextView tvSSs;
	private static TextView tvTDelimiter3;
	private static TextView tvMSMSs;

	// LinearLayout of upper buttons row
	private static LinearLayout lLayoutButtonsViewTop;
	private static Button CatchButton;
	private static Button StartButton;
	private static Button ResetButton;

	// LinearLayout of bottom buttons row
	private static RelativeLayout rLayoutButtonsViewBottom;
	private static Button StopButton;
	private static Button ClearButton;

	// LinearLayout of current timecheck
	private static LinearLayout lLayoutLogView;

	private static TextView tvCurrentTimeCheckStr;
	private static TextView tvCurrentTimeCheck;

	// ListView of time results
	private static ListView listOfLaps;

	private static TextView tvEmptyStr;

	TableLayout tLayoutTimeOfStopWatch;

	private static DigitalClock dClock;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		StopWatchActivityToTest = getActivity();

		// Solo clicker; Standart TouchUtils does not work ((
		solo = new Solo(getInstrumentation(), StopWatchActivityToTest);

		// Top layout of view
		rLayoutOfStopWatchActivity = (RelativeLayout) StopWatchActivityToTest
				.findViewById(R.id.rl_swatch_top_layout);

		// LinearLayout of StopWatch
		lLayoutOfStopWatch = (LinearLayout) StopWatchActivityToTest
				.findViewById(R.id.linearLayout_chrono_full);

		// LinearLayout of ChronoView
		lLayoutChronoView = (LinearLayout) StopWatchActivityToTest
				.findViewById(R.id.linearLayout_chrono_view);

		tvStopWatchHeader = (TextView) StopWatchActivityToTest
				.findViewById(R.id.chronometer_text);

		// TableRow of counter
		tRowCronometer = (TableRow) StopWatchActivityToTest
				.findViewById(R.id.chronometer_tableRow);

		tvHHs = (TextView) StopWatchActivityToTest
				.findViewById(R.id.hh_text_view);
		tvTDelimiter1 = (TextView) StopWatchActivityToTest
				.findViewById(R.id.colon_1);
		tvMMs = (TextView) StopWatchActivityToTest
				.findViewById(R.id.mm_text_view);
		tvTDelimiter2 = (TextView) StopWatchActivityToTest
				.findViewById(R.id.colon_2);
		tvSSs = (TextView) StopWatchActivityToTest
				.findViewById(R.id.ss_text_view);
		tvTDelimiter3 = (TextView) StopWatchActivityToTest
				.findViewById(R.id.colon_3);
		tvMSMSs = (TextView) StopWatchActivityToTest
				.findViewById(R.id.msms_text_view);

		// LinearLayout of upper buttons row
		lLayoutButtonsViewTop = (LinearLayout) StopWatchActivityToTest
				.findViewById(R.id.linearLayout_chrono_buttons_level_1);
		CatchButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_catch);
		StartButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_start);
		ResetButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_reset);

		// LinearLayout of bottom buttons row
		rLayoutButtonsViewBottom = (RelativeLayout) StopWatchActivityToTest
				.findViewById(R.id.relativeLayout_chrono_buttons_level_2);
		StopButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_stop);
		ClearButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_clear);
		// LinearLayout of current timecheck
		lLayoutLogView = (LinearLayout) StopWatchActivityToTest
				.findViewById(R.id.log_view);

		tvCurrentTimeCheckStr = (TextView) StopWatchActivityToTest
				.findViewById(R.id.current_ms_text);
		tvCurrentTimeCheck = (TextView) StopWatchActivityToTest
				.findViewById(R.id.current_ms_long);

		// ListView of time results
		listOfLaps = (ListView) StopWatchActivityToTest
				.findViewById(R.id.lv_for_timechecks);

		tvEmptyStr = (TextView) StopWatchActivityToTest
				.findViewById(R.id.tv_empty_str);

		tLayoutTimeOfStopWatch = (TableLayout) StopWatchActivityToTest
				.findViewById(R.id.time_view_table_layout);

		dClock = (DigitalClock) StopWatchActivityToTest
				.findViewById(R.id.digital_clock);
		// TODO
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");
	}

	public void testAllWiewsArePresentOnMainActivity() {
		Log.i(LOGGER, "Running testAllWiewsArePresentOnMainActivity()");

		// TODO

		assertNotNull("Cannot find mainActivityToTest!",
				StopWatchActivityToTest);

		assertNotNull("Cannot find rLayoutOfStopWatchActivity!",
				rLayoutOfStopWatchActivity);

		assertNotNull("Cannot find lLayoutOfStopWatch!", lLayoutOfStopWatch);
		assertNotNull("Cannot find lLayoutChronoView!", lLayoutChronoView);
		assertNotNull("Cannot find tvStopWatchHeader!", tvStopWatchHeader);

		assertNotNull("Cannot find tRowCronometer!", tRowCronometer);
		assertNotNull("Cannot find tvHHs!", tvHHs);
		assertNotNull("Cannot find tvTDelimiter1!", tvTDelimiter1);
		assertNotNull("Cannot find tvMMs!", tvMMs);
		assertNotNull("Cannot find tvSSs!", tvTDelimiter2);
		assertNotNull("Cannot find tvSSs!", tvSSs);
		assertNotNull("Cannot find tvTDelimiter3!", tvTDelimiter3);
		assertNotNull("Cannot find tvMSMSs!", tvMSMSs);

		assertNotNull("Cannot find lLayoutButtonsViewTop!",
				lLayoutButtonsViewTop);
		assertNotNull("Cannot find ResetButton!", ResetButton);
		assertNotNull("Cannot find CatchButton!", CatchButton);
		assertNotNull("Cannot find ResetButton!", ResetButton);
		assertNotNull("Cannot find StartButton!", StartButton);

		assertNotNull("Cannot find lLayoutButtonsViewBottom!",
				rLayoutButtonsViewBottom);
		assertNotNull("Cannot find StopButton!", StopButton);
		assertNotNull("Cannot find ClearButton!", ClearButton);

		assertNotNull("Cannot find lLayoutLogView!", lLayoutLogView);
		assertNotNull("Cannot find tvCurrentTimeCheckStr!",
				tvCurrentTimeCheckStr);
		assertNotNull("Cannot find tvCurrentTimeCheck!", tvCurrentTimeCheck);

		assertNotNull("Cannot find listOfLaps!", listOfLaps);

		assertNotNull("Cannot find tLayoutTimeOfStopWatch!",
				tLayoutTimeOfStopWatch);

		assertNotNull("Cannot find dClock!", dClock);

	}

	public final void testRelativeLayoutOfStopWatchActivityLayoutParameters() {
		Log.i(LOGGER,
				"Running testRelativeLayoutOfStopWatchActivityLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutOfStopWatchActivity.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				rLayoutOfStopWatchActivity.getLayoutParams().width);

	}

	public final void testRealtiveLayoutOfStopWatchActivityChildren() {

		Log.i(LOGGER, "Running testRealtiveLayoutOfStopWatchActivityChildren()");

		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity,
				lLayoutOfStopWatch);
		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity,
				tLayoutTimeOfStopWatch);
		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity, tvEmptyStr);

		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity, dClock);

	}

	public final void testLinearLayoutOfStopWatchLayoutParameters() {

		Log.i(LOGGER, "Running testLinearLayoutOfStopWatchLayoutParameters()");

		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutOfStopWatch.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutOfStopWatch.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutOfStopWatch.getOrientation());

		assertEquals(lLayoutOfStopWatch.getBottom(),
				tLayoutTimeOfStopWatch.getTop());

	}

	public final void testLinearLayoutOfStopWatchChildren() {

		Log.i(LOGGER, "Running testLinearLayoutOfStopWatchChildren()");

		ViewAsserts.assertGroupContains(lLayoutOfStopWatch, lLayoutChronoView);
		ViewAsserts.assertGroupContains(lLayoutOfStopWatch,
				lLayoutButtonsViewTop);
		ViewAsserts.assertGroupContains(lLayoutOfStopWatch,
				rLayoutButtonsViewBottom);
		ViewAsserts.assertGroupContains(lLayoutOfStopWatch, lLayoutLogView);
		ViewAsserts.assertGroupContains(lLayoutOfStopWatch, listOfLaps);

	}

	public final void testLinearLayoutOfChronoViewLayoutParameters() {

		Log.i(LOGGER, "Running testLinearLayoutOfChronoViewLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutChronoView.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutChronoView.getLayoutParams().width);

	}

	public final void testLinearLayoutOfChronoViewChildren() {

		Log.i(LOGGER, "Running testLinearLayoutOfChronoViewChildren()");

		ViewAsserts.assertGroupContains(lLayoutChronoView, tvStopWatchHeader);
		ViewAsserts.assertGroupContains(lLayoutChronoView, tRowCronometer);

	}

	public final void testTextViewHeaderStr() {

		Log.i(LOGGER, "Running testTextViewHeaderStr()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutChronoView.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutChronoView.getLayoutParams().width);

		assertEquals("StopWatch", tvStopWatchHeader.getText().toString());

		assertEquals(Gravity.CENTER, tvStopWatchHeader.getGravity());

		assertEquals(Typeface.MONOSPACE, tvStopWatchHeader.getTypeface());

	}

	public final void testTableRowOfChronometerLayoutParameters() {

		Log.i(LOGGER, "Running testTableRowOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tRowCronometer.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tRowCronometer.getLayoutParams().width);

		// assertEquals(Gravity.CENTER, tRowCronometer.getGravity();

		assertEquals(LinearLayout.HORIZONTAL, tRowCronometer.getOrientation());

	}

	public final void testTableRowOfChronometerChildren() {

		Log.i(LOGGER, "Running testTableRowOfChronometerChildren()");

		ViewAsserts.assertGroupContains(tRowCronometer, tvHHs);
		ViewAsserts.assertGroupContains(tRowCronometer, tvTDelimiter1);
		ViewAsserts.assertGroupContains(tRowCronometer, tvMMs);
		ViewAsserts.assertGroupContains(tRowCronometer, tvTDelimiter2);
		ViewAsserts.assertGroupContains(tRowCronometer, tvSSs);
		ViewAsserts.assertGroupContains(tRowCronometer, tvTDelimiter3);
		ViewAsserts.assertGroupContains(tRowCronometer, tvMSMSs);

	}

	public final void testTextViewHoursOfChronometer() {

		Log.i(LOGGER, "Running testTextViewHoursOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().width);

		assertEquals("00", tvHHs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvHHs.getTypeface());
	}

	public final void testTextViewtvTDelimiterOneOfChronometer() {

		Log.i(LOGGER, "Running testTextViewtvTDelimiterOneOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter1.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter1.getLayoutParams().width);

		assertEquals(":", tvTDelimiter1.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter1.getTypeface());
	}

	public final void testTextViewMinutesOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMinutesOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	public final void testTextViewDelimiterTwoOfChronometer() {

		Log.i(LOGGER, "Running testTextViewDelimiterTwoOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter2.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter2.getLayoutParams().width);

		assertEquals(":", tvTDelimiter2.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter2.getTypeface());
	}

	public final void testTextViewSecondsOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMinutesOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().width);

		assertEquals("00", tvSSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvSSs.getTypeface());
	}

	public final void testTextViewDelimiterThreeOfChronometer() {

		Log.i(LOGGER, "Running testTextViewDelimiterThreeOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter3.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter3.getLayoutParams().width);

		assertEquals(":", tvTDelimiter3.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter3.getTypeface());
	}

	public final void testTextViewMilliSecondsOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMilliSecondsOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvMSMSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMSMSs.getLayoutParams().width);

		assertEquals("000", tvMSMSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMSMSs.getTypeface());
	}

	public final void testLinearLayoutButtonsViewTopOfChronometer() {

		Log.i(LOGGER, "Running testLinearLayoutButtonsViewTopOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutButtonsViewTop.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutButtonsViewTop.getLayoutParams().width);

	}

	public final void testLinearLayoutButtonsViewTopChildren() {

		Log.i(LOGGER, "Running testLinearLayoutButtonsViewTopChildren()");

		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, CatchButton);
		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, StartButton);
		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, ResetButton);

	}

	public final void testRelativeLayoutButtonsViewBottomOfChronometer() {

		Log.i(LOGGER,
				"Running testRelativeLayoutButtonsViewBottomOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutButtonsViewBottom.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutButtonsViewBottom.getLayoutParams().width);

	}

	public final void testRelativeLayoutButtonsViewBottomChildren() {

		Log.i(LOGGER, "Running testRelativeLayoutButtonsViewBottomChildren()");

		ViewAsserts.assertGroupContains(rLayoutButtonsViewBottom, StopButton);
		ViewAsserts.assertGroupContains(rLayoutButtonsViewBottom, ClearButton);

	}

	public final void testLinearLayoutLogOfChronometer() {

		Log.i(LOGGER,
				"Running testRelativeLayoutButtonsViewBottomOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutLogView.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutLogView.getLayoutParams().width);

	}

	public final void testLinearLayoutLogChildren() {

		Log.i(LOGGER, "Running testRelativeLayoutButtonsViewBottomChildren()");

		ViewAsserts.assertGroupContains(lLayoutLogView, tvCurrentTimeCheckStr);
		ViewAsserts.assertGroupContains(lLayoutLogView, tvCurrentTimeCheck);

	}

	public final void testTextViewtvCurrentTimeCheckStrOfChronometer() {

		Log.i(LOGGER,
				"Running testTextViewtvCurrentTimeCheckStrOfChronometer()");

		assertEquals(LayoutParams.FILL_PARENT,
				tvCurrentTimeCheckStr.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvCurrentTimeCheckStr.getLayoutParams().width);

		assertEquals("Current time check:", tvCurrentTimeCheckStr.getText()
				.toString());

	}

	public final void testTextViewtvCurrentTimeCheckTimeOfChronometer() {

		Log.i(LOGGER,
				"Running testTextViewtvCurrentTimeCheckTimeOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCurrentTimeCheck.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCurrentTimeCheck.getLayoutParams().width);

		assertEquals("00:00:00:000", tvCurrentTimeCheck.getText().toString());

	}

	public final void testListViewListOfLapsOfChronometerLayoutParameters() {

		Log.i(LOGGER,
				"Running testListViewListOfLapsOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				listOfLaps.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				listOfLaps.getLayoutParams().width);

	}

	public final void testDigitalClockOfChronometerLayoutParameters() {

		Log.i(LOGGER, "Running testDigitalClockOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfStopWatchActivity,
				dClock);

		assertEquals(Gravity.CENTER, dClock.getGravity());

		assertEquals(rLayoutOfStopWatchActivity.getBottom(), dClock.getBottom());
	}

	public final void testInitialStateOfStopWatchActivity() {

		Log.i(LOGGER, "Running testInitialStateOfStopWatchActivity()");

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		assertEquals("00:00:00:000", tvCurrentTimeCheck.getText().toString());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals("00", tvSSs.getText().toString());
		assertEquals("000", tvMSMSs.getText().toString());

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLaps.getVisibility());

	}

	public final void testStartButtonBehaviorOfStopWatchActivity()
			throws InterruptedException {

		Log.i(LOGGER, "Running testStartButtonBehaviorOfStopWatchActivity()");

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		assertEquals("00:00:00:000", tvCurrentTimeCheck.getText().toString());

		assertEquals("00", tvHHs.getText().toString());
		assertEquals("00", tvMMs.getText().toString());
		assertEquals("00", tvSSs.getText().toString());
		assertEquals("000", tvMSMSs.getText().toString());

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLaps.getVisibility());

		solo.clickOnButton("Start");

		Thread.sleep(500);

		assertEquals(false, StartButton.isEnabled());

		assertEquals(true, StopButton.isEnabled());
		assertEquals(true, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		String s = (tvHHs.getText().toString() + tvMMs.getText().toString()
				+ tvSSs.getText().toString() + tvMSMSs.getText().toString());

		assertNotSame("00:00:00:000", s);

		solo.clickOnButton("Stop");
	}

}
