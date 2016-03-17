package com.example.shashank.storexp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shashank.storexp.R;
import com.example.shashank.storexp.apis.StoresGet;

import java.util.List;

/**
 * Created by shashank on 3/9/15.
 */
public class StoresListAdapter extends RecyclerView.Adapter<StoresListAdapter.storeViewHolder>{
     Context mContext;
    private List<StoresGet> storeGetList;
    private CardView cv;
    public StoresListAdapter(List<StoresGet> storelist) {
        this.storeGetList = storelist;
    }
    private int position;
//    public Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "font/Brandon_Grotesque_Bold.ttf");

    @Override
    public int getItemCount() {
        return storeGetList.size();
    }
    @Override
    public void onBindViewHolder(storeViewHolder storeViewHolder, int i) {
        StoresGet store  = storeGetList.get(i);
        storeViewHolder.storename.setText(store.getStorename());
        storeViewHolder.menbership.setText(store.getMembership());
        storeViewHolder.points.setText(store.getPoints().toString());
//      storeViewHolder.storepic.setImageBitmap(store.getStorepic());

        position = storeViewHolder.getAdapterPosition();
    }
    @Override
    public storeViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
        final View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.list_item_stores, viewGroup, false);
        return new storeViewHolder(itemView);
    }
    public static class storeViewHolder extends RecyclerView.ViewHolder {
        protected TextView storename;
        protected TextView points;
        protected TextView menbership;
        protected TextView tag1;
        protected ImageView storepic;
        protected Button call,locate;
        public View view;
         Context mCon ;


        public storeViewHolder(View v) {
            super(v);

            storename =  (TextView) v.findViewById(R.id.storeName);
            points = (TextView)  v.findViewById(R.id.points);
            menbership = (TextView)  v.findViewById(R.id.membership);
            storepic = (ImageView) v.findViewById(R.id.storeImage);
            call = (Button) v.findViewById(R.id.call);
            locate = (Button) v.findViewById(R.id.locate);
            Typeface typeface = Typeface.createFromAsset(v.getContext().getAssets(), "font/Brandon_Grotesque_Bold.ttf");
            call.setTypeface(typeface);
            locate.setTypeface(typeface);
//            View linearLayout =  v.findViewById(R.id.tagslist);
//            tag1 = new TextView(null);
            //LinearLayout layout = (LinearLayout) findViewById(R.id.info);


//            tag1.setText("hallo hallo");
//            tag1.setId(5);
//            tag1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

//            ((LinearLayout) linearLayout).addView(tag1);
        }
    }
}
