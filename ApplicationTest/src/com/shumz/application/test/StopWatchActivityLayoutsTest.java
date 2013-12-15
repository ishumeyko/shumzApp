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

import com.shumz.application.R;
import com.shumz.application.StopWatchActivity;

/**
 * <h6>StopWatchActivityLayoutsTest is a class intended to verify layout
 * parameters of views of {@link StopWatchActivity} activity.</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods intended to
 * verify layout parameters, their position and visual parameters.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see StopWatchActivity
 * @see StopWatchActivityBehaviorTest
 * 
 * @since Dec 15th, 2013
 */
@SuppressWarnings("deprecation")
public class StopWatchActivityLayoutsTest extends
		ActivityInstrumentationTestCase2<StopWatchActivity> {

	public StopWatchActivityLayoutsTest() {
		super(StopWatchActivity.class);
	}

	private static final String LOGGER = "StopWatchActivityTest:";

	/**
	 * Instance of a {@link StopWatchActivity} class under test.
	 */
	private static StopWatchActivity StopWatchActivityToTest;

	/**
	 * Top view of {@link StopWatchActivity} class under test
	 */
	private static RelativeLayout rLayoutOfStopWatchActivity;

	/**
	 * Linear Layout which contains views related to StopWatch feature
	 */
	private static LinearLayout lLayoutOfStopWatch;

	/**
	 * Linear Layout which contains views related to time-counter
	 */
	private static LinearLayout lLayoutChronoView;

	/**
	 * Top header TextView
	 */
	private static TextView tvStopWatchHeader;

	/**
	 * TableRow which contains time-counter's digits
	 */
	private static TableRow tRowCronometer;

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
	 * LinearLayout, which contains {@link #CatchButton}, {@link #StartButton},
	 * {@link #ResetButton} buttons.
	 */
	private static LinearLayout lLayoutButtonsViewTop;

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
	 * LinearLayout, which contains {@link #StopButton}, {@link #ClearButton}
	 * buttons.
	 */
	private static RelativeLayout rLayoutButtonsViewBottom;

	/**
	 * Stop button of StopWatchActivity to test.
	 */
	private static Button StopButton;

	/**
	 * Clear button of StopWatchActivity to test.
	 */
	private static Button ClearButton;

	/**
	 * LinearLayout, which contains {@link #tvCurrentTimeCheckStr} and
	 * {@link #tvCurrentTimeCheck} TextViews.
	 */
	private static LinearLayout lLayoutLogView;

	/**
	 * TextView, which displays "Current time check:" string, is used for
	 * debugging.
	 */
	private static TextView tvCurrentTimeCheckStr;

	/**
	 * TextView, which displays last catched time, is used for debugging.
	 */
	private static TextView tvCurrentTimeCheck;

	/**
	 * ListView which is used for displaying time results to test.
	 */
	private static ListView listOfLaps;

	/**
	 * TextView which is displaying "Empty..." text when list of time results is
	 * empty.
	 */
	private static TextView tvEmptyStr;

	/**
	 * TableLayout, which is used for debugging, will be excluded in future
	 * versions.
	 */
	TableLayout tLayoutTimeOfStopWatch;

	/**
	 * DigitalClock, is used for displaying current system time.
	 */
	private static DigitalClock dClock;

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

	/**
	 * Verifies layout parameters of {@link #rLayoutOfStopWatchActivity} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * </ul>
	 * </p>
	 */
	public final void testRelativeLayoutOfStopWatchActivityLayoutParameters() {
		Log.i(LOGGER,
				"Running testRelativeLayoutOfStopWatchActivityLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutOfStopWatchActivity.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				rLayoutOfStopWatchActivity.getLayoutParams().width);

	}

	/**
	 * Asserts presence of child views in {@link #rLayoutOfStopWatchActivity}
	 * view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #rLayoutOfStopWatchActivity} is a parent view of
	 * {@link #lLayoutOfStopWatch};</li>
	 * <li>asserts that {@link #rLayoutOfStopWatchActivity} is a parent view of
	 * {@link #tLayoutTimeOfStopWatch};</li>
	 * <li>asserts that {@link #rLayoutOfStopWatchActivity} is a parent view of
	 * {@link #tvEmptyStr};</li>
	 * <li>asserts that {@link #rLayoutOfStopWatchActivity} is a parent view of
	 * {@link #dClock}.</li>
	 * </ul>
	 * </p>
	 */
	public final void testRealtiveLayoutOfStopWatchActivityChildren() {

		Log.i(LOGGER, "Running testRealtiveLayoutOfStopWatchActivityChildren()");

		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity,
				lLayoutOfStopWatch);
		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity,
				tLayoutTimeOfStopWatch);
		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity, tvEmptyStr);

		ViewAsserts.assertGroupContains(rLayoutOfStopWatchActivity, dClock);

	}

	/**
	 * Verifies layout parameters of {@link #lLayoutOfStopWatch} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters;</li>
	 * <li>asserts view's orientation parameter;</li>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is above
	 * {@link #tLayoutTimeOfStopWatch}.</li>
	 * </ul>
	 * </p>
	 */
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

	/**
	 * Asserts presence of child views in {@link #lLayoutOfStopWatch} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is a parent view of
	 * {@link #lLayoutChronoView};</li>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is a parent view of
	 * {@link #lLayoutButtonsViewTop};</li>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is a parent view of
	 * {@link #rLayoutButtonsViewBottom};</li>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is a parent view of
	 * {@link #lLayoutLogView}.</li>
	 * <li>asserts that {@link #lLayoutOfStopWatch} is a parent view of
	 * {@link #listOfLaps}.</li>
	 * </ul>
	 * </p>
	 */
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

	/**
	 * Verifies layout parameters of {@link #lLayoutChronoView} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters;</li>
	 * <li>asserts view's orientation parameter.</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutOfChronoViewLayoutParameters() {

		Log.i(LOGGER, "Running testLinearLayoutOfChronoViewLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutChronoView.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutChronoView.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutChronoView.getOrientation());

	}

	/**
	 * Asserts presence of child views in {@link #lLayoutChronoView} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #lLayoutChronoView} is a parent view of
	 * {@link #tvStopWatchHeader};</li>
	 * <li>asserts that {@link #lLayoutChronoView} is a parent view of
	 * {@link #tRowCronometer};</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutOfChronoViewChildren() {

		Log.i(LOGGER, "Running testLinearLayoutOfChronoViewChildren()");

		ViewAsserts.assertGroupContains(lLayoutChronoView, tvStopWatchHeader);
		ViewAsserts.assertGroupContains(lLayoutChronoView, tRowCronometer);

	}

	/**
	 * Verifies the parameters of {@link #tvStopWatchHeader} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text gravity of this view;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewHeaderStr() {

		Log.i(LOGGER, "Running testTextViewHeaderStr()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvStopWatchHeader.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvStopWatchHeader.getLayoutParams().width);

		assertEquals("StopWatch", tvStopWatchHeader.getText().toString());

		assertEquals(Gravity.CENTER, tvStopWatchHeader.getGravity());

		assertEquals(Typeface.MONOSPACE, tvStopWatchHeader.getTypeface());

	}

	/**
	 * Verifies layout parameters of {@link #tRowCronometer} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters;</li>
	 * <li>asserts view's orientation parameter.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTableRowOfChronometerLayoutParameters() {

		Log.i(LOGGER, "Running testTableRowOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tRowCronometer.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tRowCronometer.getLayoutParams().width);

		// assertEquals(Gravity.CENTER, tRowCronometer.getGravity();

		assertEquals(LinearLayout.HORIZONTAL, tRowCronometer.getOrientation());

	}

	/**
	 * Asserts presence of child views in {@link #tRowCronometer} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvHHs};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvTDelimiter1};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvMMs};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvTDelimiter2};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvSSs};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvTDelimiter3};</li>
	 * <li>asserts that {@link #tRowCronometer} is a parent view of
	 * {@link #tvMSMSs};</li>
	 * </ul>
	 * </p>
	 */
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

	/**
	 * Verifies the parameters of {@link #tvHHs} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewHoursOfChronometer() {

		Log.i(LOGGER, "Running testTextViewHoursOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvHHs.getLayoutParams().width);

		assertEquals("00", tvHHs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvHHs.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvTDelimiter1} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewtvTDelimiterOneOfChronometer() {

		Log.i(LOGGER, "Running testTextViewtvTDelimiterOneOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter1.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter1.getLayoutParams().width);

		assertEquals(":", tvTDelimiter1.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter1.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvMMs} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewMinutesOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMinutesOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMMs.getLayoutParams().width);

		assertEquals("00", tvMMs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMMs.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvTDelimiter2} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewDelimiterTwoOfChronometer() {

		Log.i(LOGGER, "Running testTextViewDelimiterTwoOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter2.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter2.getLayoutParams().width);

		assertEquals(":", tvTDelimiter2.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter2.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvSSs} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewSecondsOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMinutesOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSSs.getLayoutParams().width);

		assertEquals("00", tvSSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvSSs.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvTDelimiter3} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewDelimiterThreeOfChronometer() {

		Log.i(LOGGER, "Running testTextViewDelimiterThreeOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter3.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTDelimiter3.getLayoutParams().width);

		assertEquals(":", tvTDelimiter3.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvTDelimiter3.getTypeface());
	}

	/**
	 * Verifies the parameters of {@link #tvMSMSs} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewMilliSecondsOfChronometer() {

		Log.i(LOGGER, "Running testTextViewMilliSecondsOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvMSMSs.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvMSMSs.getLayoutParams().width);

		assertEquals("000", tvMSMSs.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvMSMSs.getTypeface());
	}

	/**
	 * Verifies layout parameters of {@link #lLayoutButtonsViewTop} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters;</li>
	 * <li>asserts view's orientation parameter.</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutButtonsViewTopOfChronometer() {

		Log.i(LOGGER, "Running testLinearLayoutButtonsViewTopOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutButtonsViewTop.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutButtonsViewTop.getLayoutParams().width);
		assertEquals(LinearLayout.HORIZONTAL,
				lLayoutButtonsViewTop.getOrientation());

	}

	/**
	 * Asserts presence of child views in {@link #lLayoutButtonsViewTop} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #lLayoutButtonsViewTop} is a parent view of
	 * {@link #CatchButton};</li>
	 * <li>asserts that {@link #lLayoutButtonsViewTop} is a parent view of
	 * {@link #StartButton};</li>
	 * <li>asserts that {@link #lLayoutButtonsViewTop} is a parent view of
	 * {@link #ResetButton};</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutButtonsViewTopChildren() {

		Log.i(LOGGER, "Running testLinearLayoutButtonsViewTopChildren()");

		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, CatchButton);
		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, StartButton);
		ViewAsserts.assertGroupContains(lLayoutButtonsViewTop, ResetButton);

	}

	/**
	 * Verifies layout parameters of {@link #rLayoutButtonsViewBottom} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters.</li>
	 * </ul>
	 * </p>
	 */
	public final void testRelativeLayoutButtonsViewBottomOfChronometer() {

		Log.i(LOGGER,
				"Running testRelativeLayoutButtonsViewBottomOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutButtonsViewBottom.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				rLayoutButtonsViewBottom.getLayoutParams().width);

	}

	/**
	 * Asserts presence of child views in {@link #rLayoutButtonsViewBottom}
	 * view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #rLayoutButtonsViewBottom} is a parent view of
	 * {@link #StopButton};</li>
	 * <li>asserts that {@link #rLayoutButtonsViewBottom} is a parent view of
	 * {@link #StopButton};</li>
	 * </ul>
	 * </p>
	 */
	public final void testRelativeLayoutButtonsViewBottomChildren() {

		Log.i(LOGGER, "Running testRelativeLayoutButtonsViewBottomChildren()");

		ViewAsserts.assertGroupContains(rLayoutButtonsViewBottom, StopButton);
		ViewAsserts.assertGroupContains(rLayoutButtonsViewBottom, StopButton);

	}

	/**
	 * Verifies layout parameters of {@link #lLayoutLogView} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts view's layout parameters;</li>
	 * <li>asserts view's orientation parameter.</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutLogOfChronometer() {

		Log.i(LOGGER,
				"Running testRelativeLayoutButtonsViewBottomOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutLogView.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutLogView.getLayoutParams().width);

		assertEquals(LinearLayout.HORIZONTAL, lLayoutLogView.getOrientation());

	}

	/**
	 * Asserts presence of child views in {@link #lLayoutLogView} view.
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that {@link #lLayoutLogView} is a parent view of
	 * {@link #tvCurrentTimeCheckStr};</li>
	 * <li>asserts that {@link #lLayoutLogView} is a parent view of
	 * {@link #tvCurrentTimeCheck};</li>
	 * </ul>
	 * </p>
	 */
	public final void testLinearLayoutLogChildren() {

		Log.i(LOGGER, "Running testRelativeLayoutButtonsViewBottomChildren()");

		ViewAsserts.assertGroupContains(lLayoutLogView, tvCurrentTimeCheckStr);
		ViewAsserts.assertGroupContains(lLayoutLogView, tvCurrentTimeCheck);

	}

	/**
	 * Verifies the parameters of {@link #tvCurrentTimeCheckStr} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewtvCurrentTimeCheckStrOfChronometer() {

		Log.i(LOGGER,
				"Running testTextViewtvCurrentTimeCheckStrOfChronometer()");

		assertEquals(LayoutParams.FILL_PARENT,
				tvCurrentTimeCheckStr.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvCurrentTimeCheckStr.getLayoutParams().width);

		assertEquals("Current time check:", tvCurrentTimeCheckStr.getText()
				.toString());

		assertEquals(Typeface.MONOSPACE, tvCurrentTimeCheckStr.getTypeface());

	}

	/**
	 * Verifies the parameters of {@link #tvCurrentTimeCheck} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts that text is equal to expected;</li>
	 * <li>asserts text typeface of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTextViewtvCurrentTimeCheckTimeOfChronometer() {

		Log.i(LOGGER,
				"Running testTextViewtvCurrentTimeCheckTimeOfChronometer()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCurrentTimeCheck.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCurrentTimeCheck.getLayoutParams().width);

		assertEquals("00:00:00:000", tvCurrentTimeCheck.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvCurrentTimeCheck.getTypeface());

	}

	/**
	 * Verifies the parameters of {@link #listOfLaps} ListView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts visibility parameter of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testListViewListOfLapsOfChronometerParameters() {

		Log.i(LOGGER,
				"Running testListViewListOfLapsOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				listOfLaps.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				listOfLaps.getLayoutParams().width);

		assertEquals(View.GONE, listOfLaps.getVisibility());
	}

	/**
	 * Verifies the parameters of {@link #tvEmptyStr} TextView.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts alignment parameter of this view.</li>
	 * <li>asserts visibility parameter of this view.</li>
	 * <li>asserts text typeface of this view</li>
	 * <li>asserts that text is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public final void testTexViewEmptyStringOfChronometerLayoutParameters() {

		Log.i(LOGGER,
				"Running testTexViewEmptyStringOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvEmptyStr.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvEmptyStr.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfStopWatchActivity,
				tvEmptyStr);
		ViewAsserts.assertVerticalCenterAligned(rLayoutOfStopWatchActivity,
				tvEmptyStr);

		assertEquals(View.VISIBLE, tvEmptyStr.getVisibility());

		assertEquals(Typeface.MONOSPACE, tvEmptyStr.getTypeface());

		assertEquals("Empty…", tvEmptyStr.getText().toString());

	}

	/**
	 * Verifies the parameters of {@link #dClock} DigitalClock.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of view;</li>
	 * <li>asserts alignment parameter of this view.</li>
	 * <li>asserts gravity parameter of this view.</li>
	 * </ul>
	 * </p>
	 */
	public final void testDigitalClockOfChronometerLayoutParameters() {

		Log.i(LOGGER, "Running testDigitalClockOfChronometerLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, dClock.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfStopWatchActivity,
				dClock);

		assertEquals(Gravity.CENTER, dClock.getGravity());

		assertEquals(rLayoutOfStopWatchActivity.getBottom(), dClock.getBottom());
	}

}
