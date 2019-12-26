package com.example.gimnasio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Inicio extends AppCompatActivity {
    private String idGenero,fechaNacimiento;
    private String url;
    private RequestQueue requestQueQue;
    private String usuario, fecha, estatura, peso, grasaInstrumento, medidaCintura, entrenador;
    private boolean genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        requestQueQue = Volley.newRequestQueue(getApplicationContext());

        usuario = getIntent().getStringExtra("usuario");
        busquedaGenero(usuario);

        Intent intent = new Intent(this,agEvaluacion.class);
        startActivity(intent);

    }

    public int calcularEdad(String x) {//Metodo para calcular edad
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy - MM - dd ");
        String fech = x;
        String[] usuario = fech.split("-");
        int day1 = calendario.get(Calendar.DAY_OF_MONTH);
        int month1 = calendario.get(Calendar.MONTH);
        int year1 = calendario.get(Calendar.YEAR);

        int year2 = Integer.parseInt(usuario[0]);
        int month2 = Integer.parseInt(usuario[1]);
        int day2 = Integer.parseInt(usuario[2]);

        int m = month1 - month2;
        int edad = year1 - year2;
        int diasdif = day1 - day2;

        if (m < 0 && diasdif < 0) {
            edad--;
        }
        return edad;
    }


    private void busquedaGenero(String lUser) {
        datosSolicitud datosSolicitud = new datosSolicitud();
        final ArrayList<String> lista = new ArrayList<>();
        url = "http://" + datosSolicitud.getIp() + "/webService/buscarSexo.php?"+datosSolicitud.getUsuario()+"="+lUser;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("genero");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject persona = jsonArray.getJSONObject(i);
                        idGenero = persona.getString("idgenero");
                        fechaNacimiento = persona.getString("fechanacimiento");
                    }


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT);
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT);
            }
        });

        requestQueQue.add(jsonObjectRequest);
        requestQueQue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                fecha = getIntent().getStringExtra("fecha");
                 estatura = getIntent().getStringExtra("estatura");
                peso = getIntent().getStringExtra("peso");
                grasaInstrumento = getIntent().getStringExtra("grasaInstrumento");
                medidaCintura = getIntent().getStringExtra("medidaCintura");
                SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.varGlobal, MODE_PRIVATE);
                entrenador = sharedPreferences.getString("entrenador", "");

                if(Integer.parseInt(idGenero)==1){
                    genero = false;
                }
                else{
                    genero = true;
                }
                calculos calculos = new calculos(Integer.parseInt(peso),Integer.parseInt(estatura),calcularEdad(fechaNacimiento),genero);
                insertaRegistro insertaRegistro = new insertaRegistro(getApplicationContext(), usuario, entrenador, fecha, estatura, peso, grasaInstrumento, medidaCintura,""+calculos.getImc(),""+calculos.getGrasa());
                Intent intent = new Intent(getApplicationContext(), agEvaluacion.class);
                startActivity(intent);
            }
        });

    }

}
