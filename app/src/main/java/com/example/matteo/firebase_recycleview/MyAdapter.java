package com.example.matteo.firebase_recycleview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matteo on 24/08/2015.
 */
public class MyAdapter extends FirebaseRecyclerAdapter<MyAdapter.ViewHolder, MyItem> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAge;

        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textview_name);
            textViewAge = (TextView) view.findViewById(R.id.textview_age);
        }
    }

    public MyAdapter(Query query, @Nullable ArrayList<MyItem> items,
                     @Nullable ArrayList<String> keys) {
        super(query, items, keys);
    }

    @Override public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        MyItem item = getItem(position);
        holder.textViewName.setText(item.getName());
        holder.textViewAge.setText(String.valueOf(item.getAge()));
    }

    @Override protected void itemAdded(MyItem item, String key, int position) {
        Log.d("MyAdapter", "Added a new item to the adapter.");
    }

    @Override protected void itemChanged(MyItem oldItem, MyItem newItem, String key, int position) {
        Log.d("MyAdapter", "Changed an item.");
    }

    @Override protected void itemRemoved(MyItem item, String key, int position) {
        Log.d("MyAdapter", "Removed an item from the adapter.");
    }

    @Override protected void itemMoved(MyItem item, String key, int oldPosition, int newPosition) {
        Log.d("MyAdapter", "Moved an item.");
    }
}
