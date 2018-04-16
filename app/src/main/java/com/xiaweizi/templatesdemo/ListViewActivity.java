package com.xiaweizi.templatesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = findViewById(R.id.list_view);
        ListViewAdapter adapter = new ListViewAdapter(this);
        listView.setAdapter(adapter);
        List<MyBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyBean bean = new MyBean();
            bean.content = "data:  " + i;
            data.add(bean);
        }
        adapter.setData(data);
    }
}
