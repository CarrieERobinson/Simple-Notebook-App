package edu.ilstu.cerobi1.notepad;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        final String saveFile = "note";
        final Button saveBtn =findViewById(R.id.save_btn);
        final EditText notes = findViewById(R.id.textBox);

        //Get the name of the note chosen using intent n stuff, then store in a var
        //Change toolbar title to name of note

        

        //read from save file
        try {
            FileInputStream fileInputStream = openFileInput(saveFile);
            int i;
            String text = "";

            while((i = fileInputStream.read()) > 0)
            {
                text = text + Character.toString((char) i);
            }

            fileInputStream.close();
            notes.setText(text);
        }catch (Exception e)
        {
            e.printStackTrace();
        }



        //Write to save file
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    public void saveNote(String noteName)
    {

        //get edit text box
        EditText notes = findViewById(R.id.textBox);

        try{
            FileOutputStream fileOutputStream = openFileOutput(noteName, Context.MODE_PRIVATE);
            fileOutputStream.write(notes.getText().toString().getBytes());
            fileOutputStream.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        Toast saveToast = Toast.makeText(getApplicationContext(), "Notes saved!", Toast.LENGTH_SHORT);
        saveToast.show();
    }
}
