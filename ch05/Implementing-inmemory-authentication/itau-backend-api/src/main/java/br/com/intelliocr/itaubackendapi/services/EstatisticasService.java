package br.com.intelliocr.itaubackendapi.services;

import br.com.intelliocr.itaubackendapi.controller.dto.EstatisticasResponseDTO;
import br.com.intelliocr.itaubackendapi.controller.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {
    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {
        log.info("Iniciada a busca de estatísticas de transações pelo intervalo de busca " + intervaloBusca);
        transacaoService.buscarTransacoes(intervaloBusca);
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if(transacoes.isEmpty()) {
            log.info("Não há valores para serem calculados.");
            return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics statistics = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();
        log.info("Estatísticas retornadas com sucesso.");

        return new EstatisticasResponseDTO(statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax());

    }


}
