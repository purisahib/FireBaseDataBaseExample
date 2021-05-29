package com.pradeep.fireapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrieve extends AppCompatActivity {

    ListView listView;

    DatabaseReference databaseReference;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        user = new User();
        listView = (ListView) findViewById(R.id.listView);
        databaseReference = FirebaseDatabase.getInstance().getReference("/User/");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info,R.id.userInfo, list);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    user = dataSnapshot1.<User>getValue(User.class);
                    assert user != null;
                    list.add(user.getName().toString()+" "+user.getPhone().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
