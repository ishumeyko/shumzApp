package com.shumz.application.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.test.ViewAsserts;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.shumz.application.R;
import com.shumz.application.TimerEndOfTimeDialogActivity;

public class TimerEndOfTimeDialogActivityTest extends
		ActivityInstrumentationTestCase2<TimerEndOfTimeDialogActivity> {

	private static final String LOGGER = "TimerEndOfTimeDialogActivityTest:";

	private static TimerEndOfTimeDialogActivity TimerEndOfTimeDialogActivityToTest;

	private static RelativeLayout rLayoutTimerEndOfTimeDialogTopView;
	private static LinearLayout lLayoutTimerEndOfTimeDialog;

	private static TextView tvTimeIsUpTextView;

	private static Button dismissButtonOfTimerEndOfTimeDialog;

	private static ActivityMonitor TimerEndOfTimeDialogActivityMonytor;

	public TimerEndOfTimeDialogActivityTest() {
		super(TimerEndOfTimeDialogActivity.class);

	}

	protected void setUp() throws Exception {
		Log.v(LOGGER, "Setting up...");
		super.setUp();

		TimerEndOfTimeDialogActivityToTest = getActivity();

		rLayoutTimerEndOfTimeDialogTopView = (RelativeLayout) TimerEndOfTimeDialogActivityToTest
				.findViewById(R.id.rlayout_timer_end_of_time_dialog_top_view);

		lLayoutTimerEndOfTimeDialog = (LinearLayout) TimerEndOfTimeDialogActivityToTest
				.findViewById(R.id.llayout_timer_end_of_time_dialog);

		tvTimeIsUpTextView = (TextView) TimerEndOfTimeDialogActivityToTest
				.findViewById(R.id.tv_timer_end_of_time_dialog_time_is_up);

		dismissButtonOfTimerEndOfTimeDialog = (Button) TimerEndOfTimeDialogActivityToTest
				.findViewById(R.id.button_timer_end_of_time_dialog_dismiss_dialog);

		TimerEndOfTimeDialogActivityMonytor = new ActivityMonitor(
				TimerEndOfTimeDialogActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(TimerEndOfTimeDialogActivityMonytor);

	}

	protected void tearDown() throws Exception {
		Log.v(LOGGER, "Tearing down...");
		super.tearDown();

	}

	public void testAllViewsArePresentOnTimerEndOfTimeDialogActivity() {
		Log.i(LOGGER,
				"Running testAllViewsArePresentOnTimerEndOfTimeDialogActivity()");

		assertNotNull("Cannot find TimerEndOfTimeDialogActivityToTest!",
				TimerEndOfTimeDialogActivityToTest);

		assertNotNull("Cannot find rLayoutTimerEndOfTimeDialogTopView!",
				rLayoutTimerEndOfTimeDialogTopView);

		assertNotNull("Cannot find lLayoutTimerEndOfTimeDialog!",
				lLayoutTimerEndOfTimeDialog);

		assertNotNull("Cannot find tvTimeIsUpTextView!", tvTimeIsUpTextView);

		assertNotNull("Cannot find dismissButtonOfTimerEndOfTimeDialog!",
				dismissButtonOfTimerEndOfTimeDialog);

	}

	public void testRLayoutTimerEndOfTimeDialogTopViewLayoutParameters() {
		Log.i(LOGGER,
				"Running testRLayoutTimerEndOfTimeDialogTopViewLayoutParameters()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerEndOfTimeDialogTopView.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rLayoutTimerEndOfTimeDialogTopView.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rLayoutTimerEndOfTimeDialogTopView,
				lLayoutTimerEndOfTimeDialog);

	}

	public void testLLayoutOfTimerEndOfTimeDialogLayoutParameters() {
		Log.i(LOGGER,
				"Running testLLayoutOfTimerEndOfTimeDialogLayoutParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutTimerEndOfTimeDialog.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutTimerEndOfTimeDialog.getLayoutParams().width);

		ViewAsserts
				.assertHorizontalCenterAligned(
						rLayoutTimerEndOfTimeDialogTopView,
						lLayoutTimerEndOfTimeDialog);
		ViewAsserts
				.assertVerticalCenterAligned(
						rLayoutTimerEndOfTimeDialogTopView,
						lLayoutTimerEndOfTimeDialog);

		ViewAsserts.assertGroupContains(lLayoutTimerEndOfTimeDialog,
				tvTimeIsUpTextView);
		ViewAsserts.assertGroupContains(lLayoutTimerEndOfTimeDialog,
				dismissButtonOfTimerEndOfTimeDialog);

	}

	public void testTimeIsUpTextViewOfTimerEndOfTimeDialogParameters() {
		Log.i(LOGGER,
				"Running testTimeIsUpTextViewOfTimerEndOfTimeDialogParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTimeIsUpTextView.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvTimeIsUpTextView.getLayoutParams().width);

		assertEquals("Time is up!", tvTimeIsUpTextView.getText().toString());

		assertEquals(Color.BLACK, tvTimeIsUpTextView.getCurrentTextColor());

		assertEquals(Typeface.MONOSPACE, tvTimeIsUpTextView.getTypeface());
	}

	public void testDismissButtonOfTimerEndOfTimeDialogParameters() {
		Log.i(LOGGER,
				"Running testDismissButtonOfTimerEndOfTimeDialogParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				dismissButtonOfTimerEndOfTimeDialog.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				dismissButtonOfTimerEndOfTimeDialog.getLayoutParams().width);

		assertEquals("Dismiss", dismissButtonOfTimerEndOfTimeDialog.getText()
				.toString());

		assertEquals(Typeface.MONOSPACE,
				dismissButtonOfTimerEndOfTimeDialog.getTypeface());
	}

	public void testTimerEndOfTimeDialogIfChangeDeviceOrientation()
			throws Exception {
		Log.i(LOGGER,
				"Running testTimerEndOfTimeDialogIfChangeDeviceOrientation()");

		TimerEndOfTimeDialogActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		Thread.sleep(1000);

		TimerEndOfTimeDialogActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Thread.sleep(1000);

		TimerEndOfTimeDialogActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		Thread.sleep(1000);

		Activity TEndOfTimeDialogActivity = TimerEndOfTimeDialogActivityMonytor
				.getLastActivity();
		assertNotNull("TimerEndOfTimeDialogActivityMonytor was not Started!!!",
				TEndOfTimeDialogActivity);

		assertSame(TEndOfTimeDialogActivity.getClass().getName(), getActivity()
				.getClass().getName());

		getInstrumentation().removeMonitor(TimerEndOfTimeDialogActivityMonytor);

		dismissButtonOfTimerEndOfTimeDialog.performClick();

	}

	public void testTouchingOutsideOfDialog() throws Exception {
		Log.i(LOGGER, "Running testTouchingOutsideOfDialog()");

		Thread.sleep(1000);

		tvTimeIsUpTextView.requestFocus();
		TouchUtils.clickView(this, tvTimeIsUpTextView);

		Thread.sleep(1000);

	}

	@UiThreadTest
	public void testSomething() throws Exception {
		Log.i(LOGGER, "Running testSomething()");

		Thread.sleep(1000);

		dismissButtonOfTimerEndOfTimeDialog.requestFocus();
		dismissButtonOfTimerEndOfTimeDialog.performClick();

		if (!TimerEndOfTimeDialogActivityToTest.isFinishing()) {
			fail();
		}

	}

}
