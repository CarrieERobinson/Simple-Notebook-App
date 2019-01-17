package edu.ilstu.cerobi1.notepad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemClickListener {

    MyAdapter adapter;
    ArrayList<String> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String listFile = "NotesDir";
        noteList = new ArrayList<>();
        noteList.add("Item 1");
        noteList.add("Item 2");

        //read from save file
        /*try {
            FileInputStream fileInputStream = openFileInput(listFile);
            int i;
            String temp = "";

            while((i = fileInputStream.read()) > 0) {
                if (Character.toString((char) i).equals(" ")) {
                    noteList.add(temp);
                    temp = "";
                } else {
                    temp = temp + Character.toString((char) i);

                }
            }

            fileInputStream.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }*/


        //Set up recycleview
        RecyclerView rView = findViewById(R.id.rView);

        rView.setHasFixedSize(true);

        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this);
        rView.setLayoutManager(lManager);

        adapter = new MyAdapter(this, noteList);
        adapter.setClickListener(this);
        rView.setAdapter(adapter);


    }

    //toast for debugging purposes right now, later add in intent to go to note that is clicked
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("TITLE", noteList.get(position));
        
    }
}

