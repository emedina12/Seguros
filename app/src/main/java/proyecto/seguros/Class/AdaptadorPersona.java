package proyecto.seguros.Class;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import proyecto.seguros.R;

public class AdaptadorPersona  extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {
    private ArrayList<Persona> personas;
    private OnpersonaClickListener clickListener;



    public AdaptadorPersona(ArrayList<Persona> personas, OnPersonaClickListener clickListener){
        this.personas=personas;
        this.clickListener = clickListener;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_persona,parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.cedula.setText(p.getCedula());
        holder.nombres.setText(p.getNombres());
        holder.apellidos.setText(p.getApellidos());
        holder.direccion.setText(p.getDireccion());
        holder.telefono.setText(p.getTelefono());
        holder.email.setText(p.getEmail());

        holder.v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickListener.onPersonaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView cedula;
        private TextView nombres;
        private TextView apellidos;
        private TextView direccion;
        private TextView telefono;
        private TextView email;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imagene1);
            cedula = v.findViewById(R.id.lblCedula);
            nombres = v.findViewById(R.id.lblNombres);
            apellidos = v.findViewById(R.id.lbApellidos);
            direccion = v.findViewById(R.id.lblDireccion);
            telefono = v.findViewById(R.id.lblTelefono);
            email = v.findViewById(R.id.lblEmail);


        }

    }

    public interface OnPersonaClickListener{
        void onPersonaClick(Persona p);
    }
}
