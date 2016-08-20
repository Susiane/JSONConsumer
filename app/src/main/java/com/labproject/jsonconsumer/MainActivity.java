package com.labproject.jsonconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.labproject.jsonconsumer.adapter.AdapterRecycleView;
import com.labproject.jsonconsumer.callback.RefreshRecycleView;
import com.labproject.jsonconsumer.model.Person;
import com.labproject.jsonconsumer.task.ConsumeJsonTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RefreshRecycleView {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_person);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        new ConsumeJsonTask().execute(this);
    }

    @Override
    public void getList(List<Person> personList) {
        loadList(personList);
    }

    public void loadList(List<Person> personList){
        mAdapter = new AdapterRecycleView(personList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
