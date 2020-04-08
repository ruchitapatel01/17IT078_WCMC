package com.example.a17it078_wcmc.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a17it078_wcmc.R;

public class p4 extends Fragment {

    EditText input;
    Button fc,cf;
    TextView result;
    Double ans;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View header = inflater.inflate(R.layout.fragment_p4, container, false);

        input = header.findViewById(R.id.p4_input);
        fc = header.findViewById(R.id.p4_fc);
        cf = header.findViewById(R.id.p4_cf);
        result = header.findViewById(R.id.p4_rslt);

        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = ((Double.parseDouble(input.getText().toString())) - 32) / 1.8;
                result.setText(String.valueOf(ans));
            }
        });

        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = ((Double.parseDouble(input.getText().toString())) * 1.8) + 32;
                result.setText(String.valueOf(ans));
            }
        });

        return header;
    }
}