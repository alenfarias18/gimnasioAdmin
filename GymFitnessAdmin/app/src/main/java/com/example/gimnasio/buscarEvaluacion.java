package com.example.gimnasio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class buscarEvaluacion extends Fragment {


    public buscarEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_buscar_evaluacion, container, false);
        //Este codigo es para mostrar el uso de la app, luego sera sacado
        ListView list = (ListView)view.findViewById(R.id.listViewBuscar);
        String user[] = {"User1","User2","User3"};
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,user);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Usuario encontrado",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
