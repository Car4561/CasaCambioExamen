package com.example.llerenahuayta_17100648;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBManager {
    static private DatabaseHelper dbHelper;
    static private SQLiteDatabase database;
    private Context context;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<Integer> getData(String sql) {
        Cursor cursor;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        this.open();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            arrayList.add(cursor.getInt(0));
        }
        this.close();
        return arrayList;

    }
    private int codigo;
    private double envia;
    private double recibe;
    private double valorTipoCambio;
    private String monedaTipocambio;
    private String fechaCreacion;
    private String estado;
    public void insert(Double envia, Double recibe, double valorTipoCambio,String monedaTipocambio, String fechaCreacion,String estado) {
        this.open();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.ENVIA, envia);
        contentValue.put(DatabaseHelper.RECIBE, recibe);
        contentValue.put(DatabaseHelper.VALORTIPOCAMBIO, valorTipoCambio);
        contentValue.put(DatabaseHelper.MONEDATIPOCAMBIO, monedaTipocambio);
        contentValue.put(DatabaseHelper.FECHACREACION, fechaCreacion);
        contentValue.put(DatabaseHelper.ESTADO, estado);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        this.close();
    }

    public ArrayList<Transaccion> fetch() {
        this.open();
        ArrayList<Transaccion> arrayList = new ArrayList<>();
        String[] columns = new String[]{DatabaseHelper.CODIGO, DatabaseHelper.ENVIA
                , DatabaseHelper.RECIBE, DatabaseHelper.VALORTIPOCAMBIO,DatabaseHelper.MONEDATIPOCAMBIO,DatabaseHelper.FECHACREACION,DatabaseHelper.ESTADO};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns
                , null, null
                , null, null, null);
        while (cursor.moveToNext()) {
            int codigo = cursor.getInt(0);
            double envia = cursor.getDouble(1);
            double recibe= cursor.getDouble(2);
            double valorTipoCambio= cursor.getDouble(3);
            String monedaTipocambio = cursor.getString(4);
            String fechaCreacion= cursor.getString(5);
            String estado= cursor.getString(6);

            arrayList.add(new Transaccion(codigo,envia,recibe,valorTipoCambio,monedaTipocambio,fechaCreacion,estado));
        }
        this.close();
        return arrayList;
    }

    public void update(long codigo, String nombre, Double precio, byte[] imagen) {
        this.open();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.ENVIA, envia);
        contentValue.put(DatabaseHelper.RECIBE, recibe);
        contentValue.put(DatabaseHelper.VALORTIPOCAMBIO, valorTipoCambio);
        contentValue.put(DatabaseHelper.MONEDATIPOCAMBIO, monedaTipocambio);
        contentValue.put(DatabaseHelper.FECHACREACION, fechaCreacion);
        contentValue.put(DatabaseHelper.ESTADO, estado);
        int i = database.update(DatabaseHelper.TABLE_NAME
                , contentValue
                , DatabaseHelper.CODIGO + " = " + codigo
                , null);
        this.close();
    }

    public void delete(int codigo) {
        this.open();
        database.delete(DatabaseHelper.TABLE_NAME
                , DatabaseHelper.CODIGO + "=" + codigo
                , null);
        this.close();
    }
}
