package com.nirmaan_bits.nirmaan;

import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nirmaan_bits.nirmaan.Service.MyFirebaseSrevice;

import java.util.Objects;

import static com.nirmaan_bits.nirmaan.GalleryFragment.if_pl;
import static com.nirmaan_bits.nirmaan.GalleryFragment.visibility;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    private String currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
    private String currentuserName = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();


    private FirebaseAnalytics mFirebaseAnalytics =  FirebaseAnalytics.getInstance(this);
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private DatabaseReference databaseReference;
    private DatabaseReference mDbr;

    private  DatabaseReference databaseReference1= FirebaseDatabase.getInstance().getReference().child("notification").child("gbbaas").child("members");
    private  DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference().child("notification").child("gbcb").child("members");
    private  DatabaseReference databaseReference3= FirebaseDatabase.getInstance().getReference().child("notification").child("sap").child("members");
    private  DatabaseReference databaseReference4= FirebaseDatabase.getInstance().getReference().child("notification").child("pcd").child("members");
    private  DatabaseReference databaseReference5= FirebaseDatabase.getInstance().getReference().child("notification").child("sko").child("members");
    private  DatabaseReference databaseReference6= FirebaseDatabase.getInstance().getReference().child("notification").child("utkarsh").child("members");
    private  DatabaseReference databaseReference7= FirebaseDatabase.getInstance().getReference().child("notification").child("disha").child("members");
    private  DatabaseReference databaseReference8= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati1").child("members");
    private  DatabaseReference databaseReference9= FirebaseDatabase.getInstance().getReference().child("notification").child("unnati2").child("members");
    private  DatabaseReference databaseReference10= FirebaseDatabase.getInstance().getReference().child("notification").child("youth").child("members");

    BottomNavigationView bottomNav;
    public static ViewPager viewPager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       bottomNav =findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListen);








        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        MyFirebaseSrevice.userProp= prefs.getInt("connect1", 0);


    databaseReference1.addValueEventListener(new ValueEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                    visibility();

                    mFirebaseAnalytics.setUserProperty("project", "gbbaas");
                    MyFirebaseSrevice.userProp = 1;
                    GalleryFragment.findIfPl();



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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "gbcb");
                    MyFirebaseSrevice.userProp = 2;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "sap");

                MyFirebaseSrevice.userProp = 3;
                    GalleryFragment.findIfPl();


                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt("connect1", 3);
                editor.apply();
            }
            }
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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "pcd");
                    MyFirebaseSrevice.userProp = 4;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "sko");

                MyFirebaseSrevice.userProp = 5;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "disha");
                    MyFirebaseSrevice.userProp = 7;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "unnati1");

                    MyFirebaseSrevice.userProp = 8;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "unnati2");
                    MyFirebaseSrevice.userProp = 9;
                    GalleryFragment.findIfPl();


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
                    visibility();
                    mFirebaseAnalytics.setUserProperty("project", "utkarsh");
                    MyFirebaseSrevice.userProp = 6;
                    GalleryFragment.findIfPl();


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
        databaseReference10.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (Objects.equals(Objects.requireNonNull(snapshot.child("id").getValue()).toString(), currentuser)) {
                        visibility();
                        mFirebaseAnalytics.setUserProperty("project", "youth");
                        MyFirebaseSrevice.userProp = 10;
                        GalleryFragment.findIfPl();


                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putInt("connect1", 10);
                        editor.apply();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        viewPager = findViewById(R.id.pager); //Init Viewpager
        setupFm(getSupportFragmentManager(), viewPager); //Setup Fragment
        viewPager.setCurrentItem(0); //Set Currrent Item When Activity Start
        viewPager.addOnPageChangeListener(new PageChange()); //Listeners For Viewpager When Page Changed

     //   getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new GalleryFragment()).commit();



    }
    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager){
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new GalleryFragment(), "Home");
        Adapter.add(new ProjectsFragment(), "Projects");
        Adapter.add(new HomeFragment(), "Gallery");

        Adapter.add(new Mark_attendance_fragment(), "Mark Attendance");

        viewPager.setAdapter(Adapter);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListen=new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       // Fragment aba=null;
  switch (item.getItemId()){
      case R.id.home:
          viewPager.setCurrentItem(0);

          break;

      case R.id.project:
          viewPager.setCurrentItem(1);
          break;
      case R.id.gallery:
          viewPager.setCurrentItem(2);
          break;

      case R.id.attendance:
        viewPager.setCurrentItem(3);
          break;

  }


        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment, Objects.requireNonNull(aba)).commit();
    return true;
    }

};
    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);
    }
    public class PageChange implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    bottomNav.setSelectedItemId(R.id.home);
                    break;
                case 1:
                    bottomNav.setSelectedItemId(R.id.project);
                    break;
                case 2:
                    bottomNav.setSelectedItemId(R.id.gallery);
                    break;
                case 3:
                    bottomNav.setSelectedItemId(R.id.attendance);
                    break;

            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
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