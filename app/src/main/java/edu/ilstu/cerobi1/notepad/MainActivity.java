package edu.ilstu.cerobi1.notepad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button saveBtn =findViewById(R.id.save_btn);
        final EditText notes = findViewById(R.id.textBox);

        pref = getApplicationContext().getSharedPreferences("Notes", 0);
        String text = pref.getString("Notes", null);
        notes.setText(text);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("Notes");
                editor.putString("Notes", notes.getText().toString());
                editor.commit();
                Toast saveToast = Toast.makeText(getApplicationContext(), "Notes saved!", Toast.LENGTH_SHORT);
                saveToast.show();
            }
        });
    }
}
