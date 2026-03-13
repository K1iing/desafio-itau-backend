package com.example.desafio_itau_backend.controller;


import com.example.desafio_itau_backend.dto.ResponseTransactionDTO;
import com.example.desafio_itau_backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping()
    public ResponseEntity<ResponseTransactionDTO> responseTransaction(@RequestBody  ResponseTransactionDTO dto) {
        return transactionService.sendTransaction(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction() {
        return transactionService.deleteTransaction();
    }
}
