package com.mao.classonjune21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    TextView mytextview1;
    Button mybuttonupdate;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference userRef = mRootRef.child("condition");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytextview1 = (TextView) findViewById(R.id.textView);
        mybuttonupdate = (Button) findViewById(R.id.button);
    }
//    implementation 'com.google.firebase:firebase-database:16.0.4'
/*
1.
    Mac:
        control + o
    Windows:
        ctrl + o
2.
    write:    userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String text = dataSnapshot.getValue(String.class);
                        mytextview1.setText(text);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
3.
    write a new class:
    public void onUpdateClick(View view){
        userRef.setValue("Warm");
    }
 */

    @Override
    protected void onStart() {
        super.onStart();
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mytextview1.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void onUpdateClick(View view){
        userRef.setValue("Warm");
    }
}