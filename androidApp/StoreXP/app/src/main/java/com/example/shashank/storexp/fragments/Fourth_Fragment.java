package com.example.shashank.storexp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shashank.storexp.R;

/**
 * Created by shashank on 30/9/15.
 */
public class Fourth_Fragment extends Fragment {
    public static Fourth_Fragment newInstance(int position) {
        Fourth_Fragment fragment = new Fourth_Fragment();
        return fragment;

    }
    public Fourth_Fragment() {

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
        View v = inflater.inflate(R.layout.fragment_fourth_, container, false);
        return v;
    }
}
