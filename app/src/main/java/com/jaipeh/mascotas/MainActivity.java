package com.jaipeh.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{


    private RecyclerView listMascotas;
    ArrayList<Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_titulo);
        toolbar_title.setText(R.string.txtMascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        listMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listMascotas.setLayoutManager(llm);

        initMascotas();
        inicilizarAdaptador();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Menu) {
            Toast.makeText(this,"Menu de solo vista",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
    private void inicilizarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listMascotas.setAdapter(adaptador);
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Chester",R.drawable.gato,"2"));
        mascotas.add(new Mascota(1,"Daysi",R.drawable.pez,"4"));
        mascotas.add(new Mascota(1,"Caty",R.drawable.vaca,"5"));
        mascotas.add(new Mascota(1,"Coto",R.drawable.loro,"6"));
        mascotas.add(new Mascota(1,"Perry",R.drawable.perro,"8"));
        mascotas.add(new Mascota(1,"Tuly",R.drawable.jirafa,"0"));
        mascotas.add(new Mascota(1,"Gonza",R.drawable.leon,"5"));
        mascotas.add(new Mascota(1,"Pingu",R.drawable.pinguino,"1"));
        mascotas.add(new Mascota(1,"Pepa",R.drawable.cerdo,"5"));
        mascotas.add(new Mascota(1,"Rabby",R.drawable.conejo,"9"));
    }

    public void getList(View v){
        Intent intent = new Intent(MainActivity.this,SegundaPantalla.class);
        startActivity(intent);
    }
}

