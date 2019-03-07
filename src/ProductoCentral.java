public class ProductoCentral {
    int Semilla1;
    int Semilla2;
    int aux;
    int X0;
    int X1;
    int [] numeros;

    public ProductoCentral(int semilla1, int semilla2, int aux, int x0, int x1, int[] numeros) {
        Semilla1 = semilla1;
        Semilla2 = semilla2;
        this.aux = aux;
        X0 = x0;
        X1 = x1;
        this.numeros = numeros;
    }

    public void Calcular(int S1, int S2, int Num){
        Semilla1 = S1;
        Semilla2 = S2;
        X0=Semilla1;
        X1=Semilla2;
        for(int i = 0; i <= Num; i++){
            aux = X0 * X1;
            String num = Integer.toString(aux);
            if(num.length()==8){
                String subnum = num.substring(2,5);
                num = subnum;
                Integer n = Integer.parseInt(num);
                X0=X1;
                X1=n;
                System.out.println(n);
            }

        }

    }

    public int getSemilla1() {
        return Semilla1;
    }

    public int getSemilla2() {
        return Semilla2;
    }

    public int getAux() {
        return aux;
    }

    public int getX0() {
        return X0;
    }

    public int getX1() {
        return X1;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
