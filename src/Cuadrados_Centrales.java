public class Cuadrados_Centrales {
    int semilla;
    int x, aux;
    int[] numeeros;

    public Cuadrados_Centrales(int semilla, int x, int aux, int[] numeeros) {
        this.semilla = semilla;
        this.x = x;
        this.aux = aux;
        this.numeeros = numeeros;


    }

    public int getSemilla() {
        return semilla;
    }

    public void setSemilla(int semilla) {
        this.semilla = semilla;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public int[] getNumeeros() {
        return numeeros;
    }

    public void setNumeeros(int[] numeeros) {
        this.numeeros = numeeros;
    }

    public void ingresardatos(){

    }

    public int generar(int semilla) {
        ;

        int c;
        String cuadrado = Integer.toString((int)Math.pow(semilla,2));
        do {
            int ceros = 7 - cuadrado.length();
            for (int i = 0; i <= ceros; i++) {
                cuadrado = "0" + cuadrado;

            }
        } while (cuadrado.length() < 7);
        this.semilla = Integer.parseInt(cuadrado.substring(5, 7));

        return semilla;
    }

}
