package com.example.shashank.storexp.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shashank.storexp.R;
import com.example.shashank.storexp.adapters.DemoPagerAdapter;
import com.example.shashank.storexp.views.VerticalViewPager;

public class StoreDedicatedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_dedicated_page);
        VerticalViewPager customViewpager = (VerticalViewPager) findViewById(R.id.viewpager_custom);
        DemoPagerAdapter customPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        customViewpager.setAdapter(customPagerAdapter);
//        customViewpager.setPageTransformer(false, new FadePageTransformer());
        customViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }
            @Override
            public void onPageSelected(int i) {
                Log.d("OnPageChangeListener", "Current selected = " + i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_dedicated_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    private class FadePageTransformer implements ViewPager.PageTransformer {
//
//        @Override
//        public void transformPage(View view, float position) {
//            if (position < -1 || position > 1) {
//                view.setAlpha(0);
//            }
//            else if (position <= 0 || position <= 1) {
//                // Calculate alpha. Position is decimal in [-1,0] or [0,1]
//                float alpha = (position <= 0) ? position + 1 : 1 - position;
//                view.setAlpha(alpha);
//            }
//            else if (position == 0) {
//                view.setAlpha(1);
//            }
//
//        }
//    }
}
