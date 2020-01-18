package com.nirmaan_bits.nirmaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ContactFragment extends Fragment {


    private RecyclerView recyclerView;

    private DatabaseReference databaseReference;
    private View homeView;


    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Contact> options= new FirebaseRecyclerOptions.Builder<Contact>()
                .setQuery(databaseReference,Contact.class)
                .build();

        FirebaseRecyclerAdapter<Contact,ContactViewHolder> adapter=
                new FirebaseRecyclerAdapter<Contact,ContactViewHolder>(options) {


                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    protected void onBindViewHolder(@NonNull final ContactViewHolder holder, int position, @NonNull Contact model) {




                        String musersId = getRef(position).getKey();

                        databaseReference.child(Objects.requireNonNull(musersId)).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {





                                    String mName = Objects.requireNonNull(dataSnapshot.child("name").getValue()).toString();
                                    final String mNumb = Objects.requireNonNull(dataSnapshot.child("num").getValue()).toString();
                                    String mYear = Objects.requireNonNull(dataSnapshot.child("position").getValue()).toString();
                                    final String mMail = Objects.requireNonNull(dataSnapshot.child("mail").getValue()).toString();

                                    holder.name.setText(mName);
                                    holder.pl.setText(mYear);
                                    holder.contact.setText(mNumb);
                                    holder.mail.setText(mMail);


                                holder.call.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String no="tel:"+mNumb;

                                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(no));
                                        startActivity(intent);
                                    }
                                });

                                holder.send_mail.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                                        intent.setData(Uri.parse("mailto:"));
                                        intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{mMail});


                                        if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
                                            startActivity(intent);}
                                    }
                                });
                                }


                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }



                    @NonNull
                    @Override
                    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_card,viewGroup,false);
                        return new ContactViewHolder(view);
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name,contact,mail,pl ;
        ImageView call,send_mail;



        ContactViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.contacts_member_name);
            contact= itemView.findViewById(R.id.contacts_member_numb);
            mail= itemView.findViewById(R.id.contacts_member_mail);
            pl= itemView.findViewById(R.id.contacts_member_post);
            call=itemView.findViewById(R.id.contacts_call);
            send_mail=itemView.findViewById(R.id.contacts_mail);

        }

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeView = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = homeView.findViewById(R.id.contact_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        databaseReference = FirebaseDatabase.getInstance().getReference().child("contact");
        databaseReference.keepSynced(true);

        Button feed=homeView.findViewById(R.id.feedback);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),feedback.class);
                startActivity(intent);
            }
        });
        return homeView;

    }




}
