package com.example.demo.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "utlisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NotNull
    private int tel;

    @NotBlank
    @Size(min=3, max = 10)
    private String matricule;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<BonDeCommande> bonDeCommandeList ;

    @OneToMany(mappedBy = "user")
    private List<FacturePartielle> facturePartielleList ;

    @OneToMany(mappedBy = "user")
    private List<FactureGlobal> factureGlobalList ;

    public User() {}
/*
    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }*/

    public User(String name, String username, int tel, String matricule,String email,String password, Role role ,List<BonDeCommande> bonDeCommandeList, List<FacturePartielle> facturePartielleList, List<FactureGlobal> factureGlobalList) {

        this.name = name;
        this.username = username;
        this.tel = tel;
        this.matricule = matricule;
        this.email = email;
        this.password = password;
        this.role = role;
        this.bonDeCommandeList = bonDeCommandeList;
        this.facturePartielleList = facturePartielleList;
        this.factureGlobalList = factureGlobalList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<BonDeCommande> getBonDeCommandeList() {
        return bonDeCommandeList;
    }

    public void setBonDeCommandeList(List<BonDeCommande> bonDeCommandeList) {
        this.bonDeCommandeList = bonDeCommandeList;
    }

    public List<FacturePartielle> getFacturePartielleList() {
        return facturePartielleList;
    }

    public void setFacturePartielleList(List<FacturePartielle> facturePartielleList) {
        this.facturePartielleList = facturePartielleList;
    }

    public List<FactureGlobal> getFactureGlobalList() {
        return factureGlobalList;
    }

    public void setFactureGlobalList(List<FactureGlobal> factureGlobalList) {
        this.factureGlobalList = factureGlobalList;
    }
}