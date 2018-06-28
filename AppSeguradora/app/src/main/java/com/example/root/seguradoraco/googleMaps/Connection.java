package com.example.root.seguradoraco.googleMaps;


import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.LinkedList;




public class Connection {
    public List<MyMarker> getData() throws JSONException {


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        final StringBuilder result = new StringBuilder();

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("https://api.myjson.com/bins/23k9u");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);



            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(result);

        List<MyMarker> finalResult = generateJSON(new JSONArray(result.toString()));

        return finalResult;
    }


    public List<MyMarker> generateJSON(JSONArray json){

        List<MyMarker> found = new LinkedList<MyMarker>();

        try {


            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                found.add(new MyMarker(obj.getJSONObject("geometry").getJSONArray("coordinates").getDouble(0),obj.getJSONObject("geometry").getJSONArray("coordinates").getDouble(1), obj.getJSONObject("properties").getString("name")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;

    }
}
