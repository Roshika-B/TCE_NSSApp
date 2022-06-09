package com.roshh.tcenssapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptList extends ArrayAdapter<String>{

        Context context;
        String main[];
        String sub[];
        int img[];

        AdaptList(Context c, String tmain[], String tsub[], int timg[]){
            super(c, R.layout.row, R.id.tvmain, tmain);
            this.context=c;
            this.main=tmain;
            this.sub=tsub;
            this.img=timg;


        }
        public View getView(int pos, View convertView, ViewGroup parent){
            LayoutInflater linf=(LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=linf.inflate(R.layout.row,parent,false);
            ImageView imgss=row.findViewById(R.id.imga);
            TextView mainss=row.findViewById(R.id.tvmain);
            TextView subss=row.findViewById(R.id.tvsub);
            imgss.setImageResource(img[pos]);
            mainss.setText(main[pos]);
            subss.setText(sub[pos]);
            return row;
        }
    }