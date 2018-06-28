package com.example.root.seguradoraco.model;

public class Modelo {
    private int idMarca;
    private String nome;
    private String key;


    public Modelo(int im, String n, String k) {
        this.idMarca = im;
        this.nome = n;
        this.key = k;
    }

    //Gets
    public int getIdMarca(){
        return this.idMarca;
    }

    public String getNome(){
        return this.nome;
    }

    public String getKey(){
        return this.key;
    }



    //Sets
    public void setMarca(int im){
        this.idMarca = im;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setKey(String k){
        this.key = k;
    }

}
