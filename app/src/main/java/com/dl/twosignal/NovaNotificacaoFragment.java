package com.dl.twosignal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.dl.twosignal.adapters.CustomAdapter;
import com.dl.twosignal.models.DataModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class NovaNotificacaoFragment extends Fragment {

    public NovaNotificacaoFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nova_notificacao, container, false);

        getActivity().setTitle(R.string.app_name);


        Button enviar = (Button) view.findViewById(R.id.btn_login);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderCheckUpdate = new AlertDialog.Builder(getActivity());
                builderCheckUpdate.setTitle("Sucesso");

                builderCheckUpdate.setMessage("A notificação foi enviada para todos os dispositivos cadastrados");

                builderCheckUpdate.setCancelable(false);

                builderCheckUpdate.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Fragment temp = new HistoricoFragment();
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.anim.fade_in,   // popEnter
                                                R.anim.slide_out  // popExit
                                        )
                                        .replace(R.id.framecontainer,temp)
                                        .commit();
                            }
                        });

                AlertDialog alert1CheckUpdate = builderCheckUpdate.create();
                alert1CheckUpdate.show();
            }
        });


        return view;
    }
}