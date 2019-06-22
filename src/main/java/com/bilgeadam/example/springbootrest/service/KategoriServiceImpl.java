package com.bilgeadam.example.springbootrest.service;

import com.bilgeadam.example.springbootrest.core.BaslikNotFoundException;
import com.bilgeadam.example.springbootrest.core.KitapAdiNotFoundException;
import com.bilgeadam.example.springbootrest.dao.KategoriDAO;
import com.bilgeadam.example.springbootrest.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class KategoriServiceImpl implements KategoriService {

    private final KategoriDAO kategoriDAO;

    @Autowired
    public KategoriServiceImpl(KategoriDAO kategoriDAO) {
        this.kategoriDAO = kategoriDAO;
    }


    @Transactional
    @Override
    public Kategori kaydet(Kategori kategori) {
        if (kategori==null){
            return kategori;
        }
        return kategoriDAO.save(kategori);
    }

    @Transactional
    @Override
    public Kategori guncelle(Kategori kategori) {
        if (kategori==null||kategori.getId()==null){
            return null;
        }
        return kategoriDAO.save(kategori);
    }

    @Transactional
    @Override
    public void sil(Kategori kategori) {
        if (kategori.getId()!=null){
            kategoriDAO.delete(kategori);
        }
    }

    @Transactional
    @Override
    public void silById(Long kategoriId) {
        if (kategoriId!=null){
            kategoriDAO.deleteById(kategoriId);
        }
    }

    @Transactional
    @Override
    public List<Kategori> findAll() {
        return kategoriDAO.findAll();
    }

    @Transactional
    @Override
    public Kategori findById(Long kategoriId) {
        if (kategoriId!=null){
            return kategoriDAO.findById(kategoriId).get();
        }
        return null;
    }

    @Transactional
    @Override
    public List<Kategori> findAllByKitapAdi(String kitapAdi) {

        List<Kategori> kategoriList=kategoriDAO.findAllByKitap_Adi(kitapAdi);

        if (kategoriList.isEmpty()){
            throw new KitapAdiNotFoundException(kitapAdi+" İsimli Kitap Kategoride Bulunamadı.");
        }

        return kategoriList;


    }

    @Override
    public Kategori findByBaslik(String baslik) {

        Optional<Kategori> kategoriOptional=kategoriDAO.findByBaslik(baslik);

       /* Kategori kategori=kategoriDAO.findByBaslik(baslik).get();*/

        if (kategoriOptional.isPresent()){
            System.out.println(baslik+" İsimli Kategori Mevcut.");
        }else {
            Kategori yeniKategori=new Kategori();
            yeniKategori.setBaslik("Yeni Kategori");
            yeniKategori.setTur("Yeni Tur");
            return kategoriOptional.orElse(yeniKategori);
        }


        return kategoriOptional
                .orElseThrow(()-> new BaslikNotFoundException(baslik+" İsimli Kategori Bulunamadı!"));


        //return kategori;
    }
}
