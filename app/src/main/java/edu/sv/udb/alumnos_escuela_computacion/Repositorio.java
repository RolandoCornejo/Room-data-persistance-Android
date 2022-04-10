package edu.sv.udb.alumnos_escuela_computacion;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repositorio {
    /*Creamos un repositorio para seguir las buenas practicas  y hacer los llamados en un hilo que no sea el el ui
    * y tambien evitar repetir codigo en cada actividad  que haga uso de la base*/
    private DAO repoDAO;
    public LiveData<List<Alumno>> todosAlumnos;

    Repositorio(Application  aplicacion){
        BaseAlumnos db = BaseAlumnos.obtenerBase(aplicacion);
        repoDAO=db.DAO();
        todosAlumnos=repoDAO.obtenerListado();
    }
    //Llamaremos esta funcion en otro hilo que no sea el del ui para evitar errores a la hora de compilar y sea bloqueado
    void insertar(Alumno alumno){
        BaseAlumnos.ejecutorBase.execute(()->{
            repoDAO.insertar(alumno);
        });
    }

    void modificar(Alumno alumno){
        BaseAlumnos.ejecutorBase.execute(()->{
            repoDAO.modificar(alumno);
        });
    }
    void eliminarA(Alumno alumno){
        BaseAlumnos.ejecutorBase.execute(()->{
            repoDAO.eliminarA(alumno);
        });
    }


    LiveData<List<Alumno>> obtenerLista(){
        return todosAlumnos;
    }



}
