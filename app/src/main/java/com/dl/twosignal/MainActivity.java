package com.dl.twosignal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.onesignal.OneSignal;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton bottomFabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // OneSignal Initialization
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId("8c0b6607-8093-4fd0-9167-3583c7180740");

        bottomFabView = (FloatingActionButton) findViewById(R.id.fab);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.mHome : temp = new HomeFragment();
                        break;
                    case R.id.mHistorico : temp = new HistoricoFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.down_from_top,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.framecontainer,temp)
                        .commit();
                return true;
            }
        });

        bottomFabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment temp = new NovaNotificacaoFragment();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.framecontainer,temp)
                        .commit();

            }
        });
    }
}