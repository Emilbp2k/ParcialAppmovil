package com.app01.parcialappmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//EMIL RICARDO BARRIOS PALACIO
    private String registroGenero;
    private Spinner listaGenero;
    private EditText nombre, director;
    private Button guardar, cancelar;
    private RadioButton Ingles, Español;
    private ArrayList<Titulos> peliculas = new ArrayList<Titulos>();
    private String idioma= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaGenero = findViewById(R.id.spinnerGenero);
        String [] Genero = {"Aventura","Accion","Ficcion","Documental","Suspenso","Musical","Anime"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Genero);
        listaGenero.setAdapter(a);



        nombre= findViewById(R.id.nombreText);
        director= findViewById(R.id.directorText);
        Ingles = findViewById(R.id.RIdiomaing);
        Español = findViewById(R.id.RIdiomaesp);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Lista:
                Intent p = new Intent(this, Pelis.class);
                p.putParcelableArrayListExtra("Datos", peliculas);
                startActivity(p);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch(item.getItemId()) {
            case R.id.mayuscula:
                if(info.targetView.getId()== R.id.nombreText){
                    nombre.setText(nombre.getText().toString().toUpperCase());
                }
                else{
                    director.setText(director.getText().toString().toUpperCase());
                }

                break;

            case R.id.Minuscula:
                if(info.targetView.getId()== R.id.nombreText){
                    nombre.setText(nombre.getText().toString().toLowerCase());
                }
                else{
                    director.setText(director.getText().toString().toLowerCase());
                }


                break;


        }
        return super.onContextItemSelected(item);
    }
*/

    public void onClick(View v) {

        switch(v.getId()){


            case R.id.btnguardar:
                registroGenero =listaGenero.getSelectedItem().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Desea guardar la pelicula?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (Ingles.isChecked()==true){

                                    idioma = ("ingles");
                                    peliculas.add(new Titulos(nombre.getText().toString(),director.getText().toString(), registroGenero, idioma));


                                }
                                if (Español.isChecked()==true){
                                    idioma= ("Español");
                                    peliculas.add(new Titulos(nombre.getText().toString(),director.getText().toString(), registroGenero, idioma));

                                }


                                Toast.makeText(getApplicationContext()," GUARDADO EXITOSO", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext()," CANCELADO :c", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alerta = builder.create();
                alerta.show();

                break;
            case R.id.btncancelar:

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setMessage("Desea Cancelar")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(getApplicationContext(),"CANCELADO :c", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog a = b.create();
                a.show();



        }
    }

}
