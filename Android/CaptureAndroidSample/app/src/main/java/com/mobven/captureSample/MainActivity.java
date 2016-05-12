package com.mobven.captureSample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mobven.com.bugtrackerlibrary.BugTracker.BugTracker;

public class MainActivity extends AppCompatActivity {

    public static final String WEBSITE_URL= "http://www.capture-mobile.com";
    public static final String GITHUB_URL = "https://github.com/mobven/capture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding onCreate()
        BugTracker.onCreate(this);

        //Init and set your 'appId', 'secret' and 'projectId'
        BugTracker.initialize(this, "1", "1", "1000", BugTracker.TRACKEVENT.SHAKE, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BugTracker.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BugTracker.onPause(this);
    }

    public void visitWebsite(View view) {
        openBrowser(WEBSITE_URL);
    }

    public void visitGithub(View view) {
        openBrowser(GITHUB_URL);
    }

    public void openBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
