package com.example.demo.service;

import com.example.demo.model.Produit;

import java.util.List;

public interface IProduit {
    public List<Produit> findAll();
    public Produit save(Produit produit);
    public void delete(Produit produit);
    public List<Produit> findByPrixNormal(double prix);

}
