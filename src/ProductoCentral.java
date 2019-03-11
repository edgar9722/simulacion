import java.util.Scanner;

public class ProductoCentral {
    int Semilla1;
    int Semilla2;
    int aux;
    int X0;
    int X1;
    int [] numeros;
    int opcion;

    public ProductoCentral() {
    }

    public void Opciones(){

    }
    public void Calcular(int cant_numeros){
        Scanner r = new Scanner(System.in);
        System.out.println("Elija una opcion para generar la semilla:");
        System.out.println("0 Automatica\n" +
                "1 Ingresar\n");
        opcion=r.nextInt();
        //Recivir la cantidad de numeros a generarse en el metodo, los cuales se guardaran en un arreglo de dicho tamaño
        numeros = new int[cant_numeros];
        Scanner reader = new Scanner(System.in);
        //Añadir ceros
        String cont = "0";

        if (opcion==0){
                //Semillas aleatorias
                Semilla1 = 4799;
                Semilla2 = 5863;
                X0=Semilla1;
                X1=Semilla2;

                for(int i = 0; i < cant_numeros; i++){
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
            else{if(opcion==1){

                //Pedir las semillas que son necesarias
                System.out.println("Ingresa las semilla 1: ");
                Semilla1 = reader.nextInt();
                System.out.println("Ingresa las semilla 2: ");
                Semilla2 = reader.nextInt();
                X0=Semilla1;
                X1=Semilla2;

                //Generador de numeros pseudoaleatorios
                for(int i = 0; i < cant_numeros; i++){
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
                        //Añadir los ceros necesarios para realizar un número de 8 digitos
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
