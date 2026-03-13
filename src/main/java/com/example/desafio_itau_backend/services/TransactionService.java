package com.example.desafio_itau_backend.services;

import com.example.desafio_itau_backend.dto.ResponseTransactionDTO;
import com.example.desafio_itau_backend.repository.transactionRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionService {


    private final transactionRepository transactionRepository;

    public TransactionService(transactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ResponseEntity<ResponseTransactionDTO> sendTransaction(ResponseTransactionDTO dto) {
        try {

            if (dto == null || dto.dataHora() == null || dto.valor() < 0) {
                return ResponseEntity.unprocessableEntity().build();
            }

            transactionRepository.add(dto);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deleteTransaction() {
        transactionRepository.limpar();
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
