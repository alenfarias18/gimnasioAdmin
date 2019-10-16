package com.example.gimnasio;


import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.Calendar;

import static com.example.gimnasio.R.color.colorAccent;


/**
 * A simple {@link Fragment} subclass.
 */
public class agregarEvaluacion extends Fragment {


    public agregarEvaluacion() {
        // Required empty public constructor
    }

    Calendar calendario = Calendar.getInstance();
    final int anio = calendario.get(Calendar.YEAR);
    final int mes = calendario.get(Calendar.MONTH);
    final int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private TextInputEditText fechaNacimiento;
    TextInputEditText imc;
    CircleImageView civ;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int RESULT_OK = -1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista =  inflater.inflate(R.layout.fragment_agregar_evaluacion, container, false);






       fechaNacimiento = (TextInputEditText)vista.findViewById(R.id.inputfecha);

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha(vista);
            }
        });

        NumberPicker pickerPeso = (NumberPicker)vista.findViewById(R.id.picker2);
        pickerPeso.setMinValue(0);
        pickerPeso.setMaxValue(160);

        NumberPicker pickerCintura = (NumberPicker)vista.findViewById(R.id.picker3);
        pickerCintura.setMinValue(0);
        pickerCintura.setMaxValue(100);

        NumberPicker grasa = (NumberPicker)vista.findViewById(R.id.picker4);
        grasa.setMinValue(0);
        grasa.setMaxValue(100);


        NumberPicker estatura = (NumberPicker)vista.findViewById(R.id.picker5);
        estatura.setMinValue(100);
        estatura.setMaxValue(200);

        //camera
       civ = (CircleImageView)vista.findViewById(R.id.imagec);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarIntent();
            }
        });

        return vista;





    }

    public void llamarIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    public void obtenerFecha(View vista){

        DatePickerDialog date = new DatePickerDialog(vista.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int cero = 0;
                final int mes2 = month+1;
                String diaFormato = (dayOfMonth<10)?cero+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormato = (mes<10)?cero+String.valueOf(mes2):String.valueOf(mes2);
                fechaNacimiento.setText(diaFormato+"/"+mesFormato+"/"+year);

            }
        },anio,mes,dia);
        date.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            civ.setImageBitmap(imageBitmap);
        }
    }

}
