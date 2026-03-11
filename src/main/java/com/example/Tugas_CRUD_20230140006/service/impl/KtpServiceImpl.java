package com.example.Tugas_CRUD_20230140006.service.impl;

import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;
import com.example.Tugas_CRUD_20230140006.model.entity.Ktp;
import com.example.Tugas_CRUD_20230140006.repository.KtpRepository;
import com.example.Tugas_CRUD_20230140006.service.KtpService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public KtpDTO createKtp(KtpDTO ktpDTO) {
        if (ktpRepository.existsByNomorKtp(ktpDTO.getNomorKtp())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nomor KTP sudah terdaftar!");
        }
        Ktp ktp = new Ktp();
        BeanUtils.copyProperties(ktpDTO, ktp);
        Ktp saved = ktpRepository.save(ktp);
        BeanUtils.copyProperties(saved, ktpDTO);
        return ktpDTO;
    }

    @Override
    public List<KtpDTO> getAllKtp() {
        return ktpRepository.findAll().stream().map(ktp -> {
            KtpDTO dto = new KtpDTO();
            BeanUtils.copyProperties(ktp, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public KtpDTO getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        KtpDTO dto = new KtpDTO();
        BeanUtils.copyProperties(ktp, dto);
        return dto;
    }

    @Override
    public KtpDTO updateKtp(Integer id, KtpDTO ktpDTO) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));

        // Update fields
        ktp.setNamaLengkap(ktpDTO.getNamaLengkap());
        ktp.setAlamat(ktpDTO.getAlamat());
        ktp.setTanggalLahir(ktpDTO.getTanggalLahir());
        ktp.setJenisKelamin(ktpDTO.getJenisKelamin());

        Ktp updated = ktpRepository.save(ktp);
        BeanUtils.copyProperties(updated, ktpDTO);
        return ktpDTO;
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        ktpRepository.deleteById(id);
    }
}