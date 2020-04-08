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

public class p3 extends Fragment {

    EditText name,sgpa;
    Button show;

    public p3() {
        // Required empty public constructor
    }

    public static p3 newInstance(String param1, String param2) {
        p3 fragment = new p3();
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
        final View header = inflater.inflate(R.layout.fragment_p3, container, false);

        name = header.findViewById(R.id.p3_name);
        sgpa = header.findViewById(R.id.p3_sgpa);
        show = header.findViewById(R.id.p3_button);

        show.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (Float.parseFloat(sgpa.getText().toString()) >= 7.5){
                    Feature.ToastCenter(getContext(),"Congratulations " + name.getText().toString() + ". You have cleared this examination with Distinction.");
                }else if (Float.parseFloat(sgpa.getText().toString()) < 7.5 && Float.parseFloat(sgpa.getText().toString()) >= 6.5){
                    Feature.ToastCenter(getContext(),"Congratulations " + name.getText().toString() + ". You have cleared this examination with First Class.");
                }else if (Float.parseFloat(sgpa.getText().toString()) < 6.5 && Float.parseFloat(sgpa.getText().toString()) >= 5.5){
                    Feature.ToastCenter(getContext(),"Congratulations " + name.getText().toString() + ". You have cleared this examination with second Class.");
                }else {
                    Feature.ToastCenter(getContext(),"Sorry " + name.getText().toString() + ". You are Fail.");
                }
            }
        });

        return header;
    }
}