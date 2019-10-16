package com.example.gimnasio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class agregarUserinit extends Fragment {


    public agregarUserinit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_agregar_userinit, container, false);

        //Este codigo es para mostrar el uso de la app, luego sera sacado
        ListView list = (ListView)view.findViewById(R.id.listUserID);
        String user[] = {"User1","User2","User3"};
        ArrayAdapter<String>adaptador;
        adaptador = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,user);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment2 = new agregarEvaluacion();
                FragmentManager miManejador = getFragmentManager();
                FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                miTransaccion.replace(R.id.IDFragmentAdd,fragment2,"0");

                miTransaccion.commit();
            }
        });


        return view;
    }

}
