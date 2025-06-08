package br.com.intelliocr.itaubackendapi.controller;

import br.com.intelliocr.itaubackendapi.controller.dto.TransacaoRequestDTO;
import br.com.intelliocr.itaubackendapi.services.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;


    @PostMapping
    @Operation(description = "Endpoint responsável por adicionar transações.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação gravada com sucesso."),
            @ApiResponse(responseCode = "422", description = "Campo não atende aos requisitos da transação."),
            @ApiResponse(responseCode = "400", description = "Erro ao processar requisição."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
        transacaoService.adicionarTranssacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    @Operation(description = "Endpoint responsável por deletar transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transações deletadas com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<Void> deleterTransacoes(){
        transacaoService.limparTraansacoes();
        return ResponseEntity.ok().build();
    }
}
