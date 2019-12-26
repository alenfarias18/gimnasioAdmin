package com.example.gimnasio;

import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
<<<<<<< HEAD
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String varGlobal;
    private TextInputEditText user;
    private TextInputEditText password;
    private RequestQueue requestQueQue;
    private String url;
    private String usuarioAdmin;

=======

public class MainActivity extends AppCompatActivity {
    private TextInputEditText user;
    private TextInputEditText password;
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuracionesGlobales();

    }


    public void verificaInput(View view){ //Metodo encargado de verificar si los input son rellenados correctamente
         user = (TextInputEditText)findViewById(R.id.inputUser);
         password = (TextInputEditText)findViewById(R.id.inputPassword);
        if(user.getText().toString().trim().equals("")){
            user.setError("Favor de rellenar con un usuario valido.");
        }
        else if(password.getText().toString().equals("")){
            password.setError("Favor de rellenar con una contraseña valida.");
        }
        else{
<<<<<<< HEAD
            requestQueQue = Volley.newRequestQueue(getApplicationContext());
                BusquedaCuenta(user.getText().toString(),password.getText().toString());
                usuarioAdmin=null;
=======
            //Condicional que sera usado para conectar con la DB y validar si los campos son correctos
            //
            Intent intent = new Intent(this,agEvaluacion.class);
            startActivity(intent);
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
        }
    }



    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }
<<<<<<< HEAD
    public void  BusquedaCuenta(String lUser,String lPassword) {
        datosSolicitud datosSolicitud = new datosSolicitud();
        final ArrayList<String> lista = new ArrayList<>();
        url = "http://"+datosSolicitud.getIp()+"/webService/comprobarEntrenador.php?"+datosSolicitud.getUsuario()+"="+lUser+"&"+datosSolicitud.getClave()+"="+lPassword;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("entrenador");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject persona = jsonArray.getJSONObject(i);
                        usuarioAdmin = persona.getString("usuario");

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
                if(usuarioAdmin!=null){
                    Intent intent = new Intent(getApplicationContext(),agEvaluacion.class);
                   SharedPreferences.Editor editor = getSharedPreferences(varGlobal,MODE_PRIVATE).edit();
                   editor.putString("entrenador",usuarioAdmin);
                   editor.commit();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario/password incorrectos.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
=======

>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
}
