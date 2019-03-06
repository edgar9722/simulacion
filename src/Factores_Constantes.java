import java.util.Scanner;

public class Factores_Constantes {
    int semilla;
    int k;
    private int cantidadNumeros;
    private int x;
    private String aux;
    private int [] numeros;
    Scanner t = new Scanner (System.in);

    public Factores_Constantes(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public void pedirDatos() {
        System.out.println("Ingresa la semilla: ");
        semilla = t.nextInt();
        System.out.println("Ingresa la constante: ");
        k = t.nextInt();
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
