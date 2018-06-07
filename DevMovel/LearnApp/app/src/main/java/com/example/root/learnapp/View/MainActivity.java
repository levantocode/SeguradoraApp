package com.example.root.learnapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.learnapp.Controller.ControllerPerguntas;
import com.example.root.learnapp.Model.Pergunta;
import com.example.root.learnapp.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //Model
    Pergunta pergunta = new Pergunta();
    //Controller
    ControllerPerguntas controllerPerguntas = new ControllerPerguntas(pergunta);


    //View
    Button   btnGo, btnReset;
    TextView txtPergunta, txtNumberCounts;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGo           = (Button) findViewById(R.id.btnGo);
        btnReset        = (Button) findViewById(R.id.btnReset);
        txtPergunta     = (TextView) findViewById(R.id.txtPergunta);
        txtNumberCounts = (TextView) findViewById(R.id.txtNumberCounts);


        controllerPerguntas.definirPerguntas();



        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                txtPergunta.setText(pergunta.getRandomPergunta() );

                count++;
                txtNumberCounts.setText(Integer.toString(count));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                txtPergunta.setText("Buying Temperature");

                count = 0;
                txtNumberCounts.setText("0");
            }

        });



    }
}
