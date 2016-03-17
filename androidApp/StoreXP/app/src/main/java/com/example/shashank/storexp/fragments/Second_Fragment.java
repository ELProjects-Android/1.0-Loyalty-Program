package com.example.shashank.storexp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shashank.storexp.R;

public class Second_Fragment extends Fragment {

    public static Second_Fragment newInstance(int position) {
        Second_Fragment fragment = new Second_Fragment();
        return fragment;

    }
    public Second_Fragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second_, container, false);
        return v;
    }
}
