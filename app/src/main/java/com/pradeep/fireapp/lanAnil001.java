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
import java.util.List;

public class lanAnil001 extends AppCompatActivity {
    EditText editText001;
    Button button001;
    ListView listView001;

    // array list
    private ArrayList<String> arrayList= new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lan_anil001);
        editText001= (EditText)findViewById(R.id.editText001);
        button001=(Button)findViewById(R.id.button001);
        listView001=(ListView)findViewById(R.id.listView001);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView001.setAdapter(adapter);
        //firebase database
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        button001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference=database.getReference("/Uuser/");
                reference.push().setValue(editText001.getText().toString());

                reference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String string= dataSnapshot.getValue(String.class);
                        arrayList.add(string);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        String string= dataSnapshot.getValue(String.class);
                        arrayList.remove(string);
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
