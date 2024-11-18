package com.example.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private CampanhaRepository campanhaRepository;

    @PostMapping
    public ResponseEntity<Doacao> criarDoacao(@RequestBody Doacao doacao) {
        // Verifica se a campanha existe antes de salvar a doação
        if (doacao.getCampanha() == null || !campanhaRepository.existsById(doacao.getCampanha().getId())) {
            return ResponseEntity.badRequest().build();  // Retorna erro se campanha não existir
        }
    
        Doacao novaDoacao = doacaoRepository.save(doacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDoacao);
    }
    
    // Listar todas as doações
    @GetMapping
    public ResponseEntity<List<Doacao>> listarDoacoes() {
        List<Doacao> doacoes = (List<Doacao>) doacaoRepository.findAll();
        return ResponseEntity.ok(doacoes);
    }
}