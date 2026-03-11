package com.example.Tugas_CRUD_20230140006.mapper;

import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;
import com.example.Tugas_CRUD_20230140006.model.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    // Mengubah dari Entity ke DTO
    public KtpDTO toDTO(Ktp ktp) {
        KtpDTO dto = new KtpDTO();
        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());
        return dto;
    }

    // Mengubah dari DTO ke Entity
    public Ktp toEntity(KtpDTO dto) {
        Ktp ktp = new Ktp();
        ktp.setId(dto.getId());
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());
        return ktp;
    }
}