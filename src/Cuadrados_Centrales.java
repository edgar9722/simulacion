import java.util.Scanner;


public class Cuadrados_Centrales {
 int semilla ;
 int[] numeros;
 int cantidad;
 int numero = (int) (Math.random() * 9999 + 1);

    Scanner t = new Scanner (System.in);

    public Cuadrados_Centrales(int cantidad) {
        this.cantidad = cantidad;
    }

    public void pedirDatos() {
        System.out.println("1) Ingresar la semilla \n 2) Generar semilla automaticamente");
        int opcion = t.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("ingrese la semilla");
                semilla = t.nextInt();
                break;
            case 2:
                boolean primo = false;
                do {



                    for (int i = 2; i < numero; i++) {
                        if (numero % i == 0)
                            primo = false;
                        break;

                    }

                } while (primo = false);
                semilla = numero;

                break;


        }
    }

    public void  calcular() {
        numeros = new int[cantidad];
        int x = semilla;
        numeros[0] = x;
        for (int i = 1; i < cantidad; i++) {
            String cuadrado = Integer.toString((int) Math.pow(x, 2));
            do {
                int ceros = 8 - cuadrado.length();
                for (int j = 0; j < ceros; j++) {
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
