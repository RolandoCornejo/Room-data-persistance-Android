package edu.sv.udb.alumnos_escuela_computacion;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {
    //definimos las query que utilizaremos para que podamos acceder a la base
    @Insert
    void insertar(Alumno alumno);
    //Con esta query obtendremos
    @Query("SELECT * FROM alumno ORDER BY carnet DESC")
    LiveData< List<Alumno> > obtenerListado();

    @Query("DELETE FROM alumno")
    void eliminarTODO();

    @Delete
    void eliminarA(Alumno alumno);

    @Update
    void modificar(Alumno alumno);
}
