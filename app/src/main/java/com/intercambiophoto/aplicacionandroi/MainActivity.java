package com.intercambiophoto.aplicacionandroi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //public void iniciarsesion(View view) {
      //  Intent intent = new Intent(this, inicioactivity.class); // Reemplaza "PaginaCentralActivity" con el nombre real de tu actividad central
        //startActivity(intent);
    //}
   public void Registrarse(View view){
        Intent i = new Intent(this, registro.class);
        startActivity(i);
    }

   public void iniciarsesion(View view){
      Intent i = new Intent(this, inicioactivity.class);
       startActivity(i);
    }

}