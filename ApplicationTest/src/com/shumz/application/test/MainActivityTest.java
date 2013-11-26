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

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	private static final String LOGGER = "MainActivityTest:";

	private static MainActivity mainActivityToTest;

	private static RelativeLayout rLayoutOfMainActivityTest;
	private static LinearLayout lLayoutButtonToolsTest;

	private static TextView tvGreetingsTest;
	private static TextView tvButtonTools;

	private static ImageView cognianceLogoTest;

	private static Button AlarmButtonTest;
	private static Button StopWatchButtonTest;
	private static Button TimerButtonTest;

	private static ActivityMonitor mainActivityMonitor;
	private static ActivityMonitor alarmActivityMonitor;
	private static ActivityMonitor stopWatchActivityMonitor;
	private static ActivityMonitor timerActivityMonitor;

	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

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

	protected void tearDown() throws Exception {
		super.tearDown();
	}

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

	public void testChangingDeviceOrientationOfMainActivity() {

		Log.i(LOGGER, "Running testChangingDeviceOrientationOfMainActivity()");

		try {
			Thread.sleep(1500);
			mainActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			Thread.sleep(500);

			mainActivityToTest
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			Thread.sleep(1500);

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

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void testRelativeLayoutOfMainActivity() {
		Log.i(LOGGER, "Running testRelativeLayoutOfMainActivity()");

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvGreetingsTest);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				cognianceLogoTest);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvButtonTools);
		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				lLayoutButtonToolsTest);

	}

	public void testTextViewGreetings() {

		Log.i(LOGGER, "Running testTextViewGreetings()");

		assertEquals("Good day, Team!..", tvGreetingsTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvGreetingsTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvGreetingsTest.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutOfMainActivityTest,
				tvGreetingsTest);

		ViewAsserts.assertTopAligned(rLayoutOfMainActivityTest,
				tvGreetingsTest, 21);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfMainActivityTest,
				tvGreetingsTest);

	}

	public void testCognianceLogo() {

		Log.i(LOGGER, "Running testCognianceLogo()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				cognianceLogoTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				cognianceLogoTest.getLayoutParams().width);

		ViewAsserts.assertHorizontalCenterAligned(rLayoutOfMainActivityTest,
				cognianceLogoTest);

		ViewAsserts.assertVerticalCenterAligned(rLayoutOfMainActivityTest,
				cognianceLogoTest);

	}

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

	public void testLinearLayoutButtonTools() {
		Log.i(LOGGER, "Running testLinearLayoutButtonTools()");

		assertEquals(LinearLayout.HORIZONTAL,
				lLayoutButtonToolsTest.getOrientation());

		ViewAsserts
				.assertGroupContains(lLayoutButtonToolsTest, AlarmButtonTest);
		ViewAsserts.assertGroupContains(lLayoutButtonToolsTest,
				StopWatchButtonTest);
		ViewAsserts
				.assertGroupContains(lLayoutButtonToolsTest, TimerButtonTest);

	}

	public void testAlarmButtonProperties() {
		Log.i(LOGGER, "Running testAlarmButtonProperties()");

		assertEquals("Alarm", AlarmButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				AlarmButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				AlarmButtonTest.getLayoutParams().width);

	}

	public void testAlarmButtonOnClick() {

		Log.i(LOGGER, "Running testAlarmButtonOnClick()");

		TouchUtils.clickView(this, AlarmButtonTest);

		Activity alarmActivity = alarmActivityMonitor.getLastActivity();
		assertNotNull("AlarmActivity was not started!..", alarmActivity);

		alarmActivity.finish();

	}

	public void testStopWatchProperties() {
		Log.i(LOGGER, "Running testStopWatchProperties()");

		assertEquals("StopWatch", StopWatchButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				StopWatchButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				StopWatchButtonTest.getLayoutParams().width);

	}

	public void testStopWatchButtonOnClick() {

		Log.i(LOGGER, "Running testStopWatchButtonOnClick()");

		TouchUtils.clickView(this, StopWatchButtonTest);

		Activity stopWatchActivity = stopWatchActivityMonitor.getLastActivity();
		assertNotNull("StopWatchActivity was not Started!!!", stopWatchActivity);

		stopWatchActivity.finish();

	}

	public void testTimerProperties() {
		Log.i(LOGGER, "Running testTimerProperties()");

		assertEquals("Timer", TimerButtonTest.getText().toString());

		assertEquals(LayoutParams.WRAP_CONTENT,
				TimerButtonTest.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				TimerButtonTest.getLayoutParams().width);

	}

	public void testTimerButtonOnClick() {

		Log.i(LOGGER, "Running testTimerButtonOnClick()");

		TouchUtils.clickView(this, TimerButtonTest);

		Activity timerActivity = timerActivityMonitor.getLastActivity();
		assertNotNull("TimerActivity was not Started!!!", timerActivity);

		timerActivity.finish();

	}

	public void testOnBackPressedInMainActivity() {

		Log.i(LOGGER, "Running testOnBackPressedInMainActivity()");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendKeys(KeyEvent.KEYCODE_BACK);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Activity mainActivity = mainActivityMonitor.getLastActivity();
		assertNull("MainActivity is on screen!..", mainActivity);
	}

	public void testMenuOfMainActivity() {
		Log.i(LOGGER, "Running testMenuOfMainActivity()");

		sendKeys(KeyEvent.KEYCODE_MENU);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testInvocationOfAboutMenuOfMainActivity() {
		Log.i(LOGGER, "Running testInvocationOfAboutMenuOfMainActivity()");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				mainActivityToTest, R.id.menu_main_about, 0));

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendKeys(KeyEvent.KEYCODE_BACK);

	}

	public void testInvocationOfHelpMenuOfMainActivity() {
		Log.i(LOGGER, "Running testInvocationOfHelpMenuOfMainActivity()");

		assertTrue(getInstrumentation().invokeMenuActionSync(
				mainActivityToTest, R.id.menu_main_help, 0));

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sendKeys(KeyEvent.KEYCODE_BACK);

	}
}