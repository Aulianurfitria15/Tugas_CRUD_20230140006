package com.example.Tugas_CRUD_20230140006.service;

import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;

import java.util.List;

public interface KtpService {
    KtpDTO createKtp(KtpDTO ktpDTO);
    List<KtpDTO> getAllKtp();
    KtpDTO getKtpById(Integer id);
    KtpDTO updateKtp(Integer id, KtpDTO ktpDTO);
    void deleteKtp(Integer id);
}
