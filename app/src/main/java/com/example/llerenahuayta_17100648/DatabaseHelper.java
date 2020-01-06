package com.example.llerenahuayta_17100648;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Nombre de la tabla
    public static final String TABLE_NAME = "TRANSCCIONES";

    // Columnas de la tabla
    public static final String CODIGO = "codigo";
    public static final String ENVIA = "envia";
    public static final String RECIBE = "recibe";
    public static final String VALORTIPOCAMBIO = "valorTipoCambio";
    public static final String MONEDATIPOCAMBIO = "monedaTipocambio";
    public static final String FECHACREACION = "fechaCreacion";
    public static final String ESTADO = "estado";

    private int codigo;
    private double envia;
    private double recibe;
    private double valorTipoCambio;
    private String monedaTipocambio;
    private String fechaCreacion;
    private String estado;



    // Nombre de la base de datos
    static final String DB_NAME = "TRANSCCIONES.DB";

    // Versión de la base de datos(importante)
    static final int DB_VERSION = 10;

    // Script para la creación de la tabla
    private static final String CREATE_TABLE = " create table " + TABLE_NAME + " ( "
            + CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ENVIA + " REAL NOT NULL, "
            + RECIBE + " REAL NOT NULL, "
            + VALORTIPOCAMBIO + " REAL NOT NULL,  "
            + MONEDATIPOCAMBIO+" TEXT NOT NULL,  "
            +FECHACREACION+" TEXT NOT NULL, "
            +ESTADO+" TEXT NOT NULL "+" );";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
