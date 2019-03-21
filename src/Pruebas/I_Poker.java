package Pruebas;

public class I_Poker {
    int[] numeros;
    static double PA = 0.72;
    static double PB = 0.1;
    static double PC = 0.27;
    double[] FE = new double[3];
    double[] FO = new double[3];
    double[] X2s = new double[3];
    double X2 = 0;
    double x2Critico = 5.99;
    int intervalos = 3;
    boolean validacion = false;

    public I_Poker(int[] numeros) {
        boolean dig = true;
        this.numeros = numeros;
        for (int i = 0; i < numeros.length; i++)
            if (numeros[i]+"".length() != 3)
                dig = false;
        if (dig) {
            validacion();
            mostrar();
        }else System.out.println("No es posible por el momento");
    }

    void  validacion(){
        FE[0] = PA * numeros.length;
        FE[1] = PB * numeros.length;
        FE[2] = PC * numeros.length;
        FO[0] = FO[1] = FO[2] = 0;
        int n1, n2, n3;

        for (int i = 0; i< numeros.length; i++){
            n1 = Integer.parseInt(""+numeros[i]+"".charAt(0));
            n2 = Integer.parseInt(""+numeros[i]+"".charAt(1));
            n3 = Integer.parseInt(""+numeros[i]+"".charAt(2));
            if(n1 == n2 && n1 == n3) FO[1]++;
            else if (n1 == n2 || n1 == n3 || n2 == n3) FO[2]++;
            else FO[0]++;
        }
        for (int i = 0; i<3; i++) {
            X2s[i] = Math.pow((FO[i] - FE[i]), 2) / FE[i];
            X2 += X2s[i];
        }
    }
    void mostrar(){
        System.out.println("-----------------------");
        System.out.println("Combinación 3 diferentes: FO = "+FO[0]+" : FE = "+FE[0]+" -- "+X2s[0]);
        System.out.println("Combinación 3 iguales   : FO = "+FO[1]+" : FE = "+FE[1]+" -- "+X2s[1]);
        System.out.println("Combinación 2 iguales   : FO = "+FO[2]+" : FE = "+FE[2]+" -- "+X2s[2]);
        System.out.println("X2: "+X2);
        System.out.println("X2 critico: "+x2Critico);
        if (X2 < x2Critico)
            System.out.println("Por lo tanto se acepta la hipotesis nula");
        else System.out.println("Por lo tanto se rechaza la hipotesis nula");
    }

}
