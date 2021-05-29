package com.pradeep.fireapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activ extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ);
        String vegtable[] = {"patato","onian"};
        ListAdapter listAdapter= new ArrayAdapter<String>(Activ.this,android.R.layout.simple_list_item_1,vegtable);
        ListView list_view= (ListView)findViewById(R.id.list_view);
        list_view.setAdapter(listAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data= String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Activ.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
