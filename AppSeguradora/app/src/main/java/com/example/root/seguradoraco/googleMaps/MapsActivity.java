package com.example.root.seguradoraco.googleMaps;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;

import com.example.root.seguradoraco.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;

import android.content.Context;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import org.json.JSONException;

import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Connection connection = new Connection();
    private List<MyMarker> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        //obter o mapa da view
        SupportMapFragment mapFragment;
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);

        //set o callback
        mapFragment.getMapAsync(this);
    }


    //metodo callback
    @Override
    public void onMapReady(GoogleMap map) {

        try {
            this.markers = connection.getData();

            for (MyMarker myMarker : this.markers) {
                map.addMarker(new MarkerOptions().position(new LatLng(myMarker.getLat(), myMarker.getLon())).title(myMarker.getDesc()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        LocationListener gps = new GPS(map, this.markers);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, gps);
            return ;
        }

    }
}
