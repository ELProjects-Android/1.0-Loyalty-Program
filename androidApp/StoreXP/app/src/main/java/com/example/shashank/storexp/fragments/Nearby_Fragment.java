package com.example.shashank.storexp.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shashank.storexp.R;
import com.example.shashank.storexp.apis.StoresGet;
import com.example.shashank.storexp.adapters.StoresListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shashank on 22/9/15.
 */
public class Nearby_Fragment extends Fragment{
    private RecyclerView mRecyclerView;
    Bitmap bm = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ccd);

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frangment_nearby, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.nearList);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        StoresGet store1 = new StoresGet();
        store1.setStorename("Cafe Coffe Day ");
        store1.setMembership("Platimun Member ");
        store1.setPoints(100);
        store1.setStorepic(bm);

        StoresGet store2 = new StoresGet();
        store2.setStorename("Cafe Coffe Day ");
        store2.setMembership("Platimun");
        store2.setPoints(100);
        store2.setStorepic(bm);

        StoresGet store3 = new StoresGet();
        store3.setStorename("Cafe Coffe Day ");
        store3.setMembership("Platimun");
        store3.setPoints(100);
        store3.setStorepic(bm);


        final List<StoresGet> storesGetList = new ArrayList<>();
        storesGetList.add(store1);
        storesGetList.add(store2);
        storesGetList.add(store3);
        storesGetList.add(store1);
        storesGetList.add(store2);
        storesGetList.add(store3);
        final StoresListAdapter storesListAdapter = new StoresListAdapter(storesGetList);
        mRecyclerView.setAdapter(storesListAdapter);

        return v;

    }

    }
