package proyecto.seguros.Class;

public class Poliza {
   private int tipocarro;
   private String numeropoliza;
   private String marca;
   private String modelo;
   private int clase;
   private int blindaje;
   private int foto;

   public Poliza(){ }

    public int getTipocarro() {
        return tipocarro;
    }

    public void setTipocarro(int tipocarro) {
        this.tipocarro = tipocarro;
    }

    public String getNumeropoliza() {
        return numeropoliza;
    }

    public void setNumeropoliza(String numeropoliza) {
        this.numeropoliza = numeropoliza;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public void setBlindaje(int blindaje) {
        this.blindaje = blindaje;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
