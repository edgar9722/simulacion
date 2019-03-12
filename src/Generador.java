import java.io.IOException;
import java.util.Scanner;

public class Generador {
    Scanner t = new Scanner (System.in);
    int opcion;
    int cant_numeros;
    int[] numeros;

    public Generador() {
        menu();
    }

    public void menu(){

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
        boolean bandera1 = false;
        int opc;
        // llama la funcion dependiendo la opcion elegida
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
                numeros = factores_constantes.getNumeros();
            }break;
            case 3: {
                ProductoCentral productoCentral = new ProductoCentral();
                productoCentral.Calcular(cant_numeros);
                numeros = productoCentral.getNumeros();
            }break;
            case 4: {
                Aditivo aditivo = new Aditivo(cant_numeros);
                numeros = aditivo.getNumeros();
            }break;
            case 5: {
                Mixto mixto = new Mixto(cant_numeros);
                mixto.pedirDatos();
                mixto.generarNumeros();
                numeros=mixto.getNumeros();
            }break;
            case 6: {
                Multiplicativo multiplicativo = new Multiplicativo(cant_numeros);
                multiplicativo.pedirDatos();
                multiplicativo.generarNumeros();
                multiplicativo.getNumeros();
            }break;
            default:{
                System.out.println("Opcion no valida");
            }
        }
        // ---------------------------------------------------
        // Valida los numeros y si cumple con el periodo de repeticion los imprime y guarda
        if (validarNumeros()) System.out.println("No cumple con el periodo de repeticion");
        else {
            System.out.println("------------------------------------");
            System.out.println("Cumple con el periodo de repetición");
            mostrarNumeros();
            guardarNumeros();
            System.out.println("Numeros guardados...");
        }
        System.out.println("------------------------------------\n" +
                "1 Regresar al menu\n" +
                "Otro Salir" +
                "-> ");
        opc = t.nextInt();
        if(opc == 1)
            menu();
        else System.exit(0);
    }

    // Guardar los numeros y le asigna el nombre dependiendo del metodo
    private void guardarNumeros(){
        Archivos archivos = new Archivos();
        archivos.setNumeros(numeros);
        switch (opcion){
            case 0: {
                archivos.setNombre("automatico");
            }break;
            case 1: {
                archivos.setNombre("cuadrados_centrales");
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
        try {
            archivos.guardarArchivo();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    private boolean validarNumeros() {
        System.out.println("----------------------------------------");
        System.out.println("Periodo de repiticion minimo: ");
        int periodo = t.nextInt();
        boolean r = false;
        int p=0;
        int j;
        for(int i = 0; i < numeros.length; i++){
            j = i+1;
            while (j < numeros.length){
                if(i != j && numeros[i] == numeros[j]){
                    p = j - i;
                    System.out.println(numeros[i]+" Se repite en la posicion "+i+" y "+j+" periodo "+p);
                    if(p < periodo) r = true;
                }
                j++;
            }
        }
        return r;
    }
    private void mostrarNumeros(){
        System.out.println("----------Numeros generados");
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
