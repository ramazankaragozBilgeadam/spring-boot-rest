package com.bilgeadam.example.springbootrest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kategori")
public class Kategori extends BaseEntity {

    @Column(name = "baslik",length = 15,nullable = false)
    private String baslik;
    @Column(name = "tur",length = 20,nullable = false)
    private String tur;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kitap_id")
    private Kitap kitap;
}
