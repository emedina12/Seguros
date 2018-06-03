package proyecto.seguros.Class;

import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Datos {

    private static String dbpersona = "Personas";
    private static String dbpoliza = "polizas";

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Poliza> polizas = new ArrayList<>();

    public static ArrayList<Persona> obtenerPersona() {
        return personas;
    }

    public static void setPersonas(ArrayList<Persona> personas){
        Datos.personas = personas;
    }

   /* public static void setDbpersona(ArrayList<Persona> p) {
        personas = p;
    }
    public static ArrayList<Poliza> getPolizas(String PersonaCedula) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(PersonaCedula)) {
                if (personas.get(i).getPolizas() != null) {
                    return personas.get(i).getPolizas();
                }
            }
        }

        return new ArrayList<>();
    }*/

    public static void guardarPersona(Persona p) {
        p.setCedula(databaseReference.push().getKey());
        databaseReference.child(dbpersona).child(p.getCedula()).setValue(p);
    }

    public static void eliminarPersona(Persona b){
        databaseReference.child(dbpersona).child(b.getCedula()).removeValue();
    }

/*
    public static void saveOperation(Poliza poliza, String PersonaCedula) {
        int id = 0;
        for (int i = 0; i < personas.size(); i++){
            if(personas.get(i).getCedula().equals(PersonaCedula)){
                if(personas.get(i).getPolizas() != null){
                    id = personas.get(i).getPolizas().size();

                    personas.get(i).getPolizas().add(poliza);
                }
            }
        }

        databaseReference.child(dbpersona).child(PersonaCedula).child(dbpoliza).child(""+id).setValue(poliza);
    }*/

}
