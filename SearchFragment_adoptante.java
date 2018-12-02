package com.example.pedro.woof;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pedro.woof.RecyclerView.Dog;
import com.example.pedro.woof.RecyclerView.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment_adoptante extends Fragment {

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;
    RecyclerView rvLista;
    List<Dog> listaPerros;
    String sexo[] = {"Macho", "Hembra"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_search_adoptante, container, false);
        rvLista = (RecyclerView) vista.findViewById(R.id.rvLista);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvLista.setLayoutManager(lm);
        rvLista.setHasFixedSize(true);

        this.CargarData();
        this.CargarAdapter();

        return vista;


    }


    private void CargarData(){
        listaPerros = new ArrayList<>();
        listaPerros.add(new Dog("Héctor","8 meses", sexo[1],"Un Perro muy chevere que le encanta volar","Patitas Felices",R.drawable.perro1));
        listaPerros.add(new Dog("Pepe","1 año",sexo[0],"Lorem ipsum dolor sit amet, consectetur adipiscing wööf, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Club Wuf", R.drawable.perro2));
        listaPerros.add(new Dog("Frida","1 año", sexo[1],"Un Perro muy chevere que le encanta volar","Patota", R.drawable.perro3));
        listaPerros.add(new Dog("Johny","4 años",sexo[0],"Lorem ipsum guau guau sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Patitas Felices", R.drawable.perro4));
        listaPerros.add(new Dog("Casilda","3 años",sexo[1],"Un Perro muy chevere que le encanta volar","Patota", R.drawable.perro5));
        listaPerros.add(new Dog("Kike","5 años",sexo[0],"Lorem ipsum dolor wuf amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","Club Wuf", R.drawable.perro6));
    }

    private void CargarAdapter(){
        final RVAdapter adapter = new RVAdapter(listaPerros);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Adoptar a "+listaPerros.get(rvLista.getChildAdapterPosition(view)).getNombre()+" ??", Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarDog(listaPerros.get(rvLista.getChildAdapterPosition(view)));

            }
        });

        rvLista.setAdapter(adapter);
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;
        }
    }
}
