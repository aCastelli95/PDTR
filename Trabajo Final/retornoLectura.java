import java.io.Serializable;
public class retornoLectura implements Serializable{

byte retBytes[];
int cantBytesLeidos;
public retornoLectura(){}
public void setRetBytes (byte[] bytes){
  this.retBytes=bytes;
}

public void setCantBytesLeidos (int cant){
  this.cantBytesLeidos=cant;
}

public byte[] getRetBytes (){
  return retBytes;
}

public int getCantBytesLeidos (){
  return cantBytesLeidos;
}


}
