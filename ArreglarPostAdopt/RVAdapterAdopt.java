package com.example.pedro.woof.ArreglarPostAdopt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedro.woof.R;

import java.util.List;

public class RVAdapterAdopt extends RecyclerView.Adapter<AdoptanteViewHolder> {

    List<Adoptante> adoptantes;
    //Método constructor que asigna la lista de personas
    public RVAdapterAdopt(List<Adoptante> adoptantes) {
        this.adoptantes = adoptantes;
    }

    @Override
    public AdoptanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Se hace referencia al layout Item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adoptante, parent, false);
        AdoptanteViewHolder pvh = new AdoptanteViewHolder(vista);
        return pvh;
    }
    //Recibe el objeto PersonaViewHolder y la posición
    //Este método se va cargando tantas veces el número de datos o registros de acuerdo con getItemCount()
    @Override
    public void onBindViewHolder(AdoptanteViewHolder holder, int position) {
        holder.txtNombre.setText(adoptantes.get(position).nombre);
        holder.txtDireccion.setText(adoptantes.get(position).direccion);
        holder.txtDNI.setText(adoptantes.get(position).DNI);
        holder.txtMascota.setText(adoptantes.get(position).mascota);
        holder.imgFoto.setImageResource(adoptantes.get(position).fotoID);
    }

    @Override
    public int getItemCount() {
        return adoptantes.size();
    }


}
