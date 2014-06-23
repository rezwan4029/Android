package com.example.tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import googleme.NavigationActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sundarban extends Activity {
	TextView Txt1;
	Button btn;
	double lat = 22.1731117 ;
	double lon = 89.41821340000001 ;
	String place = "Sundarban";
	String res = "";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sundarban_page);
		
		Txt1 = (TextView) findViewById(R.id.textView2);
		Txt1.setMovementMethod(new ScrollingMovementMethod());

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					getAssets().open("sundarban.txt")));

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
				Intent myInt = new Intent(Sundarban.this, NavigationActivity.class);
				myInt.putExtra("XX",String.valueOf(lat));
				myInt.putExtra("YY",String.valueOf(lon));
				myInt.putExtra("ZZ",place);
				startActivity(myInt);
			}
		});
	}
}
