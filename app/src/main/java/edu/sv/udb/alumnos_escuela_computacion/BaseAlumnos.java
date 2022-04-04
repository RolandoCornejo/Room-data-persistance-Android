package edu.sv.udb.alumnos_escuela_computacion;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import  java.util.concurrent.Executors;
import   java.util.concurrent.ExecutorService;

//En este archivo creamos nuestra base de room
@Database(entities = {Alumno.class}, version = 1,exportSchema = false)
public abstract class BaseAlumnos extends RoomDatabase {
    public abstract DAO DAO();
    //se pega la basse a una sola  instancia /BASE/ para prevennir que hayan multiples instancias de la base siendo utilizadas al mismo tiempo
    private static volatile BaseAlumnos BASE;
    private static final int NUMERO_DE_HILOS=4;
    //Se crea un pool de hilos que corren detras, estos son usados para no correr las queries en el mismo hilo que el UI y evitar relentizaciones
    static final ExecutorService ejecutorBase = Executors.newFixedThreadPool(NUMERO_DE_HILOS);

    static BaseAlumnos obtenerBase(final Context contexto){
        if(BASE==null){
            synchronized (BaseAlumnos.class){
                if(BASE==null){
                    BASE= Room.databaseBuilder(contexto.getApplicationContext(),BaseAlumnos.class,"Alummnos").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        } return BASE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            ejecutorBase.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                DAO dao = BASE.DAO();
                dao.eliminarTODO();
            });
        }
    };

}
