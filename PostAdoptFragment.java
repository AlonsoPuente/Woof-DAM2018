package com.example.pedro.woof;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pedro.woof.ArreglarPostAdopt.Adoptante;
import com.example.pedro.woof.ArreglarPostAdopt.RVAdapterAdopt;

import java.util.ArrayList;
import java.util.List;


public class PostAdoptFragment extends Fragment {

    RecyclerView rvLista02;
    List<Adoptante> listaAdoptantes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_post_adopt, container, false);
        rvLista02 = (RecyclerView) vista.findViewById(R.id.rvLista02);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvLista02.setLayoutManager(lm);
        rvLista02.setHasFixedSize(true);

        this.CargarData();
        this.CargarAdapter();


        return vista;
    }

    private void CargarData() {
        listaAdoptantes = new ArrayList<>();
        listaAdoptantes.add(new Adoptante("Eddie Maiden", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.eddie));
        listaAdoptantes.add(new Adoptante("Johny Smith", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Héctor", R.drawable.adopt2));
        listaAdoptantes.add(new Adoptante("Clara Palgato", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Pepe", R.drawable.adop1jpg));
        listaAdoptantes.add(new Adoptante("Esterno Cleido", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.adopt4));
        listaAdoptantes.add(new Adoptante("Esteban Quito", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.adopt2));
        listaAdoptantes.add(new Adoptante("Aquiles Mando", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.adopt3));
        listaAdoptantes.add(new Adoptante("Violeta Kiñón", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.adopt2));
        listaAdoptantes.add(new Adoptante("Eduardo Manco", "Jr. Buenos Aires 666, Callao - Perú", "789632541", "Cerberus", R.drawable.eddie));
    }

    private void CargarAdapter() {
        RVAdapterAdopt adapter = new RVAdapterAdopt(listaAdoptantes);
        rvLista02.setAdapter(adapter);
    }
}
