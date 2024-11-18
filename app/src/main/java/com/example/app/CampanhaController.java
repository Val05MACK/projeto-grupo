package com.example.app;



import org.springframework.beans.factory.annotation.Autowired;
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
}