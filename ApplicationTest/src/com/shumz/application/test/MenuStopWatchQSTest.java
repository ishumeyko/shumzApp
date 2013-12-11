package com.shumz.application.test;

import com.shumz.application.MenuHelpMainActivity;
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

/**
 * <h6>MenuStopWatchQSTest is a class intended to verify layout parameters of
 * views and its values, which are present in {@link MenuStopWatchQS} class</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods, which
 * assert layout parameters of views and their String values.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see MenuStopWatchQS
 * 
 * @since Dec 11th, 2013
 */
@SuppressWarnings("deprecation")
public class MenuStopWatchQSTest extends
		ActivityInstrumentationTestCase2<MenuStopWatchQS> {

	private static final String LOGGER = "menuQuickStartOfStopWatchActivityTest:";

	/**
	 * Instance of a {@link MenuStopWatchQS} class under test
	 */
	private static MenuStopWatchQS MenuStopWatchQSToTest;

	/**
	 * Top view of {@link MenuHelpMainActivity} class under test
	 */
	private static LinearLayout lLayoutTopView;

	/**
	 * Header TextView to test
	 */
	private static TextView tvWhatCanItDo;

	/**
	 * ScrollView which contains help content to test
	 */
	private static ScrollView svSWatchInfo;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvSWatchInfo;

	public MenuStopWatchQSTest() {
		super(MenuStopWatchQS.class);
	}

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link MenuStopWatchQS} class members inside this method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
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
	 * {@link MenuHelpMainActivity}.
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

	/**
	 * Verifies the parameters of top layout of {@link MenuStopWatchQS}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts layout orientation of this view.</li>
	 * </ul>
	 * <br>
	 * Asserts that this View contains following sub-views:
	 * <ul>
	 * <li>Header TextVew;</li>
	 * <li>Help contents ScrollView.</li>
	 * </ul>
	 * </p>
	 */
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

	/**
	 * Verifies the parameters of Header TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts typeface parameter of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
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

	/**
	 * Verifies the parameters of ScrollView which contains help content.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view.</li>
	 * </ul>
	 * <br>
	 * Asserts that this View contains following sub-views:
	 * <ul>
	 * <li>Help contents TextView.</li>
	 * </ul>
	 * </p>
	 */
	public void testScrollViewSWatchQSInfoOfStopWatchActivityParameters() {
		Log.i(LOGGER,
				"Running testScrollViewSWatchQSInfoOfStopWatchActivityParameters()");

		// assertEquals(LayoutParams.WRAP_CONTENT,
		// svSWatchInfo.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				svSWatchInfo.getLayoutParams().width);

		ViewAsserts.assertGroupContains(svSWatchInfo, tvSWatchInfo);

	}

	/**
	 * Verifies the parameters of Help content TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts typeface parameter of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewSWatchQSInfoOfStopWatchActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewSWatchQSInfoOfStopWatchActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSWatchInfo.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvSWatchInfo.getLayoutParams().width);

		assertEquals(Typeface.SERIF, tvSWatchInfo.getTypeface());

		assertEquals(
				"This is a Stopwatch that can be used for precise time measurments.\n 1. Time output: it has \'HhH:MM:SS:msms\' format to show time.\n 2. Current time: biggest digits. hours, minutes, seconds - green color; millisecond - red color.\n 3. Buttons:\n Catch - catch current time snapshot.\n Start - begin/resume time measurement cycle.\n Reset - set current time measurement cycle to zero.\n Stop - stop/pause current time cycle.\n Clear - clear all cycles and measures.\n",
				tvSWatchInfo.getText().toString());

	}

}
