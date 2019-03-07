import java.util.Scanner;

public class ProductoCentral {
    int Semilla1;
    int Semilla2;
    int aux;
    int X0;
    int X1;
    int [] numeros;

    public ProductoCentral(int semilla1, int semilla2, int aux, int x0, int x1, int[] numeros) {
        Semilla1 = semilla1;
        Semilla2 = semilla2;
        this.aux = aux;
        X0 = x0;
        X1 = x1;
        this.numeros = numeros;
    }

    public ProductoCentral() {
    }

    public void Calcular(int cant_numeros){
        Scanner reader = new Scanner(System.in);
        String cont = "0";

        System.out.println("Ingresa las semilla1: ");
        Semilla1 = reader.nextInt();
        System.out.println("Ingresa las semilla2: ");
        Semilla2 = reader.nextInt();
        X0=Semilla1;
        X1=Semilla2;

        for(int i = 0; i <= cant_numeros; i++){
            aux = X0 * X1;
            String num = Integer.toString(aux);
            if(num.length()==8){
                String subnum = num.substring(2,6);
                num = subnum;
                Integer n = Integer.parseInt(num);
                X0=X1;
                X1=n;
                System.out.println(num);
                numeros[i]=n;
            }
            else{
                while(num.length()<8){
                    num = cont + num;
                }
                String subnum = num.substring(2,6);
                num = subnum;
                Integer n = Integer.parseInt(num);
                X0=X1;
                X1=n;
                System.out.println(num);
                numeros[i]=n;
            }

        }

    }

    public int getSemilla1() {
        return Semilla1;
    }

    public int getSemilla2() {
        return Semilla2;
    }

    public int getAux() {
        return aux;
    }

    public int getX0() {
        return X0;
    }

    public int getX1() {
        return X1;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
