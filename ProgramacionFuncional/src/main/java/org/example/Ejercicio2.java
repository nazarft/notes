package org.example;

import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Dada una lista de enteros, devuelve una lista con solo los números pares.
        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(pares);
    }
}
