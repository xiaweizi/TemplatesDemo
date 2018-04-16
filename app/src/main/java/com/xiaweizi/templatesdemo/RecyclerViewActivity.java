package com.xiaweizi.templatesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        List<MyBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyBean bean = new MyBean();
            bean.content = "data:  " + i;
            data.add(bean);
        }
        adapter.setData(data);
        recyclerView.setAdapter(adapter);
    }
}
