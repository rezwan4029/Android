package com.example.tour;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button destinationSearch, tImageSearch, aboutUs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intialization();
		CheckButton();
	}

	private void Intialization() {
		destinationSearch = (Button) findViewById(R.id.buttonDes);
		tImageSearch = (Button) findViewById(R.id.buttonIGrid);
		aboutUs = (Button) findViewById(R.id.buttonUS);
	}

	
	private void CheckButton() {
		destinationSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(MainActivity.this, Destination.class);
				startActivity(myInt);
			}
		});

		tImageSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(MainActivity.this, ImageSearch.class);
				startActivity(myInt);
			}
		});

		aboutUs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myInt = new Intent(MainActivity.this, Us.class);
				startActivity(myInt);
			}
		});

	}


}
