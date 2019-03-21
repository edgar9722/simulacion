package Pruebas;

public class U_Promedios {
    int[] numeros;
    int suma;
    double media;
    double z;
    boolean validacion = false;

    public U_Promedios(int[] numeros, double media, double z) {
        this.numeros = numeros;
        this.media = media;
        this.z = z;
        Calculos();
        imprimir();
    }
    private void Calculos(){

        // obtener el promedio
        for(int i=0; i< numeros.length; i++)
        {
          suma=suma+numeros[i];
        }
        media=suma/numeros.length;

       //calcular z

        if(z < 1.96){
            validacion=true;
        }
    }
    private void imprimir (){

        if (validacion )
            System.out.println("Z "+z+" es menor a 1.96 , se acepta la hiposis de que la muestra viene de una distribucion uniforme");
        else
            System.out.println("Z "+z+" es mayor a 1.96 , no se acepta la hipotesis");


    }

}
