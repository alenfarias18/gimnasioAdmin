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
import android.widget.*;
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
public class agregarUserinit extends Fragment {
    private RequestQueue requestQueQue;
    private String url;
    private  ListView list;
    private  ArrayAdapter arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_agregar_userinit, container, false);
        list = (ListView)view.findViewById(R.id.listUserID);
        requestQueQue = Volley.newRequestQueue(view.getContext());
        cargarDatos(view);
        TextInputEditText buscador = (TextInputEditText)view.findViewById(R.id.buscador1);
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment2 = new agregarEvaluacion();
                FragmentManager miManejador = getFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("usuario", list.getItemAtPosition(position).toString());
                fragment2.setArguments(bundle);
                FragmentTransaction miTransaccion = miManejador.beginTransaction();
                miTransaccion.replace(R.id.IDFragmentAdd, fragment2, "0");
                miTransaccion.commit();






            }


        });





        return view;
    }

    private void cargarDatos(final View view){

        requestQueQue = Volley.newRequestQueue(view.getContext());



        datosSolicitud datosSolicitud = new datosSolicitud();
        //url = "https://" + datosSolicitud.getIp()+"/webService/buscarUsuarios.php";
        url = "http://"+datosSolicitud.getIp()+"/webService/buscarUsuarios.php";
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


}