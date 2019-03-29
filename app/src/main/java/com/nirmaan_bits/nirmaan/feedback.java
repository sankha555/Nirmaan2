package com.nirmaan_bits.nirmaan;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.Objects;

public class feedback extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("feedback");
    long feed_no;
    Button button;
    EditText title;
    EditText body;
    FirebaseAuth mAuth;
    String user;
    DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        button=findViewById(R.id.send_feedback);
        title=findViewById(R.id.feed_title);
        body=findViewById(R.id.feed_desc);

        mAuth=FirebaseAuth.getInstance();
        user= Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();



    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.child("number").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                feed_no=dataSnapshot.getValue(Long.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String head=title.getText().toString();
                final String desc=body.getText().toString();

                connectedRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean connected = snapshot.getValue(Boolean.class);
                        if (connected) {

                            if (head.equals("")||desc.equals(""))
                                Toast.makeText(getApplicationContext(),"Title and Description can't be empty",Toast.LENGTH_SHORT).show();

                            else {

                                databaseReference.child(String.valueOf(feed_no)).child("title").setValue(head);
                                databaseReference.child(String.valueOf(feed_no)).child("point").setValue(desc);
                                databaseReference.child(String.valueOf(feed_no)).child("id").setValue(user);
                                feed_no++;
                                databaseReference.child("number").setValue(feed_no);
                                Toast.makeText(getApplicationContext(),"Feedback Sent",Toast.LENGTH_SHORT).show();
                                title.setText("");
                                body.setText("");

                            }

                        } else {
                            Toast.makeText(getApplicationContext(),"Offline",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });


    }


}


