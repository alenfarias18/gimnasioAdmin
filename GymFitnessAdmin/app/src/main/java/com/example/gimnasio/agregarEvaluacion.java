package com.example.gimnasio;


import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
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
import android.widget.*;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONObject;

import java.util.Calendar;

import static com.example.gimnasio.R.color.colorAccent;


/**
 * A simple {@link Fragment} subclass.
 */
public class agregarEvaluacion extends Fragment  {


    public agregarEvaluacion() {
        // Required empty public constructor
    }

    Calendar calendario = Calendar.getInstance();
    final int anio = calendario.get(Calendar.YEAR);
    final int mes = calendario.get(Calendar.MONTH);
    final int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private TextInputEditText fechaNacimiento;
    private TextInputEditText imc;
    private CircleImageView civ;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int RESULT_OK = -1;
    private Button button;
    private String usuario;

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

        final NumberPicker pickerPeso = (NumberPicker)vista.findViewById(R.id.picker2);
        pickerPeso.setMinValue(0);
        pickerPeso.setMaxValue(160);

        final NumberPicker pickerCintura = (NumberPicker)vista.findViewById(R.id.picker3);
        pickerCintura.setMinValue(0);
        pickerCintura.setMaxValue(100);

        final NumberPicker grasa = (NumberPicker)vista.findViewById(R.id.picker4);
        grasa.setMinValue(0);
        grasa.setMaxValue(100);


        final NumberPicker estatura = (NumberPicker)vista.findViewById(R.id.picker5);
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


        Bundle bundle = this.getArguments();
        usuario = bundle.getString("usuario");

        button = (Button)vista.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fechaNacimiento.getText().toString().trim().equals("")){
                    fechaNacimiento.setError("Favor de agregar una fecha");
                }
                else{
                    estatura.clearFocus();
                    pickerPeso.clearFocus();
                    grasa.clearFocus();
                    pickerCintura.clearFocus();


                    final String Stringestatura = ""+estatura.getValue();
                    final String Speso = ""+pickerPeso.getValue();
                    final String Sgrasa = ""+grasa.getValue();
                    final String SmedidaCintura = ""+pickerCintura.getValue();




                    Intent intent = new Intent(getActivity(),Inicio.class);
                    intent.putExtra("usuario",usuario);
                    intent.putExtra("fecha",fechaNacimiento.getText().toString());
                    intent.putExtra("estatura",Stringestatura);
                    intent.putExtra("peso",Speso);
                    intent.putExtra("grasaInstrumento",Sgrasa);
                    intent.putExtra("medidaCintura",SmedidaCintura);
                    startActivity(intent);
                }

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
                fechaNacimiento.setText(year+"-"+mesFormato+"-"+diaFormato);

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