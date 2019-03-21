package Pruebas;

public class I_Huecos {
    int[] numeros;
    String listDigitos;
    int[][][] hLongitud;
    int[] numHuecos;

    public I_Huecos(int[] numeros) {
        this.numeros = numeros;
        listDigitos = listarDigitos();
    }

    String listarDigitos(){
        String list = "";
        for (int i = 0; i < numeros.length;i++)
            list+=""+numeros[i];
        return list;
    }
    void declarar(){

    }
}
