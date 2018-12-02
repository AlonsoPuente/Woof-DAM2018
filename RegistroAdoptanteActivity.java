package com.example.pedro.woof;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pedro.woof.SQLite.AdoptanteSQLiteHelper;

public class RegistroAdoptanteActivity extends AppCompatActivity {
    private EditText dnii;
    private EditText nombre;
    private EditText apellido;
    private EditText correo;
    private EditText clave;
    private EditText telefono;
    private EditText direccion;
    private EditText estadoCivil;// S=soltero; Co=conviviente; Ca=Casado y V=Viudo;
    private int estado; //Ha adoptado = 1; no ha adoptado=0;
    private int aceptado; //Si ha sido aceptado o no para adoptar


    private Button btnRegAdop;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_adoptante);
        //Obtenemos las referencias de los controles
        dnii = (EditText) findViewById(R.id.txtdni);
        nombre = (EditText) findViewById(R.id.txtNombreAdopt);
        apellido = (EditText) findViewById(R.id.txtApellidoAdopt);
        telefono = (EditText) findViewById(R.id.txtTelfAdopt);
        correo = (EditText) findViewById(R.id.txtCorreoAdopt);
        clave = (EditText) findViewById(R.id.txtClaveAdopt);
        direccion = (EditText) findViewById(R.id.txtDireccionAdopt);
        estadoCivil = (EditText) findViewById(R.id.txtEstadoCivAdopt);
        estado = 0;
        aceptado = 0;

        btnRegAdop =  (Button) findViewById(R.id.btnRegistrarAdop);


        //Abrimos la base de datos "DBUsuarios" en modo escritura
        final AdoptanteSQLiteHelper dsdbh = new AdoptanteSQLiteHelper(this, "DBAdoptante", null, 1);

        db = dsdbh.getWritableDatabase();

        //Agregamos los click Listener de los botones:

        //BOTÓN INSTERTAR
        btnRegAdop .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dnii.getText().toString();
                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String tel = telefono.getText().toString();
                String cor = correo.getText().toString();
                String pw = clave.getText().toString();
                String dir = direccion.getText().toString();
                String ec = estadoCivil.getText().toString();
                estado = 0;
                aceptado = 0;


                //Alternativa 2: método insert()

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("dni", dni);
                nuevoRegistro.put("nombre", nom);
                nuevoRegistro.put("apellido", ape);
                nuevoRegistro.put("telefono", tel);
                nuevoRegistro.put("correo", cor);
                nuevoRegistro.put("direccion", dir);
                nuevoRegistro.put("clave", pw);
                nuevoRegistro.put("estadoCivil", ec);
                nuevoRegistro.put("estado", 0);
                nuevoRegistro.put("aceptado", 0);

                db.insert("Adoptante", null,nuevoRegistro);

                Toast.makeText(RegistroAdoptanteActivity.this, "Se Registró Correctamente", Toast.LENGTH_SHORT).show();

                //Limpiamos los controles después de la inserción
                dnii.setText("");
                nombre.setText("");
                apellido.setText("");
                correo.setText("");
                clave.setText("");
                telefono.setText("");
                direccion.setText("");
                estadoCivil.setText("");
                estado = 0;
                aceptado = 0;

                Intent intent = new Intent(getApplicationContext(), LoginAdoptanteActivity.class);
                startActivity(intent);

            }
        });


    }
}
