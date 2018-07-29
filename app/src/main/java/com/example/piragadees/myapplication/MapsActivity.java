package com.example.piragadees.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText latitude;
    private EditText longitude;
    private Button getLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        longitude=(EditText)findViewById(R.id.editText4);
        latitude=(EditText)findViewById(R.id.editText2);
        getLocation=(Button)findViewById(R.id.button2) ;




            getLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId()==R.id.button2){
                        final String lati=latitude.getText().toString();
                        final String longi1=longitude.getText().toString();
                        final double longiDouble=Double.parseDouble(longi1);
                        final double latiDouble=Double.parseDouble(lati);
                        LatLng yourLocation = new LatLng(longiDouble,latiDouble);
                        mMap.addMarker(new MarkerOptions().position(yourLocation));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(yourLocation));
                        mMap.animateCamera( CameraUpdateFactory.zoomTo( 14.0f ) );//Zoom your map

                    }



                }

            });







    }
}
