package Pruebas;


import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivo {
    File file = null;

    public void Escribir (int [] num_pseudoaleatorio, String nombre_archivo){
        file = new File(nombre_archivo);
        try {
            FileOutputStream Fi_Out = new FileOutputStream (file,true);
            DataOutputStream escribe = new DataOutputStream(Fi_Out);

            for(int i=0; i<num_pseudoaleatorio.length;i++){
                escribe.writeInt(num_pseudoaleatorio[i]);
            }
            System.out.println("Escrito correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> Leer(String nombre_archivo) {
        ArrayList <Integer> Lectura = new ArrayList();
        try {
            file = new File(nombre_archivo);
            FileInputStream Fi_Input = new FileInputStream(file);
            DataInputStream lee = new DataInputStream(Fi_Input);

            while(true){
                Lectura.add(lee.readInt());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(EOFException e) {
            for (int i = 0; i < Lectura.size(); i++) {
                System.out.print(Lectura.get(i)+"\t");
                if (((i+1) % 30) == 0){
                    System.out.println("");
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lectura;
    }

    public double[][] LeerChi(String nombre_archivo){
        double Lectura[][] = new double[29][15];
        LinkedList<Double> r=new LinkedList<>();
        int i=0, j=0;
        try {
            file = new File(nombre_archivo);
            FileInputStream Fi_Input = new FileInputStream(file);
            DataInputStream lee = new DataInputStream(Fi_Input);

            while(true){
                r.add(lee.readDouble());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(EOFException e) {
            for (int k = 0; k < 29; k++) {
                for (int l = 0; l < 15; l++) {
                    Lectura[k][l]=r.get(j);
                    j++;
                }
            }
            for (i = 0; i < Lectura.length; i++) {
                for (int k = 0; k < Lectura[0].length; k++) {
                    System.out.print(Lectura[i][k]+"\t");
                    if (((i+1) % 30) == 0){
                        System.out.println("");
                    }
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lectura;
    }
}