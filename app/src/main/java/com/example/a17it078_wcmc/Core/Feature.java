package com.example.a17it078_wcmc.Core;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Feature {

    public static void Toast(Context context, String str) {
        Toast t = Toast.makeText(context, str, Toast.LENGTH_LONG);
        t.show();
    }

    public static void ToastCenter(Context context, String str) {
        Toast t = Toast.makeText(context, str, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 10, 20);
        t.show();
    }
}
