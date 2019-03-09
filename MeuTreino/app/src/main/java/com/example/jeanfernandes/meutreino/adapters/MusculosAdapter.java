package com.example.jeanfernandes.meutreino.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeanfernandes.meutreino.R;
import com.example.jeanfernandes.meutreino.models.Musculos;

import java.util.List;

public class MusculosAdapter extends BaseAdapter {
    private Context context;
    private List<Musculos> list;

    public MusculosAdapter(Context context, List<Musculos> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get selected entry
        Musculos entry = this.list.get(position);

        // inflating list view layout if null
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.custom_list_item, null);
        }

        // set avatar
        ImageView avatar = (ImageView)convertView.findViewById(R.id.imgAvatar);
        avatar.setImageBitmap(entry.getAvatar());

        // set name
        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
        tvName.setText(entry.getNome());

        return convertView;
    }
}
