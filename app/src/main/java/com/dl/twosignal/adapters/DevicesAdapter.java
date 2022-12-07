package com.dl.twosignal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dl.twosignal.R;
import com.dl.twosignal.models.DataModel;

import java.util.List;

/**
 * Created by oshin on 1/30/2018.
 */

class DevicesAdapter extends BaseAdapter {

    private Context applicationContext;
    private int sample;
    private List<DataModel> jsonModels;

    DevicesAdapter(Context applicationContext, int sample, List<DataModel> jsonModels) {

        this.applicationContext = applicationContext;
        this.sample = sample;
        this.jsonModels = jsonModels;

    }

    @Override
    public int getCount() {
        return jsonModels.size();
    }

    @Override
    public Object getItem(int i) {
        return jsonModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) applicationContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.row_item, viewGroup, false);

        }

        TextView name, grade, section;

        name = view.findViewById(R.id.name);
        grade = view.findViewById(R.id.type);
        section = view.findViewById(R.id.version_number);

        name.setText(jsonModels.get(i).getName());
        grade.setText(jsonModels.get(i).getType());
        section.setText(jsonModels.get(i).getVersion_number());

        return view;
    }
}