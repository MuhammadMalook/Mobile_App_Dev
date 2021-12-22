package com.example.mad_libs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<stories> list;
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<stories> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        stories story = list.get(position);
        TextView name =  convertView.findViewById(R.id.textView4);
        name.setText(story.title);
        return convertView;
    }
}
