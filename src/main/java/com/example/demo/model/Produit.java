package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String nomProduit;

    @Column(length = 35)
    private String refProduit;

    @Column()
    private double prixNormal;

    @Column()
    private double prixMinimum;

    @OneToMany(mappedBy = "produit")
    private List<QuantiteBonCommande> quantiteBonCommandeList ;

    public Produit(String nomProduit, String refProduit, double prixNormal, double prixMinimum, List<QuantiteBonCommande> quantiteBonCommandeList) {
        this.nomProduit = nomProduit;
        this.refProduit = refProduit;
        this.prixNormal = prixNormal;
        this.prixMinimum = prixMinimum;
        this.quantiteBonCommandeList = quantiteBonCommandeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public double getPrixNormal() {
        return prixNormal;
    }

    public void setPrixNormal(double prixNormal) {
        this.prixNormal = prixNormal;
    }

    public double getPrixMinimum() {
        return prixMinimum;
    }

    public void setPrixMinimum(double prixMinimum) {
        this.prixMinimum = prixMinimum;
    }

    public List<QuantiteBonCommande> getQuantiteBonCommandeList() {
        return quantiteBonCommandeList;
    }

    public void setQuantiteBonCommandeList(List<QuantiteBonCommande> quantiteBonCommandeList) {
        this.quantiteBonCommandeList = quantiteBonCommandeList;
    }
}
