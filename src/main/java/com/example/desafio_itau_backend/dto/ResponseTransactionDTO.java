package com.example.desafio_itau_backend.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ResponseTransactionDTO(

        double valor,

        OffsetDateTime dataHora
) {
}
