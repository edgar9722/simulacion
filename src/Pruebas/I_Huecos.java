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
        int[] cantidad = new int[10];
        int numero = 0;
        int i;
        for (i = 0;i< cantidad.length; i++)
            cantidad[i] = 0;
        for(i = 0; i<listDigitos.length(); i++){
            numero = Integer.parseInt(""+listDigitos.charAt(i));
            switch (numero){
                case 0:{
                    cantidad[0]++;
                }break;
                case 1:{
                    cantidad[1]++;
                }break;
                case 2:{
                    cantidad[2]++;
                }break;
                case 3:{
                    cantidad[3]++;
                }break;
                case 4:{
                    cantidad[4]++;
                }break;
                case 5:{
                    cantidad[5]++;
                }break;
                case 6:{
                    cantidad[6]++;
                }break;
                case 7:{
                    cantidad[7]++;
                }break;
                case 8:{
                    cantidad[8]++;
                }break;
                default:
                    cantidad[9]++;
            }
        }
        for (i = 0; i<cantidad.length;i++)
                if (numero < cantidad[i])
                    numero = cantidad[i];


    }
}
