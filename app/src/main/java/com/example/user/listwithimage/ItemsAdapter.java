package com.example.user.listwithimage;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ItemsAdapter extends ArrayAdapter<String>{

    int [] adapPhotos;
    String [] adapNames;
    Context adapContext;


    public ItemsAdapter(Context context, int mylayout, String[] names, int[]photo) {

        super(context, mylayout,names);

        adapContext = context;
        adapNames = names;
        adapPhotos = photo;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder  = new ViewHolder();

         String pap = parent.toString();

        Log.i(TAG, "getView: "+pap);

        if(convertView == null){

            LayoutInflater adapInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = adapInflater.inflate(R.layout.listview_item,parent,false);

            viewHolder.vPhoto = (ImageView) convertView.findViewById(R.id.imageV);
            viewHolder.vName = (TextView) convertView.findViewById(R.id.textV);

            viewHolder.vPhoto .setImageResource(adapPhotos[position]);
            viewHolder.vName.setText(adapNames[position]);

            convertView.setTag(viewHolder);
        }
         else {
            viewHolder = (ViewHolder) convertView.getTag();
        }



        //Toast.makeText(adapContext, adapNames[1], Toast.LENGTH_SHORT).show();

        return convertView;
    }
    // to improve perfomance we use ViewHolder instead of using TextView and ImageView.
    static class ViewHolder{

        ImageView vPhoto;
        TextView  vName;


    }
}
