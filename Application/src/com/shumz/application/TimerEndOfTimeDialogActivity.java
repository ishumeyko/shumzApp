package com.shumz.application;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TimerEndOfTimeDialogActivity extends Activity {

	private Button dismissDialogButton;
	private MediaPlayer mBeeper;
	private Vibrator notifierVibrator;

	private long vibrate_pattern[] = { 250, 500 };

	final Thread notifierThread = new Thread() {

		public void run() {
			try {
				while (!isInterrupted()) {

					mBeeper.setLooping(true);
					mBeeper.start();
					sleep(500);

					mBeeper.setLooping(false);
					sleep(1000);
				}
			} catch (InterruptedException e) {

			}
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer_end_time_dialog);

		mBeeper = MediaPlayer.create(this, R.raw.button_generate_sound);
		notifierVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		notifierVibrator.vibrate(vibrate_pattern, 0);

		notifierThread.start();

		dismissDialogButton = (Button) findViewById(R.id.button_timer_end_of_time_dialog_dismiss_dialog);
		dismissDialogButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				onDestroy();
				finish();
			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		notifierThread.interrupt();
		mBeeper.release();
		notifierVibrator.cancel();

	}

	@Override
	public void onBackPressed() {
	}
}
