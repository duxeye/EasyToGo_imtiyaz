package com.duxeye.easytogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asuss on 11/10/2015.
 */
public class CategoryActivity extends Activity {

    LatLng latLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey("latlng")) {
            latLng = (LatLng)bundle.get("latlng");
        }


        // you need to have a list of data that you want the spinner to display
        final List<String> spinnerArray = new ArrayList<>();


        spinnerArray.add("accounting");
        spinnerArray.add("airport");
        spinnerArray.add("amusement_park");
        spinnerArray.add("art_gallery");
        spinnerArray.add("aquarium");
        spinnerArray.add("atm");
        spinnerArray.add("bakery");
        spinnerArray.add("bank");
        spinnerArray.add("bar");
        spinnerArray.add("beauty_salon");
        spinnerArray.add("bicycle_store");
        spinnerArray.add("book_store");
        spinnerArray.add("bowling_alley");
        spinnerArray.add("bus_station");


        spinnerArray.add("cafe");
        spinnerArray.add("campground");
        spinnerArray.add("car_dealer");
        spinnerArray.add("car_rent;");
        spinnerArray.add("car_repair");
        spinnerArray.add("car_wash");
        spinnerArray.add("casino");


        spinnerArray.add("cemetery");
        spinnerArray.add("church");
        spinnerArray.add("city_hall");
        spinnerArray.add("clothing_store");
        spinnerArray.add("convenience_store");
        spinnerArray.add("courthouse");
        spinnerArray.add("dentist");


        spinnerArray.add("department_store");
        spinnerArray.add("doctor");
        spinnerArray.add("electrician");
        spinnerArray.add("electronics_store");
        spinnerArray.add("embassy");
        spinnerArray.add("establishment");
        spinnerArray.add("finance");


        spinnerArray.add("fire_station");
        spinnerArray.add("florist");
        spinnerArray.add("food");
        spinnerArray.add("funeral_home");
        spinnerArray.add("furniture_store");
        spinnerArray.add("gas_station");
        spinnerArray.add("general_contractor");


        spinnerArray.add("grocery_or_supermarket");
        spinnerArray.add("gym");
        spinnerArray.add("hair_care");
        spinnerArray.add("hardware_store");
        spinnerArray.add("health");
        spinnerArray.add("hindu_temple");
        spinnerArray.add("home_goods_store");


        spinnerArray.add("hospital");
        spinnerArray.add("insurance_agency");
        spinnerArray.add("jewelry_store");
        spinnerArray.add("laundry");
        spinnerArray.add("lawyer");
        spinnerArray.add("liquor_store");
        spinnerArray.add("local_government_office");


        spinnerArray.add("locksmith");
        spinnerArray.add("lodging");
        spinnerArray.add("meal_delivery");
        spinnerArray.add("meal_takeaway");
        spinnerArray.add("mosque");
        spinnerArray.add("movie_rental");


        spinnerArray.add("movie_theater");
        spinnerArray.add("moving_company");
        spinnerArray.add("museum");
        spinnerArray.add("painter");
        spinnerArray.add("park");
        spinnerArray.add("parking");


        spinnerArray.add("pet_store");
        spinnerArray.add("pharmacy");
        spinnerArray.add("physiotherapist");
        spinnerArray.add("place_of_worship");
        spinnerArray.add("plumber");
        spinnerArray.add("police");


        spinnerArray.add("post_office");
        spinnerArray.add("real_estate_agency");
        spinnerArray.add("restaurant");
        spinnerArray.add("rv_park");
        spinnerArray.add("school");
        spinnerArray.add("shoe_store");

        spinnerArray.add("shopping_mall");
        spinnerArray.add("spa");
        spinnerArray.add("stadium");
        spinnerArray.add("storage");
        spinnerArray.add("subway_station");
        spinnerArray.add("synagogue");

        spinnerArray.add("taxi_stand");
        spinnerArray.add("train_station");
        spinnerArray.add("travel_agency");
        spinnerArray.add("university");
        spinnerArray.add("veterinary_care");
        spinnerArray.add("zoo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems = (Spinner) findViewById(R.id.spinner1);
        sItems.setAdapter(adapter);


        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int i= sItems.getSelectedItemPosition();
                Log.e("sItems : ","" + i + "  : "+spinnerArray.get(i));
                startActivity(new Intent(CategoryActivity.this, MapActivity.class).putExtra("latlng",latLng).putExtra("selected_interest",spinnerArray.get(i)));

            }
        });

    }
}
