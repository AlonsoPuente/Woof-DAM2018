package com.example.pedro.woof;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pedro.woof.Adoptante.MainActivity_Adoptante;
import com.example.pedro.woof.Albergue.MainActivity_Albergue;
import com.example.pedro.woof.Albergue.RegistroAlbergueActivity;
import com.example.pedro.woof.SQLite.AdoptanteSQLiteHelper;

public class LoginAdoptanteActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    TextView tvRegister;
    Button btnIngresar;
    EditText txtCorreo;
    EditText txtClave;
    AdoptanteSQLiteHelper adoptanteSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adoptante);

        adoptanteSQLiteHelper = new AdoptanteSQLiteHelper(getApplicationContext(), "DBAdoptante", null, 1);
        linearLayout = (LinearLayout) findViewById(R.id.linearAdopt);
        tvRegister = (TextView) findViewById(R.id.tvRegisterAdopt);
        btnIngresar = (Button) findViewById(R.id.btnIngresarAdopt);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoAdopt);
        txtClave = (EditText) findViewById(R.id.txtClaveAdopt);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cor = txtCorreo.getText().toString().trim();
                String pw = txtClave.getText().toString().trim();
                verifyFromSQLite(cor,pw);
               /* String cor = txtCorreo.getText().toString();
                Intent accountsIntent = new Intent(getApplicationContext(), MainActivity_Adoptante.class);
                accountsIntent.putExtra("EMAIL", cor);
                startActivity(accountsIntent);*/
            }
        });

        //Agregar La actividad de REgistro para el usuario
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RegistroAdoptanteActivity.class);
                startActivity(intent);
            }
        });

    }

    private void verifyFromSQLite(String cor,String pw) {

        if (adoptanteSQLiteHelper.checkAdoptante(cor, pw)){


            Intent accountsIntent = new Intent(getApplicationContext(), MainActivity_Adoptante.class);
            accountsIntent.putExtra("EMAIL", cor);
            startActivity(accountsIntent);


        }else{
            // Snack Bar to show success message that record is wrong
            Snackbar.make(linearLayout,"ERROR DE USUARIO O CONTRASEÑA", Snackbar.LENGTH_LONG).show();
        }
    }



}
