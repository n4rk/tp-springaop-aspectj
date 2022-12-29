package com.devhcm.test;

import com.devhcm.metier.Compte;
import com.devhcm.metier.IMetierBanque;
import com.devhcm.metier.MetierBanqueImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        System.out.println("----- Application running -----");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code du compte : ");
        long code = scanner.nextLong();
        System.out.println("Donner le solde initial du compte : ");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanque = new MetierBanqueImpl();
        metierBanque.ajouterCompte(new Compte(code, solde));
        while(true) {
            try {
                System.out.println("Operation type : ");
                String typeOp = scanner.next();
                if(typeOp.equals("quit")) {
                    break;
                } else if(typeOp.equals("v")){
                    System.out.println("Montant a verser : ");
                    double montant = scanner.nextDouble();
                    metierBanque.verser(code,montant);
                } else if (typeOp.equals("r")) {
                    System.out.println("Montant a retirer : ");
                    double montant = scanner.nextDouble();
                    metierBanque.retirer(code,montant);
                } else {
                    Compte compte = metierBanque.consulter(code);
                    System.out.println("Etat du compte : " + compte.toString());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("----- Application finished -----");
    }
}
