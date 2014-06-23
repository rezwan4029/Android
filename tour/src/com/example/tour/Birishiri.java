package com.example.tour;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import googleme.*;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Birishiri extends Activity {
	
	Button btn;
	TextView Txt1;
	double lat = 24.886101 ;
	double lon = 90.72913399999993 ;
	String place = "Birishiri";
	String res = "";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birishiri_page);
		
		Txt1 = (TextView) findViewById(R.id.textView2);
		Txt1.setMovementMethod(new ScrollingMovementMethod());

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					getAssets().open("birishiri.txt")));

			String myLine = reader.readLine();

			while (myLine != null) {
				res += myLine + "\n";
				myLine = reader.readLine();
			}

			reader.close();

		} catch (IOException e) {
			Toast.makeText(getApplicationContext(),
					"Error Opening the File !!!", Toast.LENGTH_LONG).show();
		}

		Txt1.setText(res);
		
		btn = (Button) findViewById(R.id.btnDir);
		btn.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				Intent myInt = new Intent(Birishiri.this, NavigationActivity.class);
				myInt.putExtra("XX",String.valueOf(lat));
				myInt.putExtra("YY",String.valueOf(lon));
				myInt.putExtra("ZZ",place);
				startActivity(myInt);
			}
		});
	}
}