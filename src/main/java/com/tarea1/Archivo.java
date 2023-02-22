package com.tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Archivo {    

   /**
     * Método que cuenta la cantidad de veces que se repite una palabra en un archivo
     * @param palabra la palabra que se desea buscar
     * @param ruta la ruta de la carpeta que contiene los archivos
     * @return la cantidad de veces que se encontró esa palabra en la carpeta
     * @throws Exception si no se encuentra la carpeta
     */
    public int[] contarPalabras(String palabra, String ruta) throws Exception {
        
        //Creamos un arreglo de tipo String para almacenar las rutas de los archivos
        String[] ficheros = obtenerArchivos(ruta);        

        //Creamos un arreglo de tipo String para almacenar las extensiones de los archivos
        String[] extension = new String[ficheros.length];
        for (int i = 0; i < extension.length; i++) {
            extension[i] = ficheros[i].substring(ficheros[i].lastIndexOf(".") + 1);
        }
        
        //Creamos un arreglo de tipo int para almacenar la cantidad de veces que se repite la palabra en cada archivo
        int[] cantidades = new int[ficheros.length]; 

        //Creamos un elemento de tipo String para almacenar las líneas del archivo
        String linea = "";       
        
        //Recorremos todas las rutas que contiene el archivo
        for (int i = 0; i < ficheros.length; i++) {

            //Creamos un elemento de tipo BufferedReader para leer el archivo
            BufferedReader br = new BufferedReader(new FileReader(ruta + "\\" + ficheros[i]));

            //Leemos el archivo línea por línea
            while ((linea = br.readLine()) != null) {

                cantidades[i] += contar(linea, palabra, extension[i]);                                              
            }
            br.close();
        }
            
        return cantidades;
    }


    /**
     * Método que cuenta la cantidad de veces que se repite una palabra en un archivo
     * @param palabras las palabras que están en el archivo
     * @param palabra la palabra que se desea buscar
     * @return la cantidad de veces que se repite la palabra
     */
    public int contar(String linea, String palabra, String extension) {

        //Creamos un arreglo de tipo String para almacenar las palabras del archivo
        String[] palabras = null;

        //Creamos una variable de tipo int para almacenar la cantidad de veces que se repite la palabra
        int cantidad = 0;

        //Verificamos la extensión del archivo para saber cómo separar las palabras
        switch (extension) {                    
            case "txt":
                palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                
                    if (palabras[i].replaceAll("[^a-zA-Z]", "").equals(palabra)) {
                        cantidad++;
                    }
                }
                break;
            case "csv":
                palabras = linea.split("[,\\s*]");
                for (int i = 0; i < palabras.length; i++) {
                
                    if (palabras[i].replaceAll("[^a-zA-Z]", "").equals(palabra)) {
                        cantidad++;
                    }
                }
                break;
            case "xml":
                palabras = linea.split("[,\\s*]");
                for (int i = 0; i < palabras.length; i++) {
                
                    if (palabras[i].replaceAll("[^a-zA-Z]", "").equals(palabra)) {
                        cantidad++;
                    }
                }
                break;
            case "json":
                palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                
                    if (palabras[i].replaceAll("[^a-zA-Z]", "").equals(palabra)) {
                        cantidad++;
                    }
                }
                break;
            default:
                //Lanzamos una excepción si la extensión no es válida para manejarla en el try exterior
                throw new IllegalArgumentException();                
        }
        
        
        return cantidad;
    }

    public String[] obtenerArchivos(String ruta) throws Exception {
        
        //Creamos un elemento de tipo File con la ruta de la carpeta para obtener los archivos internos
        File carpeta = new File(ruta);

        //Creamos un arreglo de tipo String para almacenar los nombres de los archivos y así poder acceder a ellos
        String[] ficheros = carpeta.list();        

        return ficheros;
    }
}
