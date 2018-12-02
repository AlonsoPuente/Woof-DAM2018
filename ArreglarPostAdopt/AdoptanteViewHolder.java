package com.example.pedro.woof.ArreglarPostAdopt;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pedro.woof.R;

public class AdoptanteViewHolder extends RecyclerView.ViewHolder {

    TextView txtNombre;
    TextView txtDireccion;
    TextView txtDNI;
    TextView txtMascota;
    ImageView imgFoto;

    AdoptanteViewHolder(View itemView) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombreAdopt);
        txtDireccion = (TextView) itemView.findViewById(R.id.txtDireccion);
        txtDNI = (TextView) itemView.findViewById(R.id.txtDNI);
        txtMascota = (TextView) itemView.findViewById(R.id.txtMascota);
        imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoAdopt);
    }
}
