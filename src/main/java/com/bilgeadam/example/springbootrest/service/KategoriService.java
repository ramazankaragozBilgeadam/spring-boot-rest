package com.bilgeadam.example.springbootrest.service;

import com.bilgeadam.example.springbootrest.entity.Kategori;

import java.util.List;

public interface KategoriService {

    Kategori kaydet(Kategori kategori);
    Kategori guncelle(Kategori kategori);
    void sil(Kategori kategori);
    void silById(Long kategoriId);
    List<Kategori> findAll();
    Kategori findById(Long kategoriId);
    List<Kategori> findAllByKitapAdi(String kitapAdi);

}
