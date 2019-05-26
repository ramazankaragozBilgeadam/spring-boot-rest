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


}
