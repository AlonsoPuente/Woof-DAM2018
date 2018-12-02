package com.example.pedro.woof.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedro.woof.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<DogViewHolder> implements View.OnClickListener {

    private View.OnClickListener listener;
    List<Dog> dogs;

    //Métdodo constructor que asigna la lista de personas.
    public RVAdapter(List<Dog> dogs){
        this.dogs = dogs;
    }

    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Se hace refgerencia al layout item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);
        DogViewHolder dvh = new DogViewHolder(vista);
        vista.setOnClickListener(this);
        return dvh;

    }

    //Este método se va cargando tantas veces el número de datos o registros de acuerdo con getItemCount()
    @Override
    public void onBindViewHolder(DogViewHolder holder, int position) {
        holder.txtNombre.setText(dogs.get(position).nombre);
        holder.txtEdad.setText(dogs.get(position).edad);
        holder.txtSexo.setText(dogs.get(position).sexo);
        holder.imgFoto.setImageResource(dogs.get(position).fotoID);

    }

    @Override
    public int getItemCount() {
        //Cuenta el número de registros existentes nos da la posicion (position)
        return dogs.size();
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }
}
