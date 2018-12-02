package com.example.pedro.woof;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;

public class HomeFragment extends Fragment {

    VideoView vwHome;
    WebView wvHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_home, container, false);
        vwHome = (VideoView) vista.findViewById(R.id.vwHome);
        wvHome = (WebView) vista.findViewById(R.id.wvHome);

        //String videoPath = "android.resource://" + getPackageName() + "/" + R
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.woof01;
        vwHome.setVideoURI(Uri.parse(path));
        vwHome.start();

        //Probar con;
        //https://9gag.com/tag/dog?ref=featured-tag
        //https://worldwideinterweb.com/funniest-dog-memes-time-gallery/
        String link = "https://www.purina.es/perro/pro-plan/test-perro-ideal";
        wvHome.getSettings().setJavaScriptEnabled(true);
        wvHome.setWebViewClient(new WebViewClient());
        wvHome.loadUrl(link);

        return vista;
    }
}
