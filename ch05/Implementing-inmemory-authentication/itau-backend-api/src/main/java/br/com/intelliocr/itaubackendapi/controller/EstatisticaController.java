package br.com.intelliocr.itaubackendapi.controller;

import br.com.intelliocr.itaubackendapi.controller.dto.EstatisticasResponseDTO;
import br.com.intelliocr.itaubackendapi.services.EstatisticasService;
import br.com.intelliocr.itaubackendapi.services.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")

public class EstatisticaController {
    private final EstatisticasService estatisticasService;

    public EstatisticaController(EstatisticasService estatisticasService) {
        this.estatisticasService = estatisticasService;
    }

    @GetMapping
    @Operation(description = "Endpoint responsável por calcular as estatísticas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao processar estatísticas."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatiscitas(@RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
    }
}
