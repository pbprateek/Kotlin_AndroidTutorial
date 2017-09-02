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
import android.widget.ListView;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_second, container, false);

        final ArrayList<Items> a=new ArrayList<Items>();
        a.add(new Items("Topic-1",R.drawable.chap11,getString(R.string.ch2_1)));
        a.add(new Items("Topic-2",R.drawable.chap22,getString(R.string.ch2_2)));
        a.add(new Items("Topic-3",R.drawable.chap33,getString(R.string.ch2_3)));
        a.add(new Items("Topic-4",R.drawable.chap44,getString(R.string.ch2_4)));
        a.add(new Items("Topic-5",R.drawable.chap55,getString(R.string.ch2_5)));
        a.add(new Items("Topic-6",R.drawable.chap66,getString(R.string.ch2_6)));
        CustomAdapter customAdapter=new CustomAdapter(getActivity(),a);


        ListView listView=(ListView) v.findViewById(R.id.list2);
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

