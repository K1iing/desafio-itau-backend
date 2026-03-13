package com.example.desafio_itau_backend.controller;

import com.example.desafio_itau_backend.dto.ResponseStatisticsDTO;
import com.example.desafio_itau_backend.repository.transactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
public class EstatisticaController {

    private final transactionRepository transactionRepository;

    public EstatisticaController(transactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public ResponseEntity<ResponseStatisticsDTO> getResponseStatitics() {
        return ResponseEntity.ok(transactionRepository.getStatitics());
    }
}
