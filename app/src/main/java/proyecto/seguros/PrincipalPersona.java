package proyecto.seguros;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import proyecto.seguros.Class.AdaptadorPersona;
import proyecto.seguros.Class.Datos;
import proyecto.seguros.Class.Persona;
import proyecto.seguros.Class.Poliza;

public class PrincipalPersona extends AppCompatActivity implements AdaptadorPersona.OnPersonaClickListener{
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd = "Persona";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_persona);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lstOpciones = findViewById(R.id.lstOpcionesPersona);
        personas = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPersona(personas,this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               personas.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Persona p = snapshot.getValue(Persona.class);
                        personas.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(personas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void crearPersona(View v){
        i = new Intent(PrincipalPersona.this,CrearPersona.class);
        startActivity(i);


    }


    @Override
    public void onPersonaClick(Persona p) {
        Intent i = new Intent(PrincipalPersona.this,DetallePersona.class);
        Bundle b = new Bundle();
        b.putString("cedula",p.getCedula());
        b.putString("nombres",p.getNombres());
        b.putString("apellidos",p.getApellidos());
        b.putString("direccion",p.getDireccion());
        b.putString("telefono",p.getTelefono());
        b.putString("email",p.getEmail());
        b.putInt("sexo",p.getSexo());
        b.putInt("foto",p.getFoto());


        i.putExtra("datos",b);
        startActivity(i);

    }


}
