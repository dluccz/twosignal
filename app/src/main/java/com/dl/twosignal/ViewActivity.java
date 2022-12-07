package com.dl.twosignal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.dl.twosignal.adapters.CustomAdapter;
import com.dl.twosignal.adapters.HistoricoAdapter;
import com.dl.twosignal.models.DataModel;
import com.dl.twosignal.models.HistoricoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton bottomFabView;

    ArrayList<HistoricoModel> dataModels;
    ListView listView;
    private static HistoricoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();

        Button edit = (Button) findViewById(R.id.btn_edit);
        Button enviar = (Button) findViewById(R.id.btn_send);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "DISPOSITIVO OFFLINE", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "DISPOSITIVO BLOQUEADO", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });

        listView = (ListView) findViewById(R.id.list_dispositivo);

        dataModels = new ArrayList<>();

        dataModels.add(new HistoricoModel("TESTE", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "1","September 23, 2008"));
        dataModels.add(new HistoricoModel("TESTE 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "2","February 9, 2009"));
        dataModels.add(new HistoricoModel("Cupcake", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "3","April 27, 2009"));
        dataModels.add(new HistoricoModel("Donut","Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ","4","September 15, 2009"));


        adapter = new HistoricoAdapter(dataModels,ViewActivity.this.getApplicationContext());
        listView.setAdapter(adapter);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setEnabled(true);
        //getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.mHome:

                        Intent intent = new Intent(ViewActivity.this, MainActivity.class);
                        startActivity(intent);

                        break;

                }
                return true;
            }
        });



    }
}