package com.davetriesballet.DTB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainStartingBallet  extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainstartingballet);
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
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

}