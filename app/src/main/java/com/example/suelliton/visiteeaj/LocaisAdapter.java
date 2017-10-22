package com.example.suelliton.visiteeaj;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suelliton on 14/10/2017.
 */

public class LocaisAdapter extends RecyclerView.Adapter {
    Context context;



    static LocalViewHolder ultimoItem ;



    private List<Local> listaLocais = new ArrayList<>();

    public LocaisAdapter(Context c,List<Local> locais){
        this.context = c;
        this.listaLocais = locais;


    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.local_inflate,parent,false);
        LocalViewHolder holder = new LocalViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final LocalViewHolder localHolder = (LocalViewHolder) holder;
        localHolder.textView_nome.setText(listaLocais.get(position).getNome());


            localHolder.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //POSITION_CLICADO = localHolder.getAdapterPosition();
                    if(ultimoItem == null) {

                        localHolder.row.setBackgroundColor(Color.parseColor("#00FF00"));
                    }else{
                        ultimoItem.row.setBackgroundColor(Color.parseColor("#ffffff"));
                        localHolder.row.setBackgroundColor(Color.parseColor("#00FF00"));
                    }

                    ultimoItem = localHolder;
                }
            });


    }

    @Override
    public int getItemCount() {
        return listaLocais.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class LocalViewHolder extends RecyclerView.ViewHolder{
        final TextView textView_nome ;
        final LinearLayout row;
        public LocalViewHolder(View v){
            super(v);
            textView_nome = v.findViewById(R.id.tx_nome);
            row = v.findViewById(R.id.row);
        }
    }

}
