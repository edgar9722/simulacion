package Pruebas;
import java.util.ArrayList;

public class I_Huecos {
    int[] numeros; //Lista de numeros
    String listDigitos; // Numeros ordenados en fila
    Arreglo[] longHuecos;
    Double[] F;
    Double[] FR;
    Double[] Sx;
    Double[] x1;
    Double[] aFx;
    Double[] Fx;
    Double[] FxSx;
    Double DCritico = 0.136;
    Double DMax = 0.0;
    int longMax;

    public I_Huecos(int[] numeros) {
        this.numeros = numeros;
        longHuecos = new Arreglo[10];
        listDigitos = listarDigitos();
        calcularLongitud();
        calculos();
        comprobacion();
        //mostrar();
    }

    void comprobacion(){
        System.out.println("D critico: "+DCritico);
        System.out.println("D MAX |F(x) - S(x)|: "+DMax);
        if (DMax <= DCritico)
            System.out.println("Se aprueba la hipotesis nula");
        else System.out.println("No se aprueba la hipotesis nula");
    }
    void calculos (){
        int inf, sup, saltos, x, inte;
        boolean band = true;
        inf = x = 0;
        inte = 1;
        saltos = sup = 3;
        while(sup <= longMax && band){
            inte ++;
            inf = sup+1;
            if (inf+saltos > longMax){
                sup = longMax;
                band = false;
            }
            else
                sup = inf + saltos;
        }
        F = new Double[inte];
        FR = new Double[inte];
        Sx = new Double[inte];
        x1 = new Double[inte];
        aFx = new Double[inte];
        Fx = new Double[inte];
        FxSx = new Double[inte];
        inf = x = 0;
        saltos = sup = 3;
        for (int k = 0; k<inte; k++){
            F[k] = 0.0;
            FR[k] = 0.0;
            Sx[k] = 0.0;
            x1[k] = 0.0;
            aFx[k] = 0.0;
            Fx[k] = 0.0;
            FxSx[k] = 0.0;
            for (int i = 0; i<longHuecos.length; i++){
                for (int j = 0; j< longHuecos[i].getHuecos().size(); j++ )
                    x = longHuecos[i].getNumber(j);
                if (x > inf && x < sup){
                    F[k]++;
                    FR[k]+=1/listDigitos.length();
                    if (k>0) Sx[k] = Sx[k-1]+ FR[k];
                    else Sx[k] = FR[k];
                    x1[k]=sup+1.0;
                    aFx[k] = Math.pow(0.9, x1[k]);
                    Fx[k] = 1 - aFx[k];
                    FxSx[k] = Fx[k] - Sx[k];
                }
            }
            inf = sup+1;
            if (inf+saltos > longMax){
                sup = longMax;
            }
            else
                sup = inf + saltos;
        }
        for (int i = 0; i < inte; i++){
            if (DMax < FxSx[i])
                DMax = FxSx[i];
        }
    }
    void calcularLongitud(){
        int a, b, r, j, i, k;
        j = k = r = 0;
        boolean b1 = false;
        for (i = 0; i < longHuecos.length; i++) {
            longHuecos[i] = new Arreglo();
            j = k = 0;
            while (j < listDigitos.length()){
                if (i == Integer.parseInt(""+listDigitos.charAt(j))){
                    a = j;
                    k = j+1;
                    b1 = false;
                    while (k < listDigitos.length() && !b1){
                        if (i == Integer.parseInt(""+listDigitos.charAt(k))){
                            b = k;
                            if(r < b-a-1) r =b-a-1;
                            longHuecos[i].setNumero(b-a-1);
                            b1 = true;
                            j = k;
                        }
                        k++;
                    }
                }
                j++;
            }
        }
        longMax = r;
    }
    void mostrar(){
        for (int i = 0; i<longHuecos.length; i++){
            System.out.println("--- "+i+" ---");
            for (int j = 0; j< longHuecos[i].getHuecos().size(); j++ )
                System.out.println((j+1)+" "+longHuecos[i].getHuecos().get(j));
        }
    }
    String listarDigitos(){
        String list = "";
        for (int i = 0; i < numeros.length;i++)
            list+=""+numeros[i];
        return list;
    }
    //
    class Arreglo {
        ArrayList<Integer> huecos = new ArrayList<Integer>();
        int num;
        void setNumero(int n){
            huecos.add(n);
        }
        public ArrayList<Integer> getHuecos() {
            return huecos;
        }
        int getNumber(int i){
            return huecos.get(i);
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
    //
}
