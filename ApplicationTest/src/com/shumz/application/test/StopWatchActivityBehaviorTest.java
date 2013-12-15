package com.shumz.application.test;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.application.R;
import com.shumz.application.StopWatchActivity;

/**
 * <h6>StopWatchActivityBehaviorTest is a class intended to perform several
 * behavior tests of {@link StopWatchActivity} activity.</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods intended to
 * verify behavior of activity, some real-life behavior tests.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see StopWatchActivity
 * 
 * @since Dec 14th, 2013
 */
public class StopWatchActivityBehaviorTest extends
		ActivityInstrumentationTestCase2<StopWatchActivity> {

	public StopWatchActivityBehaviorTest() {
		super(StopWatchActivity.class);
	}

	/**
	 * An instance of Solo class, which will be used in tests presented below to
	 * perform button clicks since standard <code>TouchUtils</code> methods does
	 * not work as expected in particular cases.
	 */
	private static Solo solo;

	private static final String LOGGER = "StopWatchActivityTest:";

	/**
	 * Instance of a {@link StopWatchActivity} class under test.
	 */
	private static StopWatchActivity StopWatchActivityToTest;

	/**
	 * TextView which represents hours of time-counter to test.
	 */
	private static TextView tvHHs;

	/**
	 * TextView which represents delimiter between hours and minutes of
	 * time-counter to test.
	 */
	private static TextView tvTDelimiter1;

	/**
	 * TextView which represents minutes of time-counter to test.
	 */
	private static TextView tvMMs;

	/**
	 * TextView which represents delimiter between minutes and seconds of
	 * time-counter to test.
	 */
	private static TextView tvTDelimiter2;

	/**
	 * TextView which represents seconds of time-counter to test.
	 */
	private static TextView tvSSs;

	/**
	 * TextView which represents delimiter between seconds and milliseconds of
	 * time-counter to test.
	 */
	private static TextView tvTDelimiter3;

	/**
	 * TextView which represents milliseconds of time-counter to test.
	 */
	private static TextView tvMSMSs;

	/**
	 * Catch button of StopWatchActivity to test.
	 */
	private static Button CatchButton;

	/**
	 * Start button of StopWatchActivity to test.
	 */
	private static Button StartButton;

	/**
	 * Reset button of StopWatchActivity to test.
	 */
	private static Button ResetButton;

	/**
	 * Stop button of StopWatchActivity to test.
	 */
	private static Button StopButton;

	/**
	 * Clear button of StopWatchActivity to test.
	 */
	private static Button ClearButton;

	/**
	 * TextView which is intended to assert last time-check. It is needed for
	 * debugging. Will be excluded in future versions.
	 */
	private static TextView tvCurrentTimeCheck;

	/**
	 * ListView which is used for displaying time results to test.
	 */
	private static ListView listOfLapsToTest;

	/**
	 * TextView which is displaying "Empty..." text when list of time results is
	 * empty.
	 */
	private static TextView tvEmptyStr;

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link StopWatchActivity} class members inside this method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
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

		// tLayoutTimeOfStopWatch = (TableLayout) StopWatchActivityToTest
		// .findViewById(R.id.time_view_table_layout);

		// TODO
	}

	/**
	 * <p>
	 * Overridden <code>tearDown()</code> method. Invoked after each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Should be invoked to make a cleanup after each
	 * test. So usually should contain only call of superclass
	 * <code>tearDown();</code> method within following code:
	 * <code>super.tearDown();</code>.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Sometimes it is necessary to perform a specific
	 * cleanup, so any code intended for cleaning should be placed before
	 * <code>super.tearDown();</code> method, like:
	 * 
	 * <pre>
	 *  <code>
	 *  protected void tearDown() throws Exception {
	 *  
	 *    //Your code
	 *    
	 *  super.tearDown();
	 * }
	 * </code>
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");

		// solo.finishOpenedActivities();
	}

	/**
	 * Asserts that all views are initialized and present on
	 * {@link StopWatchActivity}.
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;testAllViewsArePresentOnActivity() is
	 * non-necessary method and usually it is used to verify that all views are
	 * initialized correctly and references to those objects are not equal to
	 * <code>null</code>. <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Actually this method is redundant, but in
	 * real-life project it is a good practice to add it to tests, thus all
	 * problems caused by abnormal initialization can be easily found.
	 * </p>
	 */
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

	/**
	 * Verifies the behavior of "Start" button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Activity is launched;</li>
	 * <li>Assertion of initial state of <code>StopWatchActivity</code> is
	 * performed;</li>
	 * <li>Start button is clicked;</li>
	 * <li>Following assertions are performed:</li>
	 * <ul>
	 * <li>Assertion of <code>tvEmptyStr</code> and
	 * <code>listOfLapsToTest</code> views visibility changes is performed;</li>
	 * <li>Assertion that the time-counting is started;</li>
	 * <li>Assertion that "Start" button is disabled;</li>
	 * </ul>
	 * <li>Stop button is clicked;</li>
	 * <li>Following assertions are performed:</li>
	 * <ol>
	 * <ul>
	 * <li>Assertion that all buttons are returned to their initial states;</li>
	 * <li>Assertion that timer's value is non-zero.</li>
	 * </ol>
	 * </ol>
	 * </p>
	 */
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

	/**
	 * Verifies the behavior of "Stop" button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Activity is launched;</li>
	 * <li>Start button is clicked;</li>
	 * <li>Following assertions are performed:</li>
	 * <ul>
	 * <li>Asserting that buttons changed their accessibility states;</li>
	 * </ul>
	 * <li>Stop button is clicked;</li>
	 * <li>Following assertions are performed:</li>
	 * <ol>
	 * <ul>
	 * <li>Asserting that accessibility states is returned to initial states;</li>
	 * <li>Assertion that timer's value is non-zero.</li>
	 * </ol>
	 * </ol>
	 * </p>
	 */
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

	/**
	 * Verifies the behavior of "Reset" button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Activity is launched;</li>
	 * <li>Assertion of initial state of buttons accessibility is performed;</li>
	 * <li>Start button is clicked;</li>
	 * <li>Stop button is clicked;</li>
	 * <li>Reset button is clicked;</li>
	 * <li>Following assertions are performed:</li>
	 * <ul>
	 * <li>Asserting that buttons changed their accessibility states;</li>
	 * <li>Assertion that timer's value is returned to zero value.</li>
	 * </ul>
	 * </ol>
	 * </p>
	 */
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

	/**
	 * Verifies the behavior of "Catch" button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Activity is launched;</li>
	 * <li>Start button is clicked;</li>
	 * <li>Following loop is running 10 times:</li>
	 * <ol>
	 * <li>Catch button is clicked;</li>
	 * <li>String with last time-check is extracted from ListView's ArrayAdapter
	 * </li>
	 * <li>String is truncated to store only time-check in format
	 * "HH:MM:SS:msms";</li>
	 * <li>Assertion that last time-check extracted from ListView's ArrayAdapter
	 * is equal to {@link #tvCurrentTimeCheck}.</li>
	 * </ol>
	 * </ol>
	 * </p>
	 */
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

	/**
	 * Verifies the behavior of "Clear" button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Activity is launched;</li>
	 * <li>Start button is clicked;</li>
	 * <li>Catch button is clicked 3 times;</li>
	 * <li>Stop button is clicked;</li>
	 * <li>Clear button is clicked;</li>
	 * <li>Following Assertions are performed:</li>
	 * <ul>
	 * <li>Catch button is clicked;</li>
	 * <li>Asserting that buttons changed their accessibility states;</li>
	 * <li>Assertion that timer's value is returned to zero value.</li>
	 * <li>Assertion that {@link #listOfLapsToTest} is disappeared and
	 * {@link #tvEmptyStr} is appeared .</li>
	 * </ul>
	 * </ol>
	 * </p>
	 */
	public final void testClearButtonBehaviorOfStopWatchActivity() {

		Log.i(LOGGER, "Running testClearButtonBehaviorOfStopWatchActivity()");

		String current_time_of_chronometer;

		solo.clickOnButton(StartButton.getText().toString());

		for (int i = 0; i < 3; i++) {

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

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

	}

	/**
	 * Verifies the initial state of {@link #listOfLapsToTest}.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Assertion of visibility of {@link #tvEmptyStr};</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest};</li>
	 * <li>Assertion that {@link #tvEmptyStr} is equal to "Empty..." text;</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest} is empty.</li>
	 * </ol>
	 * </p>
	 */
	public final void testListViewInitialStateOfStopWatchActivity() {

		Log.i(LOGGER, "Running testListViewInitialStateOfStopWatchActivity()");

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());
		assertEquals(View.GONE, listOfLapsToTest.getVisibility());

		assertEquals("Empty…", tvEmptyStr.getText().toString());

		assertEquals(0, listOfLapsToTest.getAdapter().getCount());

	}

	/**
	 * Verifies the behavior of {@link #listOfLapsToTest}.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Following assertions performed:</li>
	 * <ul>
	 * <li>Assertion of visibility of {@link #tvEmptyStr};</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest};</li>
	 * <li>Assertion that {@link #tvEmptyStr} is equal to "Empty..." text;</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest} is empty.</li>
	 * </ul>
	 * <li>Start button is clicked;</li>
	 * <li>Following assertions performed:</li>
	 * <ul>
	 * <li>Assertion of visibility of {@link #tvEmptyStr};</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest};</li>
	 * <li>Assertion that {@link #tvEmptyStr} is equal to "Empty..." text;</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest} is empty.</li>
	 * </ul>
	 * <li>Catch button is clicked 3 times;</li>
	 * <li>Following assertions performed:</li>
	 * <ul>
	 * <li>Assertion of visibility of {@link #tvEmptyStr};</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest};</li>
	 * <li>Assertion that {@link #tvEmptyStr} is equal to "Empty..." text;</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest} is not empty.</li>
	 * </ul>
	 * <li>Stop button is clicked;</li>
	 * <li>Clear button is clicked;</li>
	 * <li>Following assertions performed:</li>
	 * <ul>
	 * <li>Assertion of visibility of {@link #tvEmptyStr};</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest};</li>
	 * <li>Assertion that {@link #tvEmptyStr} is equal to "Empty..." text;</li>
	 * <li>Assertion of visibility of {@link #listOfLapsToTest} has 3 entries.</li>
	 * </ul>
	 * </ol>
	 * </p>
	 */
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
		assertEquals(0, listOfLapsToTest.getAdapter().getCount());

	}

	/**
	 * Verifies ordering of list counter and lap counter of
	 * {@link #listOfLapsToTest}.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Start button is clicked;</li>
	 * <li>Following actions are performed inside double-loop:</li>
	 * <ul>
	 * <li>Catch button is clicked;</li>
	 * <li>Current time-check is extracted from {@link #listOfLapsToTest}</li>
	 * <li>List counter and Lap counter are extracted from current time-check</li>
	 * <Assertion is performed that List counter continues to increment while
	 * Lap counter is set to one, each time when {@link #ResetButton} is
	 * tapped.</li>
	 * <li>If List counter's value or Lap counter's value are not equal to
	 * expected then <code>fail();</code> method is called which result test
	 * failure.</li>
	 * </ul>
	 * </ol>
	 * </p>
	 */
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

	/**
	 * Verifies that last time-check {@link #listOfLapsToTest} is always stay
	 * visible.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Start button is clicked;</li>
	 * <li>Following actions are performed 25 times inside loop:</li>
	 * <ul>
	 * <li>Catch button is clicked;</li>
	 * <li>Assertion is performed, that last child of {@link #listOfLapsToTest}
	 * is visible.</li>
	 * </ul>
	 * </ol>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public final void testListViewCurrentPositionVisibilityOfStopWatchActivity()
			throws InterruptedException {

		Log.i(LOGGER,
				"Running testListViewCurrentPositionVisibilityOfStopWatchActivity()");

		fail("Does not work as expected!..");

		solo.clickOnButton(StartButton.getText().toString());

		for (int i = 0; i < 25; i++) {

			solo.clickOnButton(CatchButton.getText().toString());

			assertTrue(listOfLapsToTest.getChildAt(i).isSelected());

		}
	}

	public void testMenuOfStopWatchActivity() throws InterruptedException {
		Log.i(LOGGER, "Running testMenuOfStopWatchActivity()");

		sendKeys(KeyEvent.KEYCODE_MENU);

		Thread.sleep(1500);

	}

	/**
	 * Verifies that "About" menu item is invoked.
	 * 
	 * <p>
	 * Menu invoking scenario:
	 * <ol>
	 * <li>"About" menu is invoked;</li>
	 * <li>Back button is pressed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testInvocationOfAboutMenuOfStopWatchActivity()
			throws InterruptedException {
		Log.i(LOGGER, "Running testInvocationOfAboutMenuOfStopWatchActivity()");

		// fail("Not implemented yet...");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				StopWatchActivityToTest, R.id.hardwareMenuToastAbout, 0));

		Thread.sleep(1500);

		sendKeys(KeyEvent.KEYCODE_BACK);

	}

	/**
	 * Verifies that "Quick Start" menu item is invoked.
	 * 
	 * <p>
	 * Menu invoking scenario:
	 * <ol>
	 * <li>"Quick Start" menu is invoked;</li>
	 * <li>Back button is pressed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testInvocationOfQuickStartMenuOfStopWatchActivity()
			throws InterruptedException {
		Log.i(LOGGER, "Running testInvocationOfHelpMenuOfMainActivity()");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				StopWatchActivityToTest, R.id.hardwareMenuSWHelpQS, 0));

		Thread.sleep(1500);

		sendKeys(KeyEvent.KEYCODE_BACK);

	}

}

// TODO
