package com.example.llerenahuayta_17100648;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TransaccionesActivity extends AppCompatActivity {
    FloatingActionButton ftbButton;
    RecyclerView rvTrans;
    ArrayList<Transaccion> list;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacciones);
        ftbButton= findViewById(R.id.ftbButton);
        rvTrans= findViewById(R.id.rvTrans);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rvTrans.setLayoutManager(lm);
        dbManager = new DBManager(this);
        list = new ArrayList<>();
        list= dbManager.fetch();
        RVAdapter rvAdapter = new RVAdapter(list);
        rvTrans.setAdapter(rvAdapter);
        ftbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
            }
        });

    }
}
