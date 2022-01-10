package com.divyacollege.myapplication;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    final static String KEY_MESSAGE = "key_message";

TextView mTextView;
    public static FirstFragment newInstance(String message,int id) {

        Bundle args = new Bundle();
        args.putString(KEY_MESSAGE,message);
        args.putInt("key_id",id);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.textView);
        mTextView.setText(getArguments().getString(KEY_MESSAGE));
    }
}
