package org.example;

import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Dada una lista de enteros, usa programación funcional para calcular la suma de todos los elementos.
        List<Integer> numeros = List.of(1,2,3,4,5,6);
        int suma = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println(suma);
    }
}
