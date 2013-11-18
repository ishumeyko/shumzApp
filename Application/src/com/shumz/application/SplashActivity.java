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

	private static RelativeLayout splashLayout;

	private static MediaPlayer logoMusic;
	private static boolean isTouched = false;
	private static boolean isRotated = false;

	private static final String IS_ROTATED = "isRotated";

	Thread logoTimer = new Thread() {
		public void run() {

			logoMusic.start();

			try {

				for (int i = 0; i < 78; i++) {
					if (isTouched) {

						logoMusic.stop();
						break;
					} else {
						sleep(100);
					}
				}

			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}

			finally {

				logoMusic.release();

				finish();

				Intent menuIntent = new Intent(
						"com.shumz.application.MAINACTIVITY");
				startActivity(menuIntent);
			}
		}
	};

	@Override
	public void onCreate(Bundle ShumIsCool) {
		super.onCreate(ShumIsCool);
		setContentView(R.layout.activity_splash);

		splashLayout = (RelativeLayout) findViewById(R.id.splash_layout);
		splashLayout.setOnTouchListener(this);

		if (ShumIsCool != null) {
			isRotated = ShumIsCool.getBoolean(IS_ROTATED);
		} else {
			logoMusic = MediaPlayer.create(SplashActivity.this, R.raw.n_man);

			isRotated = true;

			logoTimer.start();
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(IS_ROTATED, isRotated);
	}

	public boolean onTouch(View v, MotionEvent event) {
		isTouched = true;

		// logoMusic.release();

		return false;

	}

	@Override
	protected void onDestroy() {
//

		isTouched = false;
		
//	logoMusic.release();
	super.onDestroy();

	}

	@Override
	public void onBackPressed() {
//		super.onBackPressed();
	}

}
