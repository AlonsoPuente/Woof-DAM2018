package com.example.pedro.woof.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DogSQLiteHelper extends SQLiteOpenHelper {

    //Script para crear la tabla Adoptante; Sentencia SQL para creat la tabla de usuarios
    private String sqlCreate = "CREATE TABLE Perro (id INTEGER PRIMARY KEY AUTOINCREMENT , estado INTEGER, nombre TEXT, edad INTEGER, sexo TEXT, " +
                                " descripcion TEXT, albergue TEXT, foto BLOB)";

    public DogSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Perro");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreate);
    }

    //Insertar imagen
    //X es image location de FotoID


    public Boolean insertar(Integer id, Integer est, String nom, Integer ed, String sex, String desc, String alb, String x ) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            FileInputStream fs = new FileInputStream(x);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", id);
            contentValues.put("estado", est);
            contentValues.put("nombre", nom);
            contentValues.put("edad", ed);
            contentValues.put("sexo", sex);
            contentValues.put("descripcion", desc);
            contentValues.put("albergue", alb);
            contentValues.put("foto", imgbyte);

            db.insert("Perro", null, contentValues);

            fs.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
