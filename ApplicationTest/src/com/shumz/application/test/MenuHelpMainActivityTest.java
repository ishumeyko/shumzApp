package com.shumz.application.test;

import android.graphics.Typeface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shumz.application.MenuHelpMainActivity;
import com.shumz.application.R;

/**
 * <h6>MenuHelpMainActivityTest is a class intended to verify layout parameters
 * of views and its values, which are present in {@link MenuHelpMainActivity}
 * class</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods, which
 * assert layout parameters of views and their String values.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see MenuHelpMainActivity
 * 
 * @since Dec 11th, 2013
 */
@SuppressWarnings("deprecation")
public class MenuHelpMainActivityTest extends
		ActivityInstrumentationTestCase2<MenuHelpMainActivity> {

	private static final String LOGGER = "menuHelpOfMainActivityTest:";

	/**
	 * Instance of a {@link MenuHelpMainActivity} class under test
	 */
	private static MenuHelpMainActivity menuHelpOfMainActivityToTest;

	/**
	 * Top view of {@link MenuHelpMainActivity} class under test
	 */
	private static LinearLayout lLayoutTop;

	/**
	 * Header TextView to test
	 */
	private static TextView tvHelpCont000;

	/**
	 * ScrollView which contains help content to test
	 */
	private static ScrollView sViewMenuHelpContents;

	/**
	 * LinearLayout which contains to test
	 */
	private static LinearLayout lLayoutMenuHelpContents;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont001;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont002;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont003;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont004;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont005;

	/**
	 * TextView with the help content to test
	 */
	private static TextView tvHelpCont006;

	public MenuHelpMainActivityTest() {
		super(MenuHelpMainActivity.class);
	}

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link MenuHelpMainActivity} class members inside this
	 * method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {

		super.setUp();

		Log.v(LOGGER, "Setting up...");

		menuHelpOfMainActivityToTest = getActivity();

		lLayoutTop = (LinearLayout) menuHelpOfMainActivityToTest
				.findViewById(R.id.llayout_top);

		tvHelpCont000 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_000);

		sViewMenuHelpContents = (ScrollView) menuHelpOfMainActivityToTest
				.findViewById(R.id.sc_menu_activity_main_help_contents);

		lLayoutMenuHelpContents = (LinearLayout) menuHelpOfMainActivityToTest
				.findViewById(R.id.ll_menu_activity_main_help_contents);

		tvHelpCont001 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_001);
		tvHelpCont002 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_002);
		tvHelpCont003 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_003);
		tvHelpCont004 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_004);
		tvHelpCont005 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_005);
		tvHelpCont006 = (TextView) menuHelpOfMainActivityToTest
				.findViewById(R.id.tv_menu_activity_main_help_content_006);

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
	public void testAllViewsArePresentOnHelpMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testAllViewsArePresentOnHelpMenuOfMainActivity()");

		assertNotNull("Cannot find menuHelpOfMainActivityToTest!",
				menuHelpOfMainActivityToTest);

		assertNotNull("Cannot find lLayoutTop!", lLayoutTop);

		assertNotNull("Cannot find tvHelpCont000!", tvHelpCont000);

		assertNotNull("Cannot find sViewMenuHelpContents!",
				sViewMenuHelpContents);

		assertNotNull("Cannot find lLayoutMenuHelpContents!",
				lLayoutMenuHelpContents);

		assertNotNull("Cannot find tvHelpCont001!", tvHelpCont001);
		assertNotNull("Cannot find tvHelpCont002!", tvHelpCont002);
		assertNotNull("Cannot find tvHelpCont003!", tvHelpCont003);
		assertNotNull("Cannot find tvHelpCont004!", tvHelpCont004);
		assertNotNull("Cannot find tvHelpCont005!", tvHelpCont005);
		assertNotNull("Cannot find tvHelpCont006!", tvHelpCont006);

	}

	/**
	 * Verifies the parameters of top layout of {@link MenuHelpMainActivity}.
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
	public void testLinearLayoutTopOfMainActivityLayoutParameters() {
		Log.i(LOGGER,
				"Running testLinearLayoutTopOfMainActivityLayoutParameters()");

		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTop.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTop.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutTop.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutTop, tvHelpCont000);
		ViewAsserts.assertGroupContains(lLayoutTop, sViewMenuHelpContents);

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
	public void testTextViewHelpCont000OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont000OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont000.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont000.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont000.getTypeface());

		assertEquals("Hello User!", tvHelpCont000.getText().toString());

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
	 * <li>Help contents LinearLayout.</li>
	 * </ul>
	 * </p>
	 */
	public void testScrollViewHelpContentsOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testScrollViewHelpContentsOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				sViewMenuHelpContents.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				sViewMenuHelpContents.getLayoutParams().width);

		ViewAsserts.assertGroupContains(sViewMenuHelpContents,
				lLayoutMenuHelpContents);

	}

	/**
	 * Verifies the parameters of LinearLayout which includes TextViews with
	 * help content.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts layout orientation of this view.</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutHelpContentsOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testLinearLayoutHelpContentsOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutMenuHelpContents.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutMenuHelpContents.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL,
				lLayoutMenuHelpContents.getOrientation());

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
	public void testTextViewHelpCont001OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont001OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont001.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont001.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont001.getTypeface());

		assertEquals(
				"This is a simple \n \'Hello World\' \n application, which was created just for fun.",
				tvHelpCont001.getText().toString());

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
	public void testTextViewHelpCont002OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont001OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont002.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont002.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont002.getTypeface());

		assertEquals("There are following features available in this app:",
				tvHelpCont002.getText().toString());

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
	public void testTextViewHelpCont003OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont003OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont003.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont003.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont003.getTypeface());

		assertEquals("-> Alarm;", tvHelpCont003.getText().toString());

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
	public void testTextViewHelpCont004OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont004OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont004.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont004.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont004.getTypeface());

		assertEquals("-> StopWatch;", tvHelpCont004.getText().toString());

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
	public void testTextViewHelpCont005OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont005OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont005.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont005.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont005.getTypeface());

		assertEquals("-> Timer;", tvHelpCont005.getText().toString());

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
	public void testTextViewHelpCont006OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont006OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont006.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				tvHelpCont006.getLayoutParams().width);

		assertEquals(Typeface.MONOSPACE, tvHelpCont006.getTypeface());

		assertEquals("enjoy!..", tvHelpCont006.getText().toString());

	}

}
