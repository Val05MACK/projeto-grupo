package com.example.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @GetMapping
    public Iterable<Campanha> listarCampanhas() {
        return campanhaRepository.findAll();
    }


    @PostMapping
    public Campanha criarCampanha(@RequestBody Campanha campanha) {
        return campanhaRepository.save(campanha);
    }
    @PutMapping("/{id}")
    public Campanha atualizarCampanha(@PathVariable Long id, @RequestBody Campanha campanhaAtualizada) {
        Campanha campanhaExistente = campanhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada"));
        campanhaExistente.setSolicitante(campanhaAtualizada.getSolicitante());
        campanhaExistente.setDescricao(campanhaAtualizada.getDescricao());
        campanhaExistente.setMeta(campanhaAtualizada.getMeta());
        return campanhaRepository.save(campanhaExistente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampanha(@PathVariable Long id) {
        try {
            if (!campanhaRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se a campanha não existir
            }
            campanhaRepository.deleteById(id);  // Exclui a campanha
            return ResponseEntity.noContent().build(); // Retorna 204 em caso de sucesso
        } catch (Exception e) {
            e.printStackTrace();  // Imprime a exceção no log para investigação
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna 500 em caso de erro
        }
    }
    
    
    
}


