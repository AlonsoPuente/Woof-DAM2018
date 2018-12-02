package com.example.pedro.woof;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pedro.woof.Albergue.MainActivity_Albergue;
import com.example.pedro.woof.Albergue.RegistroAlbergueActivity;
import com.example.pedro.woof.SQLite.AlbergueSQLiteHelper;
import com.example.pedro.woof.SQLite.DogSQLiteHelper;

public class RegistroPerroActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtEdad;
    private EditText txtSexo;
    private EditText txtDescripcion;
    private EditText txtAlbergue;
    private ImageView imgFoto;
    //LA FOTOOOOOO

    private  static final int PICK_IMAGE=100;
    private Button btnInsertarImg;
    private Button btnRegistrar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_perro);

        //Obtenemos las referencias de los controles
        txtNombre = (EditText) findViewById(R.id.txtNombreDog);
        txtEdad = (EditText) findViewById(R.id.txtEdadDog);
        txtSexo = (EditText) findViewById(R.id.txtSexoDog);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcionDog);
        txtAlbergue = (EditText) findViewById(R.id.txtAlbergueDog);


        btnInsertarImg = (Button) findViewById(R.id.btnInsertarImg);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrarDog);


        //Abrimos la base de datos "DBUsuarios" en modo escritura
        final DogSQLiteHelper dsdbh = new DogSQLiteHelper(this, "DBUsuarios", null, 1);

        db = dsdbh.getWritableDatabase();

        //Agregamos los click Listener de los botones:
        //BOTÓN Imagen
        /*
        btnInsertarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("contents://media/internal/images/media"));
                startActivityForResult(intent,PICK_IMAGE);
            }
        });*/


        //BOTÓN Registrar
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





             /*   String nom = txtNombre.getText().toString();
                String edad = txtEdad.getText().toString();
                String sex = txtSexo.getText().toString();
                String desc = txtDescripcion.getText().toString();
                String alb = txtAlbergue.getText().toString();
                int estado = 0;

                //Alternativa 2: método insert()

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nom);
                nuevoRegistro.put("edad", edad);
                nuevoRegistro.put("sexo", sex);
                nuevoRegistro.put("descripcion", desc);
                nuevoRegistro.put("albergue", alb);
                nuevoRegistro.put("estado", estado);
                //nuevoRegistro.put("foto", FOTOOOOOO);

                db.insert("Perro", null,nuevoRegistro);

                Toast.makeText(RegistroPerroActivity.this, "Se Registró Correctamente", Toast.LENGTH_SHORT).show();

                //Limpiamos los controles después de la inserción
                txtNombre.setText("");
                txtEdad.setText("");
                txtSexo.setText("");
                txtDescripcion.setText("");
                txtAlbergue.setText("");

                Intent intent = new Intent(getApplicationContext(), MainActivity_Albergue.class);
                startActivity(intent);*/

            }
        });

    }

}
