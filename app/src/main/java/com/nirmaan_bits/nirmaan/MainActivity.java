package com.nirmaan_bits.nirmaan;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {


    private String currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();

    private FirebaseAnalytics mFirebaseAnalytics =  FirebaseAnalytics.getInstance(this);


    private  DatabaseReference databaseReference1= FirebaseDatabase.getInstance().getReference().child("notification").child("gbbaas");
    private  DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference().child("notification").child("gbcb");
    private  DatabaseReference databaseReference3= FirebaseDatabase.getInstance().getReference().child("notification").child("sap");
    private  DatabaseReference databaseReference4= FirebaseDatabase.getInstance().getReference().child("notification").child("pcd");
    private  DatabaseReference databaseReference5= FirebaseDatabase.getInstance().getReference().child("notification").child("sko");
    private  DatabaseReference databaseReference6 = FirebaseDatabase.getInstance().getReference().child("notification").child("utkarsh");

    private  DatabaseReference databaseReference7= FirebaseDatabase.getInstance().getReference().child("notification").child("disha");
    private  DatabaseReference databaseReference8= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati1");
    private  DatabaseReference databaseReference9= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListen);






       databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","gbbaas");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","gbcb");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        databaseReference3.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","sap");                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        databaseReference4.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","pcd");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        databaseReference5.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","sko");                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        databaseReference7.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","disha");                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        databaseReference8.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","unnati1");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        databaseReference9.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","unnati2");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        databaseReference6.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if(Objects.equals(snapshot.child("id").getValue(), currentuser))

                        mFirebaseAnalytics.setUserProperty("project","utkarsh");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new GalleryFragment()).commit();



    }

private BottomNavigationView.OnNavigationItemSelectedListener navListen=new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        android.support.v4.app.Fragment aba=null;
  switch (item.getItemId()){
      case R.id.home:
          aba =  new GalleryFragment();
          break;

      case R.id.project:
           aba =  new ProjectsFragment();
          break;
      case R.id.gallery:
           aba =  new HomeFragment();
          break;
      case R.id.contact:
           aba =  new ContactFragment();
          break;

  }


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,aba).commit();
    return true;
    }

};
    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);
    }
}

/*
    <string name="default_web_client_id" translatable="false">767599280120-rf9ranprhbrhp41oeej8430j6ti79pji.apps.googleusercontent.com</string>
    <string name="firebase_database_url" translatable="false">https://nirmaan-1c862.firebaseio.com</string>
    <string name="google_api_key" translatable="false">AIzaSyBJ0M6TKt57Y5cepoYt-wWR1lsxdDoWkKs</string>
    <string name="google_app_id" translatable="false">1:767599280120:android:95be88874eb1b672</string>
    <string name="google_storage_bucket" translatable="false">nirmaan-1c862.appspot.com</string>
    <string name="project_id" translatable="false">nirmaan-1c86</string>


*/