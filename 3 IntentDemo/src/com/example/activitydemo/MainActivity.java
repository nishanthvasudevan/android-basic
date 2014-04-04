package com.example.activitydemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void myMethod(View v) {  
     // Intent to call second activity
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    
}
