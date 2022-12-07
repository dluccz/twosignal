package com.dl.twosignal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dl.twosignal.adapters.CustomAdapter;
import com.dl.twosignal.models.DataModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_princ, container, false);

        getActivity().setTitle(R.string.app_name);

        listView = (ListView) view.findViewById(R.id.list_dispositivo);

        dataModels = new ArrayList<>();

        dataModels.add(new DataModel("Dispositivo do Junior", "311s443dsad-sdsa-dssad-781", "1","September 23, 2008"));
        dataModels.add(new DataModel("Dispositivo do Bruno", "3e43dsad-sdsa-dssad-781", "2","February 9, 2009"));
        dataModels.add(new DataModel("Dispositivo do Joao", "334u3dsad-sdsa-dssad-781", "3","April 27, 2009"));
        dataModels.add(new DataModel("Dispositivo do Marcelina","3443dsad-sdsa-dssad-781","4","September 15, 2009"));
        dataModels.add(new DataModel("Dispositivo do Juriscleide", "t3dsad-sdsa-dssad-781", "5","October 26, 2009"));
        dataModels.add(new DataModel("Dispositivo do Julia", "334rdsad-sdsa-dssad-781", "8","May 20, 2010"));
        dataModels.add(new DataModel("Dispositivo do Brian", "33wsad-sdsa-dssad-781", "9","December 6, 2010"));
        dataModels.add(new DataModel("Dispositivo do Jose","33443dsad-sdsa-dssad-781","11","February 22, 2011"));


        adapter = new CustomAdapter(dataModels,getActivity().getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
        return view;
    }

}