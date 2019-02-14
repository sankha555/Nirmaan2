package com.nirmaan_bits.nirmaan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ProjectsFragment extends Fragment {
    public static int project;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


       /* ArrayList<String> proj = new ArrayList<>();
        proj.add("GB Baas");
        proj.add("GB CB");
        proj.add("Unnati 1");
        proj.add("Unnati 2");
        proj.add("SAP");
        proj.add("SKO");
        proj.add("Utkarsh");
        proj.add("PCD");
        proj.add("Disha");
       */


        View view= inflater.inflate(R.layout.fragment_projects, container, false);


 TextView gbbaas =view.findViewById(R.id.gbbs);
        TextView gbcb =view.findViewById(R.id.gbcb);
        TextView sap =view.findViewById(R.id.sap);
        TextView pcd =view.findViewById(R.id.pcd);
        TextView sko =view.findViewById(R.id.sko);
        TextView utk = view.findViewById(R.id.utkarsh);
        TextView disha =view.findViewById(R.id.disha);
        TextView un1 =view.findViewById(R.id.un1);
        TextView un2 =view.findViewById(R.id.un2);

 gbbaas.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v){
        Intent in= new Intent(getActivity(),utkarsh.class);
        project =1;

    startActivity(in);}

                       }


);
        gbcb.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =2;

                                       startActivity(in);}
                               }


        );
        sap.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =3;

                                       startActivity(in);}
                               }


        );
        pcd.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =4;

                                       startActivity(in);}
                               }


        );
        sko.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =5;

                                       startActivity(in);}
                               }


        );
        utk.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =6;

                                       startActivity(in);}
                               }


        );
        disha.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =7;

                                       startActivity(in);}
                               }


        );
        un1.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =8;

                                       startActivity(in);}
                               }


        );
        un2.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent in= new Intent(getActivity(),utkarsh.class);
                                       project =9;

                                       startActivity(in);}
                               }


        );
return view;
    }



}


