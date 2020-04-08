package com.example.a17it078_wcmc.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a17it078_wcmc.Core.Feature;
import com.example.a17it078_wcmc.R;

import java.lang.reflect.Parameter;
import java.security.Policy;

public class p6 extends Fragment {

    Button on_off;
    Camera camera;
    Camera.Parameters params;
    boolean isFlashOn = false;
    private boolean hasFlash;

    public p6() {
        // Required empty public constructor
    }

    public static p6 newInstance(String param1, String param2) {
        p6 fragment = new p6();
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
        View header = inflater.inflate(R.layout.fragment_p6, container, false);

//        hasFlash = getContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//
//        if (!hasFlash) {
//            AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
//            alert.setTitle("Error");
//            alert.setMessage("Sorry, your device doesn't support flash light!");
//            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    // closing the application
//                    getActivity().finish();
//                }
//            });
//            alert.show();
//            return header;
//        }

        getCamera();

        on_off = header.findViewById(R.id.p6_button);
        on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn){
                    turnOffFlash();
                }else {
                    turnOnFlash();
                }
            }
        });

        return header;
    }

    public void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            }catch (Exception e) {
                Feature.Toast(getContext(),e.toString());
            }
        }
    }

    public void turnOnFlash() {
        try {
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
            on_off.setText("OFF");
        }catch (Exception e) {
            Feature.Toast(getContext(),e.toString());
        }
    }

    public void turnOffFlash() {
        try {
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;
            on_off.setText("ON");
        }catch (Exception e) {
            Feature.Toast(getContext(),e.toString());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
            params = null;
        }
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        // on resume turn on the flash
//        if (hasFlash)
//            turnOnFlash();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // on starting the app get the camera params
//        getCamera();
//    }

}