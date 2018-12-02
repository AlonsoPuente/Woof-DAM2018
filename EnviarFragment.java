package com.example.pedro.woof;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

//import com.example.pedro.woof.RecyclerView.Adoptante;
import com.example.pedro.woof.RecyclerView.Dog;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnviarFragment extends Fragment {
    Button btnEdit;
    Button btnEnviar;
    /*TextView txtNombreA;
    TextView txtApellidosA;
    TextView txtTelefonoA;
    TextView txtDNIA;
    TextView txtDireccionA;
    TextView txtEstadoA;
    TextView txtEdadA;
    TextView txtCorreoA;
    TextView txtAlbergue;
    TextView txtPerro;*/
    TextView txtSolicitud;

    String nombre1;
    String apellidos1;
    String telefono1;
    String dni1;
    String direccion1;
    String estadoA1;
    String edad1;
    String  correo1;
    String albergue1;
    String perro1;




    public EnviarFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vista = inflater.inflate(R.layout.fragment_enviar, container, false);
        Bundle bundle = this.getArguments();

        if (bundle != null) {

            nombre1 = bundle.getString("nombreA");
            apellidos1 = bundle.getString("apellidoA");
            telefono1 = bundle.getString("telefonoA");
            dni1 = bundle.getString("dniA");
            direccion1 = bundle.getString("direccion");
            edad1 = bundle.getString("edad");
            correo1 = bundle.getString("correo");
            //albergue = bundle.getString("albergue");
            //perro = bundle.getString("perro");
            estadoA1 = bundle.getString("estado civil");
        }






        txtSolicitud = (TextView)vista.findViewById(R.id.txtSolicitud);






        Bundle objetoAdoptante = getArguments();
        //Adoptante adoptante = null;

        Bundle objetoDog = getArguments();
        Dog dog = null;
        /*if (objetoAdoptante != null){
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
            txtAlbergue.setText(dog.getAlbergue());
            //obteniedo los valores




        }*/

        //Bundle bundle = new Bundle();
        //bundle.putInt("nombre", Integer.parseInt(nombre));
        //Fragment.setArguments(bundle);




        //solicitud que será enviada al albergue para su posterior revision
        txtSolicitud.setText("Yo " +nombre1+" "+apellidos1+
                " identificado con DNI : "+dni1 +" , domiciliado en: "+direccion1+
                " deseo adoptar a "+perro1+" perteneciente al albergue "+albergue1+
                ". Soy una persona "+estadoA1+" con "+edad1+" años de edad, amante " +
                "de los animales, para cualquier duda sobre mis datos comunicarse al teléfono "+telefono1+
                " o escribirme a "+correo1+". Gracias");


        btnEdit = (Button) vista.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FichaFragment regresarFragment = new FichaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.adopcion, regresarFragment);
                transaction.addToBackStack(null);
                // regresamos a arreglar la solicitud por si un dato no es correcto

                transaction.commit();
            }
        });
        btnEnviar = (Button) vista.findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment_adoptante solicitudFragment = new SearchFragment_adoptante();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.adopcion, solicitudFragment);
                transaction.addToBackStack(null);
                //enviamos la solicitud para que el albergue lo revise
                transaction.commit();
                // Toast.makeText(getContext(),"El albergue "+ txtAlbergue.getText().toString()+ " se pondra en contacto con usted", Toast.LENGTH_SHORT).show();
            }
        });


        /*Toast.makeText(getContext(),"Yo "+ txtNombreA.getText().toString()+" "+txtApellidosA.getText().toString()+
                " identificado con DNI : "+txtDNIA.getText().toString()+ " , domiciliado en: "+txtDireccionA.getText().toString()+
                " deseo adoptar a "+txtPerro.getText().toString()+" perteneciente al albergue "+txtAlbergue.getText().toString()+
                ". Soy una persona "+txtEstadoA.getText().toString()+" con "+txtEdadA.getText().toString()+" años de edad, amante " +
                "de los animales, para cualquier duda sobre mis datos comunicarse al teléfono "+txtTelefonoA.getText().toString()+
                " o escribirme a "+txtCorreoA.getText().toString()+". Gracias", Toast.LENGTH_SHORT).show();*/


        // Inflate the layout for this fragment
        return vista;
    }

}