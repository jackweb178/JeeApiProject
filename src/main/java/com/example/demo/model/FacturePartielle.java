package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FacturePartielle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateFactureP;

    @Column
    private double dejaPayer;

    @Column
    private double restePayer;

    @Column
    private double totalFacture;

    @ManyToOne
    @JoinColumn(name = "factureGlobal_id")
    private FactureGlobal factureGlobal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    public FacturePartielle(Date dateFactureP, double dejaPayer, double restePayer, double totalFacture, FactureGlobal factureGlobal, User user) {
        this.dateFactureP = dateFactureP;
        this.dejaPayer = dejaPayer;
        this.restePayer = restePayer;
        this.totalFacture = totalFacture;
        this.factureGlobal = factureGlobal;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFactureP() {
        return dateFactureP;
    }

    public void setDateFactureP(Date dateFactureP) {
        this.dateFactureP = dateFactureP;
    }

    public double getDejaPayer() {
        return dejaPayer;
    }

    public void setDejaPayer(double dejaPayer) {
        this.dejaPayer = dejaPayer;
    }

    public double getRestePayer() {
        return restePayer;
    }

    public void setRestePayer(double restePayer) {
        this.restePayer = restePayer;
    }

    public double getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(double totalFacture) {
        this.totalFacture = totalFacture;
    }

    public FactureGlobal getFactureGlobal() {
        return factureGlobal;
    }

    public void setFactureGlobal(FactureGlobal factureGlobal) {
        this.factureGlobal = factureGlobal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
