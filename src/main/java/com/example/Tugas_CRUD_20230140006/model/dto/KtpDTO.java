package com.example.Tugas_CRUD_20230140006.model.dto;

import lombok.Data;

@Data
public class KtpDTO {

    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;
}