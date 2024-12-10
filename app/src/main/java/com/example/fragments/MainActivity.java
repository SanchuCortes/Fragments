package com.example.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {  //Creamos unos if usando el metodo creado para cargar el fragmento dependiendo del boton pulsado
                if(item.getItemId() == R.id.btnRojo){
                    CargaFragmento(new FragmentRojo());
                } else if (item.getItemId() == R.id.btnAzul) {
                    CargaFragmento(new FragmentAzul());
                }else if (item.getItemId() == R.id.btnVerde) {
                    CargaFragmento(new FragmentVerde());
                }
                return true;
            }
        });
    }
    private void CargaFragmento(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();  //Metodo para cargar el fragment dependiendo del cual le mandemos
    }
}
