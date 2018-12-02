package com.example.pedro.woof.Adoptante;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.pedro.woof.Albergue.ProfileFragmentAlbergue;
import com.example.pedro.woof.DetalleFragment;
import com.example.pedro.woof.HomeFragment;
import com.example.pedro.woof.IComunicaFragments;
import com.example.pedro.woof.R;
import com.example.pedro.woof.RecyclerView.Dog;
import com.example.pedro.woof.SearchFragment_adoptante;

public class MainActivity_Adoptante extends AppCompatActivity implements IComunicaFragments {

    DetalleFragment detalleFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_adoptante);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Preselected menu item
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


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
