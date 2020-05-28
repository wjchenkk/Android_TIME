package com.example.hp.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.entity.Selection;

import java.util.ArrayList;
import java.util.List;

public class SelectionAdapter extends ArrayAdapter {

    private int resourceId;
    private List<String> name = new ArrayList<>();

    public SelectionAdapter (Context context, int textViewResourceId,
                             List<Selection> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    public List<String> getName() {
        return name;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup partent) {
        Selection selection = (Selection) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, partent, false);
        ImageView selectImage = (ImageView) view.findViewById(R.id.select_image);
        TextView selectName = (TextView) view.findViewById(R.id.select_name);
        ImageView arrowImage = (ImageView) view.findViewById(R.id.arrow_image);
        selectImage.setImageResource(selection.getImgId());
        selectName.setText(selection.getName());
        arrowImage.setImageResource(R.drawable.right_arrow_icon);
        if (selection.getName().equals("休息时间")) {
            TextView time = (TextView) view.findViewById(R.id.time);
            time.setText(selection.getTime() + "分钟");
            selectImage.setVisibility(View.GONE);
            arrowImage.setVisibility(View.GONE);
        }
        if (selection.getName().equals("使用帮助")) {
            selectImage.setVisibility(View.GONE);
        }
        return view;
    }

}
