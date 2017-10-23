package com.example.suelliton.visiteeaj;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarContext;

import java.util.List;

import static com.example.suelliton.visiteeaj.FragmentRecycler.POSITION_CLICADO;


/**
 * Created by suelliton on 14/10/2017.
 */

public class FragmentInformacoes extends Fragment{
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmentinformacoes_inflate,container,false);


        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
