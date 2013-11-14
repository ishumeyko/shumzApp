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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final MediaPlayer buttonSound = MediaPlayer.create(MainActivity.this,
				R.raw.button_sound);

		Button AlarmButton = (Button) findViewById(R.id.button_alarm_activity_main);
		Button StopWatchButton = (Button) findViewById(R.id.button_stopwatch_activity_main);
		Button TimerButton = (Button) findViewById(R.id.button_timer_activity_main);

		AlarmButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				buttonSound.start();

				Toast.makeText(getApplicationContext(),
						"Sorry,  not implemented yet :-(", Toast.LENGTH_SHORT)
						.show();

//				buttonSound.stop();
			}
		});

		StopWatchButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				buttonSound.start();

				startActivity(new Intent("com.shumz.application.STOPWATCHACTIVITY"));

//				buttonSound.stop();
			}
		});

		TimerButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				buttonSound.start();

				startActivity(new Intent("com.shumz.application.TIMERACTIVITY"));
//				buttonSound.stop();
			}
		});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
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
			startActivity(new Intent("com.shumz.application.MENUHELPMAINHACTIVITY"));
			return true;

		case R.id.menu_main_about:
			startActivity(new Intent("com.shumz.application.MENUABOUTMAINHACTIVITY"));
			
			return true;
		}
		return false;
	}
}
