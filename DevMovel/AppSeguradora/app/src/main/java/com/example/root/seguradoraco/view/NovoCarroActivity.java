package com.example.root.seguradoraco.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.seguradoraco.R;
import com.example.root.seguradoraco.controller.HttpRequestMarcas;

import java.util.ArrayList;
import java.util.List;


public class NovoCarroActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;

    Spinner spnMarca;
    Spinner spnModelo;

    EditText etPlacaLetras;
    EditText etPlacaNumeros;
    EditText etAnoDoCarro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_carro);

        btnSalvar   = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        spnMarca  = (Spinner) findViewById(R.id.spnMarca);
        spnModelo = (Spinner) findViewById(R.id.spnModelo);

        etPlacaLetras  = (EditText) findViewById(R.id.etPlacaLetras);
        etPlacaNumeros = (EditText) findViewById(R.id.etPlacaNumeros);
        etAnoDoCarro   = (EditText) findViewById(R.id.etAnoDoCarro);



        List<String> lista = new ArrayList<String>();

        lista.add("teste um");
        lista.add("teste dois");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMarca.setAdapter(dataAdapter);




        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }


}
