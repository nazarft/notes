package org.example;

import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Dada una lista de cadenas, convierte todas a mayúsculas usando programación funcional.
        List<String> palabras = List.of("Hola", "Adios");
        List<String> mayusculas = palabras.stream().map(String::toUpperCase).toList();
        System.out.println(mayusculas);
    }
}
