package com.shumz.application;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StopWatchAdvanced extends Activity {

	// Time elapsed from boot of Device
	long start_time_handler = SystemClock.elapsedRealtime(); // Is used by
																// Handlers for
																// Chronometer
																// Countdown
	long current_time_handler; // Is used by Handlers for Chronometer Countdown

	String start_time_str; // currently is unused

	long current_time; // Is used to count curent countdown
	String current_time_str; // Is used to output Formated time converted to
								// "Hh:Mm:Ss:msms" String format

	long time_from_reset; // Is used to count time elapsed from last reset
	long time_from_activity_start; // Is used to count time elsapsed from start
									// of activity
	long time_from_boot = start_time_handler; // Is used to count time elapsed
												// from device boot

	// String elapsed_time_from_reset_str;
	// String elapsed_time_from_activity_str;
	// String elapsed_time_from_boot_str;

	// Declaring Button Triggers
	boolean cleared_condition = false;
	boolean start_condition = false;
	boolean reset_condition = false;
	boolean catch_condition = false;
	boolean stop_condition = false;

	boolean stop_condition_handler; // It is a Stop Condition Handler switcher

	Handler mHandler = new Handler(); // I didn't understand this stuff
	Handler cHandler = new Handler(); // I didn't understand this stuff too

	byte counter_for_result_list = 0; // Used to output first digit of list
	byte counter_for_result_list_sub_counter = 0; // Used to output second digit
													// of list
	byte counter_for_result_list_sub_counter_sub = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stopwatch_advanced);

		// Setting Initial Button Triggers
		catch_condition = false;
		start_condition = true;
		reset_condition = false;
		stop_condition = false;
		cleared_condition = false;

		// Starting Counters
		cHandler.removeCallbacks(startCounter);
		cHandler.postDelayed(startCounter, 1000);

		final MediaPlayer genButtonSoundRight = MediaPlayer.create(
				StopWatchAdvanced.this, R.raw.button_right_sound);
		final MediaPlayer genButtonSoundWrong = MediaPlayer.create(
				StopWatchAdvanced.this, R.raw.button_wrong_sound);

		Button button_clear = (Button) findViewById(R.id.button_clear);
		button_clear.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (cleared_condition) {
					// Changing Triggers if Clear Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = false;
					stop_condition = false;
					cleared_condition = false;

					// Rest of code
					if (counter_for_result_list != 0) {
						counter_for_result_list = 0;
						counter_for_result_list_sub_counter = 0;
						counter_for_result_list_sub_counter_sub = 0;

						current_time_str = "--:--:--:---";
						((TextView) findViewById(R.id.result_text_view_1))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_2))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_3))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_4))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_5))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_6))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_7))
								.setText(current_time_str);

						((TextView) findViewById(R.id.result_text_view_8))
								.setText(current_time_str);
						((TextView) findViewById(R.id.result_text_view_9))
								.setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_10))
						// .setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_11))
						// .setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_12))
						// .setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_13))
						// .setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_14))
						// .setText(current_time_str);
						// ((TextView) findViewById(R.id.result_text_view_15))
						// .setText(current_time_str);

						// Maybe I'll add it later
					}

					mHandler.removeCallbacks(startTimer);

					stop_condition_handler = false;
					((TextView) findViewById(R.id.hh_text_view)).setText("00");
					((TextView) findViewById(R.id.mm_text_view)).setText("00");
					((TextView) findViewById(R.id.ss_text_view)).setText("00");
					((TextView) findViewById(R.id.msms_text_view))
							.setText("000");

					counter_for_result_list_sub_counter_sub = 0;

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		Button button_stop = (Button) findViewById(R.id.button_stop);
		button_stop.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (stop_condition) {
					// Changing Triggers if Stop Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = true;
					stop_condition = false;
					cleared_condition = true;

					// Rest of code
					mHandler.removeCallbacks(startTimer);
					stop_condition_handler = true;

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		Button button_start = (Button) findViewById(R.id.button_start);
		button_start.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (start_condition) {
					// Changing Triggers if Start Button is Pressed
					catch_condition = true;
					start_condition = false;
					reset_condition = false;
					stop_condition = true;
					cleared_condition = false;

					// Rest of code
					if (stop_condition_handler) {
						start_time_handler = System.currentTimeMillis()
								- current_time_handler;
					} else {
						start_time_handler = System.currentTimeMillis();
					}
					mHandler.removeCallbacks(startTimer);
					mHandler.postDelayed(startTimer, 10);

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		Button button_reset = (Button) findViewById(R.id.button_reset);
		button_reset.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (reset_condition) {
					// Changing Triggers if Reset Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = false;
					stop_condition = false; // true;
					cleared_condition = false;

					// Rest of code
					stop_condition_handler = false;
					((TextView) findViewById(R.id.hh_text_view)).setText("00");
					((TextView) findViewById(R.id.mm_text_view)).setText("00");
					((TextView) findViewById(R.id.ss_text_view)).setText("00");
					((TextView) findViewById(R.id.msms_text_view))
							.setText("000");

					counter_for_result_list_sub_counter = 0;

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		Button button_catch = (Button) findViewById(R.id.button_catch);
		button_catch.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (catch_condition) {
					// Changing Triggers if Start Button is Pressed
					catch_condition = true;
					start_condition = false;
					reset_condition = false;
					stop_condition = true;
					cleared_condition = false;

					// Rest of code
					current_time_str = getFormatedTime(current_time_handler);
					((TextView) findViewById(R.id.current_ms_long))
							.setText(current_time_str);

					// Result output switcher
					if (counter_for_result_list < 10) { // <8

						if (counter_for_result_list_sub_counter == 0) {
							counter_for_result_list_sub_counter_sub++;
						}

						counter_for_result_list++;
						counter_for_result_list_sub_counter++;

						current_time_str = (" "
								+ ((char) (counter_for_result_list + 48))
								+ "). <-"
								+ ((char) (counter_for_result_list_sub_counter_sub + 48))
								+ "-"
								+ ((char) (counter_for_result_list_sub_counter + 48))
								+ "-> " + current_time_str);

						switch (counter_for_result_list) {
						case 1: {
							((TextView) findViewById(R.id.result_text_view_1))
									.setText(current_time_str);
						}
							break;
						case 2: {
							((TextView) findViewById(R.id.result_text_view_2))
									.setText(current_time_str);
						}
							break;
						case 3: {
							((TextView) findViewById(R.id.result_text_view_3))
									.setText(current_time_str);
						}
							break;
						case 4: {
							((TextView) findViewById(R.id.result_text_view_4))
									.setText(current_time_str);
						}
							break;
						case 5: {
							((TextView) findViewById(R.id.result_text_view_5))
									.setText(current_time_str);
						}
							break;
						case 6: {
							((TextView) findViewById(R.id.result_text_view_6))
									.setText(current_time_str);
						}
							break;
						case 7: {
							((TextView) findViewById(R.id.result_text_view_7))
									.setText(current_time_str);
						}
							break;

						case 8: {
							((TextView) findViewById(R.id.result_text_view_8))
									.setText(current_time_str);
						}
							break;
						case 9: {
							((TextView) findViewById(R.id.result_text_view_9))
									.setText(current_time_str);
						}
							break;
						// case 10: {
						// ((TextView) findViewById(R.id.result_text_view_10))
						// .setText(current_time_str);
						// }
						// break;
						// case 11: {
						// ((TextView) findViewById(R.id.result_text_view_11))
						// .setText(current_time_str);
						// }
						// break;
						// case 12: {
						// ((TextView) findViewById(R.id.result_text_view_12))
						// .setText(current_time_str);
						// }
						// break;
						// case 13: {
						// ((TextView) findViewById(R.id.result_text_view_13))
						// .setText(current_time_str);
						// }
						// break;
						// case 14: {
						// ((TextView) findViewById(R.id.result_text_view_14))
						// .setText(current_time_str);
						// }
						// break;
						// case 15: {
						// ((TextView) findViewById(R.id.result_text_view_15))
						// .setText(current_time_str);
						// }
						// break;

						default:

							break;
						} // eof-switcher
					} // eof-if

					genButtonSoundRight.start();
				} else {
					genButtonSoundWrong.start();
				}// eof-if(pause_condition)
			} // eof-onClick
		});

	} // eof-onCreate

	// Displays counting of seconds from boot, start and last thread
	private Runnable startCounter = new Runnable() {
		public void run() {

			current_time = SystemClock.elapsedRealtime();

			// Displays counting from activity started
			((TextView) findViewById(R.id.time_from_activity_start_ms_long))
					.setText(String.valueOf(current_time - time_from_boot));
			((TextView) findViewById(R.id.time_from_activity_start_formatted_long))
					.setText(getFormatedTimeShort(current_time - time_from_boot));

			// Displays counting from device boot started
			((TextView) findViewById(R.id.time_from_boot_ms_long))
					.setText(String.valueOf(current_time));
			((TextView) findViewById(R.id.time_from_boot_formatted_long))
					.setText(getFormatedTimeShort(current_time));

			mHandler.postDelayed(this, 1000);
		}
	};

	// Displays counting of main chronometer
	private Runnable startTimer = new Runnable() {
		public void run() {
			current_time_handler = System.currentTimeMillis()
					- start_time_handler;
			ShowTime(current_time_handler);
			mHandler.postDelayed(this, 10);
		}
	};

	// Formatted time string getter !!with!! millisecods
	private String getFormatedTime(long time_current) {

		long HH = 0L;
		long MM = 0L;
		long SS = 0L;
		long msms = 0L;

		String HH_str;
		String MM_str;
		String SS_str;
		String msms_str;

		long current_t;

		HH = time_current / 3600000L;
		current_t = time_current % 3600000L;
		time_current = current_t;

		MM = time_current / 60000L;
		current_t = time_current % 60000L;
		time_current = current_t;

		SS = time_current / 1000L;
		current_t = time_current % 1000L;
		time_current = current_t;

		msms = time_current;

		if (HH < 10L) {
			HH_str = ('0' + String.valueOf(HH));
		} else
			HH_str = String.valueOf(HH);

		if (MM < 10L) {
			MM_str = ('0' + String.valueOf(MM));
		} else
			MM_str = String.valueOf(MM);

		if (SS < 10L) {
			SS_str = ('0' + String.valueOf(SS));
		} else
			SS_str = String.valueOf(SS);

		if (msms < 100L) {
			msms_str = ('0' + String.valueOf(msms));
		} else if (msms < 10L) {
			msms_str = ("00" + String.valueOf(msms));
		} else
			msms_str = String.valueOf(msms);

		String s = (HH_str + ":" + MM_str + ":" + SS_str + ":" + msms_str);

		return s;
	}

	// Formatted time string getter without millisecods
	private String getFormatedTimeShort(long time_current) {

		long HH = 0L;
		long MM = 0L;
		long SS = 0L;

		String HH_str;
		String MM_str;
		String SS_str;

		long current_t;

		HH = time_current / 3600000L;
		current_t = time_current % 3600000L;
		time_current = current_t;

		MM = time_current / 60000L;
		current_t = time_current % 60000L;
		time_current = current_t;

		SS = time_current / 1000L;

		if (HH < 10L) {
			HH_str = ('0' + String.valueOf(HH));
		} else
			HH_str = String.valueOf(HH);

		if (MM < 10L) {
			MM_str = ('0' + String.valueOf(MM));
		} else
			MM_str = String.valueOf(MM);

		if (SS < 10L) {
			SS_str = ('0' + String.valueOf(SS));
		} else
			SS_str = String.valueOf(SS);

		String s = (HH_str + ":" + MM_str + ":" + SS_str);

		return s;
	}

	// Main Chronometer output convertion method
	private void ShowTime(long t_to_show) {
		long HH = 0L;
		long MM = 0L;
		long SS = 0L;
		long msms = 0L;

		String HH_str;
		String MM_str;
		String SS_str;
		String msms_str;

		long current_t;

		HH = t_to_show / 3600000L;
		current_t = t_to_show % 3600000L;
		t_to_show = current_t;

		MM = t_to_show / 60000L;
		current_t = t_to_show % 60000L;
		t_to_show = current_t;

		SS = t_to_show / 1000L;
		current_t = t_to_show % 1000L;
		t_to_show = current_t;

		msms = t_to_show;

		if (HH < 10L) {
			HH_str = ('0' + String.valueOf(HH));
		} else
			HH_str = String.valueOf(HH);

		if (MM < 10L) {
			MM_str = ('0' + String.valueOf(MM));
		} else
			MM_str = String.valueOf(MM);

		if (SS < 10L) {
			SS_str = ('0' + String.valueOf(SS));
		} else
			SS_str = String.valueOf(SS);

		if ((msms < 100L) && (msms > 9L)) {
			msms_str = ('0' + String.valueOf(msms));
		} else if (msms < 10L) {
			msms_str = ("00" + String.valueOf(msms));
		} else
			msms_str = String.valueOf(msms);

		((TextView) findViewById(R.id.hh_text_view)).setText(HH_str);
		((TextView) findViewById(R.id.mm_text_view)).setText(MM_str);
		((TextView) findViewById(R.id.ss_text_view)).setText(SS_str);
		((TextView) findViewById(R.id.msms_text_view)).setText(msms_str);
	}

	// Menu Declaration
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.menu_stopwatch, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.hardwareMenuSWHelpQS:
			startActivity(new Intent("com.shumz.application.MENUSTOPWATCHQS"));
			return true;
		case R.id.hardwareMenuSWHelpAd:
			startActivity(new Intent("com.shumz.application.MENUSTOPWATCHAD"));
			return true;

		case R.id.hardwareMenuToastSW:
			Toast andEggs = Toast.makeText(StopWatchAdvanced.this,
					"Property of Shumz Soft Inc.", Toast.LENGTH_SHORT);
			andEggs.show();

			andEggs = Toast.makeText(StopWatchAdvanced.this,
					"I really hope you've enjoied it...", Toast.LENGTH_LONG);
			andEggs.show();

			andEggs = Toast.makeText(StopWatchAdvanced.this,
					"Antonina and Elena  ;-)", Toast.LENGTH_SHORT);
			andEggs.show();

			return true;
		}
		return false;
	}
	
	
}
