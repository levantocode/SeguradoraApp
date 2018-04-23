package com.example.root.seguradoraco.controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;


public class HttpRequestMarcas {

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request
    public List<String> sendGet() throws Exception {

        //Creating Connection
        URL url = new URL("http://fipeapi.appspot.com/api/1/carros/marcas.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        // optional default is GET
        connection.setRequestMethod("GET");
        //add request header
        connection.setRequestProperty("User-Agent", USER_AGENT);


        //Testing Connection
        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);


        //Reading Content
        BufferedReader brIn =
                new BufferedReader(new InputStreamReader(connection.getInputStream()) );


        //Getting Content
        String inputLine;
        StringBuffer sbDadosCru = new StringBuffer();

        while ( (inputLine = brIn.readLine()) != null){
            sbDadosCru.append(inputLine);
        }
        brIn.close();

        //System.out.println(response.toString());

        List<String> listaMarcasAchadas = findAllNames(new JSONArray(sbDadosCru.toString()));

        return listaMarcasAchadas;
    }

    public List<String> findAllNames(JSONArray dadosCru) {

        List<String> listaMarcasAchadas = new LinkedList<String>();

        try {
            for (int i = 0; i < dadosCru.length(); i++) {
                JSONObject jsonObj = dadosCru.getJSONObject(i);
                listaMarcasAchadas.add(jsonObj.getString("name"));
            }
        } catch (JSONException e) {
            // handle exception
        }


        return listaMarcasAchadas;
    }



}
