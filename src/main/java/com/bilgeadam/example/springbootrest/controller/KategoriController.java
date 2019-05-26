package com.bilgeadam.example.springbootrest.controller;


import com.bilgeadam.example.springbootrest.entity.Kategori;
import com.bilgeadam.example.springbootrest.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "kategori")
public class KategoriController {

    private final KategoriService kategoriService;

    @Autowired
    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @PostMapping(value = "/kaydet")
    public Kategori kaydet(@RequestBody Kategori kategori){

        return kategoriService.kaydet(kategori);
    }


}
