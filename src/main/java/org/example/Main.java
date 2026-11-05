package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService trabalhadores = Executors.newFixedThreadPool(3);

        AtomicInteger numeroAtomico = new AtomicInteger(0);
        System.out.println("O valor atual é "+numeroAtomico.get());

        for (int i = 1;i<=100;i++){

            CompletableFuture.supplyAsync(() ->{
                numeroAtomico.incrementAndGet();
                return 0;
            },trabalhadores).join();// Método .join() para fazer com que a Thread Main espere todas as atividades serem feitas.
        }

        System.out.println("Valor final é "+numeroAtomico.get());
        trabalhadores.shutdown();
    }
}