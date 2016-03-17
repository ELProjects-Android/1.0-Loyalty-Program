package com.example.shashank.storexp.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shashank.storexp.utils.GlobalObjects;
import com.example.shashank.storexp.activities.Qrcode_scanner;
import com.example.shashank.storexp.R;

/**
 * Created by shashank on 1/9/15.
 */public class QRcode_fragment extends Fragment {
//    Bundle bundle = getArguments();
//    String text= bundle.getString("content");
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_qrcode,container,false);
        Button Qr = (Button)v.findViewById(R.id.scanner);
        TextView txt =(TextView)v.findViewById(R.id.textView1);
        TextView txt1 =(TextView)v.findViewById(R.id.text1);
        TextView txt2 =(TextView)v.findViewById(R.id.text2);
        Button add =(Button)v.findViewById(R.id.add);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "font/Brandon_Grotesque_Bold.ttf");
        Qr.setTypeface(typeface);
        add.setTypeface(typeface);

        if(GlobalObjects.URl !=null) {
            txt.setText(GlobalObjects.URl);
            txt1.setVisibility(View.VISIBLE);
            txt2.setVisibility(View.VISIBLE);
            add.setVisibility(View.VISIBLE);
        }
//        if (text!=null)
//        txt.setText(text);
//        else
//        txt.setText("null");
//        String mURL =
        Qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Qrcode_scanner.class);
                startActivity(intent);}
        });
        return v;
    }

    //product barcode mode

    //product qr code mode

}
