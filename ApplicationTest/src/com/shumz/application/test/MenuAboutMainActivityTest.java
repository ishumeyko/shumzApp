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

public class MenuAboutMainActivityTest extends
		ActivityInstrumentationTestCase2<MenuAboutMainActivity> {

	private static final String LOGGER = "menuAboutOfMainActivityTest:";

	MenuAboutMainActivity menuAboutOfMainActivityToTest;

	private static LinearLayout lLayoutTopView;

	private static LinearLayout lLayoutAppLogoAndName;
	private static ImageView ivAppLogo;
	private static LinearLayout lLayoutAppName;

	private static TextView tvAppName;
	private static TextView tvAppVersion;

	private static TextView tvCopyRight;
	private static TextView tvContactsStr;

	private static LinearLayout lLayoutContacts;

	private static TextView tvPhone;
	private static TextView tvSkype;
	private static TextView tvEmail;

	// TODO

	public MenuAboutMainActivityTest() {
		super(MenuAboutMainActivity.class);
	}

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

	protected void tearDown() throws Exception {
		super.tearDown();

		Log.v(LOGGER, "Tearing down...");
	}

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

	public void testLinearLayoutTopViewOfAboutMenuOfMainActivity() {
		Log.i(LOGGER,
				"Running testLinearLayoutTopViewOfAboutMenuOfMainActivity()");

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

	public void testImageViewAppLogoOfAboutMenuOfMainActivity() {
		Log.i(LOGGER, "Running testImageViewAppLogoOfAboutMenuOfMainActivity()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				ivAppLogo.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				ivAppLogo.getLayoutParams().width);

	}

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

	public void testTextViewAppNameOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewAppNameOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppName.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppName.getLayoutParams().width);

		assertEquals("Application", tvAppName.getText().toString());

	}

	public void testTextViewAppVersionOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewAppVersionOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppVersion.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvAppVersion.getLayoutParams().width);

		assertEquals("Version: 3.0", tvAppVersion.getText().toString());

	}

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

	public void testTextViewContactsStringOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsStringOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvContactsStr.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvContactsStr.getLayoutParams().width);

		assertEquals("Contacts:", tvContactsStr.getText().toString());

	}

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

	public void testTextViewContactsPhoneOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsPhoneOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvPhone.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvPhone.getLayoutParams().width);

		assertEquals("Phone: +38(096) 869–20–99", tvPhone.getText().toString());

	}

	public void testTextViewContactsSkypeOfAboutMenuOfMainActivityParameters() {
		Log.i(LOGGER,
				"Running testTextViewContactsSkypeOfAboutMenuOfMainActivityParameters()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSkype.getLayoutParams().height);
		assertEquals(LayoutParams.WRAP_CONTENT, tvSkype.getLayoutParams().width);

		assertEquals("Skype: shum_z", tvSkype.getText().toString());

	}

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