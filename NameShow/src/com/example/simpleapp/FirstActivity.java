package com.example.simpleapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class FirstActivity extends Activity {
	
	TextView txt;
	Button btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    
        txt = (TextView) findViewById(R.id.inputEditText);
        btn = (Button) findViewById(R.id.SubmitButton);
        
        btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String ret = txt.getText().toString();
				Intent intnt = new Intent(FirstActivity.this,SecondActivity.class);
				intnt.putExtra("NAME", ret);
				startActivity(intnt);
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }
    
}
