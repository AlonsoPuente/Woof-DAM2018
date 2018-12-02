package com.example.pedro.woof;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedro.woof.Albergue.MainActivity_Albergue;
import com.example.pedro.woof.Albergue.RegistroAlbergueActivity;
import com.example.pedro.woof.SQLite.AlbergueSQLiteHelper;

public class LoginAlbergueActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText txtCorreoAlb;
    EditText txtClaveAlb;
    Button btnIngresar;
    TextView tvRegister;
    AlbergueSQLiteHelper albergueSQLiteHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_albergue);
        linearLayout = (LinearLayout) findViewById(R.id.linearAlb);
        tvRegister = (TextView) findViewById(R.id.tvRegisterAlb);
        btnIngresar = (Button) findViewById(R.id.btnIngresarAlb);



        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCorreoAlb = (EditText) findViewById(R.id.txtCorreoAlb);
                txtClaveAlb = (EditText) findViewById(R.id.txtClaveAlb);
                String pw = txtClaveAlb.getText().toString().trim();
                String cor = txtCorreoAlb.getText().toString().trim();


               /* if(txtCorreoAlb.getText().length()>10 && !pw.isEmpty() && txtClaveAlb.getText().length()>4){
                    Intent accountsIntent = new Intent(getApplicationContext(), MainActivity_Albergue.class);
                    accountsIntent.putExtra("EMAIL", cor);
                    startActivity(accountsIntent);
                }*/


                if(cor != null && !cor.isEmpty()){

                    if(checkAlbergue(cor,pw)){
                        Intent accountsIntent = new Intent(getApplicationContext(), MainActivity_Albergue.class);
                        accountsIntent.putExtra("EMAIL", cor);
                        startActivity(accountsIntent);
                    }else{
                        Toast.makeText(LoginAlbergueActivity.this, "ERROR DE USUARIO  O CONTRASEÑA ("+txtCorreoAlb.getText().toString()+")", Toast.LENGTH_SHORT).show();
                    }
                }


                //Este código con sqlite puro no nos llego a salir, debido a que no se lograba jalar la data de los albrgues.
/*
                if(cor != null && !cor.isEmpty()){
                    String password = albergueSQLiteHelper.searchPass(cor);

                    if(pw.equals(password)){
                        Intent accountsIntent = new Intent(getApplicationContext(), MainActivity_Albergue.class);
                        accountsIntent.putExtra("EMAIL", cor);
                        startActivity(accountsIntent);
                    }else{
                        Toast.makeText(LoginAlbergueActivity.this, "ERROR DE USUARIO  O CONTRASEÑA ", Toast.LENGTH_SHORT).show();
                    }
                }

*/
/*

                if (txtCorreoAlb.getText().toString().isEmpty() && txtClaveAlb.getText().toString().isEmpty()) {
                    Snackbar.make(linearLayout, "Ingrese su Correo y Contraseña", Toast.LENGTH_SHORT).show();
                } else if (txtCorreoAlb.getText().toString().isEmpty()) {
                    Snackbar.make(linearLayout, "Ingrese su Correo", Toast.LENGTH_SHORT).show();
                } else if (txtClaveAlb.getText().toString().isEmpty()) {
                    Snackbar.make(linearLayout, "Ingrese su Correo", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(linearLayout,"ERROR DE USUARIO "+cor+" O CONTRASEÑA "+pw, Snackbar.LENGTH_LONG).show();
                    //verifyFromSQLite();
                    if (albergueSQLiteHelper.checkAlbergue(cor, pw )) {





                    } else {
                        // Snack Bar to show success message that record is wrong
                        Snackbar.make(linearLayout,"ERROR DE USUARIO O CONTRASEÑA", Snackbar.LENGTH_LONG).show();
                    }
                }*/

            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroAlbergueActivity.class);
                startActivity(intent);
            }
        });


    }

/*
    private void verifyFromSQLite() {



    }
*/
public boolean checkAlbergue(String email, String password) {

    // array of columns to fetch
    String[] columns = {
            "correo",
            "clave"
    };
    albergueSQLiteHelper = new AlbergueSQLiteHelper(getApplicationContext(), "DBUsuarios", null, 1);

    SQLiteDatabase db = albergueSQLiteHelper.getWritableDatabase();
    // selection criteria
    String selection = "correo = ? AND clave = ?";

    // selection arguments
    String[] selectionArgs = {email, password};

    // query user table with conditions
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
     */
    Cursor cursor = db.query("Albergue", //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
        return true;
    }

    return false;
}

}
