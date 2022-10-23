package com.example.hackgt22.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;


import com.example.hackgt22.R;
import com.example.hackgt22.databinding.FragmentForumBinding;

public class ForumFragment extends Fragment {

    WebView webView;
    FragmentForumBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containerBundle, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentForumBinding.inflate(inflater, containerBundle, false);

        webView = binding.webView;

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://vsharda3.wixsite.com/vertical-farming");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        return binding.getRoot();
        }

}
