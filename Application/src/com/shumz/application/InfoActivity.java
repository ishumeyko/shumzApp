/**
 * 
 */
package com.shumz.application;




import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author shum
 * 
 */
public class InfoActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		final MediaPlayer buttonSound = MediaPlayer.create(InfoActivity.this,
				R.raw.button_sound);

		Button button_st_adv = (Button) findViewById(R.id.stopwatch_advanced_button);
		button_st_adv.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();

				startActivity(new Intent(
						"com.shumz.application.STOPWATCHADVANCED"));
				// startActivity(new Intent(InfoActivity.this,
				// StopWatchAdvanced.class));
			}
		});
	}

}
