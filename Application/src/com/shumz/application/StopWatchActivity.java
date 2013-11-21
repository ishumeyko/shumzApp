package com.shumz.application;

import java.util.ArrayList;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StopWatchActivity extends Activity {

	// Time elapsed from boot of Device
	// Is used by Handlers for Chronometer Countdown
	long start_time_handler = SystemClock.elapsedRealtime();
	long current_time_handler; // Is used by Handlers for Chronometer Countdown

	long current_time; // Is used to count curent countdown
	String current_time_str; // Is used to output Formated time converted to
								// "Hh:Mm:Ss:msms" String format

	long time_from_reset; // Is used to count time elapsed from last reset
	long time_from_activity_start; // Is used to count time elsapsed from start
									// of activity
	long time_from_boot = start_time_handler; // Is used to count time elapsed
												// from device boot

	// Declaring Button Triggers
	boolean cleared_condition = false;
	boolean start_condition = false;
	boolean reset_condition = false;
	boolean catch_condition = false;
	boolean stop_condition = false;

	boolean stop_condition_handler; // It is a Stop Condition Handler switcher

	Handler mHandler = new Handler();
	Handler cHandler = new Handler();

	int lap_counter = 0; // Used to output # of laps

	Button StartButton;
	Button ClearButton;
	Button CatchButton;
	Button ResetButton;
	Button StopButton;

	TextView tvEmptyString;

	// Declaring objects responsible for List of Laps
	ListView listOfLaps;
	ArrayList<String> listOfItems = new ArrayList<String>();
	ArrayAdapter<String> listAdapter;

	String listItemPrefix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stopwatch);

		// Setting Initial Button Triggers
		catch_condition = false;
		start_condition = true;
		reset_condition = false;
		stop_condition = false;
		cleared_condition = false;

		// Starting Counters
		cHandler.removeCallbacks(startCounter);
		cHandler.postDelayed(startCounter, 1000);

		// Sounds for buttons
		final MediaPlayer genButtonSoundRight = MediaPlayer.create(
				StopWatchActivity.this, R.raw.button_right_sound);
		final MediaPlayer genButtonSoundWrong = MediaPlayer.create(
				StopWatchActivity.this, R.raw.button_wrong_sound);

		// Buttons initialization
		StartButton = (Button) findViewById(R.id.button_start);
		ClearButton = (Button) findViewById(R.id.button_clear);
		CatchButton = (Button) findViewById(R.id.button_catch);
		ResetButton = (Button) findViewById(R.id.button_reset);
		StopButton = (Button) findViewById(R.id.button_stop);

		CatchButton.setEnabled(catch_condition);
		StartButton.setEnabled(start_condition);
		ClearButton.setEnabled(cleared_condition);
		ResetButton.setEnabled(reset_condition);
		StopButton.setEnabled(stop_condition);

		tvEmptyString = (TextView) findViewById(R.id.tv_empty_str);

		// List of laps initialization
		listOfLaps = (ListView) findViewById(R.id.lv_for_timechecks);
		listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listOfItems);
		listOfLaps.setAdapter(listAdapter);

		ClearButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (cleared_condition) {
					// Changing Triggers if Clear Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = false;
					stop_condition = false;
					cleared_condition = false;

					CatchButton.setEnabled(catch_condition);
					StartButton.setEnabled(start_condition);
					ClearButton.setEnabled(cleared_condition);
					ResetButton.setEnabled(reset_condition);
					StopButton.setEnabled(stop_condition);

					lap_counter = 0;

					mHandler.removeCallbacks(startTimer);

					stop_condition_handler = false;
					((TextView) findViewById(R.id.hh_text_view)).setText("00");
					((TextView) findViewById(R.id.mm_text_view)).setText("00");
					((TextView) findViewById(R.id.ss_text_view)).setText("00");
					((TextView) findViewById(R.id.msms_text_view))
							.setText("000");

					listOfItems.removeAll(listOfItems);
					listAdapter.notifyDataSetChanged();

					tvEmptyString.setVisibility(View.VISIBLE);
					listOfLaps.setVisibility(View.GONE);

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		StopButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (stop_condition) {
					// Changing Triggers if Stop Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = true;
					stop_condition = false;
					cleared_condition = true;

					CatchButton.setEnabled(catch_condition);
					StartButton.setEnabled(start_condition);
					ClearButton.setEnabled(cleared_condition);
					ResetButton.setEnabled(reset_condition);
					StopButton.setEnabled(stop_condition);

					// Rest of code
					mHandler.removeCallbacks(startTimer);
					stop_condition_handler = true;

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		StartButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (start_condition) {
					// Changing Triggers if Start Button is Pressed
					catch_condition = true;
					start_condition = false;
					reset_condition = false;
					stop_condition = true;
					cleared_condition = false;

					CatchButton.setEnabled(catch_condition);
					StartButton.setEnabled(start_condition);
					ClearButton.setEnabled(cleared_condition);
					ResetButton.setEnabled(reset_condition);
					StopButton.setEnabled(stop_condition);

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

		ResetButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (reset_condition) {
					// Changing Triggers if Reset Button is Pressed
					catch_condition = false;
					start_condition = true;
					reset_condition = false;
					stop_condition = false; // true;
					cleared_condition = false;

					CatchButton.setEnabled(catch_condition);
					StartButton.setEnabled(start_condition);
					ClearButton.setEnabled(cleared_condition);
					ResetButton.setEnabled(reset_condition);
					StopButton.setEnabled(stop_condition);

					// Rest of code
					stop_condition_handler = false;
					((TextView) findViewById(R.id.hh_text_view)).setText("00");
					((TextView) findViewById(R.id.mm_text_view)).setText("00");
					((TextView) findViewById(R.id.ss_text_view)).setText("00");
					((TextView) findViewById(R.id.msms_text_view))
							.setText("000");

					lap_counter = 0;

					genButtonSoundRight.start();
				} else {

					genButtonSoundWrong.start();
				}
			}
		});

		CatchButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (catch_condition) {
					// Changing Triggers if Start Button is Pressed
					catch_condition = true;
					start_condition = false;
					reset_condition = false;
					stop_condition = true;
					cleared_condition = false;

					CatchButton.setEnabled(catch_condition);
					StartButton.setEnabled(start_condition);
					ClearButton.setEnabled(cleared_condition);
					ResetButton.setEnabled(reset_condition);
					StopButton.setEnabled(stop_condition);

					if (listOfLaps.getVisibility() == View.GONE) {
						tvEmptyString.setVisibility(View.GONE);
						listOfLaps.setVisibility(View.VISIBLE);
					}

					current_time_str = getFormatedTime(current_time_handler);
					((TextView) findViewById(R.id.current_ms_long))
							.setText(current_time_str);

					// Calculating the prefix for list of items
					if ((listOfItems.size() + 1) < 10) {
						listItemPrefix = "00"
								+ String.valueOf((listOfItems.size() + 1))
								+ ").  ";
					} else if ((listOfItems.size() + 1) < 100) {
						listItemPrefix = "0"
								+ String.valueOf((listOfItems.size() + 1))
								+ ").  ";
					} else {
						listItemPrefix = String.valueOf((listOfItems.size() + 1))
								+ ").  ";
					}

					// Adding lap
					lap_counter++;
					if ((lap_counter) < 10) {
						listItemPrefix = listItemPrefix + "Lap #00"
								+ String.valueOf(lap_counter) + "  :  ";
					} else if ((listOfItems.size() + 1) < 100) {
						listItemPrefix = listItemPrefix + "Lap #0"
								+ String.valueOf(lap_counter) + "  :  ";
					} else {
						listItemPrefix = listItemPrefix + "Lap #"
								+ String.valueOf(lap_counter) + "  :  ";
					}

					listOfItems.add(listItemPrefix + current_time_str);
					listAdapter.notifyDataSetChanged();
					listOfLaps.setSelection(listOfItems.size() - 1);
					genButtonSoundRight.start();
				} else {
					genButtonSoundWrong.start();
				}// eof-if(pause_condition)
			} // eof-onClick
		});

	} // eof-onCreate method

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
			showTime(current_time_handler);
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

	// Main StopWatch output convertion method
	private void showTime(long t_to_show) {
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
			Toast andEggs = Toast.makeText(StopWatchActivity.this,
					"Property of Shumz Soft Inc.", Toast.LENGTH_SHORT);
			andEggs.show();

			return true;
		}
		return false;
	}

}
