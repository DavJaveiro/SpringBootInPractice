package br.com.intelliocr.itaubackendapi.services;

import br.com.intelliocr.itaubackendapi.controller.dto.TransacaoRequestDTO;
import br.com.intelliocr.itaubackendapi.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private ArrayList<TransacaoRequestDTO> transacoes = new ArrayList<>();

    public void adicionarTranssacao(TransacaoRequestDTO dto) {
        log.info("Iniciando transação! " + dto);
        if(dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Hora atual incorreta.");
            throw new UnprocessableEntity("Data e hora incorreta, não podendo ser maior do que a data atual.");
        }

        if(dto.valor() < 0) {
            log.error("Valor incorreto");
            throw new UnprocessableEntity("Valor não pode ser negativo!");
        }

        transacoes.add(dto);
    }

    public void limparTraansacoes() {
        log.info("Iniiciando o processamento para deletar as transações.");
        transacoes.clear();
        log.info("Transações deletadas com sucesso!");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloSegundos) {
        log.info("Iniciada as buscas de transações pelo intervalor de tempo: " + intervaloSegundos);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now()
                .minusSeconds(intervaloSegundos);
        return transacoes.stream()
                    .filter(transacao -> transacao.dataHora()
                                    .isAfter(dataHoraIntervalo)).toList();
    }
}
