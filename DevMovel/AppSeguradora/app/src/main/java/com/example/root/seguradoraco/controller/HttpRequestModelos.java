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


public class HttpRequestModelos {

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request ID
    public List<String> sendGetID() throws Exception {

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
                new BufferedReader(new InputStreamReader(connection.getInputStream()));


        //Getting Content
        String inputLine;
        StringBuffer sbDadosCru = new StringBuffer();

        while ((inputLine = brIn.readLine()) != null) {
            sbDadosCru.append(inputLine);
        }
        brIn.close();

        //System.out.println(response.toString());

        List<String> listaIDs = findAllIDs(new JSONArray(sbDadosCru.toString()));

        return listaIDs;
    }

    public List<String> findAllIDs(JSONArray dadosCru) {

        List<String> listaIDs = new LinkedList<String>();

        try {
            for (int i = 0; i < dadosCru.length(); i++) {
                JSONObject jsonObj = dadosCru.getJSONObject(i);
                listaIDs.add(jsonObj.getString("id"));
            }
        } catch (JSONException e) {
            // handle exception
        }


        return listaIDs;
    }







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
                new BufferedReader(new InputStreamReader(connection.getInputStream()));


        //Getting Content
        String inputLine;
        StringBuffer sbDadosCru = new StringBuffer();

        while ((inputLine = brIn.readLine()) != null) {
            sbDadosCru.append(inputLine);
        }
        brIn.close();

        //System.out.println(response.toString());

        List<String> listaModelosAchados = findAllModelos(new JSONArray(sbDadosCru.toString()));

        return listaModelosAchados;
    }

    public List<String> findAllModelos(JSONArray dadosCru) {

        List<String> listaModelosAchados = new LinkedList<String>();

        try {
            for (int i = 0; i < dadosCru.length(); i++) {
                JSONObject jsonObj = dadosCru.getJSONObject(i);
                listaModelosAchados.add(jsonObj.getString("model"));
            }
        } catch (JSONException e) {
            // handle exception
        }


        return listaModelosAchados;
    }
}
