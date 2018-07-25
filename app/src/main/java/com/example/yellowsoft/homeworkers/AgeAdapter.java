package com.example.yellowsoft.homeworkers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by info on 29-05-2018.
 */

public class AgeAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Age> age;

    public  AgeAdapter(Context context,ArrayList<Age> age){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.age = age;
    }
    @Override
    public int getCount() {
        return age.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item_view = inflater.inflate(R.layout.nationality_religion_items,null);
        TextView title = (TextView) item_view.findViewById(R.id.title);
        title.setText(age.get(i).title);
        return item_view;
    }
}
