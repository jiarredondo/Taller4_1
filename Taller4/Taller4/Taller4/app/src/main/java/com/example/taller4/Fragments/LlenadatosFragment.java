package com.example.taller4.Fragments;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.taller4.Adapters.PersonaAdapter;
import com.example.taller4.AppDatabase;
import com.example.taller4.Models.Persona;
import com.example.taller4.PersonaDao;
import com.example.taller4.R;

import java.io.Serializable;
import java.util.ArrayList;

public class LlenadatosFragment extends Fragment {
    AppDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Room.databaseBuilder(getContext(), AppDatabase.class, "localDB").allowMainThreadQueries().build();

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        setupUI(view);
        return view;
    }

    public void setupUI(View view){
        final EditText snombre = (EditText) view.findViewById(R.id.nombre);
        final EditText sapellido = (EditText) view.findViewById(R.id.apellido);
        final EditText scorreo = (EditText) view.findViewById(R.id.correo);
        final EditText stelefono = (EditText) view.findViewById(R.id.telefono);
       // PersonaDao personadao = database.getItemDAO();

        Button btnDatos = (Button) view.findViewById(R.id.btndatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = snombre.getText().toString();

                String apellido = sapellido.getText().toString();

                String correo = scorreo.getText().toString();

                String telefono = stelefono.getText().toString();

                PersonaDao personadao = database.getItemDAO();
                Persona persona = new Persona();
                persona.setName(nombre);
                persona.setLastname(apellido);
                persona.setEmail(correo);
                persona.setPhonenumber(telefono);

                personadao.insert(persona);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                MainFragment fragment2 = new MainFragment();
                //Bundle bundle = new Bundle();
                //bundle.putCharSequenceArrayList("Datos",mItems.toString());
                //Persona obj = new Persona(nombre, apellido, correo, telefono); //Our Persona Object
                //bundle.putSerializable("Datos", obj);
                //fragment2.setArguments(bundle);
                ft.replace(android.R.id.content, fragment2);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();
            }
        });



    }

}
