package com.shumz.application.test;

import android.test.ActivityInstrumentationTestCase2;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.application.R;
import com.shumz.application.StopWatchActivity;

public class StopWatchActivityBehaviorTest extends
		ActivityInstrumentationTestCase2<StopWatchActivity> {

	public StopWatchActivityBehaviorTest() {
		super(StopWatchActivity.class);
	}

	private static Solo solo;

	private static final String LOGGER = "StopWatchActivityTest:";

	private static StopWatchActivity StopWatchActivityToTest;

	private static TextView tvHHs;
	private static TextView tvTDelimiter1;
	private static TextView tvMMs;
	private static TextView tvTDelimiter2;
	private static TextView tvSSs;
	private static TextView tvTDelimiter3;
	private static TextView tvMSMSs;

	private static Button CatchButton;
	private static Button StartButton;
	private static Button ResetButton;

	private static Button StopButton;
	private static Button ClearButton;

	private static TextView tvCurrentTimeCheck;

	// ListView of time results
	private static ListView listOfLapsToTest;

	private static TextView tvEmptyStr;

	TableLayout tLayoutTimeOfStopWatch;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		StopWatchActivityToTest = getActivity();

		// Solo clicker; Standart TouchUtils does not work ((
		solo = new Solo(getInstrumentation(), StopWatchActivityToTest);

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

		CatchButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_catch);
		StartButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_start);
		ResetButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_reset);
		StopButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_stop);
		ClearButton = (Button) StopWatchActivityToTest
				.findViewById(R.id.button_clear);

		tvCurrentTimeCheck = (TextView) StopWatchActivityToTest
				.findViewById(R.id.current_ms_long);

		// ListView of time results
		listOfLapsToTest = (ListView) StopWatchActivityToTest
				.findViewById(R.id.lv_for_timechecks);

		tvEmptyStr = (TextView) StopWatchActivityToTest
				.findViewById(R.id.tv_empty_str);

		tLayoutTimeOfStopWatch = (TableLayout) StopWatchActivityToTest
				.findViewById(R.id.time_view_table_layout);

		// TODO
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");
	
	solo.finishOpenedActivities();
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
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

	}

	public final void testStartButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testStartButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

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
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		solo.clickOnButton(StartButton.getText().toString());

		assertEquals(false, StartButton.isEnabled());

		assertEquals(true, StopButton.isEnabled());
		assertEquals(true, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		current_time_of_chronometer = tvHHs.getText().toString()
				+ tvTDelimiter1.getText().toString()
				+ tvMMs.getText().toString()
				+ tvTDelimiter2.getText().toString()
				+ tvSSs.getText().toString()
				+ tvTDelimiter3.getText().toString()
				+ tvMSMSs.getText().toString();

		assertNotSame("00:00:00:000", current_time_of_chronometer);

		solo.clickOnButton(StopButton.getText().toString());

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(true, ResetButton.isEnabled());
		assertEquals(true, ClearButton.isEnabled());

		current_time_of_chronometer = tvHHs.getText().toString()
				+ tvTDelimiter1.getText().toString()
				+ tvMMs.getText().toString()
				+ tvTDelimiter2.getText().toString()
				+ tvSSs.getText().toString()
				+ tvTDelimiter3.getText().toString()
				+ tvMSMSs.getText().toString();

		assertNotSame("00:00:00:000", current_time_of_chronometer);

	}

	public final void testStopButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testStopButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

		solo.clickOnButton(StartButton.getText().toString());

		assertEquals(false, StartButton.isEnabled());

		assertEquals(true, StopButton.isEnabled());
		assertEquals(true, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		solo.clickOnButton(StopButton.getText().toString());

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(true, ResetButton.isEnabled());
		assertEquals(true, ClearButton.isEnabled());

		current_time_of_chronometer = tvHHs.getText().toString()
				+ tvTDelimiter1.getText().toString()
				+ tvMMs.getText().toString()
				+ tvTDelimiter2.getText().toString()
				+ tvSSs.getText().toString()
				+ tvTDelimiter3.getText().toString()
				+ tvMSMSs.getText().toString();

		assertNotSame("00:00:00:000", current_time_of_chronometer);

	}

	public final void testResetButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testResetButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

		solo.clickOnButton(StartButton.getText().toString());

		assertEquals(false, StartButton.isEnabled());

		assertEquals(true, StopButton.isEnabled());
		assertEquals(true, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		solo.clickOnButton(StopButton.getText().toString());

		solo.clickOnButton(ResetButton.getText().toString());

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		current_time_of_chronometer = tvHHs.getText().toString()
				+ tvTDelimiter1.getText().toString()
				+ tvMMs.getText().toString()
				+ tvTDelimiter2.getText().toString()
				+ tvSSs.getText().toString()
				+ tvTDelimiter3.getText().toString()
				+ tvMSMSs.getText().toString();

		assertEquals("00:00:00:000", current_time_of_chronometer);

	}

	public final void testCatchButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testCatchButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

		solo.clickOnButton(StartButton.getText().toString());

		for (int i = 0; i < 10; i++) {

			solo.clickOnButton(CatchButton.getText().toString());

			current_time_of_chronometer = listOfLapsToTest.getAdapter()
					.getItem(i).toString();

			Log.i(LOGGER, i + " => " + current_time_of_chronometer);

			current_time_of_chronometer = current_time_of_chronometer
					.substring(20);

			assertEquals(tvCurrentTimeCheck.getText().toString(),
					current_time_of_chronometer);

		}

	}

	public final void testClearButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testClearButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

		solo.clickOnButton(StartButton.getText().toString());

		for (int i = 0; i < 2; i++) {

			solo.clickOnButton(CatchButton.getText().toString());

		}

		solo.clickOnButton(StopButton.getText().toString());

		solo.clickOnButton(ClearButton.getText().toString());

		assertEquals(true, StartButton.isEnabled());

		assertEquals(false, StopButton.isEnabled());
		assertEquals(false, CatchButton.isEnabled());
		assertEquals(false, ResetButton.isEnabled());
		assertEquals(false, ClearButton.isEnabled());

		current_time_of_chronometer = tvHHs.getText().toString()
				+ tvTDelimiter1.getText().toString()
				+ tvMMs.getText().toString()
				+ tvTDelimiter2.getText().toString()
				+ tvSSs.getText().toString()
				+ tvTDelimiter3.getText().toString()
				+ tvMSMSs.getText().toString();

		assertEquals("00:00:00:000", current_time_of_chronometer);

	}

	public final void testListViewInitialStateOfStopWatchActivity() {

		Log.i(LOGGER, "Running testListViewInitialStateOfStopWatchActivity()");

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());

		assertEquals(0, listOfLapsToTest.getAdapter().getCount());

	}

	public final void testListViewBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testListViewBehaviorOfStopWatchActivity()");

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());
		assertEquals(0, listOfLapsToTest.getAdapter().getCount());

		solo.clickOnButton(StartButton.getText().toString());

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());
		assertEquals(0, listOfLapsToTest.getAdapter().getCount());

		for (int i = 0; i < 3; i++) {

			solo.clickOnButton(CatchButton.getText().toString());
		}

		assertEquals(View.GONE, tvEmptyStr.getVisibility());
		assertEquals(View.VISIBLE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());
		assertEquals(3, listOfLapsToTest.getAdapter().getCount());

		solo.clickOnButton(StopButton.getText().toString());

		solo.clickOnButton(ClearButton.getText().toString());

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());

	}

	public final void testListViewCountersOfStopWatchActivity() {

		Log.i(LOGGER, "Running testListViewCountersOfStopWatchActivity()");

		String current_time_of_chronometer;
		String counter_of_list_items_str;
		String counter_of_laps_in_list_str;

		int counter_of_list_items = 0;
		int counter_of_laps_in_list = 0;

		int counter = 0;
		int sub_counter = 0;

		solo.clickOnButton(StartButton.getText().toString());

		for (int j = 0; j < 5; j++) {

			sub_counter = 0;

			for (int i = 0; i < j; i++) {

				solo.clickOnButton(CatchButton.getText().toString());

				current_time_of_chronometer = listOfLapsToTest.getAdapter()
						.getItem(listOfLapsToTest.getCount() - 1).toString();

				counter_of_list_items_str = (String) current_time_of_chronometer
						.subSequence(0, 3);
				counter_of_laps_in_list_str = (String) current_time_of_chronometer
						.subSequence(12, 15);

				while ((counter_of_list_items_str.charAt(0) == '0')
						&& (counter_of_list_items_str.length() >= 0)) {
					counter_of_list_items_str = counter_of_list_items_str
							.substring(1);
				}

				while ((counter_of_laps_in_list_str.charAt(0) == '0')
						&& (counter_of_laps_in_list_str.length() >= 0)) {
					counter_of_laps_in_list_str = counter_of_laps_in_list_str
							.substring(1);
				}

				counter_of_list_items = Integer
						.valueOf(counter_of_list_items_str);
				counter_of_laps_in_list = Integer
						.valueOf(counter_of_laps_in_list_str);

				Log.i(LOGGER, "current_time_of_chronometer: "
						+ current_time_of_chronometer);
				Log.i(LOGGER, "______________________________");

				Log.i(LOGGER, "counter_of_list_items_str: "
						+ counter_of_list_items_str);
				Log.i(LOGGER, "counter_of_laps_in_list_str: "
						+ counter_of_laps_in_list_str);
				Log.i(LOGGER, "------------------------------");

				Log.i(LOGGER, "counter_of_list_items: " + counter_of_list_items);
				Log.i(LOGGER, "counter_of_laps_in_list: "
						+ counter_of_laps_in_list);
				Log.i(LOGGER, "==============================");

				counter++;
				sub_counter++;

				if (sub_counter != counter_of_laps_in_list) {
					fail("Lap count is invalid!..");
				}
			}

			solo.clickOnButton(StopButton.getText().toString());

			solo.clickOnButton(ResetButton.getText().toString());

			solo.clickOnButton(StartButton.getText().toString());

			if (counter != counter_of_list_items) {
				fail("List count is invalid!..");
			}

		}
	}

	public final void testListViewCurrentPositionVisibilityOfStopWatchActivity() {

		Log.i(LOGGER,
				"Running testListViewCurrentPositionVisibilityOfStopWatchActivity()");

		solo.clickOnButton(StartButton.getText().toString());

		for (int i = 0; i < 25; i++) {

			solo.clickOnButton(CatchButton.getText().toString());

			listOfLapsToTest.getChildAt(listOfLapsToTest.getChildCount() - 1)
					.isSelected();

		}

	}

}

// TODO
