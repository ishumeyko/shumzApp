package com.shumz.application.test;

import com.shumz.application.MenuStopWatchQS;
import com.shumz.application.R;

import android.graphics.Typeface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MenuStopWatchQSTest extends
		ActivityInstrumentationTestCase2<MenuStopWatchQS> {

	private static final String LOGGER = "menuQuickStartOfStopWatchActivityTest:";

	private static MenuStopWatchQS MenuStopWatchQSToTest;

	private static LinearLayout lLayoutTopView;

	private static TextView tvWhatCanItDo;

	private static ScrollView svSWatchInfo;

	private static TextView tvSWatchInfo;

	public MenuStopWatchQSTest() {
		super(MenuStopWatchQS.class);
	}

	protected void setUp() throws Exception {
		Log.v(LOGGER, "Setting up...");

		super.setUp();

		MenuStopWatchQSToTest = getActivity();

		lLayoutTopView = (LinearLayout) MenuStopWatchQSToTest
				.findViewById(R.id.ll_swatch_qs_top_view);

		tvWhatCanItDo = (TextView) MenuStopWatchQSToTest
				.findViewById(R.id.tv_swatch_what_it_can_do_sw_qs_str);

		svSWatchInfo = (ScrollView) MenuStopWatchQSToTest
				.findViewById(R.id.sv_swatch_qs_info);

		tvSWatchInfo = (TextView) MenuStopWatchQSToTest
				.findViewById(R.id.tv_swatch_info);

	}

	protected void tearDown() throws Exception {
		Log.v(LOGGER, "Tearing down...");
		super.tearDown();
	}

	public void testAllViewsArePresentOnQuickStartMenuOfStopWatchActivity() {
		Log.i(LOGGER,
				"Running testAllViewsArePresentOnQuickStartMenuOfStopWatchActivity()");

		assertNotNull("Cannot find MenuStopWatchQSToTest!",
				MenuStopWatchQSToTest);
		assertNotNull("Cannot find lLayoutTopView!", lLayoutTopView);
		assertNotNull("Cannot find tvWhatCanItDo!", tvWhatCanItDo);
		assertNotNull("Cannot find svSWatchInfo!", svSWatchInfo);
		assertNotNull("Cannot find tvSWatchInfo!", tvSWatchInfo);

	}

	public void testLinearLayoutTopViewOfQuickStartMenuOfStopWatchActivity() {
		Log.i(LOGGER,
				"Running testLinearLayoutTopViewOfQuickStartMenuOfStopWatchActivity()");

		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTopView.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTopView.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutTopView.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutTopView, tvWhatCanItDo);
		ViewAsserts.assertGroupContains(lLayoutTopView, svSWatchInfo);

	}

	public void testTextViewWhatCanItDoOfQuickStartMenuOfStopWatchActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewWhatCanItDoOfQuickStartMenuOfStopWatchActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvWhatCanItDo.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvWhatCanItDo.getLayoutParams().width);

		assertEquals("What it is actually:", tvWhatCanItDo.getText().toString());

		assertEquals(Typeface.MONOSPACE, tvWhatCanItDo.getTypeface());

	}

	public void testScrollViewSWatchQSInfoOfStopWatchActivityParameters() {
		Log.i(LOGGER,
				"Running testScrollViewSWatchQSInfoOfStopWatchActivityParameters()");

		// assertEquals(LayoutParams.WRAP_CONTENT,
		// svSWatchInfo.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				svSWatchInfo.getLayoutParams().width);

		ViewAsserts.assertGroupContains(svSWatchInfo, tvSWatchInfo);

	}

	public void testTextViewSWatchQSInfoOfStopWatchActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewSWatchQSInfoOfStopWatchActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSWatchInfo.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvSWatchInfo.getLayoutParams().width);

		assertEquals(
				"This is a Stopwatch that can be used for precise time measurments.\n 1. Time output: it has \'HhH:MM:SS:msms\' format to show time.\n 2. Current time: biggest digits. hours, minutes, seconds - green color; millisecond - red color.\n 3. Buttons:\n Catch - catch current time snapshot.\n Start - begin/resume time measurement cycle.\n Reset - set current time measurement cycle to zero.\n Stop - stop/pause current time cycle.\n Clear - clear all cycles and measures.\n",
				tvSWatchInfo.getText().toString());

	}

}
