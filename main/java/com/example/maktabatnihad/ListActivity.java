package com.example.maktabatnihad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    String[] items;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        type = getIntent().getStringExtra("type");

        if(type.equals("books")){
            items = PDFLinks.getBooksList();
        } else {
            items = PDFLinks.getNotesList();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(ListActivity.this, PdfActivity.class);
            i.putExtra("name", items[position]);
            i.putExtra("type", type);
            startActivity(i);
        });
    }
}
