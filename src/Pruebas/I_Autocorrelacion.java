package Pruebas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class I_Autocorrelacion {



    int i, m, M;
    int[] numeros;
    double pim, vPim, Z;
    boolean comprobacion = false;
    int N;

    public I_Autocorrelacion(int[] numeros) {
        this.numeros = numeros;

        pedirDatos();
        calculos();
        imprimir();
    }

    private void calculos()
    {
        int N = numeros.length;
        M = ((N-i)/m)-1;

        pim = ((1.0/(M+1))*sumatoria())-0.25;  // pim
        vPim = Math.sqrt(13*M+7)/(12*(M+1));   //opim
        Z=pim/vPim;   //
        if (Z >= -1.96 && Z <= 1.96)
            comprobacion = true;
        else comprobacion = false;
    }

    private double sumatoria()
    {
        double sum=0;

        for(int j=((i-1)+m); j< numeros.length; j+=m)
            sum += numeros[j-m]*numeros[j];

        return sum;
    }


    private  void imprimir()
    {
        System.out.println("Result -");
        System.out.println("M = " + M);
        System.out.println("sumatoria = " + sumatoria());
        System.out.println("pim = " + pim);
        System.out.println("vPim = " + vPim);
        System.out.println("Z = " + Z);
        System.out.println("Comprobacion");
        if(comprobacion)
            System.out.println("se acepta la hipotesis");
        else
            System.out.println("No se acepta la hipotesis");
    }


    public void pedirDatos()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Ingrese el numero inicial (i) = ");
            i = Integer.parseInt(br.readLine());

            System.out.print("ingrese la longitud de saltos  (m) = ");
            m = Integer.parseInt(br.readLine());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



}
