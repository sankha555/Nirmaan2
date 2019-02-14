package com.nirmaan_bits.nirmaan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private View homeView;
LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = homeView.findViewById(R.id.recycle);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        databaseReference =FirebaseDatabase.getInstance().getReference().child("Global");
        databaseReference.keepSynced(true);

        return homeView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Blog> options= new FirebaseRecyclerOptions.Builder<Blog>()
                .setQuery(databaseReference,Blog.class)
                .build();

        FirebaseRecyclerAdapter<Blog,BlogViewHolder> adapter=
                new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull final BlogViewHolder holder, int position, @NonNull Blog model) {

                        String musersId = getRef(position).getKey();

                        assert musersId != null;
                        databaseReference.child(musersId).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.hasChild("image")) {

                                    final String profImage = dataSnapshot.child("image").getValue().toString();
                                    String profTitle = dataSnapshot.child("title").getValue().toString();
                                    final String profDesc = dataSnapshot.child("desc").getValue().toString();

                                    holder.title.setText(profTitle);
                                    Picasso.with(getContext()).load(profImage).into(holder.imageic);

                                    holder.imageic.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            Intent intent = new Intent(getContext(),recyclable.class);
                                            intent.putExtra("desc",profDesc);
                                            intent.putExtra("image_url",profImage);
                                            startActivity(intent);
                                        }
                                    });

                                }

                                else {

                                    String profTitle = dataSnapshot.child("title").getValue().toString();
                                    final String profDesc = dataSnapshot.child("desc").getValue().toString();

                                    holder.title.setText(profTitle);
                                    Picasso.with(getContext()).load(R.drawable.logo).into(holder.imageic);
holder.imageic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getContext(),recyclable.class);
        intent.putExtra("desc",profDesc);
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
                    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_main,viewGroup,false);
                        return new BlogViewHolder(view);
                        }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();


    }


    public static class BlogViewHolder extends RecyclerView.ViewHolder{

TextView title ,desc ;
ImageView imageic;


public BlogViewHolder(@NonNull View itemView)
{
    super(itemView);

    title = itemView.findViewById(R.id.card_title);
    imageic= itemView.findViewById(R.id.card_image);
    desc=itemView.findViewById(R.id.recycle_text);


}

    }

}
    /*

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        this.v = view;
        init();

        progressDialog= new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Syncing");
        progressDialog.setCancelable(false);
        progressDialog.show();
        loaddata();

    }

    private void loaddata() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Global");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataset.clear();
                mDataKey.clear();
for (DataSnapshot single:dataSnapshot.getChildren()){
    dataset.add(single.getValue(Blog.class));
    mDataKey.add(single.getKey().toString());
}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void init() {
        recyclerView= v.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



    }
}


   /* @Override
    public void onStart() {

        super.onStart();

        FirebaseRecyclerOptions<Blog> options =
                new FirebaseRecyclerOptions.Builder<Blog>()
                        .setQuery(databaseReference, Blog.class)
                        .build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Blog, RecyclerViewHolder >(options) {
            @Override
            protected void onBindViewHolder(@NonNull BlogViewHolder holder, int position, @NonNull Blog model) {
holder.setTitle(model);
            }

            @Override
            public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_main, parent, false);

                return new BlogViewHolder(view);
            }


            FirebaseRecyclerAdapter<Blog,BlogViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class,R.layout.card_main,BlogViewHolder.class,databaseReference) {
            @Override
            protected void onBindViewHolder(@NonNull BlogViewHolder holder, int position, @NonNull Blog model) {

            }

            @NonNull
            @Override
            public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return null;
            }
        };


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    databaseReference= FirebaseDatabase.getInstance().getReference().child("Global");
    databaseReference.keepSynced(true);



    recyclerView =getView().findViewById(R.id.recycle);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



    }
}

<ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/background"
        android:scaleType="centerCrop"/>

*/