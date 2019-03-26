package Pruebas;

public class I_Poker {
    int[] numeros;

    String[] nums;
    double PA; // TODOS DIFERENTES
    double PB; // TODS IGUALES
    double PC; // 5 digitos 2 IGUALES - 4 digitos 2 IGUALES
    double PD; // 5 digitos 3 IGUALES - 4 digitos 3 IGUALES
    double PE; // 5 digitos 4 IGUALES - 4 digitos NO se usa

    double[] FE;
    double[] FO;
    double[] X2s;
    double X2 = 0;
    double x2Critico;

    public I_Poker(int[] numeros) {
        this.numeros = numeros;
        int digitos = contarDigitos(this.numeros);
        if (digitos == 4){
            calcularProbabilidades4Digitos();
            cantDigitos(digitos);
            validacion4Digitos();
            mostrar4Digitos();
        }else {
            calcularProbabilidades5Digitos();
            cantDigitos(digitos);
            validacion5Digitos();
            mostrar5Digitos();
        }
    }

    void  validacion5Digitos(){
        FE[0] = PA * numeros.length;
        FE[1] = PB * numeros.length;
        FE[2] = PC * numeros.length;
        FE[3] = PD * numeros.length;
        FE[4] = PE * numeros.length;
        FO[0] = FO[1] = FO[2] = FO[3] = FO[4] = 0;
        int a, b, c, d, e;

        for (int i = 0; i< numeros.length; i++){
            a = Integer.parseInt("" + nums[i].charAt(0));
            b = Integer.parseInt("" + nums[i].charAt(1));
            c = Integer.parseInt("" + nums[i].charAt(2));
            d = Integer.parseInt("" + nums[i].charAt(3));
            e = Integer.parseInt("" + nums[i].charAt(4));
            if(a == b && b == c && c == d && d == e) {
                FO[1]++;
            }
            else if(b == c && c == d && d == e){
                FO[4]++;
            }
            else if(a == c && c == d && d == e) {
                FO[4]++;
            }
            else if(a == b && b == d && d == e) {
                FO[4]++;
            }
            else if(a == b && b == c && c == e) {
                FO[4]++;
            }
            else if(a == b && b == c) {
                FO[3]++;
            }
            else if(a == b && b == d) {
                FO[3]++;
            }
            else if(a == b && b == e) {
                FO[3]++;
            }
            else if(a == c && c == d) {
                FO[3]++;
            }
            else if(a == c && c == e) {
                FO[3]++;
            }
            else if(b == c && c == d) {
                FO[3]++;
            }
            else if(b == c && c == e) {
                FO[3]++;
            }
            else if(c == d && d == e) {
                FO[3]++;
            }
            else if(a == c && c == d) {
                FO[3]++;
            }
            else if(a == b) {
                FO[2]++;
            }
            else if(a == c) {
                FO[2]++;
            }
            else if(a == d) {
                FO[2]++;
            }
            else if(a == e) {
                FO[2]++;
            }
            else if(b == c) {
                FO[2]++;
            }
            else if(b == d) {
                FO[2]++;

            }
            else if(b == e) {
                FO[2]++;

            }
            else if(c == d) {
                FO[2]++;
            }
            else if(c == e) {
                FO[2]++;
            }
            else if(d == e) {
                FO[2]++;
            }
            else {
                FO[0]++;
            }
        }
        for (int i = 0; i<5; i++) {
            X2s[i] = Math.pow((FO[i] - FE[i]), 2) / FE[i];
            X2 += X2s[i];
        }
    }
    void  validacion4Digitos(){
        FE[0] = PA * numeros.length;
        FE[1] = PB * numeros.length;
        FE[2] = PC * numeros.length;
        FE[3] = PD * numeros.length;
        FO[0] = FO[1] = FO[2] = FO[3] = 0;
        int a, b, c, d;
        for (int i = 0; i< numeros.length; i++){
            a = Integer.parseInt("" + nums[i].charAt(0));
            b = Integer.parseInt("" + nums[i].charAt(1));
            c = Integer.parseInt("" + nums[i].charAt(2));
            d = Integer.parseInt("" + nums[i].charAt(3));
            if(a == b && b == c && c == d) FO[1]++;
            else if(a == b && b == c) FO[3]++;
            else if(a == b && b == d) FO[3]++;
            else if(a == c && c == d) FO[3]++;
            else if(b == c && c == d) FO[3]++;
            else if(a == b) FO[2]++;
            else if(a == c) FO[2]++;
            else if(a == d) FO[2]++;
            else if(b == c) FO[2]++;
            else if(b == d) FO[2]++;
            else if(c == d) FO[2]++;
            else FO[0]++;
        }
        for (int i = 0; i<4; i++) {
            X2s[i] = Math.pow((FO[i] - FE[i]), 2) / FE[i];
            X2 += X2s[i];
        }
    }
    void cantDigitos(int digitos){
        nums = new String[numeros.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = ""+numeros[i];
            do {
                int ceros = digitos - nums[i].length();
                for (int j = 0; j < ceros; j++) {
                    nums[i] = "0" + nums[i];
                }
            } while (nums[i].length() < digitos);
        }
    }
    void mostrar5Digitos(){
        System.out.println("--POKER 5 DIGITOS---");
        System.out.println("Combinación todos diferentes: FO = "+FO[0]+" : FE = "+FE[0]);
        System.out.println("Combinación todos iguales: FO = "+FO[1]+" : FE = "+FE[1]);
        System.out.println("Combinación 4 iguales: FO = "+FO[4]+" : FE = "+FE[4]);
        System.out.println("Combinación 3 iguales   : FO = "+FO[3]+" : FE = "+FE[3]);
        System.out.println("Combinación 2 iguales   : FO = "+FO[2]+" : FE = "+FE[2]);
        System.out.println("X2: "+X2);
        System.out.println("X2 critico: "+x2Critico);
        if (X2 < x2Critico)
            System.out.println("Por lo tanto se acepta la hipotesis nula");
        else System.out.println("Por lo tanto se rechaza la hipotesis nula");
        System.out.println("------------------------");
    }
    void mostrar4Digitos(){
        System.out.println("---POKER 4 DIGITOS---");
        System.out.println("Combinación todos diferentes: FO = "+FO[0]+" : FE = "+FE[0]);
        System.out.println("Combinación todos iguales: FO = "+FO[1]+" : FE = "+FE[1]);
        System.out.println("Combinación 3 iguales   : FO = "+FO[3]+" : FE = "+FE[3]);
        System.out.println("Combinación 2 iguales   : FO = "+FO[2]+" : FE = "+FE[2]);
        System.out.println("X2: "+X2);
        System.out.println("X2 critico: "+x2Critico);
        if (X2 < x2Critico)
            System.out.println("Por lo tanto se acepta la hipotesis nula");
        else System.out.println("Por lo tanto se rechaza la hipotesis nula");
        System.out.println("------------------------");
    }
    void calcularProbabilidades5Digitos(){
        FE = new double[5];
        FO = new double[5];
        X2s = new double[5];
        x2Critico = 9.488;
        String[] num;
        int[] pro = new int[5];
        int x = 0;
        int a , b, c, d, e;
        pro[0] = 0;
        pro[1] = 0;
        pro[2] = 0;
        pro[3] = 0;
        pro[4] = 0;
        int numeros = (int)Math.pow(10,5);
        num = new String[numeros];
        for (int i = 0; i < numeros; i++){
            num[i] = ""+i;
            do {
                int ceros = 5 - num[i].length();
                for (int j = 0; j < ceros; j++) {
                    num[i] = "0" + num[i];
                }
            } while (num[i].length() < 5);
            //System.out.println(num[i].length());
        }
        for (int i = 0; i < num.length ; i++) {
            a = Integer.parseInt("" + num[i].charAt(0));
            b = Integer.parseInt("" + num[i].charAt(1));
            c = Integer.parseInt("" + num[i].charAt(2));
            d = Integer.parseInt("" + num[i].charAt(3));
            e = Integer.parseInt("" + num[i].charAt(4));

            if(a == b && b == c && c == d && d == e) pro[1]++;
            else if(b == c && c == d && d == e) pro[4]++;
            else if(a == c && c == d && d == e) pro[4]++;
            else if(a == b && b == d && d == e) pro[4]++;
            else if(a == b && b == c && c == e) pro[4]++;
            else if(a == b && b == c) pro[3]++;
            else if(a == b && b == d) pro[3]++;
            else if(a == b && b == e) pro[3]++;
            else if(a == c && c == d) pro[3]++;
            else if(a == c && c == e) pro[3]++;
            else if(b == c && c == d) pro[3]++;
            else if(b == c && c == e) pro[3]++;
            else if(c == d && d == e) pro[3]++;
            else if(a == c && c == d) pro[3]++;
            else if(a == b) pro[2]++;
            else if(a == c) pro[2]++;
            else if(a == d) pro[2]++;
            else if(a == e) pro[2]++;
            else if(b == c) pro[2]++;
            else if(b == d) pro[2]++;
            else if(b == e) pro[2]++;
            else if(c == d) pro[2]++;
            else if(c == e) pro[2]++;
            else if(d == e) pro[2]++;
            else pro[0]++;
        }
        PA = pro[0] /(double)numeros;
        PB = pro[1] /(double)numeros;
        PC = pro[4] /(double)numeros;
        PD = pro[3] /(double)numeros;
        PE = pro[2] /(double)numeros;
    }
    void calcularProbabilidades4Digitos(){
        FE = new double[4];
        FO = new double[4];
        X2s = new double[4];
        x2Critico = 7.815;
        String[] num;
        int[] pro = new int[4];
        int x = 0;
        int a , b, c, d;
        pro[0] = 0;
        pro[1] = 0;
        pro[2] = 0;
        pro[3] = 0;
        int numeros = (int)Math.pow(10,4);
        num = new String[numeros];
        for (int i = 0; i < numeros; i++){
            num[i] = ""+i;
            do {
                int ceros = 4 - num[i].length();
                for (int j = 0; j < ceros; j++) {
                    num[i] = "0" + num[i];
                }
            } while (num[i].length() < 4);
        }
        for (int i = 0; i < num.length ; i++) {
            a = Integer.parseInt("" + num[i].charAt(0));
            b = Integer.parseInt("" + num[i].charAt(1));
            c = Integer.parseInt("" + num[i].charAt(2));
            d = Integer.parseInt("" + num[i].charAt(3));

            if(a == b && b == c && c == d) pro[1]++;
            else if(a == b && b == c) pro[3]++;
            else if(a == b && b == d) pro[3]++;
            else if(a == c && c == d) pro[3]++;
            else if(b == c && c == d) pro[3]++;
            else if(a == b) pro[2]++;
            else if(a == c) pro[2]++;
            else if(a == d) pro[2]++;
            else if(b == c) pro[2]++;
            else if(b == d) pro[2]++;
            else if(c == d) pro[2]++;
            else pro[0]++;
        }
        PA = pro[0] /(double)numeros;
        PB = pro[1] /(double)numeros;
        PC = pro[2] /(double)numeros;
        PD = pro[3] /(double)numeros;
    }
    class Probabilidades {
        double numero = 0;
        public double getNumero() {
            return numero;
        }

        public void setNumero(double numero) {
            this.numero = numero;
        }
    }
    int contarDigitos(int[] nums){
        int cantidad;
        String n = ""+nums[0];
        cantidad = n.length();
        for (int i = 1; i < nums.length; i++){
            n = ""+nums[i];
            if(cantidad <= n.length()) {
                cantidad = n.length();
            }
        }
        return cantidad;
    }
}
