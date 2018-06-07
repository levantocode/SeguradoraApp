package com.example.root.seguradoraco.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.seguradoraco.R;
import com.example.root.seguradoraco.controller.HttpRequestMarcas;
import com.example.root.seguradoraco.controller.HttpRequestModelos;
import com.example.root.seguradoraco.controller.ListaMarcas;
import com.example.root.seguradoraco.controller.ListaModelos;

import java.util.List;


public class NovoCarroActivity extends AppCompatActivity {

    HttpRequestMarcas httpRequestMarcas = new HttpRequestMarcas();
    HttpRequestModelos httpRequestModelos = new HttpRequestModelos();

    ListaMarcas  listaMarcas;
    ListaModelos listaModelos;

    List<String> listaNomeTodosModelos;


    Button btnSalvar;
    Button btnCancelar;

    Spinner spnMarca;
    Spinner spnModelo;
    ArrayAdapter<String> dataAdapterMarca;
    ArrayAdapter<String> dataAdapterModelo;

    EditText etPlacaLetras;
    EditText etPlacaNumeros;
    EditText etAnoDoCarro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_carro);


        listaMarcas = new ListaMarcas(httpRequestMarcas);

        btnSalvar   = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        spnMarca  = (Spinner) findViewById(R.id.spnMarca);
        spnModelo = (Spinner) findViewById(R.id.spnModelo);

        etPlacaLetras  = (EditText) findViewById(R.id.etPlacaLetras);
        etPlacaNumeros = (EditText) findViewById(R.id.etPlacaNumeros);
        etAnoDoCarro   = (EditText) findViewById(R.id.etAnoDoCarro);






        //Spinner Modelo

        dataAdapterModelo = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item);






        //Spinner Marca
        dataAdapterMarca = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item,
                            listaMarcas.getNomeTodasMarcas());

        dataAdapterMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMarca.setAdapter(dataAdapterMarca);



        spnMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String itemSelecionado = parentView.getItemAtPosition(position).toString();
                int idItemSelecionado = listaMarcas.findIdMarcaByName(itemSelecionado);

                listaModelos = new ListaModelos(httpRequestModelos, idItemSelecionado);
                listaNomeTodosModelos = listaModelos.getNomeTodosModelos();

                //Spinner Modelo
                dataAdapterModelo.addAll(listaNomeTodosModelos);
                dataAdapterModelo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnModelo.setAdapter(dataAdapterModelo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });






        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }


}
