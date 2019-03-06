public class Factores_Constantes {
    int semilla;
    int k;
    int x;
    int aux;
    int [] numeros;

    public Factores_Constantes(int semilla, int k, int x, int aux, int[] numeros) {
        this.semilla = semilla;
        this.k = k;
        this.x = x;
        this.aux = aux;
        this.numeros = numeros;
    }

    public int getSemilla() {
        return semilla;
    }

    public int getK() {
        return k;
    }

    public int getX() {
        return x;
    }

    public int getAux() {
        return aux;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
