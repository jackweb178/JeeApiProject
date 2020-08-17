package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.service.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private IProduit iProduit;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/add")
    public @ResponseBody
    Produit add(@RequestBody Produit produit){ return iProduit.save(produit); }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_SECRETAIRE')")
    @GetMapping("/all")
    public @ResponseBody List<Produit> findAll(){
        return iProduit.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/update")
    public @ResponseBody
    Produit update(@RequestBody Produit produit){ return iProduit.save(produit); }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/delete")
    public @ResponseBody void delete(@RequestBody Produit produit){ iProduit.delete(produit); }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_SECRETAIRE')")
    @GetMapping("/search/{prixUnitaire}")
    public @ResponseBody List<Produit> search(@PathVariable("prixNormal") Double prix){
        return iProduit.findByPrixNormal(prix);
    }
}
