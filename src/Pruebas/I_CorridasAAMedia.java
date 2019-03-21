package Pruebas;

public class I_CorridasAAMedia {
    int[] numeros;
    int suma;
    double media;
    int corridas_Am=0; // corridas arriba de la media
    int corridas_Bm=0; // corridas abajo de la media

    public I_CorridasAAMedia(int[] numeros, int suma, double media, int corridas_Am, int corridas_Bm) {
        this.numeros = numeros;
        this.suma = suma;
        this.media = media;
        this.corridas_Am = corridas_Am;
        this.corridas_Bm = corridas_Bm;
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
            }
            else{
                corridas_Bm=corridas_Bm++;
            }
        }

    }
}
