package com.example.gimnasio;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Navegacion extends Fragment {


    public Navegacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_navegacion, container, false);

<<<<<<< HEAD
        int button [] = {R.id.imageButton1,R.id.imageButton3};
        for(int i=0;i<2;i++){
=======
        int button [] = {R.id.imageButton1,R.id.imageButton2,R.id.imageButton3};
        for(int i=0;i<3;i++){
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
            ImageButton imageButton = (ImageButton)vista.findViewById(button[i]);
            final int botonPresionado = i;
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity actividad = getActivity();
                    ((ComunicaButton)actividad).menu(botonPresionado);

                }
            });
        }


        return vista;
    }


}
