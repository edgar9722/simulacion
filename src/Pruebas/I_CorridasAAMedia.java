package Pruebas;

public class I_CorridasAAMedia {
    double[] numeros;
    double suma;
    double media;
    int corridas_Am; // corridas arriba de la media
    int corridas_Bm; // corridas abajo de la media
    int corridas;
    double valorEsperado;
    double varianza;
    double z;
    boolean validacion=false;



    public I_CorridasAAMedia(double[] numeros) {
        this.suma = suma;
        this.media = media;
        this.corridas_Am = corridas_Am;
        this.corridas_Bm = corridas_Bm;
        this.numeros = new double[numeros.length];
        for (int i = 0; i < numeros.length; i++){
            this.numeros[i] = numeros[i]/10000;
        }
        Calculos();
        imprimir();
    }

    private void Calculos() {

        // obtener el promedio
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }
        media = suma / numeros.length;


        //corridas
        for (int i = 0; i <numeros.length ;i++ ) {
            if (numeros[i]>media){
                corridas_Am=corridas_Am++;
                corridas=corridas++;
            }
            else{
                corridas_Bm=corridas_Bm++;
                corridas=corridas++;
            }
        }



        //calcuar valor esperado

        valorEsperado=((2*(corridas_Am*corridas_Bm))/numeros.length)+1/2;
        varianza=((2*(corridas_Am*corridas_Bm))*(2*(corridas_Am*corridas_Bm)-numeros.length))/(Math.pow(numeros.length,2)*(numeros.length-1));
        z= (corridas-valorEsperado)/Math.sqrt(varianza);

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
