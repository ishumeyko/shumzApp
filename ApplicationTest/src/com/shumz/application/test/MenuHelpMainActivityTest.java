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

@SuppressWarnings("deprecation")
public class MenuHelpMainActivityTest extends
		ActivityInstrumentationTestCase2<MenuHelpMainActivity> {

	private static final String LOGGER = "menuHelpOfMainActivityTest:";

	private static MenuHelpMainActivity menuHelpOfMainActivityToTest;

	private static LinearLayout lLayoutTop;

	private static TextView tvHelpCont000;

	private static ScrollView sViewMenuHelpContents;

	private static LinearLayout lLayoutMenuHelpContents;

	private static TextView tvHelpCont001;
	private static TextView tvHelpCont002;
	private static TextView tvHelpCont003;
	private static TextView tvHelpCont004;
	private static TextView tvHelpCont005;
	private static TextView tvHelpCont006;

	public MenuHelpMainActivityTest() {
		super(MenuHelpMainActivity.class);
	}

	protected void setUp() throws Exception {

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

		Log.v(LOGGER, "Setting up...");

		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");

	}

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

	public void testLinearLayoutTopOfMainActivityLayoutParameters() {
		Log.i(LOGGER, "Running testLinearLayoutTopOfMainActivityLayoutParameters()");

		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTop.getLayoutParams().height);
		assertEquals(LayoutParams.FILL_PARENT,
				lLayoutTop.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutTop.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutTop, tvHelpCont000);
		ViewAsserts.assertGroupContains(lLayoutTop, sViewMenuHelpContents);

	}

	public void testTextViewHelpCont000OfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewHelpCont000OfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont000.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvHelpCont000.getLayoutParams().width);

		assertEquals("Hello User!", tvHelpCont000.getText().toString());

	}

	public void testScrollViewHelpContentsOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testScrollViewHelpContentsOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				sViewMenuHelpContents.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				sViewMenuHelpContents.getLayoutParams().width);

		// ViewAsserts.assertRightAligned(lLayoutTop, sViewMenuHelpContents,
		// 25);
		// ViewAsserts.assertLeftAligned(lLayoutTop, sViewMenuHelpContents, 25);

	}

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
