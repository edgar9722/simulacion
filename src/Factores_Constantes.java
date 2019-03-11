import java.io.IOException;
import java.util.Scanner;

public class Factores_Constantes {
    int semilla;
    int k;
    private int cantidadNumeros;
    private int x;
    private String aux;
    private int [] numeros;
    private int opcion;
    Scanner t = new Scanner (System.in);

    public Factores_Constantes(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
        System.out.println("Elija una opcion para generar los valores iniciales:");
        System.out.println("0 Automatica\n" +
                "1 Manual\n");
        opcion = t.nextInt();
        if (opcion == 0) recuperarDatos();
        else pedirDatos();
        generarNumeros();
    }

    public void pedirDatos() {
        System.out.println("Ingresa la semilla: ");
        semilla = t.nextInt();
        System.out.println("Ingresa la constante: ");
        k = t.nextInt();
    }
    public void recuperarDatos() {
        Archivos archivos = new Archivos();
        int[] datos = new int[10];
        try {
            datos = archivos.leerArchivo("V0FactorConstante.dat",10);
        }catch (IOException e){
            System.out.println(e);
        }
        semilla = datos[0];
        k = datos[1];
    }
    public void generarNumeros(){
        x = semilla;
        numeros = new int[cantidadNumeros];
        numeros[0] = x;
        for (int i = 1; i<cantidadNumeros; i++){
            aux = ""+k*x;
            while (aux.length() != 8){
                aux = 0+aux;
            }
            x = Integer.parseInt(aux.substring(2,6));
            numeros[i] = x;
        }
    }

    public int getSemilla() {
        return semilla;
    }
    public int getK() {
        return k;
    }
    public int[] getNumeros() {
        return numeros;
    }
}
