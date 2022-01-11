package com.divyacollege.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button firstBtn;
Button secondBtn;
Button mOpenDialogBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBtn =findViewById(R.id.button_a);
        secondBtn = findViewById(R.id.button_b);
        mOpenDialogBtn = findViewById(R.id.open_dialog_btn);
        mOpenDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new AlertDialog.Builder(MainActivity.this).setTitle("This is a dialog")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        })
//                        .setNegativeButton("Cancel", ((dialogInterface, i) ->{
//
//                } )).create().show();

                new MessageDialog().show(getSupportFragmentManager(),"tag");


            }});
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