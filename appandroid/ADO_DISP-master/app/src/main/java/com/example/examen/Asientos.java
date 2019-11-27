package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class Asientos extends AppCompatActivity implements View.OnClickListener{

    CheckBox a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;
    Integer counter = 0;
    Integer i,precioBoleto;
    Button bts;
    Boolean roundtrip;
    String origen,destino;
    String horarioSalida ="",horarioRegreso ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asientos);

        a1 = findViewById(R.id.asi1);
        a2 = findViewById(R.id.asi2);
        a3 = findViewById(R.id.asi3);
        a4 = findViewById(R.id.asi4);
        a5 = findViewById(R.id.asi5);
        a6 = findViewById(R.id.asi6);
        a7 = findViewById(R.id.asi7);
        a8 = findViewById(R.id.asi8);
        a9 = findViewById(R.id.asi9);
        a10 = findViewById(R.id.asi10);
        a11 = findViewById(R.id.asi11);
        a12 = findViewById(R.id.asi12);
        a13 = findViewById(R.id.asi13);
        a14 = findViewById(R.id.asi14);
        a15 = findViewById(R.id.asi15);
        a16 = findViewById(R.id.asi16);
        a17 = findViewById(R.id.asi17);
        a18 = findViewById(R.id.asi18);
        a19 = findViewById(R.id.asi19);
        a20 = findViewById(R.id.asi20);
        bts = findViewById(R.id.btsigue);
        bts.setOnClickListener(this);
        //DATOS RECIBIDOS
        Bundle datosRecibidos = new Bundle();
        datosRecibidos = getIntent().getExtras();

        precioBoleto = datosRecibidos.getInt("precioBoleto");
        roundtrip = datosRecibidos.getBoolean("roundtrip");
        origen = datosRecibidos.getString("origen");
        destino = datosRecibidos.getString("destino");
        horarioRegreso = datosRecibidos.getString("horarioRegreso");
        horarioSalida = datosRecibidos.getString("horarioSalida");


        //
        System.out.println("El precio es:" + precioBoleto);
        System.out.println("Viaje redondo: " + roundtrip);
        System.out.println("El origen es: " + origen);
        System.out.println("El destino es: " + destino);

        this.asientos();


    }

    @Override
    public void onClick(View v) {
            if(bts.isPressed()){
                if(this.counter.equals(0)){
                    Toast.makeText(this,"Selecciona por lo menos un asiento",Toast.LENGTH_SHORT).show();
                }else{
                    Bundle datosAsientos = new Bundle();

                    datosAsientos.putInt("precioBoleto",precioBoleto);
                    datosAsientos.putBoolean("roundtrip",roundtrip);
                    datosAsientos.putString("origen",origen);
                    datosAsientos.putString("destino",destino);
                    datosAsientos.putInt("counter",counter);
                    datosAsientos.putString("horarioSalida",horarioSalida);
                    datosAsientos.putString("horarioRegreso",horarioRegreso);

                    Intent i = new Intent(Asientos.this, Ticket.class);
                    i.putExtras(datosAsientos);

                    startActivity(i);

                }
            }else{}
    }
    public void asientos(){
        a1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a1.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a2.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a3.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a4.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a5.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a6.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a7.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a8.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a9.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a10.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a11.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a12.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a13.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a14.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a15.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a16.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a17.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a18.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a19.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });
        a20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(a20.isChecked()){
                    counter = counter + 1;
                    System.out.println(counter);
                }else{
                    counter = counter -1;
                    System.out.println(counter);
                }
            }
        });


    }
}
