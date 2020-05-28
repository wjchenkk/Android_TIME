package com.example.hp.myapplication.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.myapplication.entity.Group;
import com.example.hp.myapplication.entity.Item;
import com.example.hp.myapplication.R;

import java.util.ArrayList;


public class MExpandableListAdapter extends BaseExpandableListAdapter {

    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData;
    private Context mContext;

    public MExpandableListAdapter(ArrayList<Group> gData, ArrayList<ArrayList<Item>> iData, Context mContext) {
        this.gData = gData;
        this.iData = iData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup groupHolder;
        if (convertView == null) {
            if (gData.get(groupPosition).getgName().equals("待办")) {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.expandlist_group, parent, false);
                TextView group_name = (TextView) convertView.findViewById(R.id.group_name);
                group_name.setTextSize(18);
            }
            else {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.expandlist_group, parent, false);
            }
            groupHolder = new ViewHolderGroup();
            groupHolder.group_name = (TextView) convertView.findViewById(R.id.group_name);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.group_name.setText(gData.get(groupPosition).getgName());
        return convertView;
    }

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.expandlist_item, parent, false);

            itemHolder = new ViewHolderItem();
            itemHolder.item_time = (TextView) convertView.findViewById(R.id.item_time);
            itemHolder.item_name = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.item_time.setText(iData.get(groupPosition).get(childPosition).getiTime() + "分钟");
        itemHolder.item_name.setText(iData.get(groupPosition).get(childPosition).getiName());

        Button btn_start = (Button) convertView.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You clicked " + iData.get(groupPosition).get(childPosition).getiName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        convertView.setBackgroundColor(randomColor());
        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private static class ViewHolderGroup {
        private TextView group_name;
    }

    private static class ViewHolderItem {
        private TextView item_time;
        private TextView item_name;
    }

    private int randomColor() {
        double num;
        num = Math.random() * 10;
        if (num >= 0 && num <2){
            return Color.rgb(135, 206, 255);
        }
        else if (num >= 2 && num < 4) {
            return Color.rgb(106, 90, 205);
        }
        else if (num >= 4 && num < 6) {
            return Color.rgb(32, 178, 170);
        }
        else if (num >= 6 && num < 8) {
            return Color.rgb(95, 158, 160);
        }
        else {
            return Color.rgb(255, 130, 71);
        }
    }
}
