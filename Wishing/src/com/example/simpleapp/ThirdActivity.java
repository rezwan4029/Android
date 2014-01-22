package com.example.simpleapp;

import java.util.ArrayList;
import java.util.Date;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.widget.AdapterView.OnItemLongClickListener;


public class ThirdActivity extends Activity {
	
	EditText newWish;
	Button btn;
	ListView WishList;
	ArrayList<Items>arrList;
	BaseAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		Init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}
	
	private void Init(){
		newWish = (EditText) findViewById(R.id.wishText);
		btn = (Button) findViewById(R.id.WishButton);
		WishList = (ListView) findViewById(R.id.WishlistView);
		arrList = new ArrayList<Items>();
		adapter = new BaseAdapter() {
			
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			
			public View getView(int position, View view, ViewGroup grpView) {
				
				if(view == null){
					view = inflater.inflate(R.layout.show_item_view,null);
				}
				
				TextView WishListItemTextView = (TextView) view.findViewById(R.id.WishListItemTextView);
				TextView WishListDateTextView = (TextView) view.findViewById(R.id.WishListDateTextView);
				
				WishListItemTextView.setText( arrList.get(position).getItemName() );
				Date dt = arrList.get(position).getDt();
				
				WishListDateTextView.setText(DateFormat.format("dd/MM/yyyy HH:mm:ss a", dt));
				
				return view;
			}
			
			public long getItemId(int position) { // do nothing
				return 0;
			}
			
			public Object getItem(int position) {
				return arrList.get(position);
			}
			
			public int getCount() {
				return arrList.size();
			}
		};
		
		WishList.setAdapter(adapter);
		
		btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String Str = newWish.getText().toString();
				if( Str.length() == 0 ) return ;
				Date date = new Date();
				Items I = new Items(Str,date);
				arrList.add(I);
				adapter.notifyDataSetChanged();
				newWish.setText("");
					
				InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(newWish.getWindowToken(),0);
					
				Toast.makeText(getBaseContext(),"New Item Added to List",Toast.LENGTH_SHORT).show(); // pop up
						
			}
        });
		
		
		WishList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View view,
					int position, long ID) {
				// TODO Auto-generated method stub
				
				arrList.remove(position);
				adapter.notifyDataSetChanged();
				Toast.makeText(getBaseContext(),"Item Deleted from the List",Toast.LENGTH_SHORT).show(); // pop up

				return false;
			}
		});
		
	}
}