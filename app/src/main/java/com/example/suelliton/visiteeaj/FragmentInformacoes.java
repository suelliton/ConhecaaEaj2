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

        //preencheInformacoes();
        return v;
    }
    public void preencheInformacoes(){

        TextView nome = (TextView) v.findViewById(R.id.tx_nome);
        TextView descricao = (TextView) v.findViewById(R.id.tx_descricao);
        TextView responsavel = (TextView) v.findViewById(R.id.tx_responsavel);
        TextView telefone = (TextView) v.findViewById(R.id.tx_telefone);
        TextView email = (TextView) v.findViewById(R.id.tx_email);
        TextView horario = (TextView) v.findViewById(R.id.tx_horario);
        ImageView imagem = (ImageView) v.findViewById(R.id.foto);

        List<Local> locais = Local.listAll(Local.class);
        Local l = locais.get(POSITION_CLICADO);

        nome.setText(l.getNome());
        descricao.setText(l.getDescricao());
        responsavel.setText(l.getResponsavel());
        telefone.setText(l.getTelefone());
        email.setText(l.getEmail());
        horario.setText(l.getHorario_funcionamento());
        Log.i("position_clicado",POSITION_CLICADO+"");
        switch(POSITION_CLICADO){
            case 0:
                imagem.setImageResource(R.drawable.informatica);
                break;
            case 1:
                imagem.setImageResource(R.drawable.diretoria);
                break;
            default:

        }



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
