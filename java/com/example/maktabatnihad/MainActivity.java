package com.example.maktabatnihad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button booksBtn, notesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksBtn = findViewById(R.id.btnBooks);
        notesBtn = findViewById(R.id.btnNotes);

        booksBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ListActivity.class);
            i.putExtra("type", "books");
            startActivity(i);
        });

        notesBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ListActivity.class);
            i.putExtra("type", "notes");
            startActivity(i);
        });
    }
}
