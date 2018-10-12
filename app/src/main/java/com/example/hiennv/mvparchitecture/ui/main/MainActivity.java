package com.example.hiennv.mvparchitecture.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hiennv.mvparchitecture.R;

public class MainActivity extends AppCompatActivity {
    /*@BindView để findViewById
    * @BindString để bind String trong file string.xml*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
