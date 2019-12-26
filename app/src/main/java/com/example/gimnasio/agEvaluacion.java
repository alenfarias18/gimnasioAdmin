package com.example.gimnasio;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class agEvaluacion extends AppCompatActivity implements ComunicaButton {
private int fragment = -1;
private int peticion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ag_evaluacion);
        menu(0);
        llamadaFragment();
        configuracionesGlobales();

    }


    public void llamadaFragment(){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.idFragmentNvegacion, new Navegacion());
        ft.commit();

    }

    public void llamadaFragmentAdd(){

            sacarFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.IDFragmentAdd, new agregarUserinit(),"0");
        ft.commit();

    }

    public void llamadaFragmentDelete(){

            sacarFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.IDFragmentAdd, new eliminarEvaluacion(),"2" );
        ft.commit();

    }
    public void sacarFragment(){
        String tag = "";
        if(fragment==0){
            tag = "0";
        }
        else if(fragment == 1){
            tag = "2";
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment != null)
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }



    @Override
    public void menu(int BotonPresionado) {

        if(BotonPresionado == 0){
            llamadaFragmentAdd();

            fragment = BotonPresionado;
        }
        else if(BotonPresionado == 1){
            llamadaFragmentDelete();

            fragment = BotonPresionado;
        }
    }
    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }



}
