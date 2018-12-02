package com.example.pedro.woof.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class AlbergueSQLiteHelper extends SQLiteOpenHelper {

/*
    private String nombre;
    private String direccion;
    private int telefono;
    private String correo;
    private String clave;

 */
    private String sqlCreate = "CREATE TABLE Albergue ( nombre TEXT, direccion TEXT, telefono INTEGER, correo TEXT, clave TEXT " +
        " , fb TEXT , twitter TEXT, instagram TEXT)";

    public AlbergueSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Albergue");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreate);
    }

    public boolean checkAlbergue(String email, String password) {

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


    public String searchPass(String correo){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select correo, clave from Albergue";
        Cursor cursor = db.rawQuery(query,null);
        String a, b;
        b="No encontrado";

        if (cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if (a.equals(correo)){
                    b=cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }

        return b;


    }


}
