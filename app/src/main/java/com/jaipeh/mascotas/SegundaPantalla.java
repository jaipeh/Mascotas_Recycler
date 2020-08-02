package com.jaipeh.mascotas;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isaachernandezquinonez on 24/06/16.
 */
public class SegundaPantalla extends AppCompatActivity{
    private RecyclerView listMascotas;
    ArrayList<Mascota> mascotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.segunda_pantalla);

        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_titulo);
        toolbar_title.setText(R.string.txtFavoritos);

        Button btnShowCollection = (Button) findViewById(R.id.btnShowCollection);
        btnShowCollection.setVisibility(View.GONE);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        listMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listMascotas.setLayoutManager(llm);

        initMascotas();
        inicilizarAdaptador();
    }
    private void inicilizarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listMascotas.setAdapter(adaptador);
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Daysi",R.drawable.pez,"4"));
        mascotas.add(new Mascota(1,"Coto",R.drawable.loro,"6"));
        mascotas.add(new Mascota(1,"Perry",R.drawable.perro,"8"));
        mascotas.add(new Mascota(1,"Gonza",R.drawable.leon,"5"));
        mascotas.add(new Mascota(1,"Pingu",R.drawable.pinguino,"1"));

    }
}
