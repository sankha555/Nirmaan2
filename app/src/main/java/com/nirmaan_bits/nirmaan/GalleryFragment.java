package com.nirmaan_bits.nirmaan;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nirmaan_bits.nirmaan.Service.MyFirebaseSrevice;

public class GalleryFragment extends Fragment {

    private DatabaseReference databaseReference,databaseReference2;
    TextView load,tab;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View homeview = inflater.inflate(R.layout.fragment_gallery, container, false);

        databaseReference2=FirebaseDatabase.getInstance().getReference().child("home");
        switch (MyFirebaseSrevice.userProp){

            case 1:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("gbbaas").child("notification");
                break;
            case 2:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("gbcb").child("notification");
                break;
            case 3:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("sap").child("notification");
                break;
            case 4:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("pcd").child("notification");
                break;
            case 5:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("sko").child("notification");
                break;
            case 6:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("utkarsh").child("notification");
                break;
            case 7:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("disha").child("notification");
                break;
            case 8:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("unnati1").child("notification");
                break;
            case 9:
                databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("unnati2").child("notification");
                break;
                default:break;
        }

        load= homeview.findViewById(R.id.homeinfo);
        tab= homeview.findViewById(R.id.notificaton_tab);

        return homeview;




    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public void onStart() {

        super.onStart();



if(MyFirebaseSrevice.userProp!=0) {
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String data = dataSnapshot.getValue(String.class);
            tab.setText(data);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}

         databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String note= dataSnapshot.child("info").getValue(String.class);
                load.setText(note);
    }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

    }
        });

    }
}
