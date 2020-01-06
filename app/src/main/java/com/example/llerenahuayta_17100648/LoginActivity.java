package com.example.llerenahuayta_17100648;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private Button btnIngresar;
    private EditText txtDNI, txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtDNI = findViewById(R.id.txtDNI);
        txtClave = findViewById(R.id.txtClave);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String dni = txtDNI.getText().toString();
                final String clave = txtClave.getText().toString();
                if (dni.length() < 8 || dni.length()>8) {
                    Toast.makeText(LoginActivity.this, "DNI debe tener 8 digitos", Toast.LENGTH_SHORT).show();
                } else {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    String url = "http://www.kreapps.biz/casacambio/validar.php";
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, "DNI=" + dni + "&PWD=" + clave, new Response.Listener<JSONObject>() {
                        String valCor = "";

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.getJSONArray("loginresult");
                                Toast.makeText(LoginActivity.this, jsonArray.toString(), Toast.LENGTH_SHORT).show();

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    valCor = jsonObject.getString("Correo");

                                    if (!valCor.equals("")) {
                                        Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Correo o Clave incorrecta", Toast.LENGTH_LONG).show();
                                    }
                                }
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
        });

    }
}
