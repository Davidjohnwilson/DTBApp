package com.davetriesballet.DTB;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainStartingBallet extends Activity {

	Button maleChecklistButton, femaleChecklistButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainstartingballet);

		// ---Set Male Checklist button---
		maleChecklistButton = (Button) findViewById(R.id.btn_checklistmale);
		maleChecklistButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(
						"com.davetriesballet.DTB.MAINCHECKLISTMALE"));
			}
		});

		// ---Set Female Checklist button---
		femaleChecklistButton = (Button) findViewById(R.id.btn_checklistfemale);
		femaleChecklistButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(
						"com.davetriesballet.DTB.MAINCHECKLISTFEMALE"));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_home:
			startActivity(new Intent("com.davetriesballet.DTB.MAIN"));
			return true;
		case R.id.menu_startingballet:
			return true;
		case R.id.menu_watchingballet:
			startActivity(new Intent(
					"com.davetriesballet.DTB.MAINWATCHINGBALLET"));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}