package com.example.pedro.woof.Albergue;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.pedro.woof.DetalleFragment;
import com.example.pedro.woof.HomeFragment;
import com.example.pedro.woof.IComunicaFragments;
import com.example.pedro.woof.MainGeneralActivity;
import com.example.pedro.woof.R;
import com.example.pedro.woof.RecyclerView.Dog;
import com.example.pedro.woof.RegistroPerroActivity;
import com.example.pedro.woof.SearchFragment_adoptante;

public class MainActivity_Albergue extends AppCompatActivity implements IComunicaFragments {

    DetalleFragment detalleFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_albergue);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Preselected menu item
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Acá metemos registrar perro
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(), RegistroPerroActivity.class);
                startActivity(intent);

            }
        });

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment_adoptante();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragmentAlbergue();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public void enviarDog(Dog dog) {
        detalleFragment = new DetalleFragment();
        Bundle bundleEnvio = new Bundle();
        bundleEnvio.putSerializable("perro", dog);
        detalleFragment.setArguments(bundleEnvio);
        //Cargamos el fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detalleFragment).addToBackStack(null).commit();
    }
}
