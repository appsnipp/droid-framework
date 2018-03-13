package com.thirdeyews.droidframework.googlePlaces;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by kapil on 31/10/17.
 */

public class GetURIDetails {


    //Get direction URL require to call Google Maps API

    public static String  getMapsApiDirectionsUrl(LatLng origin, LatLng dest) {
        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        //providing alternative routes
//        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters+"&alternatives=true";




        return url;

    }

}
