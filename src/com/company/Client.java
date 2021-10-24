package com.company;


public class Client implements Runnable {
    String nomClient;
    Carro carro = new Carro();
    Caixa caixa = new Caixa();
    float total;
    String[] nom = {"Pere", "Pau", "Carla", "Mariona"};
    String[] nomCaixa = {"Caixa 1", "Caixa 2", "Caixa 3", "Caixa 4", "Caixa 5"};

    public Client(String nomClient) {
        this.nomClient = nomClient;
    }
    @Override
    public void run() {
        caixa.nom = nomCaixa[(int) (Math.random() * nomCaixa.length)];
        nomClient = nom[(int) (Math.random() * nom.length)];
        llistaCompra(caixa.nom,nomClient);
    }
    public void llistaCompra(String caixa, String client){

        try {
            for (Producte prod: carro.call()) {
                total += prod.preuProducte;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String formattedString = String.format("%.2f", total);
        System.out.println(caixa + " |" +  " Client: " + client + "-->" +  " Total a pagar: "
                + formattedString +" €");
    }
}
