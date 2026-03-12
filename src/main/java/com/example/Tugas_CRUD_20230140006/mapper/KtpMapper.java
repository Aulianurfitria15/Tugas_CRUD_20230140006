package com.example.Tugas_CRUD_20230140006.mapper;

import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;
import com.example.Tugas_CRUD_20230140006.model.entity.Ktp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class KtpMapper {

    // Format yang sesuai dengan <input type="date"> di HTML (yyyy-MM-dd)
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public KtpDTO toDTO(Ktp ktp) {
        if (ktp == null) return null;

        KtpDTO dto = new KtpDTO();
        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());

        // Mengubah LocalDate ke String agar cocok dengan DTO
        if (ktp.getTanggalLahir() != null) {
            dto.setTanggalLahir(ktp.getTanggalLahir().format(formatter));
        }

        dto.setJenisKelamin(ktp.getJenisKelamin());
        return dto;
    }

    public Ktp toEntity(KtpDTO dto) {
        if (dto == null) return null;

        Ktp ktp = new Ktp();
        ktp.setId(dto.getId());
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());

        // Mengubah String dari DTO kembali ke LocalDate untuk Entity/Database
        if (dto.getTanggalLahir() != null && !dto.getTanggalLahir().isEmpty()) {
            ktp.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir(), formatter));
        }

        ktp.setJenisKelamin(dto.getJenisKelamin());
        return ktp;
    }
}