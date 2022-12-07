package com.dl.twosignal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dl.twosignal.adapters.HistoricoAdapter;
import com.dl.twosignal.models.HistoricoModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HistoricoFragment extends Fragment {

    ArrayList<HistoricoModel> dataModels;
    ListView listView;
    private static HistoricoAdapter adapter;

    public HistoricoFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        getActivity().setTitle("Historico");

        listView = (ListView) view.findViewById(R.id.list_dispositivo);

        dataModels = new ArrayList<>();

        dataModels.add(new HistoricoModel("Apple Pie", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "1","September 23, 2008"));
        dataModels.add(new HistoricoModel("Banana Bread", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "2","February 9, 2009"));
        dataModels.add(new HistoricoModel("Cupcake", "TESTE", "3","April 27, 2009"));
        dataModels.add(new HistoricoModel("Donut","Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ","4","September 15, 2009"));
        dataModels.add(new HistoricoModel("Eclair", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. A pulvinar pellentesque felis elementum integer iaculis feugiat. ", "5","October 26, 2009"));
        dataModels.add(new HistoricoModel("Froyo", "Android 2.2", "8","May 20, 2010"));
        dataModels.add(new HistoricoModel("Gingerbread", "Android 2.3", "9","December 6, 2010"));
        dataModels.add(new HistoricoModel("Honeycomb","Android 3.0","11","February 22, 2011"));
        dataModels.add(new HistoricoModel("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011"));
        dataModels.add(new HistoricoModel("Jelly Bean", "Android 4.2", "16","July 9, 2012"));
        dataModels.add(new HistoricoModel("Kitkat", "Android 4.4", "19","October 31, 2013"));
        dataModels.add(new HistoricoModel("Lollipop","Android 5.0","21","November 12, 2014"));
        dataModels.add(new HistoricoModel("Marshmallow", "Android 6.0", "23","October 5, 2015"));

        adapter = new HistoricoAdapter(dataModels,getActivity().getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HistoricoModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
        return view;
    }
}