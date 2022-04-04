package edu.sv.udb.alumnos_escuela_computacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemRecyclerView extends RecyclerView.ViewHolder {
    private TextView carnetTV;
    private TextView nombreTV;
    private TextView planTV;
    private TextView emailTV;
    private TextView telefonoTV;
    private TextView direccionTV;

    private ItemRecyclerView(View vista){
        super(vista);
        carnetTV=vista.findViewById(R.id.carnetTV);
        nombreTV=vista.findViewById(R.id.nombreTV);
        planTV=vista.findViewById(R.id.planTV);
        emailTV=vista.findViewById(R.id.emailTV);
        telefonoTV=vista.findViewById(R.id.telefonoTV);
        direccionTV=vista.findViewById(R.id.direccionTV);
    }
    public void llenar(String[] datos){
        carnetTV.setText(datos[0]);
        nombreTV.setText("Nombre: "+datos[1]);
        planTV.setText("Plan de estudio: "+datos[2]);
        emailTV.setText("Correo Electrónico: "+datos[3]);
        telefonoTV.setText("Teléfono: "+datos[4]);
        direccionTV.setText("Dirección: "+datos[5]);
    }

    static  ItemRecyclerView create(ViewGroup padre){
        View view = LayoutInflater.from(padre.getContext()).inflate(R.layout.item_recyclerview,padre,false);
        return new ItemRecyclerView(view);
    }

}
