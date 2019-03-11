import java.util.Scanner;

public class Mixto {

    int semilla;
    int c, x, a, modulo;
    int[] numeros;
    int cantidadNumeros;



    Scanner s = new Scanner(System.in);

    public Mixto(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public void pedirDatos() {

        System.out.println("1) Ingresar la semilla \n 2) Generar semilla automaticamente");
        int opcion = s.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese Costante Aditiva");
                c = s.nextInt();
                System.out.println("Ingrese Constante Multiplicativa");
                a = s.nextInt();
                System.out.println("Ingrese modulo");
                modulo = s.nextInt();
                System.out.println("Ingrese semilla");
                semilla = s.nextInt();

                break;
            case 2:
                int sem_auto = (int) (Math.random() * 99 + 1);
                semilla = sem_auto;
                System.out.println(semilla);

                int c_auto = (int) (Math.random() * 99 + sem_auto);
                c=c_auto;
                System.out.println(c);

                int x_auto = (int) (Math.random() * 99 + c_auto);
                x=x_auto;
                System.out.println(x);
                modulo=100;

                System.out.println(modulo);

                break;

        }


    }

    public void generarNumeros() {
        numeros = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            semilla = ((a * semilla) + c) % modulo;
            numeros[i] = semilla;
        }
    }
    public int[] getNumeros() {
        return numeros;
    }
}