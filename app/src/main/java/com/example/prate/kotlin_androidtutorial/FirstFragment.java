package com.example.prate.kotlin_androidtutorial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_blank, container, false);

        final ArrayList<Items> a=new ArrayList<Items>();
        a.add(new Items("Topic-1",R.drawable.chap1,getString(R.string.ch1_1)));
        a.add(new Items("Topic-2",R.drawable.chap2,getString(R.string.ch1_2)));
        a.add(new Items("Topic-3",R.drawable.chap3,getString(R.string.ch1_3)));
        a.add(new Items("Topic-4",R.drawable.chap4,getString(R.string.ch1_4)));
        a.add(new Items("Topic-5",R.drawable.chap5,getString(R.string.ch1_5)));
        a.add(new Items("Topic-6",R.drawable.chap6,getString(R.string.ch1_6)));
        a.add(new Items("Topic-7",R.drawable.chap7,getString(R.string.ch1_7)));
        a.add(new Items("Topic-8",R.drawable.chap8,getString(R.string.ch1_8)));
        a.add(new Items("Topic-9",R.drawable.chap9,getString(R.string.ch1_9)));
        a.add(new Items("Topic-10",R.drawable.chap10,getString(R.string.ch1_10)));
        CustomAdapter customAdapter=new CustomAdapter(getActivity(),a);


        ListView listView=(ListView) v.findViewById(R.id.list1);
        listView.setAdapter(customAdapter);
        // listView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Items items = a.get(position);
                Intent intent=new Intent(getContext(),Main2Activity.class);
                intent.putExtra("key",items.getHtml());
                startActivity(intent);
                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                //startActivity(browserIntent);

            }
        });
        return v;
    }
}
