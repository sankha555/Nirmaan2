package com.nirmaan_bits.nirmaan;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nirmaan_bits.nirmaan.Service.MyFirebaseSrevice;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class GalleryFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    private DatabaseReference databaseReference;
    public static DatabaseReference mDbr;

    private DatabaseReference dbr = FirebaseDatabase.getInstance().getReference().child("notification");
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

    static TextView project;
    static TextView project1;
    private String currentuser = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
    private TextView name;
   public static TextView visits_tv;
    private static TextView pl;
    private static String currentuserName = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
    public static int if_pl =0;





    notf_member member = new notf_member(currentuser);
    private GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    Button logout;
    static Button select_project;
    FirebaseAuth.AuthStateListener mAuthListener;




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View homeview = inflater.inflate(R.layout.fragment_gallery, container, false);
        project = homeview.findViewById(R.id.project_1);

        project1 = homeview.findViewById(R.id.project_name);
        select_project = homeview.findViewById(R.id.select_project);
        name = homeview.findViewById(R.id.name);
        name.setText(currentuserName.toUpperCase());
        pl = homeview.findViewById(R.id.pl);
        visits_tv = homeview.findViewById(R.id.visits);


        if(MyFirebaseSrevice.userProp != 0){
            select_project.setVisibility(View.GONE);
            project.setVisibility(View.VISIBLE);
            project1.setVisibility(View.VISIBLE);

        }
        select_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getActivity(), view);
                popup.setOnMenuItemClickListener(GalleryFragment.this);
                popup.inflate(R.menu.select_project_menu);
                popup.show();
            }
        });


        databaseReference2=FirebaseDatabase.getInstance().getReference().child("home");


        Button feed=homeview.findViewById(R.id.feedback);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),feedback.class);
                startActivity(intent);
            }
        });
        Button contact=homeview.findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),contact_activity.class);
                startActivity(intent);
            }
        });
        Button about=homeview.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),About.class);
                startActivity(intent);
            }
        });


        return homeview;




    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public void onStart() {

        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);





     dbr.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             if(MyFirebaseSrevice.userProp!=0)

             {switch (MyFirebaseSrevice.userProp){

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
                 case 10:
                     databaseReference = FirebaseDatabase.getInstance().getReference().child("notification").child("youth").child("notification");
                     break;
                 default:break;
             }
                 databaseReference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     String data = dataSnapshot.getValue(String.class);
                     project1.setText(data);
                     findIfPl();

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError databaseError) {

                 }
             });
             }

         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });




    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.gb_bass:
                databaseReference1.push().setValue(member);
                return true;
            case R.id.gb_cb:
                databaseReference2.push().setValue(member);
                return true;
            case R.id.sap:
                databaseReference3.push().setValue(member);
                return true;
            case R.id.pcd:
                databaseReference4.push().setValue(member);
                return true;
            case R.id.sko:
                databaseReference5.push().setValue(member);
                return true;
            case R.id.utkarsh:
                databaseReference6.push().setValue(member);
                return true;
            case R.id.disha:
                databaseReference7.push().setValue(member);
                return true;
            case R.id.unnati_1:
                databaseReference8.push().setValue(member);
            case R.id.unnati_2:
                databaseReference9.push().setValue(member);
                return true;
            case R.id.youth:
                databaseReference10.push().setValue(member);
                return true;
            default:
                return false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logout= Objects.requireNonNull(getView()).findViewById(R.id.signout);
        mAuth=FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("767599280120-rf9ranprhbrhp41oeej8430j6ti79pji.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(Objects.requireNonNull(getActivity()), gso);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                mGoogleSignInClient.signOut();

            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null) {
                    Intent intent=new Intent(getActivity(),SignIn.class);
                    startActivity(intent);
                }
            }
        };


    }
    public static void visibility(){
        project.setVisibility(View.VISIBLE);
        project1.setVisibility(View.VISIBLE);

        select_project.setVisibility(View.GONE);


    }
    public static void findIfPl(){
        switch (MyFirebaseSrevice.userProp){

            case 1:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("gbbaas").child("members");
                break;
            case 2:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("gbcb").child("members");
                break;
            case 3:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("sap").child("members");
                break;
            case 4:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("pcd").child("members");
                break;
            case 5:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("sko").child("members");
                break;
            case 6:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("utkarsh").child("members");
                break;
            case 7:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("disha").child("members");
                break;
            case 8:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("unnati1").child("members");
                break;
            case 9:
                mDbr = FirebaseDatabase.getInstance().getReference().child("Projects").child("unnati2").child("members");
                break;
        }
        mDbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if( snapshot.child("name").getValue().toString().toLowerCase().replaceAll("\\s+","").equals(currentuserName.toLowerCase().replaceAll("\\s+",""))) {
                        if (snapshot.child("pl").getValue() != null) {
                            pl.setText("PL");
                            if_pl = 1;

                        }
                        int visits =0;
                        if (snapshot.child("history").getValue() != null){
                            for (DataSnapshot snapshot1 : snapshot.child("history").getChildren()) {
                                if (snapshot1.child("status").getValue().equals("Present")){
                                    visits++;

                                }
                            }
                    }

                        visits_tv.setText("VISITS : " + visits);

                        break;


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
