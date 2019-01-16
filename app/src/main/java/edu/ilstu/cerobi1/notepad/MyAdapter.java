package edu.ilstu.cerobi1.notepad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    //the dataset will be an arraylist of strings that each represent one on the user's notes
    private ArrayList<String> dataset;
    public MyAdapter(ArrayList<String> dataset)
    {
        this.dataset = dataset;
    }

    //Layout inflater: not sure what it does, but I guess I need it
    private LayoutInflater layoutInflater;

    //Constructor: takes in context and the list of notes the user has saved
    public MyAdapter(Context c, ArrayList<String> dataset)
    {
        this.dataset = dataset;
        this.layoutInflater = LayoutInflater.from(c);
    }

    
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.r_view_row, viewGroup, false);
        return new RecyclerView.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
