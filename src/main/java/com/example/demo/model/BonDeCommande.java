package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class BonDeCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Temporal(TemporalType.DATE)
    private Date dateDebutBonCom;

    @Temporal(TemporalType.DATE)
    private Date dateFinBonCom;

    @Column(length = 255)
    private String detailBonCom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "factureGlobal_id")
    private FactureGlobal factureGlobal;

    @OneToMany(mappedBy = "bonDeCommande")
    private List<QuantiteBonCommande> quantiteBonCommandeList ;

    public BonDeCommande(Date dateDebutBonCom, Date dateFinBonCom, String detailBonCom, User user, FactureGlobal factureGlobal, List<QuantiteBonCommande> quantiteBonCommandeList) {
        this.dateDebutBonCom = dateDebutBonCom;
        this.dateFinBonCom = dateFinBonCom;
        this.detailBonCom = detailBonCom;
        this.user = user;
        this.factureGlobal = factureGlobal;
        this.quantiteBonCommandeList = quantiteBonCommandeList;
    }

    public Date getDateDebutBonCom() {
        return dateDebutBonCom;
    }

    public void setDateDebutBonCom(Date dateDebutBonCom) {
        this.dateDebutBonCom = dateDebutBonCom;
    }

    public Date getDateFinBonCom() {
        return dateFinBonCom;
    }

    public void setDateFinBonCom(Date dateFinBonCom) {
        this.dateFinBonCom = dateFinBonCom;
    }

    public String getDetailBonCom() {
        return detailBonCom;
    }

    public void setDetailBonCom(String detailBonCom) {
        this.detailBonCom = detailBonCom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FactureGlobal getFactureGlobal() {
        return factureGlobal;
    }

    public void setFactureGlobal(FactureGlobal factureGlobal) {
        this.factureGlobal = factureGlobal;
    }

    public List<QuantiteBonCommande> getQuantiteBonCommandeList() {
        return quantiteBonCommandeList;
    }

    public void setQuantiteBonCommandeList(List<QuantiteBonCommande> quantiteBonCommandeList) {
        this.quantiteBonCommandeList = quantiteBonCommandeList;
    }
}
