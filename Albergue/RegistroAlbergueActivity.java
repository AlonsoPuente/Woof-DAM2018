package com.example.pedro.woof.Albergue;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pedro.woof.LoginAlbergueActivity;
import com.example.pedro.woof.R;
import com.example.pedro.woof.SQLite.AlbergueSQLiteHelper;

public class RegistroAlbergueActivity extends AppCompatActivity {
    //Declaramos las variables del Layout
    private EditText txtNombre;
    private EditText txtDireccion;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private EditText txtClave;


    private Button btnRegistrar;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_albergue);
        //Obtenemos las referencias de los controles
        txtNombre = (EditText) findViewById(R.id.txtNombreAlbReg);
        txtDireccion = (EditText) findViewById(R.id.txtDireccionAlbReg);
        txtTelefono = (EditText) findViewById(R.id.txtTelfAlbReg);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoAlbReg);
        txtClave = (EditText) findViewById(R.id.txtClaveAlbReg);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrarAlb);



        //Abrimos la base de datos "DBUsuarios" en modo escritura
        final AlbergueSQLiteHelper dsdbh = new AlbergueSQLiteHelper(this, "DBUsuarios", null, 1);

        db = dsdbh.getWritableDatabase();

        //Agregamos los click Listener de los botones:

        //BOTÓN INSTERTAR
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = txtNombre.getText().toString();
                String dir = txtDireccion.getText().toString();
                String telf = txtTelefono.getText().toString();
                String cor = txtCorreo.getText().toString();
                String pw = txtClave.getText().toString();
                String fb = "www.facebook.com";
                String twt = "www.twitter.com";
                String ig = "www.instagram.com";


                //Alternativa 2: método insert()

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nom);
                nuevoRegistro.put("direccion", dir);
                nuevoRegistro.put("telefono", telf);
                nuevoRegistro.put("correo", cor);
                nuevoRegistro.put("clave", pw);
                nuevoRegistro.put("fb", fb);
                nuevoRegistro.put("twitter", twt);
                nuevoRegistro.put("instagram", ig);
                db.insert("Albergue", null,nuevoRegistro);

                Toast.makeText(RegistroAlbergueActivity.this, "Se Registró Correctamente", Toast.LENGTH_SHORT).show();

                //Limpiamos los controles después de la inserción
                txtNombre.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtCorreo.setText("");
                txtClave.setText("");

                Intent intent = new Intent(getApplicationContext(), LoginAlbergueActivity.class);
                startActivity(intent);

            }
        });
    }
}
