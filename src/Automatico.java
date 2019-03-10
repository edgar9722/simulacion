import java.util.Scanner;

public class Automatico {
    int semilla= 6493;
    int k= 2467;
    private int cantidadNumeros;
    private int x;
    private String aux;
    private int [] numeros;

    public Automatico(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
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
            x = Integer.parseIrnt(aux.substring(2,6));
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
