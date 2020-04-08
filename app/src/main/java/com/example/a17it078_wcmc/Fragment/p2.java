package com.example.a17it078_wcmc.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a17it078_wcmc.Core.Feature;
import com.example.a17it078_wcmc.R;

public class p2 extends Fragment {

    EditText num1,num2;
    Button add;
    Double nm1,nm2,sum;

    public p2() {
        // Required empty public constructor
    }

    public static p2 newInstance(String param1, String param2) {
        p2 fragment = new p2();
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
        final View header = inflater.inflate(R.layout.fragment_p2, container, false);

        num1 = header.findViewById(R.id.n1);
        num2 = header.findViewById(R.id.n2);
        add = header.findViewById(R.id.addition);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()){
                    Feature.Toast(getContext(),"Please Enter Value.");
                }else{
                    nm1 = Double.parseDouble(num1.getText().toString());
                    nm2 = Double.parseDouble(num2.getText().toString());
                    sum = nm1 + nm2;
                    Feature.Toast(getContext(),sum.toString());
                }
            }
        });
        return header;
    }
}