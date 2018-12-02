package com.example.pedro.woof;


import android.os.Bundle;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

//import com.example.pedro.woof.RecyclerView.Adoptante;
import com.example.pedro.woof.RecyclerView.Dog;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class FichaFragment extends Fragment {
    TextView txtNombreA;
    TextView txtApellidosA;
    TextView txtTelefonoA;
    TextView txtDNIA;
    TextView txtDireccionA;
    TextView txtEstadoA;
    TextView txtEdadA;
    TextView txtCorreoA;
    TextView txtPerro;
    TextView txtMostrarP;
    //TextView txtSolicitud;

    String nombre;
    String apellidos;
    String telefono;
    String dni;
    String direccion;
    String estadoA;
    String edad;
    String  correo;
    String albergue;
    String perro;


    Button btnNext;



    public FichaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_ficha, container, false);


        txtNombreA = (EditText) vista.findViewById(R.id.txtNombreA);
        txtApellidosA = (EditText) vista.findViewById(R.id.txtApellidosA);
        txtTelefonoA = (EditText) vista.findViewById(R.id.txtTelefonoA);
        txtDNIA = (EditText) vista.findViewById(R.id.txtDNIA);
        txtDireccionA = (EditText) vista.findViewById(R.id.txtDireccionA);
        txtEdadA = (EditText) vista.findViewById(R.id.txtEdadA);
        txtCorreoA =(EditText) vista.findViewById(R.id.txtCorreoA);

        //txtPerro = (TextView) vista.findViewById(R.id.txtPerro);
        txtEstadoA = (EditText)vista.findViewById(R.id.txtEstadoA);
        txtMostrarP = (TextView) vista.findViewById(R.id.txtMostrarP);







        Bundle bundle = new Bundle();


        bundle.putString("nombreA", String.valueOf(txtNombreA));
        bundle.putString("apellidoA", String.valueOf(txtApellidosA));
        bundle.putString("telefonoA", String.valueOf(txtTelefonoA));
        bundle.putString("dniA", String.valueOf(txtDNIA));
        bundle.putString("direccion", String.valueOf(txtDireccionA));
        bundle.putString("edad", String.valueOf(txtEdadA));
        bundle.putString("correo", String.valueOf(txtCorreoA));
        bundle.putString("estado civil", String.valueOf(txtEstadoA));

        EnviarFragment mensaje=new EnviarFragment();



        mensaje.setArguments(bundle);




        /*perro = getArguments().getString("perro");
        txtPerro = (TextView) vista.findViewById(R.id.txtPerro);
        txtPerro.setText(perro);*/















        btnNext = (Button) vista.findViewById(R.id.btnNext);

        //txtSolicitud = (EditText) vista.findViewById(R.id.txtSolicitud);


        /*Bundle objetoAdoptante = getArguments();
        Adoptante adoptante = null;

        Bundle objetoDog = getArguments();
        Dog dog = null;


        if (objetoAdoptante != null){
            //adoptante = (Dog) objetoAdoptante.getSerializable("adoptante");
            txtPerro.setText(dog.getNombre());
            txtNombreA.setText(adoptante.getNombreA());
            txtApellidosA.setText(adoptante.getApellidosA());
            txtTelefonoA.setText(adoptante.getTelefonoA());
            txtDNIA.setText(adoptante.getDNIA());
            txtDireccionA.setText(adoptante.getDireccionA());
            txtEdadA.setText(adoptante.getEdadA());
            txtCorreoA.setText(adoptante.getCorreoA());
            txtEstadoA.setText(adoptante.getEstadoCivilA());


        }*/







        // pasar a la solicitud para revision del adoptante

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnviarFragment NewFragment2 = new EnviarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.fichaF, NewFragment2);
                transaction.addToBackStack(null);
                //String nombre = txtNombreA.getText().toString();
                //txtSolicitud.setText(String.valueOf(nombre));


                transaction.commit();

            }
        });
        return vista;
    }

}
