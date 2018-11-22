package com.example.vargasok.bongeszo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    String[] data;
    Context context;
    public MyAdapter(String[] data, Context context) {
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.length;
    }
    @Override
    public Object getItem(int position) {
        return data[position];
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }
        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        textView1.setText(data[position]);
        textView2.setText( String.valueOf( position ) );

        switch (position)
        {
            case 0:
                imageView.setImageResource(R.drawable.google);
                break;

            case 1:
                imageView.setImageResource(R.drawable.facebook);
                break;

            case 2:
                imageView.setImageResource(R.drawable.tesla);
                break;

            case 3:
                imageView.setImageResource(R.drawable.spacex);
                break;

            case 4:
                imageView.setImageResource(R.drawable.github);
                break;


        }

        return convertView;
    }
}
