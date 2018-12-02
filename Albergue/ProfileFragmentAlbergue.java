package com.example.pedro.woof.Albergue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pedro.woof.PostAdoptFragment;
import com.example.pedro.woof.R;
import com.example.pedro.woof.SolicitudesActivity;

public class ProfileFragmentAlbergue extends Fragment {

    Button btnSolAdopt;
    Button btnContPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_profile_albergue, container, false);

        btnSolAdopt = (Button) vista.findViewById(R.id.btnSolicitudAdopcion);
        btnContPost = (Button) vista.findViewById(R.id.btnContactoPost);

        btnSolAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SolicitudesActivity.class);
                startActivity(intent);
            }
        });

        btnContPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PostAdoptFragment postAdoptFragment = new PostAdoptFragment();
                android.support.v4.app.FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment_container,postAdoptFragment).commit();



                /*Intent intent = new Intent(getActivity(), PostAdoptFragment.class);
                startActivity(intent);
                PostAdoptFragment newGamefragment = new PostAdoptFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, newGamefragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });

        return vista;
    }


}
