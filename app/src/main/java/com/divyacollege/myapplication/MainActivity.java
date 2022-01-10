package com.divyacollege.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button firstBtn;
Button secondBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBtn =findViewById(R.id.button_a);
        secondBtn = findViewById(R.id.button_b);
        firstBtn.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_fl,FirstFragment.newInstance("data from main activity",1));
            fragmentTransaction.commit();

        });

        secondBtn.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key_second","Data from MainActivity");
            secondFragment.setArguments(bundle);




            fragmentTransaction.replace(R.id.container_fl,secondFragment);
            fragmentTransaction.commit();
        });






    }

}