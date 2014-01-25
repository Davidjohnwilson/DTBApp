package com.davetriesballet.DTB;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button dtbBlogButton, dtbEmailButton; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//---Set Blog button---
		dtbBlogButton = (Button) findViewById(R.id.btn_blogpage);
		dtbBlogButton.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				Intent i = new Intent(
						android.content.Intent.ACTION_VIEW, 
						Uri.parse("http://www.davetriesballet.com"));
				startActivity(i);
			}
		});
		
		//---Set Email button---
		dtbEmailButton = (Button) findViewById(R.id.btn_sendEmailToDTB);
		dtbEmailButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(android.content.Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@davetriesballet.com"});
				i.putExtra(Intent.EXTRA_SUBJECT, "DaveTriesBallet App Email");
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
