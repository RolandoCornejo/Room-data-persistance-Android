package edu.sv.udb.alumnos_escuela_computacion;

import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class AdaptadorLista extends ListAdapter<Alumno, ItemRecyclerView> {
    public AdaptadorLista(@NotNull DiffUtil.ItemCallback<Alumno> diffCallback){
        super(diffCallback);
    }
    @Override
    public void onBindViewHolder (ItemRecyclerView item, int position){
        Alumno actual = getItem(position);
        item.llenar(actual.obtenerAlumno());
    }
    @Override
    public ItemRecyclerView onCreateViewHolder(ViewGroup padre,int tipoVista){
        return ItemRecyclerView.create(padre);
    }
    static class AlumnoDiff extends DiffUtil.ItemCallback<Alumno>{
        @Override
        public boolean areItemsTheSame(@NotNull Alumno itemViewjo,@NotNull Alumno itemNuevo){
            return itemNuevo==itemViewjo;
        }
        @Override
        public boolean areContentsTheSame(@NotNull Alumno itemViejo,@NotNull Alumno itemNuevo){
            //ARREGLAR
            return Arrays.deepEquals(itemViejo.obtenerAlumno(),itemNuevo.obtenerAlumno());
        }
    }

}
