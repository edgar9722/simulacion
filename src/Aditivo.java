import java.util.Scanner;

public class Aditivo {
    int[] semillas;
    int modulo;
    int[] numeros;
    private int cantidadNumeros;
    private int aux;
    private int contador = 1;
    Scanner t = new Scanner (System.in);

    public Aditivo(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    // Metodo para pedir los datos necesarios para generar los numeros
    public void pedirDatos() {
        boolean terminar = false;
        int i = 1;
        int semilla;
        semillas = new int[cantidadNumeros];

        System.out.println("Ingresa las semillas: ");
        System.out.println("Semilla "+i+": ");
        semillas[i-1] = t.nextInt();
        do {
            i++;
            System.out.println("Para terminar escriba 0");
            System.out.println("Semilla "+i+": ");
            semilla = t.nextInt();
            if(semilla==0)
                terminar= true;
            else {
                semillas[i - 1] = semilla;
                contador++;
            }
        }while (!terminar);
        System.out.println("Ingresa el modulo: ");
        modulo = t.nextInt();
    }
    // Metodo que genera los numeros aletorios
    public void generarNumeros(){
        int contadorIzq = 0;
        int contadorDer = contador-1;
        numeros = new int[cantidadNumeros];
        for(int i = 0; i < semillas.length ; i++)
            numeros[i] = semillas[i];

        for (int i = contador; i < cantidadNumeros; i++){
            aux = (numeros[contadorIzq]+numeros[contadorDer])%modulo;
            numeros[i] = aux;
            contadorIzq++;
            contadorDer++;
        }
    }
    // gets and sets
    public int[] getSemillas() {
        return semillas;
    }

    public int getModulo() {
        return modulo;
    }

    public int[] getNumeros() {
        return numeros;
    }
}