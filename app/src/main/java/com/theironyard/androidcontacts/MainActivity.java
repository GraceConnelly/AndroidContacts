package com.theironyard.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> contacts;
    ListView list;
    EditText name;
    EditText phone;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);

        //initialize items the way we initialized the other controls above
        //simple list item one is the layout list view that we are selecting
        // to have it look like. This is the most basic way to list items on the screen
        //this is like the model and view mixed together.

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        //valid on click listener
        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!name.getText().toString().equals("") && !phone.getText().toString().equals("")) {
            String item = String.format("%s %s", name.getText().toString(), phone.getText().toString());
            contacts.add(item);
            name.setText("");
            phone.setText("");
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = contacts.getItem(position);
        contacts.remove(item);
        return true;
    }
}
