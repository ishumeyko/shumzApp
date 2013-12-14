package com.shumz.application.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shumz.application.AlarmActivity;
import com.shumz.application.MainActivity;
import com.shumz.application.R;
import com.shumz.application.StopWatchActivity;
import com.shumz.application.TimerActivity;

/**
 * <h6>MainActivityTest is a class intended to verify layout parameters of
 * views, behavior of buttons and invocation of menu items which are present in
 * {@link MainActivity} class</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods intended to
 * verify layout parameter of views and behavior of buttons placed on
 * {@link MainActivity}.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see MainActivity
 * @see AlarmActivity
 * @see StopWatchActivity
 * @see TimerActivity
 * 
 * @since Dec 10th, 2013
 */
public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	private static final String LOGGER = "MainActivityTest:";

	/**
	 * Instance of a {@link MainActivity} class under test
	 */
	private static MainActivity mainActivityToTest;

	/**
	 * Top view of {@link MainActivity} class under test
	 */
	private static RelativeLayout rLayoutOfMainActivityTest;

	/**
	 * LinearLayout containing buttons which invoke {@link AlarmActivity},
	 * {@link StopWatchActivity}, {@link TimerActivity}
	 */
	private static LinearLayout lLayoutButtonToolsTest;

	/**
	 * TextView with the greetings text under test
	 */
	private static TextView tvGreetingsTest;

	/**
	 * TextView greetings text under test
	 */
	private static TextView tvButtonTools;

	/**
	 * ImageView which contains Cogniance logo to test
	 */
	private static ImageView cognianceLogoTest;

	/**
	 * Button which should invoke {@link AlarmActivity} to test
	 */
	private static Button AlarmButtonTest;

	/**
	 * Button which should invoke {@link StopWatchActivity} to test
	 */
	private static Button StopWatchButtonTest;

	/**
	 * Button which should invoke {@link TimerActivity} to test
	 */
	private static Button TimerButtonTest;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link MainActivity}
	 */
	private static ActivityMonitor mainActivityMonitor;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link AlarmActivity}
	 */
	private static ActivityMonitor alarmActivityMonitor;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link StopWatchActivity}
	 */
	private static ActivityMonitor stopWatchActivityMonitor;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link TimerActivity}
	 */
	private static ActivityMonitor timerActivityMonitor;

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link MainActivity} class members inside this method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		Log.v(LOGGER, "Setting up...");

		super.setUp();

		mainActivityToTest = getActivity();

		rLayoutOfMainActivityTest = (RelativeLayout) mainActivityToTest
				.findViewById(R.id.rlayout_main);
		lLayoutButtonToolsTest = (LinearLayout) mainActivityToTest
				.findViewById(R.id.ll_activity_main_button_tools);

		tvGreetingsTest = (TextView) mainActivityToTest
				.findViewById(R.id.tv_activity_main_greeteings);

		tvButtonTools = (TextView) mainActivityToTest
				.findViewById(R.id.tv_activity_main_please_select);

		cognianceLogoTest = (ImageView) mainActivityToTest
				.findViewById(R.id.image_activity_main_cogniance_logo);

		AlarmButtonTest = (Button) mainActivityToTest
				.findViewById(R.id.button_alarm_activity_main);
		StopWatchButtonTest = (Button) mainActivityToTest
				.findViewById(R.id.button_stopwatch_activity_main);
		TimerButtonTest = (Button) mainActivityToTest
				.findViewById(R.id.button_timer_activity_main);

		mainActivityMonitor = new ActivityMonitor(MainActivity.class.getName(),
				null, false);
		getInstrumentation().addMonitor(mainActivityMonitor);

		alarmActivityMonitor = new ActivityMonitor(
				AlarmActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(alarmActivityMonitor);

		stopWatchActivityMonitor = new ActivityMonitor(
				StopWatchActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(stopWatchActivityMonitor);

		timerActivityMonitor = new ActivityMonitor(
				TimerActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(timerActivityMonitor);

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

		Log.v(LOGGER, "Tearing down...");

		super.tearDown();
	}

	/**
	 * Asserts that all views are initialized and present on
	 * {@link MainActivity}.
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
	public void testAllViewsArePresentOnMainActivity() {
		Log.i(LOGGER, "Running testAllViewsArePresentOnMainActivity()");

		assertNotNull("Cannot find mainActivityToTest!", mainActivityToTest);

		assertNotNull("Cannot find rLayoutOfMainActivityTest!",
				rLayoutOfMainActivityTest);
		assertNotNull("Cannot find lLayoutButtonToolsTest!",
				lLayoutButtonToolsTest);

		assertNotNull("Cannot find tvGreetingsTest!", tvGreetingsTest);
		assertNotNull("Cannot find tvButtonTools!", tvButtonTools);

		assertNotNull("Cannot find cognianceLogoTest!", cognianceLogoTest);

		assertNotNull("Cannot find AlarmTest!", AlarmButtonTest);
		assertNotNull("Cannot find StopWatchTest!", StopWatchButtonTest);
		assertNotNull("Cannot find TimerTest!", TimerButtonTest);

	}

	/**
	 * Programmatically changes device's orientation several times within the
	 * interval of 500 msec.
	 * 
	 * @throws InterruptedException
	 */
	public void testChangingDeviceOrientationOfMainActivity()
			throws InterruptedException {

		Log.i(LOGGER, "Running testChangingDeviceOrientationOfMainActivity()");

		Thread.sleep(500);

		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Thread.sleep(500);

		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread.sleep(500);

		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Thread.sleep(500);
		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread.sleep(500);
		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
		Thread.sleep(500);
		mainActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);

	}

	/**
	 * Verifies the parameters of top layout of {@link MainActivity}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this View.</li>
	 * </ul>
	 * <br>
	 * Asserts that this View contains following sub-views:
	 * <ul>
	 * <li>greetings TextView;</li>
	 * <li>Cogniance logo image;</li>
	 * <li>"Please select.." TextView;</li>
	 * <li>linear layout.</li>
	 * </ul>
	 * </p>
	 */
	public void testRelativeLayoutParametersOfMainActivity() {

		Log.i(LOGGER, "Running testRelativeLayoutParametersOfMainActivity()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutOfMainActivityTest.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutOfMainActivityTest.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvGreetingsTest);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				cognianceLogoTest);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvButtonTools);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				lLayoutButtonToolsTest);

	}

	/**
	 * Verifies the parameters of Greetings TextView of {@link MainActivity}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that text shown in activity is equal to specified;</li>
	 * <li>asserts layout parameters of this TextView;</li>
	 * <li>asserts that this TextView is a child of
	 * <code>rLayoutOfMainActivityTest</code> view;</li>
	 * <li>asserts that this TextView is horizontally centered.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewGreetingsParameters() {

		Log.i(LOGGER, "Running testTextViewGreetingsParameters()");

		assertEquals("Good day, Team!..", tvGreetingsTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvGreetingsTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvGreetingsTest.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvGreetingsTest);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfMainActivityTest,
				tvGreetingsTest);

	}

	/**
	 * Verifies the parameters of CognianceLogo ImageView of
	 * {@link MainActivity}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this ImageView;</li>
	 * <li>asserts that this ImageView is a child of
	 * <code>rLayoutOfMainActivityTest</code> view;</li>
	 * <li>asserts that this ImageView is horizontally centered;</li>
	 * <li>asserts that this ImageView is vertically centered.</li>
	 * </ul>
	 * </p>
	 */
	public void testCognianceLogo() {

		Log.i(LOGGER, "Running testCognianceLogo()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				cognianceLogoTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				cognianceLogoTest.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				cognianceLogoTest);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfMainActivityTest,
				cognianceLogoTest);

		ViewAsserts.assertVerticalCenterAligned(rLayoutOfMainActivityTest,
				cognianceLogoTest);

	}

	/**
	 * Verifies the parameters of "Please select.." TextView of
	 * {@link MainActivity}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that text shown in activity is equal to specified;</li>
	 * <li>asserts layout parameters of this TextView;</li>
	 * <li>asserts that this TextView is a child of
	 * <code>rLayoutOfMainActivityTest</code> view;</li>
	 * <li>asserts that this TextView is alighted to
	 * <code>lLayoutButtonToolsTest</code> linear layout;</li>
	 * <li>asserts that this TextView is horizontally centered.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewPleaseSelectTheTool() {

		Log.i(LOGGER, "Running testTextViewPleaseSelectTheTool()");

		assertEquals("Please select the tool:", tvButtonTools.getText()
				.toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvButtonTools.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvButtonTools.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvButtonTools);

		assertEquals(lLayoutButtonToolsTest.getTop(), tvButtonTools.getBottom());

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfMainActivityTest,
				tvButtonTools);

	}

	/**
	 * Verifies the parameters of <code>lLayoutButtonToolsTest</code>, which
	 * contains Alarm, StopWatch and Timer buttons.
	 * 
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this View.</li>
	 * </ul>
	 * <br>
	 * Asserts that this View contains following sub-views:
	 * <ul>
	 * <li>Alarm button;</li>
	 * <li>StopWatch button;</li>
	 * <li>Timer button.</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutButtonToolsParameters() {
		Log.i(LOGGER, "Running testLinearLayoutButtonToolsParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutButtonToolsTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutButtonToolsTest.getLayoutParams().width);

		assertEquals(LinearLayout.HORIZONTAL,
				lLayoutButtonToolsTest.getOrientation());

		ViewAsserts
				.assertGroupContains(lLayoutButtonToolsTest, AlarmButtonTest);
		ViewAsserts.assertGroupContains(lLayoutButtonToolsTest,
				StopWatchButtonTest);
		ViewAsserts
				.assertGroupContains(lLayoutButtonToolsTest, TimerButtonTest);

	}

	/**
	 * Verifies the parameters of Alarm button.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that text of this button is equal to specified;</li>
	 * <li>asserts layout parameters of this button.</li>
	 * </ul>
	 * </p>
	 */
	public void testAlarmButtonProperties() {
		Log.i(LOGGER, "Running testAlarmButtonProperties()");

		assertEquals("Alarm", AlarmButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				AlarmButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				AlarmButtonTest.getLayoutParams().width);

	}

	/**
	 * Verifies the Alarm button onClick() behavior.
	 * 
	 * <p>
	 * Alarm Button onClick() scenario:
	 * <ol>
	 * <li>button is clicked;</li>
	 * <li><code>alarmActivity</code> gets the reference to activity returned
	 * from <code>AlarmActivityMonitor</code>;</li>
	 * <li>assertion is performed using <code>alarmActivity</code> to verify
	 * that it was launched;</li>
	 * <li><code>alarmActivity</code> finished by calling <code>finish()</code>
	 * method.</li>
	 * </ol>
	 * </p>
	 */
	public void testAlarmButtonOnClick() {

		Log.i(LOGGER, "Running testAlarmButtonOnClick()");

		TouchUtils.clickView(this, AlarmButtonTest);

		Activity alarmActivity = alarmActivityMonitor.getLastActivity();
		assertNotNull("AlarmActivity was not started!..", alarmActivity);

		alarmActivity.finish();

	}

	/**
	 * Verifies the parameters of StopWatch button
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that text of this button is equal to specified;</li>
	 * <li>asserts layout parameters of this button.</li>
	 * </ul>
	 * </p>
	 */
	public void testStopWatchButtonProperties() {
		Log.i(LOGGER, "Running testStopWatchButtonProperties()");

		assertEquals("StopWatch", StopWatchButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				StopWatchButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				StopWatchButtonTest.getLayoutParams().width);

	}

	/**
	 * Verifies the StopWatch button onClick() behavior.
	 * 
	 * <p>
	 * StopWatch Button onClick() scenario:
	 * <ol>
	 * <li>button is clicked;</li>
	 * <li><code>stopWatchActivity</code> gets the reference to activity
	 * returned from <code>stopWatchActivityMonitor</code>;</li>
	 * <li>assertion is performed using <code>stopWatchActivity</code> to verify
	 * that it was launched;</li>
	 * <li><code>stopWatchActivity</code> finished by calling
	 * <code>finish()</code> method.</li>
	 * </ol>
	 * </p>
	 */
	public void testStopWatchButtonOnClick() {

		Log.i(LOGGER, "Running testStopWatchButtonOnClick()");

		TouchUtils.clickView(this, StopWatchButtonTest);

		Activity stopWatchActivity = stopWatchActivityMonitor.getLastActivity();
		assertNotNull("StopWatchActivity was not Started!!!", stopWatchActivity);

		stopWatchActivity.finish();

	}

	/**
	 * Verifies the parameters of Timer button.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts that text of this button is equal to specified;</li>
	 * <li>asserts layout parameters of this button.</li>
	 * </ul>
	 * </p>
	 */
	public void testTimerButtonProperties() {
		Log.i(LOGGER, "Running testTimerButtonProperties()");

		assertEquals("Timer", TimerButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				TimerButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				TimerButtonTest.getLayoutParams().width);

	}

	/**
	 * Verifies the Timer button onClick() behavior.
	 * 
	 * <p>
	 * Timer Button onClick() scenario:
	 * <ol>
	 * <li>button is clicked;</li>
	 * <li><code>timerActivity</code> gets the reference to activity returned
	 * from <code>timerActivityMonitor</code>;</li>
	 * <li>assertion is performed using <code>timerActivity</code> to verify
	 * that it was launched;</li>
	 * <li><code>timerActivity</code> finished by calling <code>finish()</code>
	 * method.</li>
	 * </ol>
	 * </p>
	 */
	public void testTimerButtonOnClick() {

		Log.i(LOGGER, "Running testTimerButtonOnClick()");

		TouchUtils.clickView(this, TimerButtonTest);

		Activity timerActivity = timerActivityMonitor.getLastActivity();
		assertNotNull("TimerActivity was not Started!!!", timerActivity);

		timerActivity.finish();

	}

	/**
	 * Verifies that the {@link MainActivity} disappears if press on Back
	 * button.
	 * 
	 * <p>
	 * Pressing on Back button scenario:
	 * <ol>
	 * <li>activity is created;</li>
	 * <li><code>mainActivity</code> gets the reference to activity returned
	 * from <code>mainActivityMonitor</code>;</li>
	 * <li>Back button is pressed;</li>
	 * <li>assertion is performed using <code>mainActivity</code> to verify that
	 * it was destroyed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testOnBackPressedInMainActivity() throws InterruptedException {

		Log.i(LOGGER, "Running testOnBackPressedInMainActivity()");

		Thread.sleep(500);

		sendKeys(KeyEvent.KEYCODE_BACK);

		Thread.sleep(1500);

		Activity mainActivity = mainActivityMonitor.getLastActivity();
		assertNull("MainActivity is on screen!..", mainActivity);
	}

	/**
	 * Invokes menu of {@link MainActivity}.
	 * 
	 * <p>
	 * Menu invoking scenario:
	 * <ol>
	 * <li>activity is created;</li>
	 * <li>Menu button is pressed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testMenuOfMainActivity() throws InterruptedException {
		Log.i(LOGGER, "Running testMenuOfMainActivity()");

		sendKeys(KeyEvent.KEYCODE_MENU);

		Thread.sleep(1500);

	}

	/**
	 * Verifies that "About" menu item is invoked.
	 * 
	 * <p>
	 * Menu invoking scenario:
	 * <ol>
	 * <li>"Help" menu is invoked;</li>
	 * <li>Back button is pressed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testInvocationOfAboutMenuOfMainActivity()
			throws InterruptedException {
		Log.i(LOGGER, "Running testInvocationOfAboutMenuOfMainActivity()");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				mainActivityToTest, R.id.menu_main_about, 0));

		Thread.sleep(1500);

		sendKeys(KeyEvent.KEYCODE_BACK);

	}

	/**
	 * Verifies that "Help" menu item is invoked.
	 * 
	 * <p>
	 * Menu invoking scenario:
	 * <ol>
	 * <li>"Help" menu is invoked;</li>
	 * <li>Back button is pressed.</li>
	 * </ol>
	 * 
	 * @throws InterruptedException
	 *             </p>
	 */
	public void testInvocationOfHelpMenuOfMainActivity()
			throws InterruptedException {
		Log.i(LOGGER, "Running testInvocationOfHelpMenuOfMainActivity()");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				mainActivityToTest, R.id.menu_main_help, 0));

		Thread.sleep(1500);

		sendKeys(KeyEvent.KEYCODE_BACK);

	}
}