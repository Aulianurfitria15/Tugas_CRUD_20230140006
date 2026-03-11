package com.example.Tugas_CRUD_20230140006.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ValidationUtil {

    // Contoh: Validasi sederhana nomor KTP harus 16 digit
    public void validateKtpFormat(String nomorKtp) {
        if (nomorKtp == null || nomorKtp.length() < 5) { // Sesuaikan kebutuhan
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Format Nomor KTP tidak valid!");
        }
    }
}