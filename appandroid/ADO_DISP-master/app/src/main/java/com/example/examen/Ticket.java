package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Ticket extends AppCompatActivity implements View.OnClickListener{
    Integer precioBoleto,counter,subTotal,total,contadorboletos,totalboleto,subtotalboleto;
    String destino,origen,horarioSalida="",horarioRegreso="";
    Boolean roundtrip;
    LinearLayout layoutRegreso;
    Double totalb;

    Button payButton, printButton;
    TextView originTV, destinyTV,horarioSalidaTV,horarioRegresoTV,counterTV,subTotalTV,totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Bundle datosRecibidos = new Bundle();
        datosRecibidos = getIntent().getExtras();

        precioBoleto = datosRecibidos.getInt("precioBoleto");
        roundtrip = datosRecibidos.getBoolean("roundtrip");
        origen = datosRecibidos.getString("origen");
        destino = datosRecibidos.getString("destino");
        horarioSalida = datosRecibidos.getString("horarioSalida");
        horarioRegreso = datosRecibidos.getString("horarioRegreso");
        counter = datosRecibidos.getInt("counter");

        payButton = findViewById(R.id.payButton);
        printButton = findViewById(R.id.printButton);

        payButton.setOnClickListener(this);


        originTV = findViewById(R.id.originTV);
        destinyTV = findViewById(R.id.destinyTV);
        horarioSalidaTV = findViewById(R.id.horarioSalidaTV);
        horarioRegresoTV = findViewById(R.id.horarioRegresoTV);
        counterTV = findViewById(R.id.counterTV);
        subTotalTV = findViewById(R.id.subTotalTV);
        totalTV = findViewById(R.id.totalTV);
        layoutRegreso = findViewById(R.id.layoutRegreso);

        if(roundtrip.equals(true)){
            layoutRegreso.setVisibility(View.VISIBLE);
        }else{
            layoutRegreso.setVisibility(View.INVISIBLE);
        }

        this.total();

    }

    @Override
    public void onClick(View v) {

        if(payButton.isPressed()){

            contadorboletos=1;

            originTV.setText(origen);
            destinyTV.setText(destino);
            horarioSalidaTV.setText(horarioSalida);
            //
            if(roundtrip.equals(true)){
                horarioRegresoTV.setText(horarioRegreso);
            }else{
                horarioRegresoTV.setText("---");
            }
            //
            printButton.setEnabled(true);
            printButton.setOnClickListener(this);


            counterTV.setText(contadorboletos.toString());
            subTotalTV.setText("$"+subtotalboleto.toString()+" MXN");
            totalTV.setText("$"+total.toString()+ " MXN");
            //Toast.makeText(Ticket.this, precioBoleto.toString(),Toast.LENGTH_SHORT).show();
           // Toast.makeText(Ticket.this, originTV.toString(), Toast.LENGTH_LONG).show();
            tickets("http://appado.webcindario.com/consu_tickets.php");
           // payButton.setEnabled(false);

        }if (printButton.isPressed()){
            if (contadorboletos<counter){
            contadorboletos=contadorboletos+1;

            counterTV.setText(contadorboletos.toString());
            /*subTotalTV.setText("$"+subtotalboleto.toString()+" MXN");
            totalTV.setText("$"+totalboleto.toString()+ " MXN");*/
                //tickets("http://appado.webcindario.com/consu_tickets.php");
        }else{
                Toast.makeText(Ticket.this,"Boletos impresos",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void total(){
        subtotalboleto=(counter*precioBoleto)/counter;
        //totalboleto=subtotalboleto*((subtotalboleto*16)/100);
        //subTotal = counter * precioBoleto;
        total = subtotalboleto + ((subtotalboleto * 16) / 100);
    }
    private void tickets (String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()) {
                            Intent intent= new Intent(getApplicationContext(),Ticket.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Ticket.this, "Response vacio", Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Ticket.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("origen", originTV.getText().toString());
                parametros.put("destino",destinyTV.getText().toString());
                parametros.put("hida",horarioSalidaTV.getText().toString());//);
                parametros.put("hvuelta",horarioRegresoTV.getText().toString());//);

                //parametros.put("totalasientos",counterTV.getText().toString());//);
                //parametros.put("redondo",roundtrip.toString());//roundtrip.toString());
                //parametros.put("subtotal",subTotalTV.getText().toString());//subTotalTV.getText().toString());
                //parametros.put("total",totalTV.getText().toString());//);
                return parametros;

            }
        };
        System.out.println(stringRequest);
        Toast.makeText(Ticket.this, stringRequest.toString(), Toast.LENGTH_LONG).show();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
