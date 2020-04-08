package com.example.a17it078_wcmc.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.a17it078_wcmc.R;

public class p7 extends Fragment {

    Spinner spinner;
    LinearLayout bg;
    String[] colors = {"Silver","White","Black","Blue","Red","Green"};

    public p7() {
        // Required empty public constructor
    }

    public static p7 newInstance(String param1, String param2) {
        p7 fragment = new p7();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View header = inflater.inflate(R.layout.fragment_p7, container, false);

        spinner = header.findViewById(R.id.p7_spinner);
        bg = header.findViewById(R.id.p7_linear);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,colors);

//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.colors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (colors[position].equals("Silver")){
                    bg.setBackgroundColor(Color.parseColor("#C0C0C0"));
                }else if (colors[position].equals("White")){
                    bg.setBackgroundColor(Color.parseColor("#ffffff"));
                }else if (colors[position].equals("Black")){
                    bg.setBackgroundColor(Color.parseColor("#000000"));
                }else if (colors[position].equals("Blue")){
                    bg.setBackgroundColor(Color.parseColor("#000080"));
                }else if (colors[position].equals("Red")){
                    bg.setBackgroundColor(Color.parseColor("#FF0000"));
                }else if (colors[position].equals("Green")){
                    bg.setBackgroundColor(Color.parseColor("#008000"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return header;
    }
}
