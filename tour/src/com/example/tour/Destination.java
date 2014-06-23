package com.example.tour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Destination extends Activity implements OnItemSelectedListener {

	Spinner Division, Zilla, Place;
	Button viewDetails , viewPlace;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.destination_page);
		Initialization();
		AddDivision();
		Work();
	}
	
	public void Work(){
		viewPlace.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Place.setVisibility(View.VISIBLE);
				SetPlace();
				viewDetails.setVisibility(View.VISIBLE);
			}
		});
		
		viewDetails.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String s = (String) Place.getSelectedItem();
				
				if( s.equals( "Lalbag Fort" ) ){
					Intent myInt = new Intent(Destination.this, Lalbagh.class);
					startActivity(myInt);
				}else if( s.equals("Birishiri") ){
					Intent myInt = new Intent(Destination.this, Birishiri.class);
					startActivity(myInt);
				}else if( s.equals( "WWII cemetery") ){
					Intent myInt = new Intent(Destination.this, Wcemetery.class);
					startActivity(myInt);
				}else if( s.equals("Potenga Beach") ){
					Intent myInt = new Intent(Destination.this, Potenga.class);
					startActivity(myInt);
				}else if( s.equals("Himchori Waterfall") ){
					Intent myInt = new Intent(Destination.this, Himchori.class);
					startActivity(myInt);
				}else if( s.equals("Moheskhali") ){
					Intent myInt = new Intent(Destination.this,Moheskhali.class);
					startActivity(myInt);
				}else if( s.equals("Kuakata") ){
					Intent myInt = new Intent(Destination.this,Kuakata.class);
					startActivity(myInt);
				}else if( s.equals("Sundarban") ){
					Intent myInt = new Intent(Destination.this,Sundarban.class);
					startActivity(myInt);
				}else if( s.equals("Madhabkunda") ){
					Intent myInt = new Intent(Destination.this, Madhabkunda.class);
					startActivity(myInt);
				}else if( s.equals("Jaflong") ){
					Intent myInt = new Intent(Destination.this, Jaflong.class);
					startActivity(myInt);
				}else if( s.equals("There is no item") || s.equals("Ahsan Manjil") || s.equals("pakutia") ){
					Intent myInt = new Intent(Destination.this, NoContent.class);
					startActivity(myInt);
				}
			}
		});
		
	}

	public void AddDivision() {
		List<String> list = new ArrayList<String>();
		list.add("Dhaka");
		list.add("Rajshahi");
		list.add("Khulna");
		list.add("Chittagong");
		list.add("Barisal");
		list.add("Rangpur");
		list.add("Sylhet");
		Collections.sort(list);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Division.setAdapter(dataAdapter);

	}

	public void SetDistrict() {

		String Dhaka[] = { "Dhaka", "Faridpur", "Gazipur", "Gopalganj","Jamalpur", "Kishoreganj", "Madaripur", "Manikganj","Munshiganj", "Mymensingh", "Narayanganj", "Narsingdi","Netrakona", "Rajbari", "Shariatpur", "Sherpur", "Tangail" };
		String Rajshahi[] = { "Bogra", "Joypurhat", "Naogaon", "Natore","Nawabganj", "Pabna", "Rajshahi", "Sirajganj" };
		String Khulna[] = { "Bagerhat", "Chuadanga", "Jessore", "Jhenaidah","Khulna", "Kushtia", "Magura", "Meherpur", "Narail", "Satkhira" };
		String Chittagong[] = { "Bandarban", "Brahmanbaria", "Chandpur","Chittagong", "Comilla", "Cox'sBazar", "Feni", "Khagrachhari","Lakshmipur", "Noakhali", "Rangamati" };
		String Barisal[] = { "Barguna", "Barisal", "Bhola", "Jhalokati","Patuakhali", "Pirojpur" };
		String Rangpur[] = { "Dinajpur", "Gaibandha", "Kurigram","Lalmonirhat", "Nilphamari", "Panchagarh", "Rangpur","Thakurgaon" };
		String Sylhet[] = { "Habiganj", "Moulvibazar", "Sunamganj", "Sylhet" };
		List<String> myList = new ArrayList<String>();
		myList.clear();
		if (Division.getSelectedItem().equals("Dhaka")) {
			Collections.addAll(myList, Dhaka);
		} else if (Division.getSelectedItem().equals("Rajshahi")) {
			Collections.addAll(myList, Rajshahi);
		} else if (Division.getSelectedItem().equals("Khulna")) {
			Collections.addAll(myList, Khulna);
		} else if (Division.getSelectedItem().equals("Chittagong")) {
			Collections.addAll(myList, Chittagong);
		}
		else if (Division.getSelectedItem().equals("Rangpur")) {
			Collections.addAll(myList, Rangpur);
		} else if (Division.getSelectedItem().equals("Sylhet")) {
			Collections.addAll(myList, Sylhet);
		} else
			Collections.addAll(myList, Barisal);
		
		Collections.sort(myList);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, myList);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Zilla.setAdapter(dataAdapter);
	}

	public void SetPlace() {
		String Dhaka[] = { "Lalbag Fort","pakutia", "Ahsan Manjil" };
		String Netrokona[] = {"Birishiri"};
		String Ctg[] = { "WWII cemetery","Potenga Beach" };
		String CBazar[] = {"Himchori Waterfall","Moheskhali"};
		String Khulna[] ={"Kuakata","Sundarban"};
		String Sylhet[] = {"Madhabkunda", "Jaflong" };
		String Raj[] = { "Mahasthan Garh", "Chotta Shona Masque" };

		List<String> myList = new ArrayList<String>();
		myList.clear();

		if (Zilla.getSelectedItem().equals("Dhaka")) {
			Collections.addAll(myList, Dhaka);
		} else if (Zilla.getSelectedItem().equals("Netrakona")) {
			Collections.addAll(myList, Netrokona);
		} else if (Zilla.getSelectedItem().equals("Chittagong")) {
			Collections.addAll(myList, Ctg);
		} else if (Zilla.getSelectedItem().equals("Cox'sBazar")) {
			Collections.addAll(myList, CBazar);
		} else if (Zilla.getSelectedItem().equals("Khulna")) {
			Collections.addAll(myList, Khulna);
		} else if (Zilla.getSelectedItem().equals("Sylhet")) {
			Collections.addAll(myList,Sylhet);
		}else if (Zilla.getSelectedItem().equals("Rajshahi")) {
			Collections.addAll(myList, Raj);
		}
		else Collections.addAll( myList , "There is no item");

		Collections.sort(myList);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, myList);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Place.setAdapter(dataAdapter);
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		SetDistrict();
	}

	public void Initialization() {
		Division = (Spinner) findViewById(R.id.spinner1);
		Zilla = (Spinner) findViewById(R.id.spinner2);
		Place = (Spinner) findViewById(R.id.spinner3);
		Place.setVisibility(View.GONE);
		Division.setOnItemSelectedListener((OnItemSelectedListener) this);
		viewDetails = (Button) findViewById(R.id.btnView);
		viewPlace = (Button) findViewById(R.id.btnPlace);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
