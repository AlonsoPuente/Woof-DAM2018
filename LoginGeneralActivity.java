package com.example.pedro.woof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginGeneralActivity extends AppCompatActivity {
    Button btnLogInv;
    Button btnLogAdopt;
    Button btnLogAlb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_general);
        btnLogInv = (Button) findViewById(R.id.btnLogInv);
        btnLogAlb  = (Button) findViewById(R.id.btnLogAlb);
        btnLogAdopt  = (Button) findViewById(R.id.btnLogAdopt);

        btnLogInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainGeneralActivity.class);
                startActivity(intent);

            }
        });

        btnLogAlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginAlbergueActivity.class );
                startActivity(intent);

            }
        });

        btnLogAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginAdoptanteActivity.class );
                startActivity(intent);

            }
        });

    }
}
