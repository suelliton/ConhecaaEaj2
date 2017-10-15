package com.example.suelliton.visiteeaj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by suelliton on 14/10/2017.
 */

public class FragmentMapa extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentmapa_inflate,container,false);

        return v;
    }
}
