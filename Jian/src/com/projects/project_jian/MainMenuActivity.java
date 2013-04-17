package com.projects.project_jian;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainMenuActivity extends Activity {
	private View startButton;
	private View extrasButton;
	private View optionsButton;
	//private View mBackground;
	private boolean isPaused;
	private Animation mButtonFlickerAnimation;
	
	private View.OnClickListener startButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			if (!isPaused) {
				Intent i = new Intent(getBaseContext(), JianGameActivity.class);
				v.startAnimation(mButtonFlickerAnimation);
				mButtonFlickerAnimation.setAnimationListener(new StartActivityAfterAnimation(i));
				
				isPaused = true;
			}
		}
	};
	
	private View.OnClickListener extrasButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			if (!isPaused) {
				Intent i = new Intent(getBaseContext(), ExtrasMenuActivity.class);
				v.startAnimation(mButtonFlickerAnimation);
				mButtonFlickerAnimation.setAnimationListener(new StartActivityAfterAnimation(i));
				
				isPaused = true;
			}
		}
	};
	
	private View.OnClickListener optionsButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			if (!isPaused) {
				Intent i = new Intent(getBaseContext(), OptionsMenuActivity.class);
				v.startAnimation(mButtonFlickerAnimation);
				mButtonFlickerAnimation.setAnimationListener(new StartActivityAfterAnimation(i));
				
				isPaused = true;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		isPaused = true;
		
		startButton = findViewById(R.id.startButton);
		extrasButton = findViewById(R.id.extrasButton);
		optionsButton = findViewById(R.id.optionsButton);
		
		startButton.setOnClickListener(startButtonListener);
		extrasButton.setOnClickListener(extrasButtonListener);
		optionsButton.setOnClickListener(optionsButtonListener);

		mButtonFlickerAnimation = AnimationUtils.loadAnimation(this, R.animator.button_flicker);
		
		//setup background music
		//setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
	}
	
	protected void onPause() {
		super.onPause();
		isPaused = true;
	}
	
	protected void onResume() {
		super.onResume();
		isPaused = false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}
	
	//handle the animation for buttons
	protected class StartActivityAfterAnimation implements Animation.AnimationListener {
		private Intent myIntent;
		
		StartActivityAfterAnimation(Intent intent) {
			myIntent = intent;
		}
		
		public void onAnimationEnd(Animation animation) {
			startActivity(myIntent);
     }
		
		public void onAnimationRepeat(Animation animation) {
		     // TODO Auto-generated method stub
		     
		 }

		 public void onAnimationStart(Animation animation) {
		     // TODO Auto-generated method stub
		     
		 }
 }


}
