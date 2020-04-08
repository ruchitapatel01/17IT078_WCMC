package com.example.a17it078_wcmc.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a17it078_wcmc.Core.ConstantString;
import com.example.a17it078_wcmc.R;

public class p9 extends Fragment {

    WebView webView;
    boolean isFinalized = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:{
                    webViewGoBack();
                }break;
            }
        }
    };

    private void webViewGoBack(){
        webView.goBack();
    }

    public p9() {
        // Required empty public constructor
    }

    public static p1 newInstance(String param1, String param2) {
        p1 fragment = new p1();
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
    public void onPrepareOptionsMenu (Menu menu) {
        if (isFinalized) {
//            menu.getItem(1).setEnabled(false);
            // You can also use something like:
            menu.findItem(R.id.action_settings).setVisible(false);
            menu.findItem(R.id.github).setVisible(true);
            menu.findItem(R.id.google).setVisible(true);
            menu.findItem(R.id.gmail).setVisible(true);
            menu.findItem(R.id.facebook).setVisible(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getTitle().equals("Github")){
            webView.loadUrl(ConstantString.github);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                    view.loadUrl(Url);
                    return true;
                }
            });
        }else if (item.getTitle().equals("Google")){
            webView.loadUrl(ConstantString.google);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                    view.loadUrl(Url);
                    return true;
                }
            });
        }else if (item.getTitle().equals("Gmail")){
            webView.loadUrl(ConstantString.gmail);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                    view.loadUrl(Url);
                    return true;
                }
            });
        } else if (item.getTitle().equals("Facebook")){
            webView.loadUrl(ConstantString.facebook);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                    view.loadUrl(Url);
                    return true;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View header = inflater.inflate(R.layout.fragment_p9, container, false);

        webView = header.findViewById(R.id.p9_web);
        webView.loadUrl(ConstantString.github);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                view.loadUrl(Url);

                webView.setOnKeyListener(new View.OnKeyListener(){

                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK
                                && event.getAction() == MotionEvent.ACTION_UP
                                && webView.canGoBack()) {
                            handler.sendEmptyMessage(1);
                            return true;
                        }

                        return false;
                    }

                });

                return true;
            }
        });

        return header;
    }
}