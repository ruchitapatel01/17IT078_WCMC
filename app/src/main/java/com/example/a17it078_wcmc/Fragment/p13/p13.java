package com.example.a17it078_wcmc.Fragment.p13;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a17it078_wcmc.R;

public class p13 extends Fragment {

    Button button;

    public p13() {
        // Required empty public constructor
    }

    public static p13 newInstance(String param1, String param2) {
        p13 fragment = new p13();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View header = inflater.inflate(R.layout.fragment_p13, container, false);

        button = header.findViewById(R.id.p13_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), p13_1.class);
                startActivity(intent);
            }
        });

        return header;
    }
}
