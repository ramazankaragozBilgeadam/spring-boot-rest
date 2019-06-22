package com.bilgeadam.example.springbootrest.dao;

import com.bilgeadam.example.springbootrest.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KategoriDAO extends JpaRepository<Kategori,Long> {

    List<Kategori> findAllByKitap_Adi(String kitapAdi);

    Optional<Kategori> findByBaslik(String baslik);

}
