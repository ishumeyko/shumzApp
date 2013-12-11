package com.shumz.application.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shumz.application.MenuAboutMainActivity;
import com.shumz.application.R;

/**
 * <h6>MenuAboutMainActivityTest is a class intended to verify layout parameters
 * of views and its values, which are present in {@link MenuAboutMainActivity}
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
 * @see MenuAboutMainActivity
 * 
 * @since Dec 10th, 2013
 */
public class MenuAboutMainActivityTest extends
		ActivityInstrumentationTestCase2<MenuAboutMainActivity> {

	private static final String LOGGER = "menuAboutOfMainActivityTest:";

	/**
	 * Instance of a {@link MenuAboutMainActivity} class under test
	 */
	private static MenuAboutMainActivity menuAboutOfMainActivityToTest;

	/**
	 * Top view of MenuAboutMainActivity class under test
	 */
	private static LinearLayout lLayoutTopView;

	/**
	 * LinearLayout view, which contains App name and App logo
	 */
	private static LinearLayout lLayoutAppLogoAndName;

	/**
	 * ImageView, which is an App logo
	 */
	private static ImageView ivAppLogo;

	/**
	 * LinearLayout view, which contains actual App name and App version
	 */

	private static LinearLayout lLayoutAppName;

	/**
	 * TextView which represents application's name
	 */
	private static TextView tvAppName;

	/**
	 * TextView which represents application's version
	 */
	private static TextView tvAppVersion;

	/**
	 * TextView which represents application's properties
	 */
	private static TextView tvCopyRight;

	/**
	 * TextView which contain "Contacts:" string
	 */
	private static TextView tvContactsStr;

	/**
	 * LinearLayout view, which contains actual contact info
	 */
	private static LinearLayout lLayoutContacts;

	/**
	 * TextView which contains telephone number
	 */
	private static TextView tvPhone;

	/**
	 * TextView which contains Skype login
	 */
	private static TextView tvSkype;

	/**
	 * TextView which contains e-mail
	 */
	private static TextView tvEmail;

	public MenuAboutMainActivityTest() {
		super(MenuAboutMainActivity.class);
	}

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link MenuAboutMainActivity} class members inside this
	 * method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		menuAboutOfMainActivityToTest = getActivity();

		lLayoutTopView = (LinearLayout) menuAboutOfMainActivityToTest
				.findViewById(R.id.llayout_top_view);

		lLayoutAppLogoAndName = (LinearLayout) menuAboutOfMainActivityToTest
				.findViewById(R.id.llayout_app_logo_and_name);
		ivAppLogo = (ImageView) menuAboutOfMainActivityToTest
				.findViewById(R.id.iv_app_logo);
		lLayoutAppName = (LinearLayout) menuAboutOfMainActivityToTest
				.findViewById(R.id.llayout_app_name);

		tvAppName = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_app_name);
		tvAppVersion = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_app_version);

		tvCopyRight = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_copyright);
		tvContactsStr = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_contacts);

		lLayoutContacts = (LinearLayout) menuAboutOfMainActivityToTest
				.findViewById(R.id.llayout_contacts);

		tvPhone = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_phone);
		tvSkype = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_skype);
		tvEmail = (TextView) menuAboutOfMainActivityToTest
				.findViewById(R.id.tv_email);

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
	 * {@link MenuAboutMainActivity}.
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
	public void testAllViewsArePresentOnAboutMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testAllViewsArePresentOnAboutMenuOfMainActivity()");

		assertNotNull("Cannot find menuAboutOfMainActivityToTest!",
				menuAboutOfMainActivityToTest);

		assertNotNull("Cannot find lLayoutTopView!", lLayoutTopView);

		assertNotNull("Cannot find lLayoutAppLogoAndName!",
				lLayoutAppLogoAndName);

		assertNotNull("Cannot find ivAppLogo!", ivAppLogo);
		assertNotNull("Cannot find lLayoutAppName!", lLayoutAppName);

		assertNotNull("Cannot find tvAppName!", tvAppName);
		assertNotNull("Cannot find tvAppVersion!", tvAppVersion);

		assertNotNull("Cannot find tvCopyRight!", tvCopyRight);

		assertNotNull("Cannot find tvContactsStr!", tvContactsStr);

		assertNotNull("Cannot find lLayoutContacts!", lLayoutContacts);

		assertNotNull("Cannot find tvPhone!", tvPhone);
		assertNotNull("Cannot find tvSkype!", tvSkype);
		assertNotNull("Cannot find tvEmail!", tvEmail);

	}

	/**
	 * Verifies the parameters of top layout of {@link MenuAboutMainActivity}.
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
	 * <li>LinearLayout view within the App logo and name;</li>
	 * <li>'Copyright' TextView;</li>
	 * <li>'Contacts:' TextView;</li>
	 * <li>LinearLayout view within the actual contact info.</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutTopViewParametersOfAboutMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testLinearLayoutTopViewParametersOfAboutMenuOfMainActivity()");

		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutTopView.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutTopView.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutTopView.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutTopView, lLayoutAppLogoAndName);
		ViewAsserts.assertGroupContains(lLayoutTopView, tvCopyRight);

		ViewAsserts.assertGroupContains(lLayoutTopView, tvContactsStr);
		ViewAsserts.assertGroupContains(lLayoutTopView, lLayoutContacts);

	}

	/**
	 * Verifies the parameters of linear layout which contains App logo and
	 * name.
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
	 * <li>ImageView which is an App logo;</li>
	 * <li>App name TextView;</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutAppLogoAndNameOfAboutMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testLinearLayoutAppLogoAndNameOfAboutMenuOfMainActivity()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutAppLogoAndName.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutAppLogoAndName.getLayoutParams().width);

		assertEquals(LinearLayout.HORIZONTAL,
				lLayoutAppLogoAndName.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutAppLogoAndName, ivAppLogo);
		ViewAsserts.assertGroupContains(lLayoutAppLogoAndName, lLayoutAppName);

	}

	/**
	 * Verifies the parameters of App logo.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * </ul>
	 * </p>
	 */
	public void testImageViewAppLogoOfAboutMenuOfMainActivity() {
		Log.i(LOGGER, "Running testImageViewAppLogoOfAboutMenuOfMainActivity()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				ivAppLogo.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				ivAppLogo.getLayoutParams().width);

	}

	/**
	 * Verifies the parameters of linear layout which contains App name and App
	 * version.
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
	 * <li>App name TextView;</li>
	 * <li>App version TextView;</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutAppNameOfAboutMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testLinearLayoutAppNameOfAboutMenuOfMainActivity()");

		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutAppName.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutAppName.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutAppName.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutAppName, tvAppName);
		ViewAsserts.assertGroupContains(lLayoutAppName, tvAppVersion);

	}

	/**
	 * Verifies the parameters of App name TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewAppNameOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewAppNameOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppName.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppName.getLayoutParams().width);

		assertEquals("Application", tvAppName.getText().toString());

	}

	/**
	 * Verifies the parameters of App version TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewAppVersionOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewAppVersionOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppVersion.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppVersion.getLayoutParams().width);

		assertEquals("Version: 4.0.0", tvAppVersion.getText().toString());

	}

	/**
	 * Verifies the parameters of 'Copyright' TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewCopyRightOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewCopyRightOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCopyRight.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvCopyRight.getLayoutParams().width);

		assertEquals("Property of ShumzSoft Inc.", tvCopyRight.getText()
				.toString());

	}

	/**
	 * Verifies the parameters of 'Contacts' TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewContactsStringOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsStringOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvContactsStr.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvContactsStr.getLayoutParams().width);

		assertEquals("Contacts:", tvContactsStr.getText().toString());

	}

	/**
	 * Verifies the parameters of linear layout which contains contact info.
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
	 * <li>Phone Number TextView;</li>
	 * <li>Skype account TextVew;</li>
	 * <li>E-mail address TextView.</li>
	 * </ul>
	 * </p>
	 */
	public void testLinearLayoutContactsOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testLinearLayoutContactsOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				lLayoutContacts.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				lLayoutContacts.getLayoutParams().width);

		assertEquals(LinearLayout.VERTICAL, lLayoutContacts.getOrientation());

		ViewAsserts.assertGroupContains(lLayoutContacts, tvPhone);
		ViewAsserts.assertGroupContains(lLayoutContacts, tvSkype);
		ViewAsserts.assertGroupContains(lLayoutContacts, tvEmail);

	}

	/**
	 * Verifies the parameters of Phone number TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewContactsPhoneOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsPhoneOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvPhone.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvPhone.getLayoutParams().width);

		assertEquals("Phone: +38(096) 869–20–99", tvPhone.getText().toString());

	}

	/**
	 * Verifies the parameters of Skype account TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewContactsSkypeOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsSkypeOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSkype.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSkype.getLayoutParams().width);

		assertEquals("Skype: shum_z", tvSkype.getText().toString());

	}

	/**
	 * Verifies the parameters of E-mail address TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testTextViewContactsEmailOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsEmailOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvEmail.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvEmail.getLayoutParams().width);

		assertEquals("E-mail: ishumeyko@cogniance.com", tvEmail.getText()
				.toString());

	}

	// TODO

}