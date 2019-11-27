package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    Button btregistro, btyacuenta;
    EditText etcorreo, etusuario, etpassword, etpassword2;

    private static String URL_REGIST = "https://appado.webcindario.com/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btregistro = findViewById(R.id.btregistrar);
        etcorreo = findViewById(R.id.etcorreo);
        etusuario = findViewById(R.id.etusuario);
        etpassword = findViewById(R.id.etpassword);
        btyacuenta = findViewById(R.id.btyacuenta);
        btregistro.setOnClickListener(this);
        btyacuenta.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btregistrar: {
                regist();
                Toast.makeText(Registro.this, "Registrando", Toast.LENGTH_SHORT).show();

            }
            case R.id.btyacuenta: {

                Intent btcuenta = new Intent(Registro.this, MainActivity.class);
                btcuenta.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(btcuenta);
                break;
            }

        }

    }
    private void regist(){
        final String usuario = this.etusuario.getText().toString().trim();
        final String correo = this.etcorreo.getText().toString().trim();
        final String pass = this.etpassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                Toast.makeText(Registro.this, "Registrando", Toast.LENGTH_SHORT).show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(Registro.this, "Registro de Error" + e.toString(), Toast.LENGTH_SHORT).show();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registro.this, "Registro de Error" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("usuario",usuario);
                params.put("correo",correo);
                params.put("pass",pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

