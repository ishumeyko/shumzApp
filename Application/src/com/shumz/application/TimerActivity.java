package com.shumz.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimerActivity extends Activity {

	private Button startStopButton;
	private Button pauseResumeButton;

	private TimePicker tPicker;

	private LinearLayout LLCountdown;

	private TextView tvCurrentHours;
	private TextView tvCurrentMinutes;
	private TextView tvCurrentSeconds;

	private boolean isStopped = false;
	private boolean isPaused = false;

	private String currentHoursString;
	private String currentMinutesString;
	private String currentSecondsString;

	private long currentHours;
	private long currentMinutes;
	private long currentSeconds;

	private long time_from_start = 0L;
	private long time_range = 0L;
	private long time_to_deadline = 0L;
	private long time_left = 0L;

	private final String TIME_FROM_START_VALUE = "tFromStartValue";
	private final String TIME_RANGE = "tRangeValue";
	private final String TIME_TO_DEADLINE = "tToDeadlineValue";
	private final String TIME_LEFT = "tLeftValue";

	private Handler tHander = new Handler();
	private static final int HANDLER_DELAY = 100;

	private final String T_PICKER_VISIBILITY = "tPickerVisibility";
	private final String LL_COUNTDOWN_VISIBILITY = "llCountDownVisibility";

	private final String SS_BUTTON_STATE = "startStopButtonState";
	private final String SS_BUTTON_TEXT = "startStopButtonText";
	private final String PR_BUTTON_STATE = "pauseResumeButtonState";
	private final String PR_BUTTON_TEXT = "pauseResumeButtonText";
	private final String PR_BUTTON_IS_ENABLED = "pauseResumeButtonIsEnabled";

	private final String TV_HOURS = "currentHrsValue";
	private final String TV_MINUTES = "currentMinValue";
	private final String TV_SECONDS = "currentSecValue";

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(T_PICKER_VISIBILITY, tPicker.getVisibility());
		outState.putInt(LL_COUNTDOWN_VISIBILITY, LLCountdown.getVisibility());

		outState.putBoolean(SS_BUTTON_STATE, isStopped);
		outState.putString(SS_BUTTON_TEXT,
				String.valueOf(startStopButton.getText()));

		outState.putBoolean(PR_BUTTON_STATE, isPaused);
		outState.putString(PR_BUTTON_TEXT,
				String.valueOf(pauseResumeButton.getText()));
		outState.putBoolean(PR_BUTTON_IS_ENABLED, pauseResumeButton.isEnabled());

		outState.putString(TV_HOURS, String.valueOf(tvCurrentHours.getText()));
		outState.putString(TV_MINUTES,
				String.valueOf(tvCurrentMinutes.getText()));
		outState.putString(TV_SECONDS,
				String.valueOf(tvCurrentSeconds.getText()));

		outState.putLong(TIME_FROM_START_VALUE, time_from_start);
		outState.putLong(TIME_RANGE, time_range);
		outState.putLong(TIME_TO_DEADLINE, time_to_deadline);
		outState.putLong(TIME_LEFT, time_left);

		tHander.removeCallbacks(tCountdownRunable);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);

		tPicker = (TimePicker) findViewById(R.id.timer_picker);
		tPicker.setIs24HourView(true);
		tPicker.setCurrentHour(0);
		tPicker.setCurrentMinute(15);

		startStopButton = (Button) findViewById(R.id.timer_button_start_stop);
		pauseResumeButton = (Button) findViewById(R.id.timer_button_pause_resume);
		pauseResumeButton.setEnabled(false);

		LLCountdown = (LinearLayout) findViewById(R.id.ll_timer_countdown);

		tvCurrentHours = (TextView) findViewById(R.id.tv_timer_current_hours);
		tvCurrentMinutes = (TextView) findViewById(R.id.tv_timer_current_minutes);
		tvCurrentSeconds = (TextView) findViewById(R.id.tv_timer_current_seconds);

		startStopButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (isStopped) {

					isStopped = false;
					startStopButton.setText("Start");

					pauseResumeButton.setEnabled(false);
					isPaused = false;
					pauseResumeButton.setText("Pause");

					tPicker.setVisibility(View.VISIBLE);
					LLCountdown.setVisibility(View.GONE);

					tHander.removeCallbacks(tCountdownRunable);

				} else {

					getTimeFromTPicker();

					if ((currentHours == 0) && (currentMinutes == 0)
							&& (currentSeconds == 0)) {
						tPicker.setVisibility(View.VISIBLE);
						LLCountdown.setVisibility(View.GONE);

						Toast.makeText(getApplicationContext(),
								"Please set non-zero time!", Toast.LENGTH_SHORT)
								.show();

					} else {

						isStopped = true;

						startStopButton.setText("Stop");

						pauseResumeButton.setEnabled(true);

						getFormatedToStringTime();
						showTime();

						tPicker.setVisibility(View.GONE);
						LLCountdown.setVisibility(View.VISIBLE);

						time_from_start = SystemClock.elapsedRealtime() + 1000;
						time_range = getTimeRange(currentHours, currentMinutes,
								currentSeconds);
						time_to_deadline = time_from_start + time_range;

						tHander.postDelayed(tCountdownRunable, HANDLER_DELAY);
					}
				}

			}

		});

		pauseResumeButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (isPaused) {
					isPaused = false;
					pauseResumeButton.setText("Pause");

					time_range = time_left;

					time_from_start = SystemClock.elapsedRealtime();
					time_to_deadline = time_from_start + time_range;

					tHander.postDelayed(tCountdownRunable, HANDLER_DELAY);
				} else {

					isPaused = true;
					pauseResumeButton.setText("Resume");

					tHander.removeCallbacks(tCountdownRunable);

				}
			}
		});

		if (savedInstanceState != null) {

			tPicker.setVisibility(savedInstanceState
					.getInt(T_PICKER_VISIBILITY));
			LLCountdown.setVisibility(savedInstanceState
					.getInt(LL_COUNTDOWN_VISIBILITY));

			isStopped = savedInstanceState.getBoolean(SS_BUTTON_STATE);
			startStopButton.setText(savedInstanceState
					.getString(SS_BUTTON_TEXT));

			isPaused = savedInstanceState.getBoolean(PR_BUTTON_STATE);
			pauseResumeButton.setText(savedInstanceState
					.getString(PR_BUTTON_TEXT));
			pauseResumeButton.setEnabled(savedInstanceState
					.getBoolean(PR_BUTTON_IS_ENABLED));

			tvCurrentHours.setText(savedInstanceState.getString(TV_HOURS));
			tvCurrentMinutes.setText(savedInstanceState.getString(TV_MINUTES));
			tvCurrentSeconds.setText(savedInstanceState.getString(TV_SECONDS));

			time_from_start = savedInstanceState.getLong(TIME_FROM_START_VALUE);
			time_range = savedInstanceState.getLong(TIME_RANGE);
			time_to_deadline = savedInstanceState.getLong(TIME_TO_DEADLINE);
			time_left = savedInstanceState.getLong(TIME_LEFT);

			if (isStopped) {

				if (isPaused) {
					tHander.removeCallbacks(tCountdownRunable);
				} else {
					time_range = time_left;

					time_from_start = SystemClock.elapsedRealtime();
					time_to_deadline = time_from_start + time_range;

					tHander.postDelayed(tCountdownRunable, HANDLER_DELAY);
				}
			}

		}
	}

	Runnable tCountdownRunable = new Runnable() {

		public void run() {
			time_left = time_to_deadline - SystemClock.elapsedRealtime();

			setCountDownTimeLeft(time_left);

			getFormatedToStringTime();
			showTime();

			if (time_left > 0) {

				tHander.postDelayed(tCountdownRunable, HANDLER_DELAY);
			} else {

				startActivity(new Intent(
						"com.shumz.application.TIMERENDOFTIMEDIALOGACTIVITY"));

				isStopped = false;
				startStopButton.setText("Start");

				pauseResumeButton.setEnabled(false);
				isPaused = false;
				pauseResumeButton.setText("Pause");

				tPicker.setVisibility(View.VISIBLE);
				LLCountdown.setVisibility(View.GONE);
			}

		}
	};

	private void getTimeFromTPicker() {
		currentHours = 0; // tPicker.getCurrentHour();
		currentMinutes = 0; // tPicker.getCurrentMinute();
		currentSeconds = 7;
	}

	private void getFormatedToStringTime() {
		if (currentHours < 10) {
			currentHoursString = "0" + String.valueOf(currentHours);
		} else {
			currentHoursString = String.valueOf(currentHours);
		}

		if (currentMinutes < 10) {
			currentMinutesString = "0" + String.valueOf(currentMinutes);
		} else {
			currentMinutesString = String.valueOf(currentMinutes);
		}

		if (currentSeconds < 10) {
			currentSecondsString = "0" + String.valueOf(currentSeconds);
		} else {
			currentSecondsString = String.valueOf(currentSeconds);
		}
	}

	private void setCountDownTimeLeft(long time_to_the_end) {
		currentHours = time_to_the_end / 3600000L;
		time_to_the_end = time_to_the_end % 3600000L;

		currentMinutes = time_to_the_end / 60000L;
		time_to_the_end = time_to_the_end % 60000L;

		currentSeconds = time_to_the_end / 1000L;
		time_to_the_end = time_to_the_end % 1000L;
	}

	private void showTime() {
		tvCurrentHours.setText(currentHoursString);
		tvCurrentMinutes.setText(currentMinutesString);
		tvCurrentSeconds.setText(currentSecondsString);
	}

	private long getTimeRange(long hrs, long min, long sec) {

		long t = 0L;

		t = (hrs * 3600 * 1000) + (min * 60 * 1000) + (sec * 1000);

		return t;
	}

}
