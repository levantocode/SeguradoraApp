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
import android.widget.TextView;

import com.example.root.seguradoraco.R;
import com.example.root.seguradoraco.controller.HttpRequestMarcas;
import com.example.root.seguradoraco.controller.HttpRequestModelos;
import com.example.root.seguradoraco.controller.ListaCarros;
import com.example.root.seguradoraco.controller.ListaMarcas;
import com.example.root.seguradoraco.controller.ListaModelos;
import com.example.root.seguradoraco.model.Carro;

import java.util.List;


public class NovoCarroActivity extends AppCompatActivity {

    HttpRequestMarcas httpRequestMarcas = new HttpRequestMarcas();
    HttpRequestModelos httpRequestModelos = new HttpRequestModelos();

    ListaMarcas  listaMarcas;
    ListaModelos listaModelos;
    ListaCarros  listaCarros;


    TextView txtErro;

    EditText etPlacaLetras;
    EditText etPlacaNumeros;
    EditText etAnoDoCarro;

    Spinner spnMarca;
    Spinner spnModelo;
    ArrayAdapter<String> dataAdapterMarca;
    ArrayAdapter<String> dataAdapterModelo;

    Button btnSalvar;
    Button btnCancelar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_carro);


        listaMarcas = new ListaMarcas(httpRequestMarcas);

        txtErro = (TextView) findViewById(R.id.txtErro);

        etPlacaLetras  = (EditText) findViewById(R.id.etPlacaLetras);
        etPlacaNumeros = (EditText) findViewById(R.id.etPlacaNumeros);
        etAnoDoCarro   = (EditText) findViewById(R.id.etAnoDoCarro);

        spnMarca  = (Spinner) findViewById(R.id.spnMarca);
        spnModelo = (Spinner) findViewById(R.id.spnModelo);

        btnSalvar   = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);








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

                //Spinner Modelo
                dataAdapterModelo.addAll(listaModelos.getNomeTodosModelos());
                dataAdapterModelo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnModelo.setAdapter(dataAdapterModelo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // nothing happens
            }
        });






        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tamanhoPlacaLetras  = etPlacaLetras.getText().length();
                int tamanhoPlacaNumeros = etPlacaNumeros.getText().length();
                int tamanhoAnoDoCarro   = etAnoDoCarro.getText().length();

                int anoDoCarroEmNumeros = Integer.parseInt(etAnoDoCarro.getText().toString());



                // Errors
                if( tamanhoPlacaLetras != 3 || tamanhoPlacaNumeros != 3 ){
                    txtErro.setText("Placa Invalida");

                    if( tamanhoAnoDoCarro != 4 || anoDoCarroEmNumeros < 1800 ){
                        txtErro.setText("Placa Inválida, Ano do Carro Inválido");
                    }

                    txtErro.setVisibility(View.VISIBLE);
                }

                if( tamanhoAnoDoCarro != 4 || anoDoCarroEmNumeros < 1800 ){
                    txtErro.setText("Ano do Carro é Inválido");
                }
                // Fim Errors



                String placaCompleta;
                String selectedMarca;
                String selectedModelo;

                placaCompleta = etPlacaLetras.getText() + "-" + etPlacaNumeros.getText();
                selectedMarca = spnMarca.getSelectedItem().toString();
                selectedModelo = spnModelo.getSelectedItem().toString();



                listaCarros.addCarro(new Carro(placaCompleta,
                                                selectedMarca,
                                                selectedModelo,
                                                anoDoCarroEmNumeros));


                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }


}
