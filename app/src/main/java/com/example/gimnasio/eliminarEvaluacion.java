package com.example.gimnasio;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class eliminarEvaluacion extends Fragment {
    private RequestQueue requestQueQue;
    private String url;
    private  ListView list;
    private ArrayAdapter arrayAdapter;
    public eliminarEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_eliminar_evaluacion, container, false);
        //Este codigo es para mostrar el uso de la app, luego sera sacado
        list = (ListView)view.findViewById(R.id.ListViewEliminar);
        requestQueQue = Volley.newRequestQueue(view.getContext());
        TextInputEditText buscador = (TextInputEditText)view.findViewById(R.id.buscador2);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cargarDatos(view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                requestQueQue = Volley.newRequestQueue(view.getContext());
            eliminarDatos(view, list.getItemAtPosition(position).toString());


            }


        });





        return view;
    }
    private void cargarDatos(final View view){

        requestQueQue = Volley.newRequestQueue(view.getContext());



        datosSolicitud datosSolicitud = new datosSolicitud();
        //url = "https://" + datosSolicitud.getIp()+"/webService/buscarUsuarios.php";
        url = "http://"+datosSolicitud.getIp()+"/webService/buscarUsuarios2.php";
        JsonObjectRequest jsonObjectRequest = new    JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("usuario");
                    ArrayList<String> lista = new ArrayList<>();

                    for(int i = 0; i<jsonArray.length();i++){
                        JSONObject persona = jsonArray.getJSONObject(i);
                        String username = persona.getString("usuario");
                        lista.add(username);

                    }

                    arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1,lista);
                    list.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    Toast.makeText(view.getContext(),"Registro insertado con exito."+e,Toast.LENGTH_SHORT);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(view.getContext(),"Registro insertado con exito."+error,Toast.LENGTH_SHORT);
            }
        });

        requestQueQue.add(jsonObjectRequest);

    }


    private void eliminarDatos(final View view,String usuario){





        datosSolicitud datosSolicitud = new datosSolicitud();
        url = "http://"+datosSolicitud.getIp()+"/webService/borrarUsuario.php?usuario="+usuario;

        JsonObjectRequest jsonObjectRequest = new    JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                    Toast.makeText(view.getContext(),"Usuario eliminado con exito.",Toast.LENGTH_SHORT).show();




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(view.getContext(),"Usuario eliminado con exito.",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueQue.add(jsonObjectRequest);

    }
}
