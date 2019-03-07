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

        for (int i = 0; i <= this.cantidad; i++) {


            String cuadrado = Integer.toString((int) Math.pow(this.semilla, 2));
            do {
                int ceros = 8 - cuadrado.length();
                for (int j = 0; j <= ceros; j++) {
                    cuadrado = "0" + cuadrado;

                }
            } while (cuadrado.length() < 8);
            this.semilla = Integer.parseInt(cuadrado.substring(5, 7));
            numeros[i] = this.semilla;
        }
    }

    public int[] getNumeros(){
        return numeros;

    }
}
