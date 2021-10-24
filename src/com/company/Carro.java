package com.company;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Carro implements Callable<ArrayList<Producte>> {
    Botiga botiga = new Botiga();
    ArrayList<Producte> producte;



    @Override
    public ArrayList<Producte> call() throws Exception {
        producte = new ArrayList<>();
        for (int i = 0; i < Math.random()*20; i++) {
            int numero = (int) (Math.random()*botiga.nomProducte.length);
            producte.add(new Producte(botiga.nomProducte[numero], botiga.preuProducte[numero]));

        }

        return producte;
    }
}
    




