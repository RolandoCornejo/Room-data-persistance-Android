package edu.sv.udb.alumnos_escuela_computacion;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "alumno")
public class Alumno {
    //Definimos el carnet como nuestra  llave principal
        @PrimaryKey
        @NotNull
        public String carnet;
        //Inggresamos las demas columnas de info que ingresaremos del alumno
        public String  nombre;
        public String programa;
        public String email;
        public String direccion;
    public String telefono;

        public Alumno(@NotNull String carnet,String nombre,String programa, String email, String telefono, String direccion){
            this.carnet=carnet;
            this.nombre=nombre;
            this.programa=programa;
            this.email=email;
            this.telefono=telefono;
            this.direccion=direccion;

        }

    public String[] obtenerAlumno(){
            String[] result={this.carnet, this.nombre, this.programa, this.email,this.telefono, this.direccion};
            return result ;
        }
    }
