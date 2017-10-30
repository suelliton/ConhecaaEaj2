package com.example.suelliton.visiteeaj;

import android.Manifest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import static com.example.suelliton.visiteeaj.FragmentRecycler.POSITION_CLICADO;
import static com.example.suelliton.visiteeaj.LocaisAdapter.ultimoItem;

public class MainActivity extends AppCompatActivity {

    public static TabLayout tabLayout ;
    final String[] permissoes = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
    };



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

                        preencheRecycler();

                        break;
                    case 1:

                        preencheInformacoes();
                        break;
                    case 2:

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
        Log.i("position_clicado",POSITION_CLICADO+"");
        switch(POSITION_CLICADO){
            case 0:
                imagem.setImageResource(R.drawable.informatica);
                break;
            case 1:
                imagem.setImageResource(R.drawable.diretoria);
                break;
            case 2:
                imagem.setImageResource(R.drawable.biblioteca);
                break;
            case 3:
                imagem.setImageResource(R.drawable.agroindustria);
                break;
            case 4:
                imagem.setImageResource(R.drawable.cvt);
                break;
            case 5:
                imagem.setImageResource(R.drawable.aquicultura);
                break;
            case 6:
                imagem.setImageResource(R.drawable.ensinomedio);
                break;
            default:
        }
    }

    public void preencheRecycler(){

    }


    public void preencheBanco(){
        Local.deleteAll(Local.class);
        new Local("Informática"," Setor de Informática","Leonardo Rodrigues","SetorInformática@eaj.edu.br","84 99123-5432","7:15 as 17:00",-5.885786,-35.365748).save();
        new Local("Direçao","Direção geral da Escola Agrícola de Jundiaí","Julio Cesar","DirecaoGeralEaj@eaj.edu.br","84 99923-5362","7:30 as 17:15",-5.88636, -35.362098).save();
        new Local("Biblioteca","Biblioteca setorial Rodolfo Helinski","Rodolfo Helinski","BibliotecaSetorialRH@eaj.edu.br","84 98827-3625","7:00 as 17:30",-5.885954,-35.366073).save();
        new Local("Agroindústria","Agroindútria, construção e manipulação de alimentos ","Eronilson","SetorAgroindústria@eaj.edu.br","84 99123-5432","7:15 as 17:00",-5.885074,-35.366160).save();
        new Local("CVT"," Centro Vocacional Tecnológico","André Stwart","cvteajeaj.edu.br","84 99653-5872","7:15 as 17:00",-5.884567, -35.364924).save();
        new Local("Aquicultura"," Aquicultura, piscicultura e camarocultura","Paulo Faria","SetorAquicultura@eaj.edu.br","84 99123-2232","7:15 as 17:00", -5.887602,-35.361685).save();
        new Local("Ensino médio"," Ensino médio integrado aos cursos de informática,aquicultura etc.","Aristotelina","Ensinomedio@eaj.edu.br","84 99423-5432","7:15 as 17:00",-5.885205,-35.364782).save();

        List<Local> locais = Local.listAll(Local.class);
        Log.i("susu", String.valueOf(locais.size()));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int result : grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                alertAndFinish();
                return;
            }
        }
    }
    private void alertAndFinish(){
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.app_name).setMessage("Para utilizar este aplicativo, você precisa aceitar as permissões.");
            // Add the buttons
            builder.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setPositiveButton("Permitir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        PermissionUtils.validate(this, 0, permissoes);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
