package com.example.root.seguradoraco.googleMaps;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;



public class GPS implements LocationListener {

    private Calculation calculation = new Calculation();

    private GoogleMap googleMap;
    private List<MyMarker> otherMarkers;



    public GPS(GoogleMap map, List<MyMarker> markers){
        this.googleMap = map;
        this.otherMarkers = markers;
    }



    @Override
    public void onLocationChanged(Location location) {

        Double distance = calculation.CalculationByDistance(new LatLng(location.getLatitude(), location.getLongitude()),
                                    new LatLng(this.otherMarkers.get(0).getLat(), this.otherMarkers.get(0).getLon()));
        Integer km = distance.intValue();

        MyMarker marker = new MyMarker(location.getLatitude(), location.getLongitude(), "");
        googleMap.addMarker(new MarkerOptions().position(new LatLng(marker.getLat(),
                marker.getLon())).title("I am here, "+km.toString()+"km from "+this.otherMarkers.get(0).getDesc()));

    }


    @Override
    public void onProviderDisabled(String provider) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
