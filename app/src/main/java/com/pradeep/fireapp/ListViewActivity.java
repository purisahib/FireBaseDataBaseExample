package com.pradeep.fireapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    // fire base var
    private DatabaseReference mDatabase;


    // Android layout
    private Button btnAdd;
    private EditText etText;
    private ListView listView;

    // array list
    private ArrayList<String> arrayList= new ArrayList<>();
    private ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mDatabase = FirebaseDatabase.getInstance().getReference("/");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        btnAdd = (Button) findViewById(R.id.buttonList);
        etText = (EditText) findViewById(R.id.editTextlist);
        listView = (ListView) findViewById(R.id.listViewSee);

        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.push().setValue(etText.getText().toString());
                mDatabase.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String text = dataSnapshot.getValue(String.class);
                        arrayList.add(text);

                        // String s1= dataSnapshot.getValue(String.class);
                        //arrayList.add(s1);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        String s1 = dataSnapshot.getValue(String.class);
                        arrayList.remove(s1);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}
