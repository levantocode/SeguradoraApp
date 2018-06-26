package com.example.root.seguradoraco.googleMaps;




public class MyMarker {

    private Double latitude;
    private Double longitude;

    private String description;


    public MyMarker(Double lat, Double longt, String desc){
        this.latitude    = lat;
        this.longitude   = longt;
        this.description = desc;
    }


    // Gets
    public Double getLat(){
        return this.latitude;
    }

    public Double getLon(){
        return this.longitude;
    }

    public String getDesc() {
        return this.description;
    }
}
