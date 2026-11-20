package br.edu.unisal.cadastrocarros.controller;

import br.edu.unisal.cadastrocarros.domain.Carro;
import br.edu.unisal.cadastrocarros.repos.CarroRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroRepository repo;

    public CarroController(CarroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Carro> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro salvar(@Valid @RequestBody Carro carro) {
        carro.setId(null);
        return repo.save(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> editar(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carro.setId(id);
        return ResponseEntity.ok(repo.save(carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
