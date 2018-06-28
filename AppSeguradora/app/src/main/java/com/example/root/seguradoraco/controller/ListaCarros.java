package com.example.root.seguradoraco.controller;


import android.support.v7.app.AppCompatActivity;

import com.example.root.seguradoraco.R;
import com.example.root.seguradoraco.model.Carro;
import com.example.root.seguradoraco.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaCarros {

    private List<Carro> carros = new ArrayList<Carro>();

    public ListaCarros(){
        //nothing
    }





    // Gets
    public List<Carro> getListCarro(){
        return this.carros;
    }



    // Sets
    public void setListCarro(List<Carro> c){
        this.carros = c;
    }



    // Methods
    public void adicionarNoListView(String marca, String modelo, String placaInteira){

    }

    public void addCarro(Carro ca){
        this.carros.add(ca);
    }
}
