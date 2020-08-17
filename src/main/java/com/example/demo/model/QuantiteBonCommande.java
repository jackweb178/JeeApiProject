package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class QuantiteBonCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int nbProduit ;

    @Column
    private double montantTTC;

    @Column
    private double montantHT;

    @ManyToOne
    @JoinColumn(name = "bonDeCommande_id")
    private BonDeCommande bonDeCommande;

    @ManyToOne
    @JoinColumn(name ="produit_id")
    private Produit produit;

    public QuantiteBonCommande(int nbProduit, double montantTTC, double montantHT, BonDeCommande bonDeCommande, Produit produit) {
        this.nbProduit = nbProduit;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.bonDeCommande = bonDeCommande;
        this.produit = produit;
    }

    public int getNbProduit() {
        return nbProduit;
    }

    public void setNbProduit(int nbProduit) {
        this.nbProduit = nbProduit;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public BonDeCommande getBonDeCommande() {
        return bonDeCommande;
    }

    public void setBonDeCommande(BonDeCommande bonDeCommande) {
        this.bonDeCommande = bonDeCommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
