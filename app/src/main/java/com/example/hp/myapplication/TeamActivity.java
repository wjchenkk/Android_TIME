package com.example.hp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.hp.myapplication.adapter.MExpandableListAdapter;
import com.example.hp.myapplication.entity.Group;
import com.example.hp.myapplication.entity.Item;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {

    private ArrayList<Group> gData = null;
    private ArrayList<Group> gData2 = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<ArrayList<Item>> iData2 = null;
    private ArrayList<Item> lData = null;
    private ArrayList<Item> lData2 = null;
    private Context mContext;
    private ExpandableListView exlist1;
    private ExpandableListView exlist2;
    private MExpandableListAdapter myAdapter1 = null;
    private MExpandableListAdapter myAdapter2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Intent intent = getIntent();
        String teamName = intent.getStringExtra("param");
        Log.d("TeamActivity", teamName);
        exlist1 = findViewById(R.id.expandlist_team);
        exlist2 = findViewById(R.id.expandlist_team_todo);
        mContext = this;
        //数据准备
        gData = new ArrayList<Group>();
        gData2 = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        iData2 = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("第三次团队作业"));
        gData2.add(new Group("待办"));
        lData = new ArrayList<Item>();
        lData2 = new ArrayList<Item>();

        lData.add(new Item(60, "原型设计"));
        lData.add(new Item(60, "需求说明书"));
        iData.add(lData);

        lData2.add(new Item(6, "工作计划"));
        iData2.add(lData2);

        myAdapter1 = new MExpandableListAdapter(gData, iData, mContext);
        myAdapter2 = new MExpandableListAdapter(gData2, iData2, mContext);
        exlist1.setAdapter(myAdapter1);
        exlist2.setAdapter(myAdapter2);
    }


    public static void actionStart(Context context, String teamName) {
        Intent intent = new Intent(context, TeamActivity.class);
        intent.putExtra("param", teamName);
        context.startActivity(intent);
    }
}
