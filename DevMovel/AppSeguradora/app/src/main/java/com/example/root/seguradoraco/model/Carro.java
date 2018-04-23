package com.example.root.seguradoraco.model;

import java.io.Serializable;

public class Carro implements Serializable {
    private int id;
    private int ano;
    private int totalEventos;
    private String placa;
    private String marca;
    private String modelo;

    public Carro(String p, String ma, String mo){
        this.placa  = p;
        this.marca  = ma;
        this.modelo = mo;

    }


    //Gets
    public int getId(){
        return this.id;
    }

    public int getAno(){
        return this.ano;
    }

    public int getTotalEventos(){
        return this.totalEventos;
    }

    public String getPlaca(){
        return this.placa;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }


    //Sets
    public void setId(int i){
        this.id = i;
    }

    public void setAno(int a){
        this.ano = a;
    }

    public void setTotalEventos(int te){
        this.totalEventos = te;
    }

    public void setPlaca(String p){
        this.placa = p;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public void setModelo(String mo){
        this.modelo = mo;
    }
}
