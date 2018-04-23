package com.example.root.seguradoraco.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.root.seguradoraco.R;

public class MainActivity extends AppCompatActivity {

    Button btnConfirmar, btnDeletar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fabNovoCarro = findViewById(R.id.fabNovoCarro);

        fabNovoCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NovoCarroActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
