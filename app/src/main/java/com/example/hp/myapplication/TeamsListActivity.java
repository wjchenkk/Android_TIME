package com.example.hp.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.myapplication.adapter.SelectionAdapter;
import com.example.hp.myapplication.entity.Selection;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TeamsListActivity extends AppCompatActivity {

    private List<Selection> selectionList = new ArrayList<>();
    private SelectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamslist);

        initSelections();

        SelectionAdapter adapter = new SelectionAdapter(
                TeamsListActivity.this, R.layout.selection_item,
                selectionList
        );

        ListView listView = (ListView) findViewById(R.id.team_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Selection selection = selectionList.get(position);
                Toast.makeText(TeamsListActivity.this, "You clicked " + selection.getName(),
                        Toast.LENGTH_SHORT).show();
                TeamActivity.actionStart(TeamsListActivity.this, selection.getName());
            }
        });
    }



    private void initView() {
        ListView listView = (ListView) findViewById(R.id.team_list);
        adapter = new SelectionAdapter(TeamsListActivity.this, R.layout.selection_item, selectionList) ;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Selection selection = selectionList.get(position);
                Toast.makeText(TeamsListActivity.this, "You clicked " + selection.getName(),
                        Toast.LENGTH_SHORT).show();
                TeamActivity.actionStart(TeamsListActivity.this, selection.getName());
            }
        });
    }

    private void loadJson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://10.0.2.2:9102/get/text");
                    //打开链接
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    //设置请求体
                    connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
                    connection.setRequestProperty("Accept", "*/*");
                    connection.connect();
                    //获得请求结果码
                    int requestCode = connection.getResponseCode();
                    if (requestCode == 200) {
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
                        for (Map.Entry<String, List<String>> entry : entries) {
                            Log.d(TAG, entry.getKey() + " == " + entry.getValue());

                        }
                        //获取内容
                        //获取流
                        InputStream inputStream = connection.getInputStream();
                        //读取流
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                        String json = bufferedReader.readLine();
//                        Log.d(TAG, "line --> " + json);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
//    private void updataUI(final GetTextItem getTextItem) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                adapter.setData(getTextItem);
//                for (int i = 0; i < adapter.getName().size(); i++) {
//                    Selection team = new Selection(adapter.getName().get(i));
//                    selectionList.add(team);
//                }
//            }
//        });
//    }
    private void initSelections() {

        Selection team1 = new Selection("xxxx小组");
        selectionList.add(team1);
    }

    private static final String TAG = "JsonParser";

}
