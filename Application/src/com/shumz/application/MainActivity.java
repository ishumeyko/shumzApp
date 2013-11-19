package com.shumz.application;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button AlarmButton;
	Button StopWatchButton;
	Button TimerButton;

	MediaPlayer buttonSound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonSound = MediaPlayer.create(MainActivity.this, R.raw.button_sound);

		AlarmButton = (Button) findViewById(R.id.button_alarm_activity_main);
		StopWatchButton = (Button) findViewById(R.id.button_stopwatch_activity_main);
		TimerButton = (Button) findViewById(R.id.button_timer_activity_main);

		AlarmButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				buttonSound.start();

				Toast.makeText(getApplicationContext(),
						"Sorry,  not implemented yet :-(", Toast.LENGTH_SHORT)
						.show();
			}
		});

		StopWatchButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				buttonSound.start();

				startActivity(new Intent(
						"com.shumz.application.STOPWATCHACTIVITY"));
			}
		});

		TimerButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				buttonSound.start();

				startActivity(new Intent("com.shumz.application.TIMERACTIVITY"));
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.menu_activity_main, menu);

		return true;

	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_main_help:
			startActivity(new Intent(
					"com.shumz.application.MENUHELPMAINHACTIVITY"));
			return true;

		case R.id.menu_main_about:
			startActivity(new Intent(
					"com.shumz.application.MENUABOUTMAINHACTIVITY"));

			return true;
		}
		return false;
	}

	@Override
	public void onDestroy() {

		buttonSound.release();
		super.onDestroy();
	}
}
