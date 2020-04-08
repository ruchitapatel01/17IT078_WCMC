package com.example.a17it078_wcmc.Fragment.p5;

import android.content.Intent;
import android.graphics.Color;
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

public class p5 extends Fragment {

    TextView failed;
    EditText usname,pass;
    Button login, cancel;
    Integer count = 0;

    public p5() {
        // Required empty public constructor
    }

    public static p5 newInstance(String param1, String param2) {
        p5 fragment = new p5();
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
        View header = inflater.inflate(R.layout.fragment_p5, container, false);

        failed = header.findViewById(R.id.p5_fail);
        usname = header.findViewById(R.id.p5_username);
        pass = header.findViewById(R.id.p5_password);
        login = header.findViewById(R.id.p5_login);
        cancel = header.findViewById(R.id.p5_cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count<2){
                    if (!usname.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
                        Intent intent = new Intent(getContext(), p5_1.class);
                        intent.putExtra("text",usname.getText().toString());
                        startActivity(intent);
                    }else {
                        count++;
                        failed.setText("Please enter valid Username or Password.");
                        failed.setBackgroundColor(Color.parseColor("#8BFFCBA4"));
                    }
                }else{
                    login.setEnabled(false);
                    login.setBackgroundColor(Color.parseColor("#b6b6b4"));
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        return header;
    }
}
