package com.example.tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ImageSearch extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_search_page);

		GridView gridView = (GridView) findViewById(R.id.grid_view);

		// Instance of ImageAdapter Class
		gridView.setAdapter(new ImageAdapter(this));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				// Sending image id to FullScreenActivity
				if(position==0){
					Intent i = new Intent(ImageSearch.this,Birishiri.class);
					startActivity(i);
				}else if(position==1){
					Intent i = new Intent(ImageSearch.this,Himchori.class);
					startActivity(i);
				}else if(position==2){
					Intent i = new Intent(ImageSearch.this,Jaflong.class);
					startActivity(i);
				}else if(position==3){
					Intent i = new Intent(ImageSearch.this,Kuakata.class);
					startActivity(i);
				}else if(position==4){
					Intent i = new Intent(ImageSearch.this,Lalbagh.class);
					startActivity(i);
				}else if(position==5){
					Intent i = new Intent(ImageSearch.this,Madhabkunda.class);
					startActivity(i);
				}else if(position==6){
					Intent i = new Intent(ImageSearch.this,Moheskhali.class);
					startActivity(i);
				}else if(position==7){
					Intent i = new Intent(ImageSearch.this,Potenga.class);
					startActivity(i);
				}else if(position==8){
					Intent i = new Intent(ImageSearch.this,Sundarban.class);
					startActivity(i);
				}else if(position==9){
					Intent i = new Intent(ImageSearch.this,Wcemetery.class);
					startActivity(i);
				}else{
				Intent i = new Intent(getApplicationContext(),FullImageActivity.class);
				i.putExtra("id", position);
				startActivity(i);
				}
			}
		});
	}
}

