package br.com.intelliocr.itaubackendapi.controller.dto;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
