package com.example.Tugas_CRUD_20230140006.controller;

import com.example.Tugas_CRUD_20230140006.model.dto.KtpDTO;
import com.example.Tugas_CRUD_20230140006.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin // Agar bisa dipanggil dari HTML/JQuery di domain berbeda
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<KtpDTO> create(@RequestBody KtpDTO ktpDTO) {
        return ResponseEntity.ok(ktpService.createKtp(ktpDTO));
    }

    @GetMapping
    public ResponseEntity<List<KtpDTO>> getAll() {
        return ResponseEntity.ok(ktpService.getAllKtp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KtpDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ktpService.getKtpById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KtpDTO> update(@PathVariable Integer id, @RequestBody KtpDTO ktpDTO) {
        return ResponseEntity.ok(ktpService.updateKtp(id, ktpDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok("Data berhasil dihapus");
    }
}