package proyecto.seguros.Class;

import java.util.ArrayList;

public class Persona {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private int sexo;
    private int foto;
    private ArrayList<Poliza> polizas;

    public Persona(){ }

    public Persona(String cedula) {
        this.cedula = cedula;
    }

    public Persona(String cedula, String nombres, String apellidos, String direccion, String telefono, String email, int sexo, int foto, ArrayList<Poliza> polizas) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sexo=sexo;
        this.foto = foto;
        this.polizas = polizas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public ArrayList<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(ArrayList<Poliza> polizas) {
        this.polizas = polizas;
    }

    public void guardarPersona(){
        Datos.guardarPersona(this);}
    public void eliminarPersona(){
        Datos.guardarPersona(this);}


}
