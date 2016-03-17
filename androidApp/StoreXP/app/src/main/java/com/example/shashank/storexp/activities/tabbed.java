package com.example.shashank.storexp.activities;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.EditText;

import com.example.shashank.storexp.R;
import com.example.shashank.storexp.views.SlidingTabLayout;
import com.example.shashank.storexp.adapters.SwipeTabsAdapter;
import com.example.shashank.storexp.fragments.Favorate_Fragment;
import com.example.shashank.storexp.fragments.Nearby_Fragment;
import com.example.shashank.storexp.fragments.QRcode_fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
public class tabbed extends AppCompatActivity {
    private static View fragment;
    private ViewPager mTabViewPager;
    private ActionBar mTabActionBar;
    private List<Fragment> mTabFragments;
    private List<String> mTabTitles;
    private SwipeTabsAdapter swipeTabsAdapter;
    private SlidingTabLayout mTabs;
    EditText searchText;
    Animation ani = new Animation() {
        @Override
        public void setInterpolator(Interpolator i) {
            super.setInterpolator(i);
        }
    };
    static LatLng ShownLocation = null;
    private GoogleMap googleMap;
//        View fragment ;

    //    @Override
//    public void onDownPressed()
//    {
//        searchText.clearFocus();
//        Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
//        return;
//    }
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.ACTION_DOWN) {
                searchText.clearFocus();

        finish();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)this.findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        fragment = findViewById(R.id.map);
//        fragment.setVisibility(View.GONE);
//
//        Button collection = (Button)findViewById(R.id.)
        mTabActionBar = getSupportActionBar();
        searchText =(EditText)findViewById(R.id.serch_text);
        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);
//            googleMap.getMaxZoomLevel();
//            googleMap.setContentDescription("MY LOC");
//            googleMap.isMyLocationEnabled();
//            googleMap.getMyLocation();
            Criteria criteria = new Criteria();
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            String provider = locationManager.getBestProvider(criteria, true);
            Location location = locationManager.getLastKnownLocation(provider);
            ShownLocation = new LatLng(location.getLatitude() , location.getLongitude());

            Marker TP = googleMap.addMarker(new MarkerOptions().
                    position(ShownLocation).title("CCD"));
            googleMap.getUiSettings().isMapToolbarEnabled();
//            googleMap.animateCamera(CameraUpdateFactory.zoomOut());
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ShownLocation,
                    14));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        mTabActionBar.setDisplayShowTitleEnabled(true);
//        mTabActionBar.hide();
        this.setTabs();
        mTabActionBar.setTitle("");

//        // Creating The Toolbar and setting it as the Toolbar for the activity
//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);
//        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
//        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);
//// Assigning ViewPager View and setting the adapter
//        pager = (ViewPager) findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//// Assiging the Sliding Tab Layout View
//        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
//        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
//        // Setting Custom Color for the Scroll bar indicator of the Tab View
//        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//                return getResources().getColor(R.color.tabsScrollColor);
//            }
//        });
//// Setting the ViewPager For the SlidingTabsLayout
//        tabs.setViewPager(pager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
//            case
        }
        return super.onOptionsItemSelected(item);
    }
    public void setTabs(){

        this.mTabTitles = new ArrayList<String>();
        this.mTabFragments = new ArrayList<Fragment>();
        this.mTabFragments.add(new QRcode_fragment());
        this.mTabFragments.add(new Favorate_Fragment());
        this.mTabFragments.add(new Nearby_Fragment());
        this.mTabTitles.add("SCAN");
        this.mTabTitles.add("Favorate");
        this.mTabTitles.add("Nearby");
        this.swipeTabsAdapter = new SwipeTabsAdapter(getSupportFragmentManager(), this.mTabFragments, this.mTabTitles, this);
        this.mTabViewPager= (ViewPager) this.findViewById(R.id.pager);
        this.mTabViewPager.setAdapter(swipeTabsAdapter);
        this.mTabs = (SlidingTabLayout)this.findViewById(R.id.tabs);
        this.mTabs.setDistributeEvenly(true);
        this.mTabs.setViewPager(mTabViewPager);


    }

    public static void changestate(boolean b) {
        if(b){
            fragment.setVisibility(View.VISIBLE);
//            fragment.setAlpha(0.1f);

// Start the animation
            fragment.animate()
//                    .translationX(fragment.getWidth())
                    .alpha(1.0f);
        }
        else
            fragment.setVisibility(View.GONE);
    }
}


