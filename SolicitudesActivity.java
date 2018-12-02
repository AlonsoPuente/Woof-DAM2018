package com.example.pedro.woof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SolicitudesActivity extends AppCompatActivity {

    String[] listarreglo = new String[]{
            "Carlos Rodriguez desea adoptar a Blanquita","Maria Ramirez desea adoptar a Popi"

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes);



        // Se obtiene la lista menú
        ListView opcioneslista = (ListView) findViewById(R.id.listmenu);
        //Se crea un adptador de para crear la lista
        ArrayAdapter adaptador = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, listarreglo);
        // Se asigana el adaptador a la vista
        opcioneslista.setAdapter(adaptador);


        opcioneslista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    Toast.makeText(getApplicationContext(), "Escogiste  "  + listarreglo[0]  ,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), CarlosActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
