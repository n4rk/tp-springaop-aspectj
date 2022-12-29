package com.devhcm.metier;

public interface IMetierBanque {
    void ajouterCompte(Compte compte);
    void verser(Long code, double montant);
    void retirer(Long code, double montant);
    Compte consulter(Long code);
}
