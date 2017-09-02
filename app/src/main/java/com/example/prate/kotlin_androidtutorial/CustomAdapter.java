package com.example.prate.kotlin_androidtutorial;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prate on 02-09-2017.
 */

public class CustomAdapter extends ArrayAdapter<Items> {


    public CustomAdapter(Context context, ArrayList<Items> items) {
        super(context,0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.lst_items,parent,false);
        }
        Items currentItem=getItem(position);
        ImageView imageView=(ImageView) listitemview.findViewById(R.id.image);
        TextView textView=(TextView) listitemview.findViewById(R.id.titlelist);
        textView.setText(currentItem.getTitle());
        imageView.setImageResource(currentItem.getImageid());
        imageView.setVisibility(View.VISIBLE);
        return listitemview;
    }
}
