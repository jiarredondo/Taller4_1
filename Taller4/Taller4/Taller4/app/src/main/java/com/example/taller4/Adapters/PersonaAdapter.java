package com.example.taller4.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.taller4.Models.Persona;
import com.example.taller4.R;

import java.util.List;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    int mLayoutId;
    public PersonaAdapter(Context context, int layoutId, List<Persona> items){
        super(context, layoutId, items);
        mLayoutId = layoutId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Persona persona = getItem(position);
        String name =persona.getName();
        String lastname = persona.getLastname();
        String email = persona.getEmail();
        String phonenumber = persona.getPhonenumber();

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(mLayoutId, parent, false);
        }

        TextView nameView = (TextView) view.findViewById(R.id.txtName);
        TextView lastnameView = (TextView) view.findViewById(R.id.txtlast);
        TextView mailView = (TextView) view.findViewById(R.id.txtemail);
        TextView phoneView = (TextView) view.findViewById(R.id.txtphonenumber);

        nameView.setText(name);
        lastnameView.setText(lastname);
        mailView.setText(email);
        phoneView.setText(phonenumber);

        return view;
    }
}
