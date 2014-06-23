package com.example.tour;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.FragmentActivity;

public class Gmap extends Activity implements LocationListener{
	
	TextView Txt ;
	
	// Google Map
	private GoogleMap googleMap;
	double latitude, longitude;
	String Str;
	double CurLatitude, CurLongitude;
	Location LOC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.googlemap);
		Txt = ( TextView ) findViewById(R.id.textDist ) ;
		
		latitude = Double.parseDouble(getIntent().getStringExtra("XX"));
		longitude = Double.parseDouble(getIntent().getStringExtra("YY"));
		Str = getIntent().getStringExtra("ZZ");

		try {

			initilizeMap();

		} catch (Exception e) {
			e.printStackTrace();
			// Log.d("Latitude : ", String.valueOf(latitude) );
			// Log.d("Longitude : ", String.valueOf(longitude) );
		}

		getCurLocation();

		Work();
		
		Txt.setText( "Distance = " +  String.valueOf(  getDistance() )  + "  meter" );
	}

	public void Work() {
		// create marker
		MarkerOptions marker = new MarkerOptions().position(
				new LatLng(latitude, longitude)).title(Str);
		MarkerOptions myMarker = new MarkerOptions().position(
				new LatLng(CurLatitude, CurLongitude)).title("You are here");

		marker.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
		myMarker.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

		googleMap.addMarker(marker);
		googleMap.addMarker(myMarker);

		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(new LatLng(23.709921, 90.40714300000002)).zoom(12).build();

		googleMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));

	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}

		}
	}

	public boolean servicesOK() {
		int isAvailable = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(this);

		if (isAvailable == ConnectionResult.SUCCESS) {
			return true;
		} else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {

		}
		// Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable,
		// this, null);
		// dialog.show();
		// }
		else {
			Toast.makeText(this, "Can't connect to Google Play services",
					Toast.LENGTH_SHORT).show();
		}
		return false;
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	public void getCurLocation() {

		LocationManager lm = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		Criteria c = new Criteria();
		String provider = lm.getBestProvider(c, false);
		LOC = lm.getLastKnownLocation(provider);

		if (LOC != null) {
			CurLatitude = LOC.getLatitude();
			CurLongitude = LOC.getLongitude();
		}

	}
	
	double getDistance(){
		double dist; 
		Location locationA = new Location("point XX");  
		locationA.setLatitude(latitude);  
		locationA.setLongitude(longitude);  
		Location locationB = new Location("point YY");  
		locationB.setLatitude(CurLatitude);  
		locationB.setLongitude(CurLongitude);  
		dist = locationA.distanceTo(locationB);  
		return dist ;
	}
	
	
	// If you want location on changing place also than use below method
	// otherwise remove all below methods and don't implement location listener
	@Override
	public void onLocationChanged(Location arg0) {
		CurLongitude = LOC.getLongitude();
		CurLatitude = LOC.getLatitude();
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
	}

}