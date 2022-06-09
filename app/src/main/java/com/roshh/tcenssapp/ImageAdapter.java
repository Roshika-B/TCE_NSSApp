package com.roshh.tcenssapp;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Base64;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public int[] imageArray = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12,
            R.drawable.img13, R.drawable.img14, R.drawable.img15, R.drawable.img16, R.drawable.img18, R.drawable.img19
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgv = new ImageView(mContext);
        imgv.setImageResource(imageArray[i]);
        imgv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgv.setLayoutParams(new ViewGroup.LayoutParams(340,350));

        return imgv;
    }
}

