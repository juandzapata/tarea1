package com.tarea1;

import java.util.Scanner;

/**
 * @author Juan David Zapata López
 * @version 1.0
 * @since 2022-02-22
 * Clase principal que contiene el método main
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println( "¡Bienvenido al contador de palabras!\n\n" +
                            "Los requisitos para el funcionamiento del programa son los siguientes:\n" +
                            "1. Debe ingresar la ruta de la carpeta que contiene los archivos.\n" +
                            "2. Los archivos deben de tener la siguiente extensión: .txt, .xml, .json o .csv.\n" +
                            "3. Debe ingresar exactamente la palabra que desea buscar.");

        System.out.print("\nIngrese la ruta de la carpeta que contiene los archivos: ");
        String ruta = sc.next();
        
        System.out.print("\nIngrese la palabra que desea buscar: ");

        String palabra = sc.next().trim();

        String[] archivos = null;
        int[] cantidades = null;
        int total = 0;

        Archivo archivo = new Archivo();
        try {
            cantidades = archivo.contarPalabras(palabra, ruta);
            archivos = archivo.obtenerArchivos(ruta);

            System.out.println("\nLa palabra " + "\"" + palabra + "\""+ " se encuentra en:\n");
            for (int i = 0; i < cantidades.length; i++) {
                total += cantidades[i];
                System.out.println(archivos[i] + ": " + cantidades[i] + " veces\n");
            }

            System.out.println("Total: " + total + " veces");

        } catch( IllegalArgumentException e){
            System.out.println("\n¡Error! -> Extensión no válida");
        } catch (Exception e) {
            System.out.println("\n¡Error! -> No se encuentra la carpeta indicada" );
        }
        
        sc.close();
    }
}
