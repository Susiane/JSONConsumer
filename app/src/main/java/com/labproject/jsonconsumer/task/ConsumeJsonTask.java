package com.labproject.jsonconsumer.task;

import android.os.AsyncTask;

import com.labproject.jsonconsumer.WebClient;
import com.labproject.jsonconsumer.callback.RefreshRecycleView;
import com.labproject.jsonconsumer.model.Person;

import java.util.List;

/**
 * Created by Susiane on 20/08/2016.
 */
public class ConsumeJsonTask extends AsyncTask<RefreshRecycleView,String,List<Person>> {
    private RefreshRecycleView refreshRecycleView;

    @Override
    protected List<Person> doInBackground(RefreshRecycleView... refreshRecycleViews) {
        this.refreshRecycleView = refreshRecycleViews[0];

        WebClient webClient = new WebClient();
        return webClient.get();
    }

    @Override
    protected void onPostExecute(List<Person> persons) {
        super.onPostExecute(persons);
        refreshRecycleView.getList(persons);
    }
}
