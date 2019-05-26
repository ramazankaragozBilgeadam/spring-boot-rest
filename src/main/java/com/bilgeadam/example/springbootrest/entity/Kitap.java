package com.bilgeadam.example.springbootrest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kitap")
public class Kitap extends BaseEntity{

    @Column(name = "adi")
    private String adi;
    @Column(name = "yazari")
    private String yazari;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kitap_bilgi_id")
    private KitapBilgi kitapBilgi;

}
