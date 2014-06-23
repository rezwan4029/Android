package com.example.tour;

import googleme.NavigationActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Lalbagh extends Activity {
	//lat long correct
	Button btn;
	double lat = 23.718915 ;
	double lon = 90.388374 ;
	String place = "Lalbagh";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lalbagh_page);
		btn = (Button) findViewById(R.id.btnDir);
		TextView Txt1 = ( TextView ) findViewById(R.id.textView2);
		Txt1.setMovementMethod(new ScrollingMovementMethod());
		btn.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				Intent myInt = new Intent(Lalbagh.this, NavigationActivity.class);
				myInt.putExtra("XX",String.valueOf(lat));
				myInt.putExtra("YY",String.valueOf(lon));
				myInt.putExtra("ZZ",place);
				startActivity(myInt);
			}
		});
	}
}