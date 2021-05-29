package com.pradeep.fireapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

private TextView mConditionText;
private Button b1,b2,listViewButton,lanButton;
Button online_image_opener;
DatabaseReference mRootRef=FirebaseDatabase.getInstance().getReference();
DatabaseReference mconditionRef=mRootRef.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mConditionText=findViewById(R.id.value);
         b1 = (Button)findViewById(R.id.rain);
         b2 = (Button)findViewById(R.id.fog);
         online_image_opener = (Button)findViewById(R.id.online_image_open);
         online_image_opener.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, Online_Image_Opener.class);
                 startActivity(intent);
             }
         });
         listViewButton = (Button)findViewById(R.id.listViewButton);
         listViewButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                 startActivity(intent);
             }
         });
        lanButton = (Button)findViewById(R.id.buttonLan);
        lanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lanAnil001.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mconditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mConditionText.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mconditionRef.setValue("Rain");
                Intent intentStartActivity=new Intent(MainActivity.this, Retrieve.class);
                startActivity(intentStartActivity);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mconditionRef.setValue("Foggy");
                Intent intentStartActivity=new Intent(MainActivity.this, Activ.class);
                startActivity(intentStartActivity);

            }
        });
    }
}
