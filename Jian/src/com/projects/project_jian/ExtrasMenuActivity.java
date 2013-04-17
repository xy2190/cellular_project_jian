package com.projects.project_jian;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ExtrasMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extras_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_extras_menu, menu);
		return true;
	}

}
