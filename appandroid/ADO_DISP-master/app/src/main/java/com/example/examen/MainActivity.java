package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btlogin, btregistro;
    EditText etusuario, etpasswordj;
    String usuario,password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btlogin = findViewById(R.id.btlogin);
        btregistro = findViewById(R.id.btreg);
        etusuario = findViewById(R.id.etusuario);
        etpasswordj = findViewById(R.id.etpasswordj);


        btlogin.setOnClickListener(this);
        btregistro.setOnClickListener(this);
    }
    private void validarusuario(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()) {
                            Intent intent= new Intent(getApplicationContext(),Boletos.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "Usuario y contraseña son incorrecta", Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> parametros = new HashMap<String, String>();
            parametros.put("usuario",etusuario.getText().toString());
            parametros.put("pass",etpasswordj.getText().toString());
            return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btlogin:{
                usuario=etusuario.getText().toString();
                password=etpasswordj.getText().toString();
                if (!usuario.isEmpty() && !password.isEmpty()){
             validarusuario("https://appado.webcindario.com/validar_usuario.php");
                }else{
                    Toast.makeText(MainActivity.this, "No se permite campos vacios", Toast.LENGTH_SHORT).show();

                }

                break;}
            case R.id.btreg: {
                Intent btregistro = new Intent(MainActivity.this, Registro.class);
                btregistro.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(btregistro);
                break;}


        }
    }

    }
