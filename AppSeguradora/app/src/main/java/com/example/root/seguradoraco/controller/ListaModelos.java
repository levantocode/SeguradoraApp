package com.example.root.seguradoraco.controller;


import com.example.root.seguradoraco.model.Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListaModelos {
    private List<Modelo> listaModelos = new ArrayList<Modelo>();



    public ListaModelos(HttpRequestModelos hrModelos, int idMarca){
        try{
            this.listaModelos = hrModelos.sendGetModelos(idMarca);
        }

        catch(Exception e){
            //
        }
    }




    //GETs
    public List<String> getNomeTodosModelos(){
        List<String> listaNomeTodosModelos = new LinkedList<String>();

        for(Modelo modelo:listaModelos){
            listaNomeTodosModelos.add(modelo.getNome());
        }

        return listaNomeTodosModelos;
    }
}
