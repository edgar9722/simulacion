import java.util.Scanner;

public class Multiplicativo {
    int semilla;
    int a;
    int x;
    int modulo;
    int cantidadNumeros;
    Scanner s = new Scanner(System.in);
    int[] numeros;



    public Multiplicativo(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }
    public void pedirDatos() {
        System.out.println("Ingrese Constante Multiplicativa");
        a = s.nextInt();
        System.out.println("Ingrese modulo "+"debe ser potencia de 2");
        modulo = s.nextInt();


        if ((modulo != 0) && ((modulo & (modulo - 1)) == 0)){

        }
        else{
            System.out.println(" El Modulo Debe ser una potencia de 2, Intente de nuevo");
            modulo = s.nextInt();

        }
        System.out.println("Ingrese semilla");
        semilla = s.nextInt();


    }

    public void generarNumeros() {
        numeros = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            semilla = (a * semilla) % modulo;
            numeros[i] = semilla;
        }
    }
    public int[] getNumeros() {
        return numeros;
    }
}

