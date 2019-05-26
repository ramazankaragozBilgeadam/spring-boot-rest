package com.bilgeadam.example.springbootrest.dao;

import com.bilgeadam.example.springbootrest.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriDAO extends JpaRepository<Kategori,Long> {
}
