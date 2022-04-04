package edu.sv.udb.alumnos_escuela_computacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Repositorio  mainRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        final AdaptadorLista adaptador = new AdaptadorLista(new AdaptadorLista.AlumnoDiff());
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainRepositorio=new Repositorio(this.getApplication());

        mainRepositorio.obtenerLista().observe(this,alumnos -> {
            adaptador.submitList(alumnos);
        });

        FloatingActionButton nuevo = findViewById(R.id.botonFlotante);
        nuevo.setOnClickListener(view -> {
            Intent nuevoActivity = new Intent(MainActivity.this,NuevoAlumnoActivity.class);
            startActivity(nuevoActivity);
        });
    }

}