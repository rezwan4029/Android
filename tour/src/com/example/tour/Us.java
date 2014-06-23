package com.example.tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

public class Us extends Activity {
	TextView Txt1;
	String res = "";
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.us_page);
	
	Txt1 = (TextView) findViewById(R.id.textView2);
	Txt1.setMovementMethod(new ScrollingMovementMethod());

	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				getAssets().open("about.txt")));

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
 }
}