package com.example.gimnasio;


<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD


public class agEvaluacion extends AppCompatActivity implements ComunicaButton {
private int fragment = -1;
private int peticion = 0;

=======
import android.widget.Toast;

public class agEvaluacion extends AppCompatActivity implements ComunicaButton{
private int fragment = -1;
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ag_evaluacion);
<<<<<<< HEAD
=======

>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
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
<<<<<<< HEAD

=======
    public void llamadaFragmentSearch(){

            sacarFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.IDFragmentAdd, new buscarEvaluacion(),"1");
        ft.commit();

    }
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
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
<<<<<<< HEAD
        else if(fragment == 1){
=======
        else if(fragment==1){
            tag = "1";
        }
        else if(fragment == 2){
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
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
<<<<<<< HEAD
=======
            llamadaFragmentSearch();

            fragment = BotonPresionado;
        }
        else if(BotonPresionado == 2){
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
            llamadaFragmentDelete();

            fragment = BotonPresionado;
        }
    }
    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }

<<<<<<< HEAD


=======
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
}
