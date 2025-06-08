package br.com.intelliocr.itaubackendapi.controller.dto;


public record EstatisticasResponseDTO(long count,
                                      Double sum,
                                      Double avg,
                                      Double min,
                                      Double max
) {
}
