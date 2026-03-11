package com.example.Tugas_CRUD_20230140006.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class KtpDTO {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}