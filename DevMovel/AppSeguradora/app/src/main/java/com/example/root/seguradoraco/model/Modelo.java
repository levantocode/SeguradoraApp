package com.example.root.seguradoraco.model;

public class Modelo {
    private int id;
    private String nome;
    private String marca;
    private String chave;



    //Gets
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getChave(){
        return this.chave;
    }



    //Sets
    public void setId(int i){
        this.id = i;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setMarca(String m){
        this.marca = m;
    }

    public void setChave(String c){
        this.chave = c;
    }

}
