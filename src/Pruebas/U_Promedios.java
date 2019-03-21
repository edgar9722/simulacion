package Pruebas;

public class U_Promedios {
    double[] numeros;
    double suma;
    double media;
    double z;
    boolean validacion = false;

    public U_Promedios(int[] numeros) {
        this.numeros = new double[numeros.length];
        for (int i = 0; i < numeros.length; i++){
            this.numeros[i] = numeros[i]/10000;
        }
        Calculos();
        imprimir();
    }
    private void Calculos(){
        // obtener el promedio
        for(int i=0; i< numeros.length; i++)
          suma=suma+numeros[i];
        media=suma/numeros.length;
       //calcular z
        z = ((media - 0.5)*Math.pow(numeros.length,0.5))/Math.pow(1/12,1/2);
        if(z < 1.96 && z > -1.962  ){
            validacion = true;
        }
    }
    private void imprimir (){
        if (validacion )
            System.out.println(" -1.96 < "+z+" < 1.96, se acepta la hiposis de que la muestra viene de una distribucion uniforme");
        else
            System.out.println("-1.96 < "+z+" < 1.96 , no se acepta la hipotesis");
    }

}
