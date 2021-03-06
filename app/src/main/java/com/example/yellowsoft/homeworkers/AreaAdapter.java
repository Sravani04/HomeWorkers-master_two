package com.example.yellowsoft.homeworkers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by info on 19-04-2018.
 */

public class AreaAdapter extends BaseAdapter implements Filterable {
    PartTimeWorkersActivity activity;
    ArrayList<Areas> areas;
    ArrayList<Areas> areas_all;
    Context context;
    LayoutInflater inflater;
    PlanetFilter planetFilter;

    private class PlanetFilter extends Filter {
        Boolean clear_all;

        private PlanetFilter() {
            this.clear_all = Boolean.valueOf(false);
        }

        @SuppressLint("WrongConstant")
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            this.clear_all = Boolean.valueOf(false);
            if (constraint == null || constraint.length() == 0) {
                this.clear_all = Boolean.valueOf(true);
                results.values = AreaAdapter.this.areas;
                results.count = AreaAdapter.this.areas.size();
            } else {
                List<Areas> nPlanetList = new ArrayList();
                Iterator it = AreaAdapter.this.areas_all.iterator();
                while (it.hasNext()) {
                    Areas p = (Areas) it.next();
                    if (Pattern.compile(Pattern.quote(constraint.toString()), 2).matcher(p.title).find()) {
                        nPlanetList.add(p);
                    }
                }
                results.values = nPlanetList;
                results.count = nPlanetList.size();
            }
            return results;
        }

        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0) {
                AreaAdapter.this.notifyDataSetChanged();
            } else if (this.clear_all.booleanValue()) {
                AreaAdapter.this.areas = AreaAdapter.this.areas_all;
                AreaAdapter.this.notifyDataSetChanged();
            } else {
                AreaAdapter.this.areas = (ArrayList) results.values;
                AreaAdapter.this.notifyDataSetChanged();
            }
        }
    }

    public AreaAdapter(Context context, ArrayList<Areas> areas, PartTimeWorkersActivity activity) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.areas = areas;
        this.activity = activity;
        this.areas_all = areas;
    }

    public int getCount() {
        return this.areas.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View item_view = this.inflater.inflate(R.layout.area_items, null);
        LinearLayout line = (LinearLayout) item_view.findViewById(R.id.line);
        final LinearLayout area_ll = (LinearLayout) item_view.findViewById(R.id.area_ll);
        final TextView area_title = (TextView) item_view.findViewById(R.id.area_title);
        if (Session.GetLang(this.context).equals(Session.Words_en)) {
            Log.e("ce", "enetred");
            area_title.setText(((Areas) this.areas.get(i)).title);
        } else {
            area_title.setText(((Areas) this.areas.get(i)).title_ar);
        }
        area_ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                activity.area_option.setText(areas.get(i).title);
                activity.area_id = areas.get(i).id;
                activity.area_popup.setVisibility(View.GONE);
//                if (!((Areas) AreaAdapter.this.areas.get(i)).type.equals("0")) {
//                    Log.e("id", ((Areas) AreaAdapter.this.areas.get(i)).id);
//                    Intent intent = new Intent();
//                    intent.putExtra("area_title", area_title.getText().toString());
//                    intent.putExtra("area_id", areas.get(i).id);
//                    ((Activity)context).setResult(-1, intent);
//                    ((Activity) AreaAdapter.this.context).finish();
//                }
            }
        });

        if (((Areas) this.areas.get(i)).type.equals("0")) {
            area_title.setBackgroundColor(context.getResources().getColor(R.color.black));
            area_title.setHeight((int) context.getResources().getDimension(R.dimen.activity_horizontal_margin));
            area_title.setTypeface(Typeface.defaultFromStyle(1));
            area_title.setTextColor(context.getResources().getColor(R.color.white));
            line.setVisibility(View.GONE);
        } else {
            area_title.setTypeface(Typeface.defaultFromStyle(0));
        }
        return item_view;
    }

    public Filter getFilter() {
        if (this.planetFilter == null) {
            this.planetFilter = new PlanetFilter();
        }
        return this.planetFilter;
    }
}
