package com.example.demo.service;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IProduit{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void delete(Produit produit) {
        produitRepository.delete(produit);
    }

    @Override
    public List<Produit> findByPrixNormal(double prix) {
        return produitRepository.findByPrixNormal(prix);
    }
}
