package com.example.aula.controller;

import com.example.aula.model.Jogador;
import com.example.aula.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Elenco")
public class JogadorController {

    private JogadorService JogadorService;

    public JogadorController(JogadorService JogadorService) {
        this.JogadorService = JogadorService;
    }

    @GetMapping
    public List<Jogador> listarTodos() {
        return JogadorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Jogador Jogador) {
        JogadorService.salvar(Jogador);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Jogador cadastrado com sucesso."));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Jogador Jogador) {
        JogadorService.atualizar(Jogador);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        JogadorService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador excluído com sucesso"));
    }
}
