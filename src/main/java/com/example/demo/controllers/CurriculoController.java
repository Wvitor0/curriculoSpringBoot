package com.example.AtvCurriculo.controllers;



import com.example.AtvCurriculo.models.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AtvCurriculo.service.CurriculoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoService curriculoService;
    @GetMapping
    public List<Curriculo> listarCurriculos(){
        return curriculoService.listarCurriculos();
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Curriculo>> getItem(@PathVariable Long id) {

        Optional<Curriculo> result = curriculoService.obterCurriculoPorId(id);

        if (result == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(result);
    }

    @PostMapping(consumes = {"Application/json", "Application/json"},
            produces = {"Application/json", "Application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Curriculo criarTarefa(@RequestBody Curriculo curriculo){
        curriculoService.create(curriculo);
        return curriculo;
    }
    @PutMapping(value = "/{id}", consumes = {"Application/json", "Application/json"})
    public void atualizarTarefa(@PathVariable Long id, @RequestBody Curriculo curriculoAtualizado) {
        curriculoService.update(id, curriculoAtualizado);
    }
    @DeleteMapping(value = "/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        curriculoService.delete(id);
    }
}