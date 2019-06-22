package com.bilgeadam.example.springbootrest.controller;


import com.bilgeadam.example.springbootrest.entity.Kategori;
import com.bilgeadam.example.springbootrest.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "kategori")
public class KategoriController {

    private final KategoriService kategoriService;

    @Autowired
    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

   /*

   {
        "baslik":"Bilim Kurgu",
            "tur":"Roman",
            "kitap":{
        "adi":"Olasılıksız",
                "yazari":"Adam Fawer",
                "kitapBilgi":{
            "ciltNo":10,
                    "fiyat":45.0,
                    "yayinTarihi":"2012-05-05",
                    "yayinEvi":"Karekök",
                    "sayfaSayisi":450
        }
    }
    }

    */
    @PostMapping(value = "/kaydet")
    public Kategori kaydet(@RequestBody Kategori kategori){
        return kategoriService.kaydet(kategori);
    }

    @PutMapping(value = "/guncelle")
    public Kategori guncelle(@RequestBody Kategori kategori){

        return kategoriService.guncelle(kategori);
    }

    @PostMapping(value = "/sil")
    public void sil(@RequestBody Kategori kategori){
        kategoriService.sil(kategori);
    }

    @DeleteMapping(value = "/silById")
    public void sil(@RequestParam(value = "id")Long id){
        kategoriService.silById(id);
    }

    @GetMapping(value = "/findAll")
    public List<Kategori> listeGetir(){
        return kategoriService.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public Kategori findById(@PathVariable(value = "id")Long id){
        return kategoriService.findById(id);
    }


    @GetMapping(value = "/findAllByKitapAdi")
    public List<Kategori> findAllByKitapAdi(@RequestParam(value = "kitapAdi")String kitapAdi){
        return kategoriService.findAllByKitapAdi(kitapAdi);
    }

    @GetMapping(value = "/findByBaslik/{baslik}")
    public Kategori findByBaslik(@PathVariable(value = "baslik")String baslik){
        return kategoriService.findByBaslik(baslik);
    }


}
