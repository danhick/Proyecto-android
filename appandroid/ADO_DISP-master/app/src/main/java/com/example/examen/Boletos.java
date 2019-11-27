package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Boletos extends AppCompatActivity implements View.OnClickListener{

    RadioGroup originRadio, destinyRadio;
    RadioButton originTizimin, originValladolid, originIzamal, destinyTizimin, destinyValladolid,destinyIzamal;
    Button xlaButtton, vipButton,btticket;
    CheckBox cbredondo;
    Boolean roundtrip = false;
    String origen ="", destino="";
    Integer precioBoleto,combinacion,boletoVIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletos);
        originRadio = findViewById(R.id.ida);
        destinyRadio = findViewById(R.id.vuelta);
        xlaButtton = findViewById(R.id.btnormal);
        vipButton = findViewById(R.id.btvip);
        btticket =findViewById(R.id.btticket);
        xlaButtton.setOnClickListener(this);
        vipButton.setOnClickListener(this);
        btticket.setOnClickListener(this);
        destinyTizimin = findViewById(R.id.rbtizimin2);
        destinyIzamal = findViewById(R.id.rbizamal2);
        destinyValladolid = findViewById(R.id.rbvalla2);

        originTizimin = findViewById(R.id.rbtizimin);
        originIzamal = findViewById(R.id.rbizamal);
        originValladolid = findViewById(R.id.rbvalla);

        cbredondo = findViewById(R.id.cbredondo);
        originRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = originRadio.findViewById(checkedId);
                int index = originRadio.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        origen = "Tizimin";
                        System.out.println(origen);
                        break;
                    case 1:
                        origen = "Valladolid";
                        System.out.println("Valladolid");
                        break;
                    case 2:
                        origen = "Izamal";
                        System.out.println("Izamal");
                        break;
                }
                if(origen.equals("Tizimin")){
                    destinyTizimin.setEnabled(false);
                    destinyValladolid.setEnabled(true);
                    destinyIzamal.setEnabled(true);
                }if(origen.equals("Valladolid")){
                    destinyValladolid.setEnabled(false);
                    destinyTizimin.setEnabled(true);
                    destinyIzamal.setEnabled(true);
                }if(origen.equals("Izamal")){
                    destinyIzamal.setEnabled(false);
                    destinyTizimin.setEnabled(true);
                    destinyValladolid.setEnabled(true);
                }

            }
        });

        destinyRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = destinyRadio.findViewById(checkedId);
                int index = destinyRadio.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        destino = "Tizimin";
                        System.out.println(destino);
                        break;
                    case 1:
                        destino = "Valladolid";
                        System.out.println(destino);
                        break;
                    case 2:
                        destino = "Izamal";
                        System.out.println(destino);
                        break;
                }
            }

        });

        cbredondo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(cbredondo.isChecked()){
                    roundtrip = true;
                }else{
                    roundtrip = false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        this.precioBoleto();

      if(xlaButtton.isPressed()){
          System.out.println("XLA");
          if(destino.equals(origen) || destino.equals("") || origen.equals("")){
              Toast.makeText(this,"Elige un lugar de origen y un destino",Toast.LENGTH_SHORT).show();
          }else{
              Bundle datosBoletos = new Bundle();
              datosBoletos.putInt("precioBoleto",precioBoleto);
              datosBoletos.putBoolean("roundtrip",roundtrip);
              datosBoletos.putString("origen",origen);
              datosBoletos.putString("destino",destino);

              Intent i = new Intent(Boletos.this, Horario.class);
              i.putExtras(datosBoletos);

              startActivity(i);

          }
      }if(vipButton.isPressed()){
          System.out.println("VIP");
            if(destino.equals(origen) || destino.equals("") || origen.equals("")){
                Toast.makeText(this,"Elige un lugar de origen y un destino",Toast.LENGTH_SHORT).show();
            }else{
                precioBoleto = precioBoleto + boletoVIP;
                Bundle datosBoletos = new Bundle();

                datosBoletos.putInt("precioBoleto",precioBoleto);
                datosBoletos.putBoolean("roundtrip",roundtrip);
                datosBoletos.putString("origen",origen);
                datosBoletos.putString("destino",destino);

                Intent i = new Intent(Boletos.this, Horario.class);
                i.putExtras(datosBoletos);

                startActivity(i);
            }
      }if(btticket.isPressed()){

            Intent i = new Intent(Boletos.this, Consultar_Ticket.class);
            
            startActivity(i);
        }
      //else{}



    }
    public void precioBoleto(){
        if(origen.equals("Tizimin") && destino.equals("Valladolid") || origen.equals("Valladolid") && destino.equals("Tizimin")){
            precioBoleto = 150;
            combinacion = 1;
            boletoVIP = 30;
            if(roundtrip.equals(true)){
                precioBoleto = precioBoleto * 2;
                boletoVIP = boletoVIP * 2;
            }else{}

            System.out.println(precioBoleto);
        }if(origen.equals("Tizimin") && destino.equals("Izamal") || origen.equals("Izamal") && destino.equals("Tizimin")){
            precioBoleto = 250;
            combinacion = 2;
            boletoVIP = 50;
            if(roundtrip.equals(true)){
                precioBoleto = precioBoleto * 2;
                boletoVIP = boletoVIP * 2;
            }else{}
            System.out.println(precioBoleto);
        }if(origen.equals("Valladolid") && destino.equals("Izamal") || origen.equals("Izamal") && destino.equals("Valladolid")){
            precioBoleto = 200;
            combinacion = 3;
            boletoVIP = 40;
            if(roundtrip.equals(true)){
                precioBoleto = precioBoleto * 2;
                boletoVIP = boletoVIP * 2;
            }else{}
            System.out.println(precioBoleto);
        }
    }
}
