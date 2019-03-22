package com.example.jakirapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] myDataset;

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TextView v=(TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtView.setText(myDataset[i]);
    }

    @Override
    public int getItemCount() {
        return myDataset.length;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtView;
        public MyViewHolder(TextView view) {
            super(view);
            txtView=view;
        }
    }

    public MyAdapter(String[] myDataset) {

        this.myDataset=myDataset;
    }
}
