package com.example.simpleapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	TextView out;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		out = (TextView) findViewById(R.id.OutputText);
		
		String ret = getIntent().getStringExtra("NAME");
		
		ret = "WELCOME\n\n" + ret + " !!!";
		
		out.setText(ret);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
