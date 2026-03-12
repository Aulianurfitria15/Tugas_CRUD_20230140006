package com.example.Tugas_CRUD_20230140006.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "KTP")
@Data
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Tambahkan name dan matikan fitur auto-naming strategy Hibernate
    @Column(name = "nomorKtp", nullable = false)
    private String nomorKtp;

    @Column(name = "namaLengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggalLahir")
    private java.time.LocalDate tanggalLahir;

    @Column(name = "jenisKelamin")
    private String jenisKelamin;
}