import java.util.Scanner;


public class Cuadrados_Centrales {
 int semilla ;
 int[] numeros;
 int cantidad;
    Scanner t = new Scanner (System.in);

    public Cuadrados_Centrales(int cantidad) {
        this.cantidad = cantidad;
    }
    public void pedirDatos(){
        System.out.println("ingrese la semilla");
        semilla = t.nextInt();    }

    public void  calcular() {
        numeros = new int[cantidad];
        int x = semilla;
        numeros[0] = x;
        for (int i = 1; i < cantidad; i++) {
            String cuadrado = Integer.toString((int) Math.pow(x, 2));
            do {
                int ceros = 8 - cuadrado.length();
                for (int j = 0; j <= ceros; j++) {
                    cuadrado = "0" + cuadrado;
                }
            } while (cuadrado.length() < 8);
            x = Integer.parseInt(cuadrado.substring(2, 6));
            numeros[i] = x;
        }
    }

    public int[] getNumeros(){
        return numeros;

    }
}
