package com.example.hp.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.myapplication.adapter.SelectionAdapter;
import com.example.hp.myapplication.entity.Selection;

import java.util.ArrayList;
import java.util.List;

public class UseHelpActivity extends AppCompatActivity {

    private List<Selection> selectionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_help);

        initSelections();

        SelectionAdapter adapter = new SelectionAdapter(UseHelpActivity.this, R.layout.selection_item, selectionList);

        ListView listView = (ListView) findViewById(R.id.help_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Selection selection = selectionList.get(position);
                Toast.makeText(UseHelpActivity.this, "You clicked " + selection.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSelections() {

        Selection help1 = new Selection("什么是番茄钟工作法");
        selectionList.add(help1);
        Selection help2 = new Selection("软件介绍");
        selectionList.add(help2);
        Selection help3 = new Selection("特色功能");
        selectionList.add(help3);
        Selection help4 = new Selection("待办与待办集");
        selectionList.add(help4);
        Selection help5 = new Selection("数据统计");
        selectionList.add(help5);

    }
}
