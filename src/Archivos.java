import java.io.*;
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

    public void guardarArchivo()throws IOException{
        fecha = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("-HHmmss");
        nombre = nombre+"-"+hourdateFormat.format(fecha); // Renombrar el nombre de salida

        FileWriter archivo = new FileWriter(nombre+".dat");
        PrintWriter arch = new PrintWriter(archivo);
        for (int i = 0; i < numeros.length; i++)
        arch.write(numeros[i]);
        // Cerrar el archivo
        arch.close();
    }
    public int[] leerArchivo(String nombre, int cantidad)throws IOException{
        int[] num = new int[10];
        System.out.println("--------");
        FileReader archivo = new FileReader(nombre);
        BufferedReader arch = new BufferedReader(archivo);
        for (int i = 0; i < cantidad; i++) {
           num[i] = Integer.parseInt(arch.readLine());
        }
        arch.close();
        return num;
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