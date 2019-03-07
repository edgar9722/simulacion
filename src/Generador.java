import java.util.Scanner;

public class Generador {
    int opcion;
    int cant_numeros;
    int[] numeros;

    public Generador() {
        menu();
    }

    public void menu(){
        Scanner t = new Scanner (System.in);
        System.out.println("Elija una opcion para generar los numeros aleatorios:");
        System.out.println("0 Automaticamente: \n" +
                           "1 Cuadrados centrales: \n" +
                           "2 Factor constante: \n" +
                           "3 Producto central: \n" +
                           "4 Aditivo: \n" +
                           "5 Mixto: \n" +
                           "6 Multiplicativo: \n" +
                           "-> ");
        opcion = t.nextInt();
        System.out.println("¿Cuantos numeros pseudoaleatorios quiere generar? ");
        cant_numeros = t.nextInt();
        llamarFuncion();
    }
    private void llamarFuncion(){
        Scanner t = new Scanner (System.in);
        boolean bandera1 = false;
        int opc;
        switch (opcion){
            case 0: {
                Automatico automatico = new Automatico(cant_numeros);
                automatico.generarNumeros();
                numeros = automatico.getNumeros();
            }break;
            case 1: {
                Cuadrados_Centrales cuadrados_centrales = new Cuadrados_Centrales(cant_numeros);
                cuadrados_centrales.pedirDatos();
                cuadrados_centrales.calcular();
                numeros = cuadrados_centrales.getNumeros();


            }break;
            case 2: {
                Factores_Constantes factores_constantes = new Factores_Constantes(cant_numeros);
                factores_constantes.pedirDatos();
                factores_constantes.generarNumeros();
                numeros = factores_constantes.getNumeros();
            }break;
            case 3: {
                ProductoCentral productoCentral = new ProductoCentral();
                productoCentral.Calcular(cant_numeros);
                numeros = productoCentral.getNumeros();
            }break;
            case 4: {
                Aditivo aditivo = new Aditivo(cant_numeros);
                aditivo.pedirDatos();
                aditivo.generarNumeros();
                numeros = aditivo.getNumeros();
            }break;
            case 5: {


            }break;
            case 6: {

            }break;
            default:{
                System.out.println("Opcion no valida");
            }
        }
        mostrarNumeros();
        guardarNumeros();
        System.out.println("------------------------------------\n" +
                    "1 Regresar al menu\n" +
                    "Otro Salir" +
                    "-> ");
        opc = t.nextInt();
        if(opc == 1)
            menu();
        else System.exit(0);
    }
    private void guardarNumeros(){
        Archivos archivos = new Archivos();
        archivos.setNumeros(numeros);
        switch (opcion){
            case 0: {
                archivos.setNombre("automatico");
            }break;
            case 1: {
                archivos.setNombre("cuadradosCentrales");
            }break;
            case 2: {
                archivos.setNombre("factorConstante");
            }break;
            case 3: {
                archivos.setNombre("productoCentral");
            }break;
            case 4: {
                archivos.setNombre("Aditivo");
            }break;
            case 5: {
                archivos.setNombre("mixto");
            }break;
            case 6: {
                archivos.setNombre("multiplicativo");
            }break;
        }
        archivos.guardar();
    }

    private void mostrarNumeros(){
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
