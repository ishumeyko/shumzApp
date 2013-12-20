package com.shumz.application.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
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

/**
 * <h6>TimerActivityBehaviorTest is a class intended to perform several behavior
 * tests on {@link TimerActivity} activity.</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods intended to
 * verify behavior of <code>TimerActivity</code>, behavior of buttons which are
 * present in <code>TimerActivity</code>, behavior of activity during device's
 * orientation changes.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see TimerActivity
 * @see TimerEndOfTimeDialogActivity
 * 
 * @see TimerActivityLayoutParametersOfLandscapeOrientationTest
 * @see TimerActivityLayoutParametersOfPortraitOrientationTest
 * @see TimerEndOfTimeDialogActivityTest
 * 
 * @since Dec 15th, 2013
 */
@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class TimerActivityBehaviorTest extends
		ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerActivityBehaviorTest() {
		super(TimerActivity.class);
	}

	private static final String LOGGER = "TimerActivityBehaviorTest:";
	private static final int SLEEP_TIME = 500;

	/**
	 * An instance of <code>Solo</code> class, which will be used in tests
	 * presented below to perform button clicks since standard
	 * <code>TouchUtils</code> methods does not work as expected in particular
	 * cases.
	 */
	private static Solo solo;

	/**
	 * Instance of a {@link TimerActivity} class under test.
	 */
	private static TimerActivity TimerActivityToTest;

	/**
	 * TimePicker which is used to set timer's time to test.
	 */
	private static TimePicker tPicker;

	/**
	 * LinearLayout, which contains {@link #tvHHs}, {@link #tvDelimeterHM},
	 * {@link #tvMMs}, {@link #tvDelimeterMS}, {@link #tvSSs} TextViews, which
	 * represent time-countdown.
	 */
	private static LinearLayout lLayoutCountdown;

	/**
	 * TextView which represents hours of time-counter to test.
	 */
	private static TextView tvHHs;

	/**
	 * TextView which represents delimiter between hours and minutes of
	 * time-counter to test.
	 */
	private static TextView tvDelimeterHM;

	/**
	 * TextView which represents minutes of time-counter to test.
	 */
	private static TextView tvMMs;

	/**
	 * TextView which represents delimiter between minutes and seconds of
	 * time-counter to test.
	 */
	private static TextView tvDelimeterMS;

	/**
	 * TextView which represents seconds of time-counter to test.
	 */
	private static TextView tvSSs;

	/**
	 * Button which is used to begin or end time count-down.
	 * 
	 * <p>
	 * Button's text can be equal to "Start" or "Stop" depending on activity
	 * state.
	 * </p>
	 */
	private static Button startStopButton;

	/**
	 * Button which is used to pause or return time count-down.
	 * 
	 * <p>
	 * Button's text can be equal to "Pause" or "Resume" depending on activity
	 * state.
	 * </p>
	 */
	private static Button pauseResumeButton;

	/**
	 * An instance of <code>KeyguardManager</code> class. Is used to unlock
	 * emulator before text execution.
	 */
	KeyguardManager keyguardManager;

	/**
	 * An instance of <code>KeyguardLock</code> class. Is used to unlock
	 * emulator before text execution within the {@link #keyguardManager}.
	 */
	KeyguardLock lock;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link TimerActivity}
	 */
	ActivityMonitor TimerActivityMonytor;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link TimerEndOfTimeDialogActivity}
	 */
	ActivityMonitor TimerEndOfTimeDialogActivityMonytor;

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link TimerActivity} class members inside this method.
	 * </p>
	 * 
	 * <p>
	 * Following code: <br>
	 * 
	 * <pre>
	 * <code>keyguardManager = (KeyguardManager) TimerActivityToTest
	 * 				.getSystemService(Context.KEYGUARD_SERVICE);
	 * 		lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);
	 * 
	 * 		
	 * 		//Unlocks the emulator if it locked before test execution.
	 * 		if (keyguardManager.isKeyguardLocked()) {
	 * 			lock.disableKeyguard();
	 * 		}
	 * </code>
	 * </pre>
	 * 
	 * checks if the emulator is locked, if <code>true</code> then
	 * <code>lock.disableKeyguard()</code> method unlocks it.
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
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

		keyguardManager = (KeyguardManager) TimerActivityToTest
				.getSystemService(Context.KEYGUARD_SERVICE);
		lock = keyguardManager.newKeyguardLock(Context.KEYGUARD_SERVICE);

		// Unlocks the emulator if it locked before test execution.
		if (keyguardManager.isKeyguardLocked()) {
			lock.disableKeyguard();
		}

		TimerActivityMonytor = new ActivityMonitor(
				TimerActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(TimerActivityMonytor);

		TimerEndOfTimeDialogActivityMonytor = new ActivityMonitor(
				TimerEndOfTimeDialogActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(TimerEndOfTimeDialogActivityMonytor);

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
	 * {@link TimerActivity}.
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

	/**
	 * Verifies the initial state of {@link TimerActivity}.
	 * 
	 * <p>
	 * Scenario:
	 * <ol>
	 * <li>Verifies the visibility of {@link #tPicker};</li>
	 * <li>Verifies that {@link #tPicker} default values are equal to expected;</li>
	 * <li>Verifies the visibility of {@link #lLayoutCountdown};</li>
	 * <li>Verifies that TextViews, which represent time-countdown are equal to
	 * zero;</li>
	 * <li>Verifies the text of {@link #pauseResumeButton} and
	 * {@link #startStopButton};</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ol>
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

	/**
	 * Verifies the initial state of {@link TimerActivity} in different
	 * orientations.
	 * 
	 * <p>
	 * Scenario:
	 * 
	 * <ol>
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies the visibility of {@link #tPicker};</li>
	 * <li>Verifies that {@link #tPicker} default values are equal to expected;</li>
	 * <li>Verifies the visibility of {@link #lLayoutCountdown};</li>
	 * <li>Verifies that TextViews, which represent time-countdown are equal to
	 * zero;</li>
	 * <li>Verifies the text of {@link #pauseResumeButton} and
	 * {@link #startStopButton};</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * <li>Device's orientation is changed to Landscape then back to Portrait
	 * within performing same assertions.</li></li>
	 * </ol>
	 */
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

	/**
	 * Verifies the behavior of {@link #startStopButton}.
	 * 
	 * <p>
	 * Scenario:
	 * 
	 * <ol>
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #tPicker} default values are equal to expected;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is invisible;</li>
	 * <li>Verifies that TextViews, which represent time-countdown are equal to
	 * zero;</li>
	 * <li>Verifies the text of {@link #pauseResumeButton} and
	 * {@link #startStopButton};</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>"Start" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Start to Stop";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * 
	 * <li>"Stop" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is gone;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Stop to Start";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * </ol>
	 */
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

	/**
	 * Verifies the behavior of {@link #startStopButton} during orientation
	 * changes.
	 * 
	 * <p>
	 * Scenario:
	 * 
	 * <ol>
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #tPicker} default values are equal to expected;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is invisible;</li>
	 * <li>Verifies that TextViews, which represent time-countdown are equal to
	 * zero;</li>
	 * <li>Verifies the text of {@link #pauseResumeButton} and
	 * {@link #startStopButton};</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>"Start" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Start to Stop";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * 
	 * <li>"Stop" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is gone;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Stop to Start";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>Device orientation is changed to Portrait mode;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is gone;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Stop to Start";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>Device orientation is changed to Landscape mode;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is gone;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Stop to Start";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>Same assertions are performed within orientation changes several
	 * times.</li>
	 * 
	 * </ol>
	 */
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

	/**
	 * Verifies the behavior of {@link #pauseResumeButton}.
	 * 
	 * <p>
	 * Scenario:
	 * 
	 * <ol>
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is visible;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is invisible;</li>
	 * <li>Verifies the text of {@link #pauseResumeButton} and
	 * {@link #startStopButton};</li>
	 * <li>Verifies that {@link #pauseResumeButton} is disabled.</li>
	 * </ul>
	 * 
	 * <li>"Start" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #startStopButton} has changed from
	 * "Start" to "Stop";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * 
	 * <li>"Pause" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #pauseResumeButton} has changed from
	 * "Pause" to "Resume";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * 
	 * <li>"Resume" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #pauseResumeButton} has changed from
	 * "Resume" to "Pause";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * 
	 * <li>"Pause" button is tapped;</li>
	 * 
	 * <li>Following assertions are performed:
	 * <ul>
	 * <li>Verifies that {@link #tPicker} is gone;</li>
	 * <li>Verifies that {@link #lLayoutCountdown} is visible;</li>
	 * <li>Verifies that text of {@link #pauseResumeButton} has changed from
	 * "Pause" to "Resume";</li>
	 * <li>Verifies that {@link #pauseResumeButton} is enabled.</li>
	 * </ul>
	 * </ol>
	 */
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
