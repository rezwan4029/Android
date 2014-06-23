package com.example.tour;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

public class Tempo extends Activity {
	
	TextView txt ;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tempo);
		
		txt = (TextView) findViewById(R.id.textDist);
		
		txt.setText( getIntent().getStringExtra("XX") + "   " + getIntent().getStringExtra("YY") );
	}
	

}