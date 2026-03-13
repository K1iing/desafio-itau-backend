package com.example.desafio_itau_backend.repository;

import com.example.desafio_itau_backend.dto.ResponseStatisticsDTO;
import com.example.desafio_itau_backend.dto.ResponseTransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

@Repository
public class transactionRepository {

    private final ArrayList<ResponseTransactionDTO> transacaoUser = new ArrayList<>();

    public void add(ResponseTransactionDTO dto) {
        transacaoUser.add(dto);
    }

    public void limpar() {
        transacaoUser.clear();
    }

    public ResponseStatisticsDTO getStatitics() {

        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics stats = transacaoUser.stream()
                .filter(t -> !t.dataHora().isBefore(limite))
                .mapToDouble(ResponseTransactionDTO::valor)
                .summaryStatistics();

        ResponseStatisticsDTO response = new ResponseStatisticsDTO(
                stats.getCount() == 0 ? 0 : stats.getCount(),
                stats.getSum() == 0 ? 0 : stats.getSum(),
                stats.getAverage() == 0 ? 0 : stats.getAverage(),
                stats.getMin() == 0 ? 0 : stats.getMin(),
                stats.getMax() == 0 ? 0 : stats.getMax()
        );
        return response;
    }
}
