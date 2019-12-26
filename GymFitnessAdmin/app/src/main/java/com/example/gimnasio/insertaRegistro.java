package com.example.gimnasio;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class insertaRegistro implements Response.Listener<JSONObject>,Response.ErrorListener {
    private JsonObjectRequest JsonObjectRequest;
    private RequestQueue request;
    private Context context;
    private String usuario;
    private String entrenador;
    private String fecha;
    private String estatura;
    private String peso;
    private String grasa;
    private String medidaCintura;
    private String imc;
    private String indiceGrasa;
    public insertaRegistro( Context context,String usuario,String entrenador,String fecha, String estatura,String peso,String grasa,String medidaCintura,String imc,String indiceGrasa){
        request = Volley.newRequestQueue(context);
        this.context = context;
        this.usuario = usuario;
        this.entrenador = entrenador;
        this.fecha = fecha;
        this.estatura = estatura;
        this.peso = peso;
        this.grasa = grasa;
        this.medidaCintura = medidaCintura;
        this.imc = imc;
        this.indiceGrasa = indiceGrasa;
        insertaDatos();
    }

    public void insertaDatos(){
        datosSolicitud datosSolicitud = new datosSolicitud();

        String url = "http://"+datosSolicitud.getIp()+":8080/GymFitness/evaluacion?"+datosSolicitud.getUsuario()+"="+usuario+"&entrenador="+entrenador+"&fecha="+fecha+
                "&estatura="+estatura+"&peso="+peso+"&grasa="+grasa+"&medidaCintura="+medidaCintura+"&imc="+imc+"&indiceGrasa="+indiceGrasa;
        JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        request.add(JsonObjectRequest);

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(context,"Evaluacion insertada con exito.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(context,"Evaluacion insertada con exito.",Toast.LENGTH_SHORT).show();
    }
}
