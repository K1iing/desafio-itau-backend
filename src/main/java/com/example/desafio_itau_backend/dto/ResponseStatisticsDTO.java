package com.example.desafio_itau_backend.dto;

public record ResponseStatisticsDTO(

         long count,
         double sum,
         double avg,
         double min,
         double max

) {
}
