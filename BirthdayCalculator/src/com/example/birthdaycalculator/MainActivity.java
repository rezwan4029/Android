package com.example.birthdaycalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

public class MainActivity extends Activity {
	
	Button b  ;
	EditText t ;
	EditText ret;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         b  = (Button) findViewById(R.id.btn);
    	 t = (EditText) findViewById(R.id.txt);
    	ret = (EditText) findViewById(R.id.ans);
        buttonCommand();

    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    void buttonCommand(){
    	b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int ans = doIt();
				ret.setText( String.valueOf(ans) );
			}
		});
    }
    
    List<Integer> spliting(String z){ // split and return in int
    	String parts[] = z.split("/");
    	List<Integer> myList = new ArrayList<Integer>();
        myList.add( Integer.parseInt( parts[0]) );
        myList.add( Integer.parseInt( parts[1]) );
        myList.add( Integer.parseInt( parts[2]) );
        return myList;
    }
    /*
     List<Integer> getCurrDate(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	Date date = new Date();
    	String dt = dateFormat.format(date);
    	return spliting(dt);
    }
     */
    
    public int doIt(){
    	//List<Integer> curr = getCurrDate();
    	List<Integer> bday = spliting( t.getText().toString() ) ;
    	int age = solve(bday.get(0) ,bday.get(1) ,bday.get(2) );
    	return age ;
    }
    
    private static int solve(int day , int month, int year) {
        Calendar birthCal = new GregorianCalendar(year, month, day);
        Calendar nowCal = new GregorianCalendar();
        int age = nowCal.get( Calendar.YEAR ) - birthCal.get( Calendar.YEAR );
        boolean isMonthGreater = birthCal.get(Calendar.MONTH) >= nowCal.get(Calendar.MONTH);
        boolean isMonthSameButDayGreater = birthCal.get(Calendar.MONTH) == nowCal.get(Calendar.MONTH)&& birthCal.get(Calendar.DAY_OF_MONTH) > nowCal.get(Calendar.DAY_OF_MONTH);
        if (isMonthGreater || isMonthSameButDayGreater) age--;
        return age;
    }
}
