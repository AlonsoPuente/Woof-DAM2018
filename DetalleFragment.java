package com.example.pedro.woof;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedro.woof.RecyclerView.Dog;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {


    TextView txtNombre;
    TextView txtEdad;
    TextView txtSexo;
    TextView txtAlbergue;
    TextView txtDescripcion;
    ImageView imgFoto;

    Button btnAdoptar;

    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_detalle, container, false);

        txtNombre = (TextView) vista.findViewById(R.id.txtNombre);
        txtEdad = (TextView) vista.findViewById(R.id.txtEdad);
        txtSexo = (TextView) vista.findViewById(R.id.txtSexo);
        txtAlbergue = (TextView) vista.findViewById(R.id.txtAlbergue);
        txtDescripcion = (TextView) vista.findViewById(R.id.txtDescripcion);
        imgFoto = (ImageView) vista.findViewById(R.id.imgFotoAdopt);
        btnAdoptar = (Button) vista.findViewById(R.id.btnAdoptar);

        Bundle objetoDog = getArguments();
        Dog dog = null;

        if (objetoDog != null){
            dog = (Dog) objetoDog.getSerializable("perro");
            txtNombre.setText(dog.getNombre());
            txtEdad.setText(dog.getEdad());
            txtSexo.setText(dog.getSexo());
            txtAlbergue.setText(dog.getAlbergue());
            txtDescripcion.setText(dog.getDescripcion());
            imgFoto.setImageResource(dog.getFotoID());
        }

        btnAdoptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FichaFragment NewFragment = new FichaFragment();
                FragmentTransaction pasante = getFragmentManager().beginTransaction();

                pasante.replace(R.id.detalle, NewFragment);
                pasante.addToBackStack(null);


                pasante.commit();
            }
        });

        return vista;
    }

}
