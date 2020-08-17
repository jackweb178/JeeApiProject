package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class FactureGlobal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateFactureG;

    @Column
    private double montantFactureG;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @OneToMany(mappedBy = "factureGlobal")
    private List<FacturePartielle> facturePartielleList ;

    @OneToMany(mappedBy = "factureGlobal")
    private List<BonDeCommande> bonDeCommandeList ;

    public FactureGlobal(Date dateFactureG, double montantFactureG, User user, List<FacturePartielle> facturePartielleList, List<BonDeCommande> bonDeCommandeList) {
        this.dateFactureG = dateFactureG;
        this.montantFactureG = montantFactureG;
        this.user = user;
        this.facturePartielleList = facturePartielleList;
        this.bonDeCommandeList = bonDeCommandeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFactureG() {
        return dateFactureG;
    }

    public void setDateFactureG(Date dateFactureG) {
        this.dateFactureG = dateFactureG;
    }

    public double getMontantFactureG() {
        return montantFactureG;
    }

    public void setMontantFactureG(double montantFactureG) {
        this.montantFactureG = montantFactureG;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FacturePartielle> getFacturePartielleList() {
        return facturePartielleList;
    }

    public void setFacturePartielleList(List<FacturePartielle> facturePartielleList) {
        this.facturePartielleList = facturePartielleList;
    }

    public List<BonDeCommande> getBonDeCommandeList() {
        return bonDeCommandeList;
    }

    public void setBonDeCommandeList(List<BonDeCommande> bonDeCommandeList) {
        this.bonDeCommandeList = bonDeCommandeList;
    }
}
