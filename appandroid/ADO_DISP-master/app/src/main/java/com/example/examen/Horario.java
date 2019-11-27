package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Horario extends AppCompatActivity implements View.OnClickListener{
    Integer precioBoleto;
    Boolean roundtrip;
    Integer counter;
    String origen,destino;
    LinearLayout salidaLayout,regresoLayout;
    String horarioSalida ="",horarioRegreso ="";
    Button nextButton;
    RadioGroup salida,regreso;
    RadioButton horarioSalida1,horarioSalida2,horarioSalida3,horarioSalida4,horarioRegreso1,horarioRegreso2,horarioRegreso3,horarioRegreso4;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        nextButton = findViewById(R.id.btcomprar);
        nextButton.setOnClickListener(this);

        salidaLayout = findViewById(R.id.salidaLayout);
        regresoLayout = findViewById(R.id.regresoLayout);

        Bundle datosRecibidos = new Bundle();
        datosRecibidos = getIntent().getExtras();

        precioBoleto = datosRecibidos.getInt("precioBoleto");
        roundtrip = datosRecibidos.getBoolean("roundtrip");
        origen = datosRecibidos.getString("origen");
        destino = datosRecibidos.getString("destino");
        counter = datosRecibidos.getInt("counter");

        salida = findViewById(R.id.hida);
        horarioSalida1 = findViewById(R.id.rb1);
        horarioSalida2 = findViewById(R.id.rb2);
        horarioSalida3 = findViewById(R.id.rb3);
        horarioSalida4 = findViewById(R.id.rb4);

        regreso = findViewById(R.id.hvuelta);
        horarioRegreso1 = findViewById(R.id.rb5);
        horarioRegreso2 = findViewById(R.id.rb6);
        horarioRegreso3 = findViewById(R.id.rb7);
        horarioRegreso4 = findViewById(R.id.rb8);
        //----------------
        if(roundtrip.equals(false)){
            regresoLayout.setVisibility(View.GONE);
        }else{

        }
        //
        this.groups();
    }

    @Override
    public void onClick(View v) {
        if(nextButton.isPressed()){
            if(roundtrip.equals(true)){
                if(horarioSalida.equals("") || horarioRegreso.equals("")){
                    Toast.makeText(this,"Seleccione sus horarios de Salida y Regreso",Toast.LENGTH_SHORT).show();
                }else{
                   //MANDA AL OTRO ACTIVITY
                    Bundle datosHorario = new Bundle();
                        datosHorario.putBoolean("roundtrip",roundtrip);
                        datosHorario.putString("origen",origen);
                        datosHorario.putString("destino",destino);
                        datosHorario.putInt("counter",counter);
                        datosHorario.putString("horarioSalida",horarioSalida);
                        datosHorario.putString("horarioRegreso",horarioRegreso);
                        datosHorario.putInt("precioBoleto",precioBoleto);
                    Intent i = new Intent(Horario.this, Asientos.class);
                    i.putExtras(datosHorario);
                    startActivity(i);
                }
            }if(roundtrip.equals(false)){
                if(horarioSalida.equals("")){
                    Toast.makeText(this,"Seleccione un horario de salida",Toast.LENGTH_SHORT).show();
                }else{
                    //MANDA AL OTRO ACTIVITY
                    Bundle datosHorario = new Bundle();
                        datosHorario.putBoolean("roundtrip",roundtrip);
                        datosHorario.putString("origen",origen);
                        datosHorario.putString("destino",destino);
                        datosHorario.putInt("counter",counter);
                        datosHorario.putString("horarioSalida",horarioSalida);
                        datosHorario.putInt("precioBoleto",precioBoleto);
                    Intent i = new Intent(Horario.this, Asientos.class);
                    i.putExtras(datosHorario);
                    startActivity(i);
                }
            }

        }else{}

    }
    public void groups(){
        salida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = salida.findViewById(checkedId);
                int index = salida.indexOfChild(radioButton);
                switch (index) {
                    case 1:
                        horarioSalida = "06:00 HR";
                        System.out.println(horarioSalida);
                        break;
                    case 2:
                        horarioSalida = "09:00 HR";
                        System.out.println(horarioSalida);
                        break;
                    case 3:
                        horarioSalida = "13:00 HR";
                        System.out.println(horarioSalida);
                        break;
                    case 4:
                        horarioSalida = "17:00 HR";
                        System.out.println(horarioSalida);
                        break;
                    case 5:
                        horarioSalida = "06:00 HR";
                        System.out.println(horarioSalida);
                        break;

                }
            }
        });
        regreso.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = regreso.findViewById(checkedId);
                int index = regreso.indexOfChild(radioButton);
                switch (index) {
                    case 1:
                        horarioRegreso = "08:00 HR";
                        System.out.println(horarioRegreso);
                        break;
                    case 2:
                        horarioRegreso = "10:00 HR";
                        System.out.println(horarioRegreso);
                        break;
                    case 3:
                        horarioRegreso = "13:00 HR";
                        System.out.println(horarioRegreso);
                        break;
                    case 4:
                        horarioRegreso = "22:00 HR";
                        System.out.println(horarioRegreso);
                        break;
                }
            }
        });
    }
}
