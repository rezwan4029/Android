package app.akexorcist.googlemapsv2direction;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class Main extends FragmentActivity {
	GoogleMap mMap;
    GMapV2Direction md;
    
	LatLng fromPosition = new LatLng(13.687140112679154, 100.53525868803263);
	LatLng toPosition = new LatLng(13.683660045847258, 100.53900808095932);
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        
        md = new GMapV2Direction();
		mMap = ((SupportMapFragment)getSupportFragmentManager()
						.findFragmentById(R.id.map)).getMap();

		LatLng coordinates = new LatLng(13.685400079263206, 100.537133384495975);		
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16));
		
		mMap.addMarker(new MarkerOptions().position(fromPosition).title("Start"));
		mMap.addMarker(new MarkerOptions().position(toPosition).title("End"));
		
		Document doc = md.getDocument(fromPosition, toPosition, GMapV2Direction.MODE_DRIVING);
		int duration = md.getDurationValue(doc);
		String distance = md.getDistanceText(doc);
		String start_address = md.getStartAddress(doc);
		String copy_right = md.getCopyRights(doc);

		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);
		
		for(int i = 0 ; i < directionPoint.size() ; i++) {			
			rectLine.add(directionPoint.get(i));
		}
		
		mMap.addPolyline(rectLine);
    }
}


/*

package app.akexorcist.googlemapsv2direction;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Main extends FragmentActivity {
	GoogleMap mMap;
	LatLng fromPosition = new LatLng(13.687140112679154, 100.53525868803263);
	LatLng toPosition = new LatLng(13.683660045847258, 100.53900808095932);

    GMapV2Direction md;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        md = new GMapV2Direction(getApplicationContext());
		mMap = ((SupportMapFragment)getSupportFragmentManager()
						.findFragmentById(R.id.map)).getMap();

		LatLng coordinates = new LatLng(13.685400079263206, 100.537133384495975);
		
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16));
		
		mMap.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				final LatLng coordinate = arg0;
				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setTitle("Select Marker")
						.setItems(new String[]{ "From", "To" }, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int position) {
						if(position == 0) 
							fromPosition = coordinate;
						else if(position == 1)
							toPosition = coordinate;
						refreshMarker();
					}
				});
				builder.show();
			}
		});

		refreshMarker();
    }
	
	public void refreshMarker() {
		mMap.clear();
		mMap.addMarker(new MarkerOptions().position(fromPosition).title("A"));
		mMap.addMarker(new MarkerOptions().position(toPosition).title("B"));
		
		Document doc = md.getDocument(fromPosition, toPosition, GMapV2Direction.MODE_DRIVING);
		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		md.getDurationValue(doc);
		md.getStartAddress(doc);
		md.getCopyRights(doc);
		
		PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);
		
		for(int i = 0 ; i < directionPoint.size() ; i++) {			
			rectLine.add(directionPoint.get(i));
		}
		mMap.addPolyline(rectLine);
	}
}


*/
