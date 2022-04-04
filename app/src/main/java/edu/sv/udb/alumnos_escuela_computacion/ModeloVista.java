package edu.sv.udb.alumnos_escuela_computacion;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModeloVista extends AndroidViewModel {
    //hacemos este modelo vista para seguir buenas practicas y tambien ahorrar cierto codigo que no necesitamos repetir cada
    private Repositorio vistaRepositorio;
    public  final LiveData<List<Alumno>> vistaAlumnos;
    public ModeloVista(Application aplicacion){
        super(aplicacion);
        vistaRepositorio = new Repositorio(aplicacion);
        vistaAlumnos = vistaRepositorio.todosAlumnos;
    }
    public void insertar(Alumno alumno){
        vistaRepositorio.insertar(alumno);
    }

}
