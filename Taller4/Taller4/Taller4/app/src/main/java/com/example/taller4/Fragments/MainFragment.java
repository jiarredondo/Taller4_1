package com.example.taller4.Fragments;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taller4.Adapters.PersonaAdapter;

import com.example.taller4.AppDatabase;
import com.example.taller4.Models.Persona;
import com.example.taller4.PersonaDao;
import com.example.taller4.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

     AppDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Room.databaseBuilder(getContext(), AppDatabase.class, "localDB").allowMainThreadQueries().build();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        setupUI(view);

        return view;

    }


    public void setupUI( final View view){
        PersonaDao personadao = database.getItemDAO();
        //Persona persona = new Persona();
        PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,personadao.getItems());

        ListView listView = (ListView) view.findViewById(R.id.listview2);
        listView.setAdapter(adapter);

        //FirstList(view);

        Button btnDatos = (Button) view.findViewById(R.id.btnllenardatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                LlenadatosFragment fragment2 = new LlenadatosFragment();
                ft.replace(android.R.id.content, fragment2);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();

            //SecondList(view);
            }
        });

       //SecondList(view);

       /* Button btndos = (Button) view.findViewById(R.id.btndos);
        btndos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PersonaDao personadao = database.getItemDAO();
                Persona persona = new Persona();
                persona.setName("Jose");
                persona.setLastname("Arredondo");
                persona.setEmail("jose_arredondo@gficr.com");
                persona.setPhonenumber("8303-8426");

                personadao.insert(persona);
                int cantidadUsers = personadao.getCount();


                //Snackbar.make(view, "Cantidad de Personas" + cantidadUsers, Snackbar.LENGTH_LONG).show();

                SharedPreferences sharedPref = getContext().getSharedPreferences("preferences", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("var", cantidadUsers);
                editor.commit(); //guarda los datos en el fichero

              int size = sharedPref.getInt("var", 0);

                Snackbar.make(view, "Cantidad de Personas" + size, Snackbar.LENGTH_LONG).show();

                //personadao.getItems().get(0).getPhonenumber();
                PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,personadao.getItems());

                ListView listView = (ListView) view.findViewById(R.id.listview2);
                listView.setAdapter(adapter);

            }
        });*/

    }

     private void FirstList(View view){
       ArrayList<String> mItems = new ArrayList<String>();

        for (int i = 1; i <= 10; i++){
            mItems.add("Item : " + i);
        }

        int layoutId = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>( getContext(), layoutId, mItems);
        ListView mListView = (ListView) view.findViewById(R.id.listfragment);
        mListView.setAdapter(mAdapter);
    }

   public void SecondList( View view){
       PersonaDao personadao = database.getItemDAO();
       int cantidadUsers = personadao.getCount();

       SharedPreferences sharedPref = getContext().getSharedPreferences("preferences", getContext().MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPref.edit();
       editor.putInt("var", cantidadUsers);
       editor.commit(); //guarda los datos en el fichero

       int size = sharedPref.getInt("var", 0);

       Snackbar.make(view, "Cantidad de Personas" + size, Snackbar.LENGTH_LONG).show();

       PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,personadao.getItems());

       ListView listView = (ListView) view.findViewById(R.id.listview2);
       listView.setAdapter(adapter);


       //PersonaDao personadao = database.getItemDAO();
       //Persona persona = new Persona();

     // Bundle bundle = getArguments();

     /* if (bundle!=null){
          Persona obj= (Persona) bundle.getSerializable("Datos");
          if (obj!=null){

              Persona newUser = new Persona(obj.getName().toString(), obj.getLastname().toString(), obj.getEmail().toString(),obj.getPhonenumber().toString());*/

              /*persona.setName(obj.getName().toString());
              persona.setLastname(obj.getLastname().toString());
              persona.setEmail(obj.getEmail().toString());
              persona.setPhonenumber(obj.getPhonenumber().toString());*/

             // personadao.insert(newUser);

              /*ArrayList<Persona> mItems = new ArrayList<Persona>();
              PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,mItems);
              Persona newUser = new Persona(obj.getName().toString(), obj.getLastname().toString(), obj.getEmail().toString(),obj.getPhonenumber().toString());
              adapter.addAll(newUser);

              ListView listView = (ListView) view.findViewById(R.id.listview2);
              listView.setAdapter(adapter);*/
              /*int cantidadUsers = personadao.getCount();

              SharedPreferences sharedPref = getContext().getSharedPreferences("preferences", getContext().MODE_PRIVATE);
              SharedPreferences.Editor editor = sharedPref.edit();
              editor.putInt("var", cantidadUsers);
              editor.commit(); //guarda los datos en el fichero

              int size = sharedPref.getInt("var", 0);

              Snackbar.make(view, "Cantidad de Personas" + size, Snackbar.LENGTH_LONG).show();

              PersonaAdapter adapter = new PersonaAdapter(getContext(), R.layout.list_element_pesona,personadao.getItems());

              ListView listView = (ListView) view.findViewById(R.id.listview2);
              listView.setAdapter(adapter);

          }
       }*/

    }



}

