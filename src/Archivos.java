import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Archivos {
    FileOutputStream file = null;
    DataOutputStream salida = null;
    Date fecha;
    private int[] numeros;
    private String nombre;
    private String direccion;

    public Archivos() {

    }

    public void guardar() {
        fecha = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss");
        nombre = nombre+"-"+hourdateFormat.format(fecha);
        try {
            file = new FileOutputStream("SalidaNumeros/"+nombre+".dat");
            salida = new DataOutputStream(file);
            for (int i = 0; i < numeros.length; i++) {
                salida.writeInt(numeros[i]);
            }
            file.close();
            salida.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}