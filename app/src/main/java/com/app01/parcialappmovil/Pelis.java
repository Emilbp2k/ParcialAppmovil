package com.app01.parcialappmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pelis extends AppCompatActivity {

    private ArrayList<Titulos> pelispedia = new ArrayList<Titulos>();
    private ListView listado;
    private ArrayAdapter<Titulos> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulos);

        Intent in = getIntent();
        pelispedia= in.getParcelableArrayListExtra("Datos");
        Toast.makeText(this,"e"+ pelispedia.size(),Toast.LENGTH_LONG).show();

        listado = findViewById(R.id.lv2);
        arrayAdapter = new ArrayAdapter<Titulos>(this, R.layout.item_spinner, R.id.txt_spinner, pelispedia);
        listado.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.ordenGen:
                Collections.sort(pelispedia, new Comparator<Titulos>() {
                    @Override
                    public int compare(Titulos o1, Titulos o2) {
                        return o1.getGenero().compareTo(o2.getGenero());
                    }
                });
                arrayAdapter.notifyDataSetChanged();

                break;

            case R.id.alfabe:
                Collections.sort(pelispedia, new Comparator<Titulos>() {
                    @Override
                    public int compare(Titulos o1, Titulos o2) {
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                });
                arrayAdapter.notifyDataSetChanged();
                break;

            case R.id.invertir:
                Collections.reverse(pelispedia);
                arrayAdapter.notifyDataSetChanged();
                break;

            case R.id.Borrar:
                pelispedia.remove(0);
                arrayAdapter.notifyDataSetChanged();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}

