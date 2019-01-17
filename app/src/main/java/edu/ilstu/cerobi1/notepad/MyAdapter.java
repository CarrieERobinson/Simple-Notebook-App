package edu.ilstu.cerobi1.notepad;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    private ItemClickListener clickListener;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String noteTitle = dataset.get(i);
        ViewHolder vH = (ViewHolder) viewHolder;
        ((ViewHolder) viewHolder).myTextView.setText(noteTitle);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.item_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return dataset.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
