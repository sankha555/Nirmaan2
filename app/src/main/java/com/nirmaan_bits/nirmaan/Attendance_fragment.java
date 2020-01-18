/*
package com.nirmaan_bits.nirmaan;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


*/
/**
 * A simple {@link Fragment} subclass.
 *//*

public class Attendance_fragment extends Fragment {
    public static int project;

    public Attendance_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_attendance_fragment, container, false);
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


                                          Intent intent = new Intent(getActivity(), mark_attendance.class);

                                          project = 1;
                                          startActivity(intent);

// Commit the transaction

                                          }

                                  }


        );
        gbcb.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View v){
                                        Intent intent = new Intent(getActivity(), mark_attendance.class);

                                        project = 2;
                                        startActivity(intent);
                                    }
                                }


        );
        sap.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 3;
                                       startActivity(intent);
                                   }
                               }


        );
        pcd.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 4;
                                       startActivity(intent);
                                   }
                               }


        );
        sko.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 5;
                                       startActivity(intent);
                                   }
                               }


        );
        utk.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 6;
                                       startActivity(intent);
                                   }
                               }


        );
        disha.setOnClickListener(new View.OnClickListener(){

                                     @Override
                                     public void onClick(View v){
                                         Intent intent = new Intent(getActivity(), mark_attendance.class);

                                         project = 7;
                                         startActivity(intent);
                                     }
                                 }


        );
        un1.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 8;
                                       startActivity(intent);
                                   }
                               }


        );
        un2.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(getActivity(), mark_attendance.class);

                                       project = 9;
                                       startActivity(intent);
                                   }
                               }
        );
        return view;

    }

}
*/
