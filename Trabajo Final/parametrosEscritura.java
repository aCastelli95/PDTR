import java.io.Serializable;
public class parametrosEscritura implements Serializable{

    String nombreEscritura;
    byte[] buffer;
    int cantAEscribir;

    public parametrosEscritura(){}

    public void setNombreEscritura (String nombre){
        this.nombreEscritura=nombre;
    }

    public void setBuffer (byte[] buf){
        this.buffer = buf;
    }

    public void setCantAEscribir (int cant){
        this.cantAEscribir = cant;
    }

    public String getNombreEscritura(){
        return nombreEscritura;
    }

    public byte[] getBuffer(){
        return buffer;
    }

    public int getCantAEscribir(){
        return cantAEscribir;
    }

}
