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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shumz.application.MainActivity;
import com.shumz.application.R;
import com.shumz.application.SplashActivity;

/**
 * <h6>SplashActivityTest is a class intended to verify layout parameters of
 * views and behavior of activity after changing device's orientation of the
 * device.</h6>
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;This class contains several test methods intended to
 * verify layout parameters of views, behavior of activity after changing
 * device's orientation, assertion of launching of {@link MainActivity} after
 * timeout.
 * </p>
 * 
 * @author Igor Shumeyko
 * @version 4.0.0
 * 
 * @see SplashActivity
 * @see MainActivity
 * 
 * @since Dec 14th, 2013
 */
public class SplashActivityTest extends
		ActivityInstrumentationTestCase2<SplashActivity> {

	public SplashActivityTest() {
		super(SplashActivity.class);
	}

	private static final String LOGGER = "SplashActivityTest:";

	/**
	 * Instance of a {@link SplashActivity} class under test
	 */
	private static SplashActivity splashActivityToTest;

	/**
	 * Top view of {@link SplashActivity} class under test
	 */
	private static RelativeLayout rlSplashLayout;

	/**
	 * TextView with the "Property.." text under test
	 */
	private static TextView tvSplashActivityPropertyOf;

	/**
	 * TextView with the "ShumzSoft" text under test
	 */
	private static TextView tvSplashActivityShumzSoft;

	/**
	 * ImageView which contains app logo to test
	 */
	private static ImageView chuckskullImage;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link MainActivity}
	 */
	private static ActivityMonitor mainActivityMonitor;

	/**
	 * Activity monitor intended to look for the creation of an
	 * {@link SplashActivity}
	 */
	private static ActivityMonitor splashAcitvityMonitor;

	/**
	 * <p>
	 * Overridden <code>setup()</code> method. Invoked before each test run.
	 * </p>
	 * 
	 * <p>
	 * &nbsp;&nbsp;&nbsp;&nbsp;All instances of objects are initialized with the
	 * references of {@link SplashActivity} class members inside this method.
	 * </p>
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		Log.v(LOGGER, "Setting up...");

		splashActivityToTest = getActivity();

		rlSplashLayout = (RelativeLayout) splashActivityToTest
				.findViewById(R.id.splash_layout);

		tvSplashActivityPropertyOf = (TextView) splashActivityToTest
				.findViewById(R.id.tv_splash_activity_property_of);
		tvSplashActivityShumzSoft = (TextView) splashActivityToTest
				.findViewById(R.id.tv_splash_activity_shumz_soft_inc);

		chuckskullImage = (ImageView) splashActivityToTest
				.findViewById(R.id.image_chuckskull);

		mainActivityMonitor = new ActivityMonitor(MainActivity.class.getName(),
				null, false);
		getInstrumentation().addMonitor(mainActivityMonitor);

		splashAcitvityMonitor = new ActivityMonitor(
				SplashActivity.class.getName(), null, false);
		getInstrumentation().addMonitor(splashAcitvityMonitor);

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
	 * <p>
	 * Special case for {@link SplashActivity}:<br>
	 * SplashActivity's implementation causes launching of MainActivity after
	 * timeout or after touching on screen. So, when you're running these tests,
	 * MainActivity will be started each time when SplashActivity was killed
	 * after completing each test. This situation prevents normal cleanup -
	 * current activity is not an activity that was launched at the beginning of
	 * test run. So further execution of test run becomes impossible.<br>
	 * If you're running each test separately then everything is OK - tests will
	 * be run and completed normally. But if you try to run whole test suite
	 * then tests will fail or test run will be stacked on definite test.<br>
	 * To solve this problem {@link ActivityMonitor} which looking for creation
	 * of {@link MainActivity} is used inside <code>tearDown()</code> method:<br>
	 * <br>
	 * 
	 * <pre>
	 * <code>
	 * if (getActivity().getClass().getName()
	 * 		.equals("com.shumz.application.MainActivity")) {
	 * 			mainActivityMonitor.getLastActivity().finish();
	 * } else { 
	 * 			mainActivityMonitor.waitForActivity().finish();
	 * }
	 * </code>
	 * </pre>
	 * 
	 * <p>
	 * After end of each test <code>tearDown()</code> is invoked and inside this
	 * method <code>mainActivityMonitor</code> following condition is used:<br>
	 * <ul>
	 * <li>if current activity is {@link MainActivity} then
	 * <code>mainActivityMonitor.getLastActivity().finish()</code> code is
	 * executed, which causes finishing of main activity.</li>
	 * <li>if current activity is not {@link MainActivity} then
	 * <code>mainActivityMonitor.waitForActivity().finish()</code> code is
	 * executed. <code>mainActivityMonitor</code> waiting until
	 * {@link MainActivity} will be appeared and then finishing it.</li>
	 * </ul>
	 * 
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {

		if (getActivity().getClass().getName()
				.equals("com.shumz.application.MainActivity")) {

			mainActivityMonitor.getLastActivity().finish();

		} else {

			mainActivityMonitor.waitForActivity().finish();

		}

		super.tearDown();
	}

	/**
	 * Asserts that all views are initialized and present on
	 * {@link SplashActivity}.
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
	public void testAllWiewsArePresentOnSplashActivity() {
		Log.i(LOGGER, "Running testAllWiewsArePresent()");

		assertNotNull("Cannot find SplashAcitvity!", splashActivityToTest);
		assertNotNull("Cannot find llSplashLayout!", rlSplashLayout);
		assertNotNull("Cannot find tvSplashActivityPropertyOf!",
				tvSplashActivityPropertyOf);
		assertNotNull("Cannot find tvSplashActivityShumzSoft!",
				tvSplashActivityShumzSoft);
		assertNotNull("Cannot find ÑhuckskullImage!", chuckskullImage);
	}

	/**
	 * Verifies the parameters of top layout of {@link SplashActivity}.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this View.</li>
	 * </ul>
	 * <br>
	 * Asserts that this View contains following sub-views:
	 * <ul>
	 * <li>"PropertyOf" TextView;</li>
	 * <li>"ShumzSoft.." TextView;</li>
	 * <li>app logo ImageView.</li>
	 * </ul>
	 * </p>
	 */
	public void testRelativeLayoutParametersOfSplashActivity() {

		Log.i(LOGGER, "Running testRelativeLayoutParametersOfSplashActivity()");

		assertEquals(LayoutParams.MATCH_PARENT,
				rlSplashLayout.getLayoutParams().height);
		assertEquals(LayoutParams.MATCH_PARENT,
				rlSplashLayout.getLayoutParams().width);

		ViewAsserts.assertGroupContains(rlSplashLayout,
				tvSplashActivityPropertyOf);
		ViewAsserts.assertGroupContains(rlSplashLayout,
				tvSplashActivityShumzSoft);
		ViewAsserts.assertGroupContains(rlSplashLayout, chuckskullImage);

	}

	/**
	 * Verifies the parameters of 'ShumzSoft' TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that this view is under
	 * <code>tvSplashActivityPropertyOf</code> TextView;</li>
	 * <li>asserts that this view is horizontally centered;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testParametersOftvSplashActivityShumzSoft() {
		Log.i(LOGGER, "Running testParametersOftvSplashActivityShumzSoft()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityShumzSoft.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityShumzSoft.getLayoutParams().height);

		assertEquals(tvSplashActivityPropertyOf.getBottom(),
				tvSplashActivityShumzSoft.getTop());

		ViewAsserts.assertHorizontalCenterAligned(rlSplashLayout,
				tvSplashActivityShumzSoft);

		assertEquals("ShumzSoft Inc.", tvSplashActivityShumzSoft.getText()
				.toString());

	}

	/**
	 * Verifies the parameters of 'PropertyOf' TextView.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that this view is vertically centered;</li>
	 * <li>asserts that this view is horizontally centered;</li>
	 * <li>asserts that text of this view is equal to expected.</li>
	 * </ul>
	 * </p>
	 */
	public void testParametersOftvSplashActivityPropertyOf() {
		Log.i(LOGGER, "Running testParametersOftvSplashActivityPropertyOf()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityPropertyOf.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				tvSplashActivityPropertyOf.getLayoutParams().height);

		ViewAsserts.assertVerticalCenterAligned(rlSplashLayout,
				tvSplashActivityPropertyOf);
		ViewAsserts.assertHorizontalCenterAligned(rlSplashLayout,
				tvSplashActivityPropertyOf);

		assertEquals("Property of", tvSplashActivityPropertyOf.getText()
				.toString());

	}

	/**
	 * Verifies the parameters of App logo.
	 * 
	 * <p>
	 * This test verifies following:
	 * <ul>
	 * <li>asserts layout parameters of this view;</li>
	 * <li>asserts that this view is a child of top view of
	 * {@link SplashActivity}.</li>
	 * </ul>
	 * </p>
	 */
	public void testParametersOfChuckskullImage() {
		Log.i(LOGGER, "Running testParametersOfChuckskullImage()");

		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().width);
		assertEquals(LayoutParams.WRAP_CONTENT,
				chuckskullImage.getLayoutParams().height);

		ViewAsserts.assertGroupContains(rlSplashLayout, chuckskullImage);

	}

	/**
	 * Verifies that {@link MainActivity} is automatically launched right after
	 * {@link SplashActivity}
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Application is launched;</li>
	 * <li>Test runner waits for timeout;</li>
	 * <li>Test runner asserts that new activity is create and it is
	 * {@link MainActivity}.</li>
	 * </ol>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void testCleanLaunch() throws InterruptedException {
		Log.i(LOGGER, "Running testCleanLaunch()");

		Thread.sleep(8500);

		Activity mainMenuActivity = mainActivityMonitor.getLastActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	/**
	 * Verifies that {@link MainActivity} is automatically launched right after
	 * {@link SplashActivity}
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Application is launched;</li>
	 * <li>Test runner waits for timeout;</li>
	 * <li>Test runner asserts that new activity is created and it is
	 * {@link MainActivity}.</li>
	 * </ol>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void testOnTouchSkippingActivity() throws InterruptedException {
		Log.i(LOGGER, "Running testOnTouchSkippingActivity()");

		Thread.sleep(1000);

		TouchUtils.clickView(this, chuckskullImage);

		Thread.sleep(1000);

		Activity mainMenuActivity = mainActivityMonitor.getLastActivity();
		assertNotNull("MainMenuActivity was not Started!!!", mainMenuActivity);

	}

	/**
	 * Verifies that {@link SplashActivity} does not disappear after pressing on
	 * hardware Back button.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Application is launched;</li>
	 * <li>Back button is presses three times with 1 sec. interval;</li>
	 * <li>Test runner asserts that {@link SplashActivity} is still present on
	 * screen.</li>
	 * </ol>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void testOnBackPressed() throws InterruptedException {

		Log.i(LOGGER, "Running testOnTouchSkippingActivity()");

		for (int i = 0; i < 3; i++) {

			Thread.sleep(1000);

			sendKeys(KeyEvent.KEYCODE_BACK);

		}

		assertNotNull("SplachActivity is finished!..", splashActivityToTest);

		// mainActivityMonitor.waitForActivity().finish();

	}

	/**
	 * Changes device's orientation several times.
	 * 
	 * <p>
	 * Scenario:<br>
	 * <ol>
	 * <li>Application is launched;</li>
	 * <li>Test runner changes programmatically device's orientation from
	 * portrait to landscape and backwards.</li>
	 * </ol>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	public void testChangingDeviceOrientationOfSplashActivity()
			throws InterruptedException {

		Log.i(LOGGER, "Running testChangingDeviceOrientationOfSplashActivity()");

		Thread.sleep(1500);
		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Thread.sleep(500);

		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread.sleep(1500);

		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Thread.sleep(500);
		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread.sleep(500);
		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
		Thread.sleep(500);
		splashActivityToTest
				.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);

	}

}
