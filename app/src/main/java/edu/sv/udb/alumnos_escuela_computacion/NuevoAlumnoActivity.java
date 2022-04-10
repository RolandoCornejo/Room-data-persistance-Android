package edu.sv.udb.alumnos_escuela_computacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoAlumnoActivity extends AppCompatActivity {

    public EditText carnetET,nombreET,planET,direccionET,emailET,telefonoET;
    private Repositorio rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_alumno);

        carnetET=findViewById(R.id.carnetET);
        nombreET=findViewById(R.id.nombreET);
        planET=findViewById(R.id.planET);
        direccionET=findViewById(R.id.direccionET);
        emailET=findViewById(R.id.emailET);
        telefonoET=findViewById(R.id.telefonoET);

        final Button guardarBtn=findViewById(R.id.guardarBtn);
        guardarBtn.setOnClickListener(view -> {
            Intent principal = new Intent();
            if(TextUtils.isEmpty(carnetET.getText())){
                Toast.makeText(this, "El campo carnet es requeridos", Toast.LENGTH_SHORT).show();
            }else{
                //Se guarda el alumno y luego se regresaa la actividad principal
                Intent atras = new Intent(this,MainActivity.class);
                rep= new Repositorio(this.getApplication());
                Alumno alumno=new Alumno(carnetET.getText().toString(),nombreET.getText().toString(),planET.getText().toString(),emailET.getText().toString(),telefonoET.getText().toString(),direccionET.getText().toString());
                rep.insertar(alumno);
                startActivity(atras);
            }
        });

        final Button editarBtn=findViewById(R.id.editarBtn);
        editarBtn.setOnClickListener(view -> {
            Intent principal = new Intent();
            if(TextUtils.isEmpty(carnetET.getText())){
                Toast.makeText(this, "El campo carnet es requeridos", Toast.LENGTH_SHORT).show();
            }else{
                //Se guarda el alumno y luego se regresaa la actividad principal
                Intent atras = new Intent(this,MainActivity.class);
                rep= new Repositorio(this.getApplication());
                Alumno alumno=new Alumno(carnetET.getText().toString(),nombreET.getText().toString(),planET.getText().toString(),emailET.getText().toString(),telefonoET.getText().toString(),direccionET.getText().toString());
                rep.modificar(alumno);
                startActivity(atras);
            }
        });

        final Button eliminarBtn=findViewById(R.id.eliminarBtn);
        eliminarBtn.setOnClickListener(view -> {
            Intent principal = new Intent();
            if(TextUtils.isEmpty(carnetET.getText())){
                Toast.makeText(this, "El campo carnet es requeridos", Toast.LENGTH_SHORT).show();
            }else{
                //Se guarda el alumno y luego se regresaa la actividad principal
                Intent atras = new Intent(this,MainActivity.class);
                rep= new Repositorio(this.getApplication());
                Alumno alumno=new Alumno(carnetET.getText().toString(),nombreET.getText().toString(),planET.getText().toString(),emailET.getText().toString(),telefonoET.getText().toString(),direccionET.getText().toString());
                rep.eliminarA(alumno);
                startActivity(atras);
            }
        });

    }
}