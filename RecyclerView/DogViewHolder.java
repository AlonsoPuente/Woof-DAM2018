package com.example.pedro.woof.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pedro.woof.R;

public class DogViewHolder extends RecyclerView.ViewHolder {

    TextView txtNombre;
    TextView txtEdad;
    TextView txtSexo;
    ImageView imgFoto;

    DogViewHolder(View itemView){
        super(itemView);
        //Se hace referencia a los views creados desde Layout "item_sad.xml"
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtEdad = (TextView) itemView.findViewById(R.id.txtEdad);
        txtSexo = (TextView) itemView.findViewById(R.id.txtSexo);
        imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoAdopt);
    }
}
