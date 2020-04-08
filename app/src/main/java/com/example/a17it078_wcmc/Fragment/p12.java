package com.example.a17it078_wcmc.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a17it078_wcmc.R;

import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


public class p12 extends Fragment {

    private TextToSpeech t1;
    private final int REQUEST_SPEECH_RECOGNIZER = 3000;
    private TextView question, answer;
    private final String mQuestion = "What is your name ?";
    private String mAnswer = "";

    public p12() {
        // Required empty public constructor
    }

    public static p12 newInstance(String param1, String param2) {
        p12 fragment = new p12();
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

        View header = inflater.inflate(R.layout.fragment_p12, container, false);

        question = header.findViewById(R.id.p12_t1);
        answer = header.findViewById(R.id.p12_t2);

        t1=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        startSpeechRecognizer();

        return header;
    }

    private void startSpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, mQuestion);
        startActivityForResult(intent, REQUEST_SPEECH_RECOGNIZER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SPEECH_RECOGNIZER) {
            if (resultCode == RESULT_OK) {
                List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                mAnswer = results.get(0);
                question.setText(mQuestion);
                answer.setText(mAnswer);
                if (mAnswer.toUpperCase().indexOf("SMIT") > -1) {
                    t1.speak("Great You are correct", TextToSpeech.QUEUE_FLUSH, null, "adfvsfgbrsgh");
                }
                else {
                    t1.speak("Wrong answer submit this phone to my owner Smit", TextToSpeech.QUEUE_FLUSH, null, "adfvsfgbrsgh");
                }
            }
        }
    }

    @Override
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
