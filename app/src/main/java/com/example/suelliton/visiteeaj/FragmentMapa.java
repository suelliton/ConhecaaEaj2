package com.example.suelliton.visiteeaj;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.example.suelliton.visiteeaj.FragmentRecycler.POSITION_CLICADO;


/**
 * Created by suelliton on 14/10/2017.
 */

public class FragmentMapa extends Fragment implements OnMapReadyCallback {
    View v;
    GoogleMap mGoogleMap;
    MapView mapView;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmentmapa_inflate,container,false);


        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) v.findViewById(R.id.map);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        List<Local> listaLocais = Local.listAll(Local.class);
        Local local = listaLocais.get(POSITION_CLICADO);

        double lat = local.getLatitude();
        double lng = local.getLongitude();

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Liberdade").snippet("hmm"));

        CameraPosition liberty = CameraPosition.builder().target(new LatLng(lat,lng)).zoom(19).bearing(0).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));
    }
}
