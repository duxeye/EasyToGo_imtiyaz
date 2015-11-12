package com.duxeye.easytogo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by asuss on 11/11/2015.
 */
public class MapActivity extends Activity {

    LatLng latLng;
    String selectedInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        GoogleMap googleMap;
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        Bundle bundle  = getIntent().getExtras();
        if(bundle.containsKey("latlng") && bundle.containsKey("selected_interest"))
        {
            latLng = (LatLng)bundle.get("latLng");
            selectedInt  = (String)bundle.get("selected_interest");

            PlacesService placesService  = new PlacesService("AIzaSyAdZ10Kp28uui3-m7uw_qbpO6c06nl8m8A");
            ArrayList<String> arrayList  = placesService.findPlaces(latLng.latitude, latLng.longitude, selectedInt);

            if(arrayList!=null)
            {
                Log.e("arrayList  : ",""+arrayList.size());
            }
        }


//        https://maps.googleapis.com/maps/api/place/search/json?types=cafe&location=37.787930,-122.4074990&radius=5000&sensor=false&key=%20AIzaSyAdZ10Kp28uui3-m7uw_qbpO6c06nl8m8A



    }
}
