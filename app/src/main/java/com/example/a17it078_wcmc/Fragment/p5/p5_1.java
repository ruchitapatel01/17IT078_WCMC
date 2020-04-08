package com.example.a17it078_wcmc.Fragment.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a17it078_wcmc.R;

public class p5_1 extends AppCompatActivity {

    TextView string;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_1);

        string = findViewById(R.id.p5_successfull);

        Intent intent = getIntent();
        text = "Welcome " + intent.getStringExtra("text") + ". You have successfully loged in.";
        string.setText(text);
    }
}
