package com.labproject.jsonconsumer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labproject.jsonconsumer.R;
import com.labproject.jsonconsumer.model.Person;

import java.util.List;

/**
 * Created by Susiane on 20/08/2016.
 */
public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {
    private List<Person> personList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id_text;
        public TextView name_text;
        public TextView pwd_text;

        public ViewHolder(View view) {
            super(view);
            id_text = (TextView)view.findViewById(R.id.id_text);
            name_text = (TextView)view.findViewById(R.id.name_text);
            pwd_text = (TextView) view.findViewById(R.id.pwd_text);
        }
    }

    public AdapterRecycleView(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public AdapterRecycleView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = new Person();
        person = personList.get(position);
        holder.id_text.setText(person.getId());
        holder.name_text.setText(person.getName());
        holder.pwd_text.setText(Integer.toString(person.getPwd()));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

}
