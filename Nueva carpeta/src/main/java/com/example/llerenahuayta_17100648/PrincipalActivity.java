package com.example.llerenahuayta_17100648;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PrincipalActivity extends AppCompatActivity {
    EditText txtEnvias,txtRecibes;
    TextView txtTipoCambio;
    Spinner spnCambio;
    DBManager dbManager;
    Button btnIniciarOperacion;
    String valorTipoCambio;
    Double cambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtEnvias=findViewById(R.id.txtEnvias);
        txtRecibes=findViewById(R.id.txtRecibes);
        txtTipoCambio=findViewById(R.id.txtTipodecambio);
        dbManager = new DBManager(this);
        btnIniciarOperacion=findViewById(R.id.btnIniciarOperaecion);
        spnCambio=findViewById(R.id.spnCambio);
        conseguirCambio();
        spnCambio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    txtRecibes.setText(String.valueOf(Double.parseDouble(txtEnvias.getText().toString())*Double.parseDouble(txtTipoCambio.getText().toString())));
                    valorTipoCambio="SOLES A DOLARES";
                }
                if(i==2){
                    txtRecibes.setText(String.valueOf(Double.parseDouble(txtEnvias.getText().toString())/Double.parseDouble(txtTipoCambio.getText().toString())));
                    valorTipoCambio="DOLARES A SOLES";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnIniciarOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.insert(Double.parseDouble(txtEnvias.getText().toString()),Double.parseDouble(txtEnvias.getText().toString()),Double.parseDouble(txtTipoCambio.getText().toString()),valorTipoCambio,"7/12/2019","P");
                startActivity(new Intent(getApplicationContext(),TransaccionesActivity.class));
            }
        });
    }

    private void conseguirCambio() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://www.kreapps.biz/casacambio/getTipoCambio.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, "", new Response.Listener<JSONObject>() {
            String valCor;
            @Override
            public void onResponse(JSONObject response) {
                    try {

                        JSONObject jsonChildNode = response;
                        valCor=response.getString("tipoCambio");
                        Toast.makeText(getApplicationContext(), valCor, Toast.LENGTH_SHORT).show();
                        txtTipoCambio.setText(valCor);

                    } catch (JSONException error) {

                    }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Procesar VolleyError
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
        };
    //Se agrega a la cola de peticiones
        requestQueue.add(request);

}

    }

