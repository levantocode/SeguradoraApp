package com.example.root.seguradoraco.controller;


import com.example.root.seguradoraco.model.Marca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListaMarcas {
    private List<Marca> listaMarcas = new ArrayList<Marca>();



    public ListaMarcas(HttpRequestMarcas hrMarcas){
        try{
            this.listaMarcas = hrMarcas.sendGetMarcas();
        }

        catch(Exception e){
            //
        }
    }




    //GETs
    public List<String> getNomeTodasMarcas(){
        List<String> listaNomeTodasMarcas = new LinkedList<String>();

        for(Marca marca:listaMarcas){
            listaNomeTodasMarcas.add(marca.getNome());
        }

        return listaNomeTodasMarcas;
    }




    public int findIdMarcaByName(String nameMarca) {
        int idMarca = 0;

        for(Marca marca:listaMarcas){
            if(marca.getNome().equals(nameMarca)){
                idMarca = marca.getId();
                break;
            }
        }

        return idMarca;
    }
}
