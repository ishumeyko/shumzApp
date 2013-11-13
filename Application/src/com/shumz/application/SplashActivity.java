package com.shumz.application;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity implements OnTouchListener {

	// Called when the activity is first created
	MediaPlayer logoMusic;
	boolean isTouched = false;

	@Override
	public void onCreate(Bundle ShumIsCool) {
		super.onCreate(ShumIsCool);
		setContentView(R.layout.activity_splash);

		RelativeLayout splashLayout = (RelativeLayout) findViewById(R.id.splash_layout);
		splashLayout.setOnTouchListener(this);

		/** final MediaPlayer **/
		logoMusic = MediaPlayer.create(SplashActivity.this, R.raw.n_man);
		logoMusic.start();

		Thread logoTimer = new Thread() {
			public void run() {
				try {

					for (int i = 0; i < 78; i++) {
						if (isTouched) {
							break;
						} else {
							sleep(100);
						}
					}

					Intent menuIntent = new Intent("com.shumz.application.MAINACTIVITY");
					startActivity(menuIntent);
				}

				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				finally {
					finish();
				}
			}
		};
		logoTimer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		logoMusic.release();
		// logoMusic.stop();
	}

	public boolean onTouch(View v, MotionEvent event) {
		isTouched = true;
		return false;
	}
}
