package com.example.Tugas_CRUD_20230140006.service.impl;

import com.example.Tugas_CRUD_20230140006.mapper.KtpMapper;
import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;
import com.example.Tugas_CRUD_20230140006.model.entity.Ktp;
import com.example.Tugas_CRUD_20230140006.repository.KtpRepository;
import com.example.Tugas_CRUD_20230140006.service.KtpService;
import com.example.Tugas_CRUD_20230140006.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public KtpDTO createKtp(KtpDTO ktpDTO) {
        if (ktpRepository.existsByNomorKtp(ktpDTO.getNomorKtp())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nomor KTP sudah terdaftar!");
        }
        validationUtil.validateKtpFormat(ktpDTO.getNomorKtp());

        Ktp ktp = ktpMapper.toEntity(ktpDTO);
        Ktp saved = ktpRepository.save(ktp);
        return ktpMapper.toDTO(saved);
    }

    @Override
    public List<KtpDTO> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDTO getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        return ktpMapper.toDTO(ktp);
    }

    @Override
    public KtpDTO updateKtp(Integer id, KtpDTO ktpDTO) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));

        ktp.setNamaLengkap(ktpDTO.getNamaLengkap());
        ktp.setAlamat(ktpDTO.getAlamat());
        ktp.setJenisKelamin(ktpDTO.getJenisKelamin());

        // Pastikan konversi String ke LocalDate benar
        if (ktpDTO.getTanggalLahir() != null && !ktpDTO.getTanggalLahir().isEmpty()) {
            ktp.setTanggalLahir(java.time.LocalDate.parse(ktpDTO.getTanggalLahir()));
        }

        Ktp updated = ktpRepository.save(ktp);
        return ktpMapper.toDTO(updated);
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        ktpRepository.deleteById(id);
    }
}