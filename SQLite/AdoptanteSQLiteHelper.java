package com.example.pedro.woof.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class AdoptanteSQLiteHelper extends SQLiteOpenHelper {


    //Script para crear la tabla Adoptante; Sentencia SQL para creat la tabla de usuarios
    private String sqlCreate = "CREATE TABLE Adoptante (dni TEXT, nombre TEXT, apellido TEXT, correo TEXT, clave TEXT, telefono TEXT, direccion TEXT," +
                                                        " estadoCivil TEXT , estado INTEGER, aceptado INTEGER)";

    public AdoptanteSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        //Creación de la tabla "Producto"
        Log.i("onCreate", "CREA TABLA");
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Este método se activa cuando se tiene una nueva versión de la tabla (por ejemplo si agregas un nuevo campo)
        //Se elimina la versión anterior de la tabla
        Log.i("onUpgrade", "CAMBIO LA BASE DE DATOS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Adoptante");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreate);
    }

    public boolean checkAdoptante(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                "correo"
        };
        SQLiteDatabase db = this.getReadableDatabase();
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
        Cursor cursor = db.query("Adoptante", //Table to query
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
