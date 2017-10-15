package com.example.suelliton.visiteeaj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.suelliton.visiteeaj.LocaisAdapter.POSITION_CLICADO;

/**
 * Created by suelliton on 14/10/2017.
 */

public class FragmentInformacoes extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentinformacoes_inflate,container,false);



        return v;
    }
}
