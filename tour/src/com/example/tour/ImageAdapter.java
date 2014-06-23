package com.example.tour;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.birishiri, R.drawable.himchori,
            R.drawable.jaflong, R.drawable.kuakata,
            R.drawable.lalbagh, R.drawable.madhabkundo,
            R.drawable.moheskhali, R.drawable.potengabeach,
            R.drawable.sundarban,R.drawable.wwcemetery,
            R.drawable.foyslake,R.drawable.mahasthangarh,
            R.drawable.alikadam,R.drawable.bogalake,
            R.drawable.buddhadhatujadi,R.drawable.nilgiri,
            R.drawable.rumabazar,R.drawable.tajindong,
            R.drawable.sonamosjid,R.drawable.srimongol};
 
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(110,90));
        return imageView;
    }
 
}