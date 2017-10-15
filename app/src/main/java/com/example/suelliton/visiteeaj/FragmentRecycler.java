package com.example.suelliton.visiteeaj;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

/**
 * Created by suelliton on 14/10/2017.
 */

public class FragmentRecycler extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmentrecycler_inflate,container,false);
        SugarContext.init(v.getContext());

        RecyclerView recyclerView =  v.findViewById(R.id.recycler);
        List<Local> locais = Local.listAll(Local.class);
        LocaisAdapter localAdapter = new LocaisAdapter(v.getContext(),locais);
        recyclerView.setAdapter(localAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);

        recyclerView.addOnItemTouchListener(new MeuRecyclerViewClickListener(recyclerView.getContext(), recyclerView, new MeuRecyclerViewClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, final int position) {


            }
        }));







        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SugarContext.terminate();
    }


}
