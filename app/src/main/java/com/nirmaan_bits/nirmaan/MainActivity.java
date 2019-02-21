package com.nirmaan_bits.nirmaan;

import android.content.SharedPreferences;
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
import com.nirmaan_bits.nirmaan.Service.MyFirebaseSrevice;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    private String currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();

    private FirebaseAnalytics mFirebaseAnalytics =  FirebaseAnalytics.getInstance(this);
public static final String MY_PREFS_NAME = "MyPrefsFile";

    private  DatabaseReference databaseReference1= FirebaseDatabase.getInstance().getReference().child("notification").child("gbbaas").child("members");
    private  DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference().child("notification").child("gbcb").child("members");
    private  DatabaseReference databaseReference3= FirebaseDatabase.getInstance().getReference().child("notification").child("sap").child("members");
    private  DatabaseReference databaseReference4= FirebaseDatabase.getInstance().getReference().child("notification").child("pcd").child("members");
    private  DatabaseReference databaseReference5= FirebaseDatabase.getInstance().getReference().child("notification").child("sko").child("members");
    private  DatabaseReference databaseReference6= FirebaseDatabase.getInstance().getReference().child("notification").child("utkarsh").child("members");
    private  DatabaseReference databaseReference7= FirebaseDatabase.getInstance().getReference().child("notification").child("disha").child("members");
    private  DatabaseReference databaseReference8= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati1").child("members");
    private  DatabaseReference databaseReference9= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati2").child("members");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        MyFirebaseSrevice.userProp= prefs.getInt("connect1", 0);


    databaseReference1.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "gbbaas");
                    MyFirebaseSrevice.userProp = 1;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 1);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });


    databaseReference2.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "gbcb");
                    MyFirebaseSrevice.userProp = 2;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 2);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

    databaseReference3.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "sap");

                MyFirebaseSrevice.userProp = 3;

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("connect1", 3);
                editor.apply();
            }}
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

    databaseReference4.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "pcd");
                    MyFirebaseSrevice.userProp = 4;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 4);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

    databaseReference5.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "sko");

                MyFirebaseSrevice.userProp = 5;

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("connect1", 5);
                editor.apply();
            }}
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });


    databaseReference7.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "disha");
                    MyFirebaseSrevice.userProp = 7;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 7);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

    databaseReference8.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "unnati1");

                    MyFirebaseSrevice.userProp = 8;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 8);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

    databaseReference9.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "unnati2");
                    MyFirebaseSrevice.userProp = 9;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 9);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });


    databaseReference6.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    mFirebaseAnalytics.setUserProperty("project", "utkarsh");
                    MyFirebaseSrevice.userProp = 6;

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("connect1", 6);
                    editor.apply();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });

        BottomNavigationView bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListen);


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


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, Objects.requireNonNull(aba)).commit();
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