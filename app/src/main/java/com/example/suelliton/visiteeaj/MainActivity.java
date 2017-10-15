package com.example.suelliton.visiteeaj;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;


import static com.example.suelliton.visiteeaj.LocaisAdapter.POSITION_CLICADO;
import static com.example.suelliton.visiteeaj.LocaisAdapter.ultimoItem;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        preencheBanco();

        tabLayout = (TabLayout) findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new FixedTabsPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(android.R.drawable.presence_online);
                        tabLayout.getTabAt(1).setIcon(android.R.drawable.star_off);
                        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_map);
                        Log.i("TESTE",""+position);
                        preencheRecycler();
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(android.R.drawable.presence_offline);
                        tabLayout.getTabAt(1).setIcon(android.R.drawable.star_on);
                        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_map);
                        Log.i("TESTE",""+position);
                        preencheInformacoes();
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(android.R.drawable.presence_offline);
                        tabLayout.getTabAt(1).setIcon(android.R.drawable.star_off);
                        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_map);
                        Log.i("TESTE",""+position);
                        break;
                    default:
                        return;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });







    }
    public void preencheRecycler(){

    }
    public void preencheInformacoes(){

        TextView nome = (TextView) findViewById(R.id.tx_nome);
        TextView descricao = (TextView) findViewById(R.id.tx_descricao);
        TextView responsavel = (TextView) findViewById(R.id.tx_responsavel);
        TextView telefone = (TextView) findViewById(R.id.tx_telefone);
        TextView email = (TextView) findViewById(R.id.tx_email);
        TextView horario = (TextView) findViewById(R.id.tx_horario);
        ImageView imagem = (ImageView) findViewById(R.id.foto);


        List<Local> locais = Local.listAll(Local.class);
        Local l = locais.get(POSITION_CLICADO);

        nome.setText(l.getNome());
        descricao.setText(l.getDescricao());
        responsavel.setText(l.getResponsavel());
        telefone.setText(l.getTelefone());
        email.setText(l.getEmail());
        horario.setText(l.getHorario_funcionamento());
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

    public void preencheBanco(){
        Local.deleteAll(Local.class);
        new Local("Informática"," Esse é o setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        new Local("Direçao","Esse é a direção geral da Escola Agrícola de Jundiaí","Julio Cesar","DirecaoGeralEaj@eaj.edu.br","84 99923-5362","7:30 as 17:15").save();
        new Local("Biblioteca","Essa é a biblioteca setorial Rodolfo Helinski","Rodolfo Helinski","BibliotecaSetorialRH@eaj.edu.br","84 98827-3625","7:00 as 17:30").save();
        new Local("Agroindústria","Esse é o setor de agroindútria","Eronilson","SetorAgroindústria@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        new Local("CVT"," Esse é o Centro Vocacional Tecnológico","André Stwart","cvteajeaj.edu.br","84 99653-5872","7:15 as 17:00").save();
        new Local("Informática"," Esse é o setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        new Local("Informática"," Esse é o setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        new Local("Informática"," Esse é o setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        new Local("Informática"," Esse é o setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00").save();
        List<Local> locais = Local.listAll(Local.class);
        Log.i("susu", String.valueOf(locais.size()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
