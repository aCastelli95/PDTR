import java.io.Serializable;
public class parametrosLectura implements Serializable{

    String filename;
    int cantBytesALeer;
    int pos;

    public parametrosLectura(){}

    public void setFilename (String fname){
        this.filename=fname;
    }

    public void setCantALeer (int cant){
        this.cantBytesALeer=cant;
    }


    public void setPos (int posicion){
        this.pos = posicion;
    }

    public String getFilename(){
        return this.filename;
    }

    public int getCantLeer(){
        return this.cantBytesALeer;
    }

    public int getPos(){
        return this.pos;
    }

}
