import java.util.Scanner;

public class Mixto {

    int Semilla;
    int c, x, a, modulo;
    int[] numeros;
    int cantidadNumeros;
    Scanner s = new Scanner(System.in);

    public Mixto(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public void pedirDatos() {

        System.out.println("Ingrese Costante Aditiva");
        c = s.nextInt();
        System.out.println("Ingrese Constante Multiplicativa");
        a = s.nextInt();
        System.out.println("Ingrese modulo");
        modulo = s.nextInt();
        System.out.println("Ingrese semilla");
        Semilla = s.nextInt();


    }

    public void generarNumeros() {
        numeros = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            Semilla = ((a * Semilla) + c) % modulo;
            numeros[i] = Semilla;
        }
    }
    public int[] getNumeros() {
        return numeros;
    }
}