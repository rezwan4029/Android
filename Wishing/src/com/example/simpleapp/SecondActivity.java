package com.example.simpleapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	TextView out;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		out = (TextView) findViewById(R.id.OutputText);
		
		String ret = getIntent().getStringExtra("NAME");
		
		ret = "WELCOME\n\n" + ret + " !!!";
		
		out.setText(ret);
		
		btn = (Button) findViewById(R.id.goToWish);
		
		 btn.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intnt = new Intent(SecondActivity.this,ThirdActivity.class);
					startActivity(intnt);
				}
	      });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
