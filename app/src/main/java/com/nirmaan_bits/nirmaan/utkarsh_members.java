package com.nirmaan_bits.nirmaan;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class utkarsh_members extends AppCompatActivity {

    private RecyclerView recyclerView;

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utkarsh_activity_members);

switch (ProjectsFragment.project){

    case 1:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("gbbaas").child("members");
        break;
    case 2:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("gbcb").child("members");
        break;
    case 3:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("sap").child("members");
        break;
    case 4:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("pcd").child("members");
        break;
    case 5:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("sko").child("members");
        break;
    case 6:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("utkarsh").child("members");
        break;
    case 7:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("disha").child("members");
        break;
    case 8:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("unnati1").child("members");
        break;
    case 9:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("unnati2").child("members");
        break;
    case 10:
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Projects").child("youth").child("members");
        break;
}



        recyclerView = findViewById(R.id.member_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Contact> options= new FirebaseRecyclerOptions.Builder<Contact>()
                .setQuery(databaseReference,Contact.class)
                .build();

        FirebaseRecyclerAdapter<Contact,ContactViewHolder> adapter=
                new FirebaseRecyclerAdapter<Contact,ContactViewHolder>(options) {


                    @Override
                    protected void onBindViewHolder(@NonNull final ContactViewHolder holder, int position, @NonNull Contact model) {
                        String musersId = getRef(position).getKey();

                        databaseReference.child(musersId).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                int visits =0;
                                if (dataSnapshot.child("history").getValue() != null){
                                    for (DataSnapshot snapshot1 : dataSnapshot.child("history").getChildren()) {
                                        if (snapshot1.child("status").getValue().equals("Present")){
                                            visits++;

                                        }
                                    }
                                }

                                holder.visits.setText("" + visits);

                                if (dataSnapshot.hasChild("pl")) {

                                    String mName = dataSnapshot.child("name").getValue().toString();
                                    final String mNumb = dataSnapshot.child("num").getValue().toString();
                                    String mYear = dataSnapshot.child("year").getValue().toString();

                                    holder.name.setText(mName);
                                    holder.year.setText(mYear);
                                    holder.contact.setText(mNumb);
                                    holder.pl.setText("PL");

                                     holder.call.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            String no="tel:"+mNumb;

                                            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(no));
                                            startActivity(intent);
                                        }
                                    });


                                }

                                else {

                                    String mName = dataSnapshot.child("name").getValue().toString();
                                    final String mNumb = dataSnapshot.child("num").getValue().toString();
                                    String mYear = dataSnapshot.child("year").getValue().toString();



                                    holder.name.setText(mName);
                                    holder.year.setText(mYear);
                                    holder.contact.setText(mNumb);
                                    holder.pl.setText("");
                                    holder.call.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            String no="tel:"+mNumb;

                                            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(no));
                                            startActivity(intent);
                                        }
                                    });


                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }



                    @NonNull
                    @Override
                    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
                        return new ContactViewHolder(view);
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name,contact,year,pl,visits ;
        ImageView call;


       public ContactViewHolder(@NonNull View itemView)
        {
            super(itemView);
            visits = itemView.findViewById(R.id.visits_total);

            name = itemView.findViewById(R.id.member_name);
            contact= itemView.findViewById(R.id.member_numb);
            year= itemView.findViewById(R.id.member_year);
            pl= itemView.findViewById(R.id.member_pl);
            call=itemView.findViewById(R.id.call);

        }

    }

}
